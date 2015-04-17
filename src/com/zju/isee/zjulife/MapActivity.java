/*
 * @author Fan Wei and CS
 */
package com.zju.isee.zjulife;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.baidu.mapapi.map.BaiduMap.OnMapClickListener;
import static com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import static com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;

import com.zju.isee.zjulife.GridViewAdapter;
import com.zju.isee.zjulife.GridPop;

/**
 * Created by CS on 2015/2/25.
 */
public class MapActivity extends Activity implements OnGetGeoCoderResultListener {

    private MapView mMapView;
    private BaiduMap mBaiduMap;

    //定位相关
    private LocationClient mLocationClient;
    private MyLocationListener mLocationListener;
    private boolean IsFirstIn = true; 	

    private double mLatitude;
    private double mLongitude;

    private Context context;

    private MyOrientationListener myOrientationListener;
    private float mCurrentX;
    //自定义定位图标
    private BitmapDescriptor mIconLocation;

    private LocationMode mLocationMode;


    //覆盖物相关
    private BitmapDescriptor mMarker;
    private LinearLayout mMarkerLy;

    GeoCoder mSearch = null;
    
    private ImageView traffic;
    private ImageView myLocation;
    private int isNormal = 1;
    private ImageView overlay;
    private int isOverlayAdd=0;
    
    List<Info> infos = Info.infos;
    List<Info> searchInfos;
    
    //Listview相关
    Button btn1;
    Button btn2;
	private GridPop gridpop1;
	private GridPop gridpop2;
	private ArrayList<String> zijingang;
	private ArrayList<String> yuquan;
	private GridView gv1;
	private GridView gv2;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.map);

        traffic = (ImageView) findViewById(R.id.traffic);
        traffic.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				if (mBaiduMap.isTrafficEnabled()) {
					traffic.setImageResource(R.drawable.traffic_disable);
                    mBaiduMap.setTrafficEnabled(false);
                    Toast.makeText(MapActivity.this, "实时路况已关闭", Toast.LENGTH_LONG).show();
                } 
				else {
                	traffic.setImageResource(R.drawable.traffic_enable);
                    mBaiduMap.setTrafficEnabled(true);
                    Toast.makeText(MapActivity.this, "实时路况已开启", Toast.LENGTH_LONG).show();
                }
			}
		});
        
        myLocation = (ImageView) findViewById(R.id.navi_gps);
        myLocation.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				
				if(isNormal==1)
				{
					centerToMyLocation();
					mLocationMode = LocationMode.FOLLOWING;
					mLocationMode = LocationMode.COMPASS;
					myLocation.setImageResource(R.drawable.compass);
					isNormal=0;
				}
				
				else 
				{
					mLocationMode = LocationMode.NORMAL;
					myLocation.setImageResource(R.drawable.normal);
					isNormal=1;
				}
				
			}
		});
        
        overlay = (ImageView) findViewById(R.id.maplayers);
        overlay.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				if(isOverlayAdd==0)
				{
//					MapStatusUpdate msu2 = MapStatusUpdateFactory.zoomTo(70.0f);
//	            	//设定中心点坐标 
//	            	LatLng cenpt = new LatLng(120.129649,30.270067); 
//	            	//定义地图状态
//	            	MapStatus mMapStatus = new MapStatus.Builder()
//	            	.target(cenpt)
//	            	.zoom(50.0f)
//	            	.build();
//	            	//定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
//
//	            	MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
//	            	//改变地图状态
//	            	mBaiduMap.setMapStatus(mMapStatusUpdate);
					addOverlays(Info.infos);
					centerToMyLocation();
					overlay.setImageResource(R.drawable.layer_switch_on);
					isOverlayAdd=1;
				}
				else {
					mBaiduMap.clear();
					overlay.setImageResource(R.drawable.layer_switch_off);
					isOverlayAdd=0;
				}
			}
		});
        
        this.context = this;

        initView();

        //初始化定位
        initLocation();

        initMarker();

        mBaiduMap.setOnMarkerClickListener(new OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Bundle extraInfo = marker.getExtraInfo();
                Info info = (Info) extraInfo.getSerializable("info");
                ImageView iv = (ImageView) mMarkerLy.findViewById(R.id.id_info_img);
                TextView distance = (TextView) mMarkerLy.findViewById(R.id.id_info_distance);
                TextView name = (TextView) mMarkerLy.findViewById(R.id.id_info_name);
                
                iv.setImageResource(info.getImgId());
                distance.setText(info.getDistance());
                name.setText(info.getName());


                InfoWindow infoWindow;
                TextView tv = new TextView(context);
                tv.setBackgroundResource(R.drawable.location_tips);
                tv.setPadding(30, 20, 30, 50);
                tv.setText(info.getName());
                tv.setTextColor(Color.parseColor("#ffffff"));

                final LatLng latLng = marker.getPosition();
                infoWindow = new InfoWindow(tv, latLng, -47);
                mBaiduMap.showInfoWindow(infoWindow);

                mMarkerLy.setVisibility(VISIBLE);
                return true;
            }
        });

        mBaiduMap.setOnMapClickListener(new OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMarkerLy.setVisibility(GONE);
                mBaiduMap.hideInfoWindow();

            }

            @Override
            public boolean onMapPoiClick(MapPoi mapPoi) {
                return false;
            }
        });


    }

    private void initMarker() {
        mMarker = BitmapDescriptorFactory.fromResource(R.drawable.marker);
        mMarkerLy = (LinearLayout) findViewById(R.id.id_maker_ly);
    }

    private void initLocation() {
        mLocationMode = LocationMode.NORMAL;
        mLocationClient = new LocationClient(this);
        mLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(mLocationListener);


        LocationClientOption option = new LocationClientOption();
        option.setCoorType("bd09ll");
        option.setIsNeedAddress(true);
        option.setOpenGps(true);
        option.setScanSpan(1000);

        mLocationClient.setLocOption(option);
        //初始化图标
        mIconLocation = BitmapDescriptorFactory.fromResource(R.drawable.navi_map_gps_locked);

        myOrientationListener = new MyOrientationListener(context);

        myOrientationListener.setOnOrientationListener(new MyOrientationListener.OnOrientationListener() {
            @Override
            public void onOrientationChanged(float x) {
                mCurrentX = x;
            }
        });


    }

    private void initView() {
        mMapView = (MapView) findViewById(R.id.id_bmapView);
        mBaiduMap = mMapView.getMap();

        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15.0f);
        mBaiduMap.setMapStatus(msu);
        
        btn1 = (Button) this.findViewById(R.id.zijingang);
		btn1.setOnClickListener(new ClickListener());
		btn2 = (Button) this.findViewById(R.id.yuquan);
		btn2.setOnClickListener(new ClickListener());
		
		zijingang = new ArrayList<String>();
		yuquan = new ArrayList<String>();
		
		
		int i = 0,j = 0;
		for(Info info: infos)
        {
        	zijingang.add(info.getName());
        	i++;
        	if (i>=51)
			break;
        }
		for(Info info: infos)
        {
        	if (j>=51)
			{
        		yuquan.add(info.getName());
			}
        	j++;
        }
		
		gridpop1 = new GridPop(MapActivity.this, R.layout.pop_list);
		gridpop2 = new GridPop(MapActivity.this, R.layout.pop_list);
		
		gv1 = gridpop1.getAllItemGrid();
		gv1.setAdapter(new GridViewAdapter(MapActivity.this, zijingang));
		gv2 = gridpop2.getAllItemGrid();
		gv2.setAdapter(new GridViewAdapter(MapActivity.this, yuquan));
		
		gv1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) 
			{
				for(Info info:infos)
				{
					if(zijingang.get(position)==info.getName())
					{
						mBaiduMap.clear();
						addOverlay(info);
						MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(50.0f);
						mBaiduMap.setMapStatus(msu);
//						Toast.makeText(getApplicationContext(), zijingang.get(position), Toast.LENGTH_SHORT).show();
						break;
					}
						
				}
//					Toast.makeText(getApplicationContext(), "item on clicked"+position, Toast.LENGTH_SHORT).show();
					if (gridpop1.isShowing()) 
					{
						gridpop1.dismiss();
					}
			}
		});
		
		gv2.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) 
			{
				for(Info info:infos)
				{
					if(yuquan.get(position)==info.getName())
					{
						mBaiduMap.clear();
						addOverlay(info);
						MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(50.0f);
						mBaiduMap.setMapStatus(msu);
//					Toast.makeText(getApplicationContext(), "item on clicked"+position, Toast.LENGTH_SHORT).show();
					break;
					}
				}
					if (gridpop2.isShowing()) 
					{
						gridpop2.dismiss();
					}
			}
		});
		
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        mMarker.recycle();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //开始定位
        mBaiduMap.setMyLocationEnabled(true);
        if (!mLocationClient.isStarted()) {
            mLocationClient.start();
        }
        //开启方向传感器
        myOrientationListener.start();

    }

    @Override
    protected void onStop() {
        super.onStop();
        //停止定位
        mBaiduMap.setMyLocationEnabled(false);
        mLocationClient.stop();
        //停止方向传感器
        myOrientationListener.stop();
    }

    /**
     * 添加覆盖物
     */
    private void addOverlays(List<Info> infos) {
        mBaiduMap.clear();
        LatLng latLng = null;
        Marker marker = null;
        OverlayOptions options;
        for (Info info : infos) {
            //经纬度
            latLng = new LatLng(info.getLatitude(), info.getLongitude());
            //图标
            options = new MarkerOptions().position(latLng).icon(mMarker).zIndex(5);
            marker = (Marker) mBaiduMap.addOverlay(options);
            Bundle bundle = new Bundle();
            bundle.putSerializable("info", info);
            marker.setExtraInfo(bundle);

        }
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
        mBaiduMap.setMapStatus(msu);

    }
    
    /**
     * 添加覆盖物
     */
    private void addOverlay(Info info) {
        mBaiduMap.clear();
        LatLng latLng = null;
        Marker marker = null;
        OverlayOptions options;
        
            //经纬度
            latLng = new LatLng(info.getLatitude(), info.getLongitude());
            //图标
            options = new MarkerOptions().position(latLng).icon(mMarker).zIndex(5);
            marker = (Marker) mBaiduMap.addOverlay(options);
            Bundle bundle = new Bundle();
            bundle.putSerializable("info", info);
            marker.setExtraInfo(bundle);

        
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
        mBaiduMap.setMapStatus(msu);

    }

    //定位到我的位置
    private void centerToMyLocation() {
        LatLng latLng = new LatLng(mLatitude, mLongitude);
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
        msu = MapStatusUpdateFactory.zoomTo(50.0f);
        mBaiduMap.animateMapStatus(msu);
    }

    private class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            MyLocationData data = new MyLocationData.Builder()//
                    .direction(mCurrentX)//
                    .accuracy(location.getRadius())//
                    .latitude(location.getLatitude())//
                    .longitude(location.getLongitude())//
                    .build();

            mBaiduMap.setMyLocationData(data);

            //更新经纬度
            mLatitude = location.getLatitude();
            mLongitude = location.getLongitude();

            //设置自定义图标
            MyLocationConfiguration configuration = new
                    MyLocationConfiguration(mLocationMode, true, mIconLocation);
            mBaiduMap.setMyLocationConfigeration(configuration);


            if (IsFirstIn) {
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
                mBaiduMap.animateMapStatus(msu);
                IsFirstIn = false;

                Toast.makeText(context, location.getAddrStr(), Toast.LENGTH_SHORT).show();
            }


        }
    }

	@Override
	public void onGetGeoCodeResult(GeoCodeResult result)
	{
		if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
			Toast.makeText(MapActivity.this, "抱歉，未能找到结果", Toast.LENGTH_LONG)
					.show();
			return;
		}
		mBaiduMap.clear();
		mBaiduMap.addOverlay(new MarkerOptions().position(result.getLocation())
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.marker)));
		mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(result
				.getLocation()));
//		String strInfo = String.format("纬度：%f 经度：%f",
//				result.getLocation().latitude, result.getLocation().longitude);
//		Toast.makeText(MapActivity.this, strInfo, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onGetReverseGeoCodeResult(ReverseGeoCodeResult paramReverseGeoCodeResult)
	{
		// 不用复写
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("blank");
		return super.onCreateOptionsMenu(menu);
	}
	
	/**
	 * popMenu
	 */
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		return false;
	}
	
	
	private class ClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			
			case R.id.zijingang:
				if (gridpop1!=null) {
					if (gridpop1.isShowing()) {
						gridpop1.dismiss();
					} else {
						gridpop1.showAsDropDown(v);
					}
				}
				break;
				
			case R.id.yuquan:
				if (gridpop2!=null) {
					if (gridpop2.isShowing()) {
						gridpop2.dismiss();
					} else {
						gridpop2.showAsDropDown(v);
					}
				}
				break;
			}
		}
		
	}
}