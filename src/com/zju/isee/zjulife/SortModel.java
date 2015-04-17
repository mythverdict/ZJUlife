/*
 * @author Fan Wei
 */
package com.zju.isee.zjulife;


public class SortModel {

	private String name;   //显示的数据
	private String sortLetters;  //显示数据拼音的首字母
	private String keywords;
	private String url;
	private String acticity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getKeyWords() {
		return keywords;
	}
	public void setKeyWords(String keyWords) {
		this.keywords = keyWords;
	}
	
	public String getActivity() {
		return acticity;
	}
	public void setActivity(String activity) {
		this.acticity = activity;
	}
	
	
	public String getSortLetters() {
		return sortLetters;
	}
	public void setSortLetters(String sortLetters) {
		this.sortLetters = sortLetters;
	}
}
