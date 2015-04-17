package com.zju.isee.zjulife;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CS and Fan Wei
 */
@SuppressWarnings("serial")
public class Info implements Serializable {



    private double Latitude;
    private double Longitude;
    private int imgId;
    private String name;
    private String distance;

    public static List<Info> infos = new ArrayList<>();

    static {
    	infos.add(new Info(120.088066,30.313587, R.drawable.bifeng, "碧峰学园",
                "浙江大学求是学院云峰学园由工科试验班（信息）、工科试验班（建筑与土木）、应用生物科学（农学）、应用生物科学（生工食品）、科技与创意设计试验班、艺术设计、贵州大学和浙江科技学院委培班等3000多名学生组成，有教师13名、班主任113名。"));
    	infos.add(new Info(120.088366,30.315212, R.drawable.lantian, "蓝田学园",
                "蓝田学园是个正式的行政单位，它是在学校本科生院领导下，全面贯彻“以人为本，求是创新，整合培养，追求卓越”的教育理念，落实学校卓越人才培养行动，负责大类招生背景下的学生教育管理单位之一。目前，蓝田学园共管理和培养了2008、2009和2010级三届学生，其中2008级和2009级均为工科大类，2010级则为工学大类与医学大类的学生。"));
    	infos.add(new Info(120.08918,30.313797, R.drawable.ziyun, "紫云学园",
                "浙江大学求是学院云峰学园由工科试验班（信息）、工科试验班（建筑与土木）、应用生物科学（农学）、应用生物科学（生工食品）、科技与创意设计试验班、艺术设计、贵州大学和浙江科技学院委培班等3000多名学生组成，有教师13名、班主任113名。"));
    	infos.add(new Info(120.090505,30.315403, R.drawable.danyang, "丹阳学园",
                "求是学院丹阳青溪学园包含经济学院、光华法学院、教育学院、人文学院、外国语言文化与国际交流学院、数学系、物理系、化学系、地科系、心理系、药学院、管理学院、公共管理学院、传媒与国际文化学院、国防生、港大委培生在内的3200余名新生，划分为114个班级。"));
    	infos.add(new Info(120.091197,30.315516, R.drawable.qingxi, "青溪学园",
                "求是学院丹阳青溪学园包含经济学院、光华法学院、教育学院、人文学院、外国语言文化与国际交流学院、数学系、物理系、化学系、地科系、心理系、药学院、管理学院、公共管理学院、传媒与国际文化学院、国防生、港大委培生在内的3200余名新生，划分为114个班级。"));
    	infos.add(new Info(120.092477,30.315442, R.drawable.cuibai, "翠柏",
                ""));
    	infos.add(new Info(120.093004,30.314512, R.drawable.baisha, "白沙",
                ""));
    	infos.add(new Info(120.0936,30.315376, R.drawable.liuxuesheng, "留学生大楼",
                ""));
    	infos.add(new Info(120.093099,30.315998, R.drawable.yanzhouqingnian, "亚洲青年交流中心",
                ""));
        infos.add(new Info(120.094872,30.315381, R.drawable.xiaojuchang, "校医院紫金港校区分院",
                ""));
        infos.add(new Info(120.096354,30.314044, R.drawable.xi1, "西1教学楼",
                ""));
        infos.add(new Info(120.092236,30.308323, R.drawable.xi1_107, "西1-107",
                ""));
        infos.add(new Info(120.091638,30.307586, R.drawable.xi2, "西2教学楼",
                ""));
        infos.add(new Info(120.096354,30.314044, R.drawable.xi3, "西3教学楼",
                ""));
        infos.add(new Info(120.091207,30.306347, R.drawable.xi4, "西4教学楼",
                "①国家工科基础课程工程制图教学基地；\n②国家工科基础课程力学教学基地、力学实验教学中心、力学实验中心；\n③机械工程实验中心\n④能源实验中心。"));
        infos.add(new Info(120.091944,30.306343, R.drawable.shuili, "土木水利实验教学中心",
                "实验中心的前身是1927年成立的土木工程学系实验室。土木水利工程实验中心是国家工科力学基础课程教学基地、国家级力学实验教学示范中心、浙江大学工程结构设计实践基地以及软弱土与环境土工教育部重点实验室等教学科研品牌的主要依托单位。"));
        infos.add(new Info(120.096206,30.308393, R.drawable.dong1, "东一教学楼",
                "①竺可桢学院：浙江大学竺可桢学院成立于1984年，以竺可桢老校长之名命名，是浙江大学对优秀本科学生实施“特别培养”和“精英培养”的荣誉学院，是实施英才教育、培养拔尖创新人才的一个重要基地；\n②教研处：主要负责：特长培养和科研训练、教研与国际交流；\n③教务处：主要负责：专业和课程建设、教学管理、学籍管理；\n④学生工作处：主要职能：爱国建设、思想政治工作、奖惩与资助、素质拓展。"));
        infos.add(new Info(120.096601,30.307411, R.drawable.dong2, "东二教学楼",
                ""));
        infos.add(new Info(120.09661,30.306538, R.drawable.dong3, "东三教学楼",
                "①人事处：浙江大学外事处承担学校国际交流与合作项目以及学生因公出国进修项目的开拓工作、教师短期因公出国管理工作和港澳台事务，同时对外国留学生管理、外国专家和留学生生活管理及国内公民自费出国留学管理等工作进行业务指导；\n②发展规划处：发展规划处（政策研究室）主要工作职责：主管学校发展规划工作，开展重大政策研究，组织、论证、实施、协调和管理“985工程”和“211工程”建设；\n③社会研究学院：社会科学研究院是主管学校人文社会科学研究与发展的职能部门；\n④科学技术研究院：浙江大学科学技术研究院简称科研院，由原科学技术处拓展组建，是全校科学技术类科技政策制定、科研机构管理、科研项目成果组织的职能部门，也是学校独立科研基地的直接挂靠单位。"));
        infos.add(new Info(120.096516,30.305252, R.drawable.dong4, "东四教学楼",
                "①物理基础教学实验中心；\n②信息与电子工程实验教学中心；\n③国家工科基础课程物理教学基地；\n④保卫处：保卫处主管学校安全保卫工作。"));
        infos.add(new Info(120.096889,30.308537, R.drawable.dong5, "东五教学楼",
                "①外国语言文化与国际交流学院： 该院培养熟谙目标语言国家的国情，了解国际政治、经济、社会发展前沿，具有交叉专业背景的国际化、复合型外语人才。不仅致力培养学生扎实的语言功底和较高的人文素养，还注重训练学生的创新思维、协作能力和跨文化交际能力；充分利用学校多学科交叉优势，引导学生跨专业、跨学科学习； \n②光及电磁波研究中心。"));
        infos.add(new Info(120.097414,30.307119, R.drawable.dong6, "东六教学楼",
                "①计划财务处：浙江大学计划财务处是对全校的财务进行管理得到行政机构；\n②审计处：浙江大学审计处是对全校项目、财务进行审计的行政机构；\n③监察处：浙江大学监察处是在校长领导下，行使内部行政监察职能的部门。浙江大学监察处依据《中华人民共和国行政监察法》等国家有关法律、法规，对工作对象执行国家法律、法规、政策和学校规章制度的情况实施监察，以保证政令畅通，维护行政纪律，促进廉政建设，改善行政管理，提高行政效能。"));
        infos.add(new Info(120.097576,30.306413, R.drawable.dong7, "东七教学楼",
                ""));
        infos.add(new Info(120.090549,30.313971, R.drawable.dacanting, "大餐厅",
                "①一楼包括休闲自选餐厅和风味餐厅，中档价格定位，风味引进外部技术，从早7：30一直营业到晚11：00提供饮食服务，早点到夜宵无所不包，应有尽有；\n②二楼包括东西两食堂，均可同时容纳2300左右师生就餐，为师生提供基本的饮食服务，属低档定位，但食品口味可是决不逊色哟！\n③三楼定位高档，但菜肴价格大部分都在2～8元，属于学生可以接受的范围，还有包厢，想搞生日聚会、毕业聚餐等不用为地点发愁，近在眼前就是理想场所。"));
        infos.add(new Info(120.093513,30.301749, R.drawable.maixiang, "麦香餐厅",
                ""));
        infos.add(new Info(120.092444,30.309598, R.drawable.linhu, "临湖餐厅",
                ""));
        infos.add(new Info(120.094603,30.309625, R.drawable.jitu, "基础图书馆",
                "120.095151,30.309936"));
        infos.add(new Info(120.093862,30.302372, R.drawable.yitu, "医学图书馆",
                ""));
        infos.add(new Info(120.096354,30.314044, R.drawable.zjgswimming, "游泳馆",
                ""));
        infos.add(new Info(120.095708,30.312267, R.drawable.tiyuguan, "体育馆",
                ""));
        infos.add(new Info(120.096354,30.314044, R.drawable.zjgxingzheng, "行政楼",
                "①管理学院：该院是国内成立最早的管理学院之一。现设5个系，9个研究中心及12个研究所。拥有一级学科博士点3个、博士后流动站3个、硕士点9个。拥有国家级重点学科1个、国家级重点（培育）学科1个，教育部人文社科重点研究基地1个，985哲学社会科学创新平台2个。现有教授36人，其中院士1人，浙江省特级专家1人，求是特聘教授2人。学院于2006年国内首家通过了AMBA国际认证，在办学水平上走上国际新台阶。 所有专业进入社会科学试验班大类招生。\n②外事处"));
        infos.add(new Info(120.09675,30.310077, R.drawable.mengminweilou, "蒙民伟楼",
                "①院士长廊；\n②社会科学学部。"));
         infos.add(new Info(120.090255,30.308428, R.drawable.haiyangdalou, "海洋大楼",
                "①计算中心：机房所在地；\n②海洋科学与工程学系。"));
        infos.add(new Info(120.096354,30.314044, R.drawable.anzhong, "安中大楼",
                "建工学院。"));
        infos.add(new Info(120.096952,30.303782, R.drawable.nongshenghuan, "农生环大楼",
                "①生命科学学院：包含植物生理学与生物化学国家重点实验室、濒危动植物保护生物学教育部重点实验室、浙江省农业微生物生化与工程代谢重点实验室、浙江省细胞与基因工程重点实验室、微生物研究多、生物化学研究所、遗传学研究所、细胞与发育生物学研究所、植物科学研究所等等；\n②生物系统工程与食品科学学院：该院秉承“笃实、励新、兼容、康健”的院训，培养农科与工科交叉的创新型人才。\n③环境与资源学院：该院是我国环境资源领域的人才培养和科学研究的重要创新基地。拥有农业资源利用国家一级重点学科、环境工程国家二级重点学科，环境工程、环境科学和农业资源与环境3个本科专业列为国家级特色专业；\n④动物科学学院：该院秉承“厚德博学、慎思敦行”的院训，培养在动物科学领域具有国际视野的创新型人才。"));
        infos.add(new Info(120.092909,30.30266, R.drawable.yaoxueyuan, "药学院",
                "①药物信息学研究所：研究所从2003年初成立伊始就创新发力，奋勇拼搏当年科研经费即到达900万，占全院的45%；发表SCI论文14篇，占全院30%。；\n②药物分析与药物代谢实验室：实验室由我国近代毒物分析化学奠基人和开拓者黄鸣驹教授创建于1924年,后经严济祥教授、刘志强教授等几代人的努力，已经发展成为多学科交叉的药物分析与药物代谢实验室。"));
        infos.add(new Info(120.090731,30.302196, R.drawable.yixueyuan, "医学院",
                "①卫生部医学神精生物学重点实验室；\n②生殖遗传教育部重点实验室；\n③浙江省生物电磁学重点研究实验室；\n④干细胞与组织工程中心；\n⑤免疫学研究所；\n⑥神经学研究所；\n⑦营养与食品安全研究所；\n⑧ 基本建设处、后勤管理处、房产管理处以及继续教务管理处等。"));
        infos.add(new Info(120.095312,30.303662, R.drawable.namikeji, "纳米研究院",
                ""));
        infos.add(new Info(120.092695,30.30132, R.drawable.dongwushiyan, "动物实验中心",
                ""));
        infos.add(new Info(120.0899,30.30388, R.drawable.shengwushiyan, "生物实验中心",
                ""));
        infos.add(new Info(120.090282,30.305026, R.drawable.huaxueshiyan, "化学实验大楼",
                "①微分析系统研究所：研究所成立近十年来，在全所师生的共同努力下，探索出了一条有中国特色的发展微流控芯片分析的有效途径。在该领域的研究取得一系列重要突破，部分成果，包括：微流控玻璃芯片的简易加工技术、微流控芯片高通量试样引入技术、微流控单细胞分析的集成化、微流控吸收光度和激光诱导荧光检测系统的微型化等在相关学术领域已具备一定国际领先优势。"));
        infos.add(new Info(120.089379,30.305766, R.drawable.jingong, "工程训练（金工）中心",
                ""));
        infos.add(new Info(120.089578,30.308437, R.drawable.shiyandating, "海洋试验大厅",
                ""));
       infos.add(new Info(120.093013,30.311028, R.drawable.yueyalou, "月牙楼",
                "①广播电视台；\n②新闻办公室：浙江大学新闻办公室主要负责浙江大学相关的新闻报道工作；\n③校史馆；\n④展览馆；\n⑤工业技术研究院；\n⑥学生活动中心。"));
    	infos.add(new Info(120.092564,30.309952, R.drawable.xiaojuchang, "小剧场",
                "①小剧场；\n②心理健康教育及咨询中心。"));
        infos.add(new Info(120.094931,30.303424, R.drawable.fuwubanshi, "浙江大学行政服务办事大厅",
                ""));
        infos.add(new Info(120.092813,30.313967, R.drawable.baishazonghe, "白沙综合楼",
                "里面有中国建设银行、农业银行、移动营业厅等，还有一个服务中心，包括网络VPN办理、临时住宿等服务。"));
        infos.add(new Info(120.094971,30.304266, R.drawable.limoxi, "李摩西楼",
                "建成于2011年5月，内有校友活动中心、校友总会秘书处等。由浙大56级医疗系校友、美国华美医学基金会主席李摩西出资110万美元支持建设。"));
        infos.add(new Info(120.097567,30.310123, R.drawable.xinxidalou, "图书信息B楼",
                "①计算机辅助设计与图形学国家重点实验室；\n②人文学部：人文学部现有17个本科专业，38个硕士学位授权点，28个博士学位授权点，其中哲学、中国语言文学、历史学为一级学科博士授权点，外国语言文学为一级学科硕士授权点，建有中国语言文学、历史学2个博士后流动站，目前拥有汉语国际教育硕士、艺术学硕士2个专业学位授权点。学部共有29个研究所，14个研究中心，许多研究所是校级强所！\n③浙江大学发展委员会；\n④浙江大学校友总会；\n⑤浙江大学教育基金会。"));
        infos.add(new Info(120.094158,30.316359, R.drawable.yuanzheng, "圆正·启真酒店",
                ""));
        infos.add(new Info(120.092884,30.314727, R.drawable.youzheng, "中国邮政",
                ""));
        infos.add(new Info(120.130869,30.272056, R.drawable.yq, "1舍",
                ""));
        infos.add(new Info(120.130825,30.271674, R.drawable.yq, "2舍",
                ""));
        infos.add(new Info(120.130209,30.272279, R.drawable.yq, "3舍",
                ""));
        infos.add(new Info(120.130528,30.273043, R.drawable.yq, "4舍",
                ""));
        infos.add(new Info(120.129374,30.272415, R.drawable.yq, "5舍",
                ""));
        infos.add(new Info(120.129791,30.273561, R.drawable.yq, "6舍",
                ""));
        infos.add(new Info(120.132145,30.269834, R.drawable.yq, "7舍",
                ""));
        infos.add(new Info(120.12897,30.27314, R.drawable.yq, "8舍",
                ""));
        infos.add(new Info(120.131907,30.271039, R.drawable.yq, "9舍",
                ""));
        infos.add(new Info(120.132024,30.271362, R.drawable.yq, "10舍",
                ""));
        infos.add(new Info(120.132639,30.271725, R.drawable.yq, "11舍",
                ""));
        infos.add(new Info(120.130645,30.273604, R.drawable.yq, "12舍",
                ""));
        infos.add(new Info(120.129172,30.27378, R.drawable.yq, "13舍",
                ""));
        infos.add(new Info(120.129378,30.27406, R.drawable.yq, "14舍",
                ""));
        infos.add(new Info(120.129738,30.27408, R.drawable.yq, "15舍",
                ""));
        infos.add(new Info(120.132751,30.272864, R.drawable.yq, "16、17、18、19舍",
                ""));
        infos.add(new Info(120.12786,30.272376, R.drawable.yq, "20舍",
                ""));
        infos.add(new Info(120.127959,30.272641, R.drawable.yq, "21舍",
                ""));
        infos.add(new Info(120.12808,30.272903, R.drawable.yq, "22舍",
                ""));
        infos.add(new Info(120.129598,30.275464, R.drawable.yq, "23舍",
                ""));
        infos.add(new Info(120.129495,30.275175, R.drawable.yq, "24舍",
                ""));
        infos.add(new Info(120.128237,30.273136, R.drawable.yq, "27舍",
                ""));
        infos.add(new Info(120.128408,30.273386, R.drawable.yq, "28舍",
                ""));
        infos.add(new Info(120.128377,30.273363, R.drawable.yq, "29舍",
                ""));
        infos.add(new Info(120.131413,30.275421, R.drawable.yq, "31舍",
                ""));
        infos.add(new Info(120.129733,30.27447, R.drawable.yq, "32舍",
                ""));
        infos.add(new Info(120.131242,30.274548, R.drawable.yq, "竺可桢国际教育大楼",
                ""));
        infos.add(new Info(120.133232,30.270848, R.drawable.yq, "教工宿舍",
                ""));
        infos.add(new Info(120.125978,30.270626, R.drawable.yq, "临时宿舍",
                ""));
        infos.add(new Info(120.130551,30.274255, R.drawable.yq, "校医院本部（玉泉校区）",
                "浙江大学校医院创建于1958年，是集医疗、科研、预防为一体的、按二级甲等医院管理的综合性医院。校医院的本部设在玉泉校区，下设紫金港校区分院、西溪校区分院、华家池校区分院及求是社区卫生服务站等医疗分支机构。我院是省市医保的定点医疗单位，实施对外开放服务。"));
        infos.add(new Info(120.130209,30.272595, R.drawable.yq, "快递提取点",
                ""));
        infos.add(new Info(120.128727,30.272146, R.drawable.yq, "一食堂",
                ""));
        infos.add(new Info(120.131372,30.273752, R.drawable.yq, "二食堂、四食堂以及小乐惠",
                "四食堂位于一楼，二食堂和小乐惠位于二楼。小乐惠以川菜为招牌。"));
        infos.add(new Info(120.131804,30.272731, R.drawable.yq, "怡膳堂（三食堂）",
                ""));
        infos.add(new Info(120.131992,30.271951, R.drawable.yq, "靓园食堂",
                ""));
        infos.add(new Info(120.13136,30.272762, R.drawable.yq, "食天一隅",
                ""));
        infos.add(new Info(120.131628,30.273066, R.drawable.yq, "清真食堂",
                ""));
        infos.add(new Info(120.130955,30.275129, R.drawable.yq, "留学生食堂",
                ""));
        infos.add(new Info(120.130384,30.268785, R.drawable.yq, "第一教学楼",
                "①计算机辅助设计与图形学国家重点实验室：实验室主要从事计算机辅助设计、计算机图形学的基础理论、算法及相关应用研究；\n②工程及计算机图形学研究所：研究所主要从事工程与产品设计开发、计算机工程图形学和制造业信息化关键技术等方面研究、开发和推广应用工作，隶属浙江大学机械工程学系；\n③机械设计创新实践基地：基地挂靠机电学院机械创新设计教学中心，可提供教学、培训、指导及作品制作等全方位的条件，可同时接纳教师10人和学生100人。"));
        infos.add(new Info(120.130083,30.267994, R.drawable.yq, "第二教学楼",
                "①电力电子技术实验室：隶属 浙江大学电气学院；\n②航天科技高新技术研发中心；\n③电气工程学院：有国家级电工电子实验教学示范中心、首批国家级人才培养模式创新实验区——“爱迪生班”、首批国家级电子信息工程特色专业、国家级自动化特色专业、国家级电气工程及其自动化特色专业。所有专业进入“工科试验班（工学）”大类招生。"));
        infos.add(new Info(120.128916,30.26939, R.drawable.yq, "第三教学楼",
                "①光电信息工程学系；\n②现代光学仪器国家重点实验室：设有微纳光子技术及器件、精密光学检测技术与仪器、功能光电子器件与技术3个方向；\n③光电信息工程实验中心。"));
        infos.add(new Info(120.128489,30.268411, R.drawable.yq, "第四教学楼",
                "①二次资源化国家专业实验室：分设生物性二次资源（可再生资源）和化工性二次资源两大研究部门。实验室在可再生资源的综合利用、生物化工分离过程开发、医药中间体的合成等方面取得了骄人的成绩；\n②制药工程研究所：成立于2000年，是由化学工程与生物工程学系教师队伍中从事与新药研发、制药技术相关的人员组建的新研究所。下辖天然药物、化学合成制药、绿色制药技术、大孔硅基超分子识别材料、药物制剂功能材料等研究室。"));
        infos.add(new Info(120.127923,30.269659, R.drawable.yq, "第五教学楼",
                "①航空航天学院：我国航空航天和力学等领域高层次人才的重要培养基地。设航空航天系和工程力学系，拥有固体力学国家重点学科、流体力学与工程力学浙江省重点学科、国家工科基础课程力学教学基地和国家级力学实验教学示范中心；\n②飞行器设计研究所；\n③空天信息技术研究所。"));
        infos.add(new Info(120.127658,30.268606, R.drawable.yq, "第六教学楼",
                "①地球科学系：该系办学历史悠久，前身是1936年由时任校长竺可桢先生创办的史地系。所有专业进入“理科试验班类”大类招生；\n②教育部含油气盆地构造研究中心：由国家教育部和中国石油天然气股份有限公司联合共建、隶属于教育部的研究机构，于2006年8月批准成立，主要依托浙江大学、南京大学、北京大学和中国地质大学（武汉）有关从事盆地构造研究队伍及资源而建立；\n③林建高海洋资源与环境实验中心；\n④浙江大学地质博物馆。"));
        infos.add(new Info(120.126785,30.270543, R.drawable.yq, "第七教学楼",
                "内有现代教育技术中心"));
        infos.add(new Info(120.126019,30.268754, R.drawable.yq, "第八教学楼",
                "建于1986年，为浙江大学化学系所在地。 所有专业进入“理科试验班类”大类招生。"));
        infos.add(new Info(120.128952,30.266044, R.drawable.yq, "第九教学楼",
                "建于1988年，内有浙江大学控制工程实验室。"));
        infos.add(new Info(120.12808,30.266267, R.drawable.yq, "第十教学楼",
                "①化学工程联合国家重点实验室：化学工程联合国家重点实验室由清华大学、天津大学、华东理工大学和浙江大学四个分室组成。浙江大学分室位于浙江大学玉泉校区，主要研究方向为聚合反应工程；\n②化学工程与生物工程学系：该系是国内最早成立的化工系，所有专业进入“工科试验班（工学）”大类招生。\n生物工程研究所：研究所的研究方向有：生化反应与分离工程、生物制药工程、生物资源工程、基因工程、蛋白质工程和仿生功能膜与膜技术。"));
        infos.add(new Info(120.131188,30.268661, R.drawable.yq, "第十一教学楼",
                "①研究生院：建于1984年12月，是国务院首批批准试办的研究生院之一。下辖研究生招生处、研工部、研究生管理处、学位管理办公室以及学科建设办公室；\n②理学部：下辖数学系、物理学系、化学系、地球科学系、心理与行为科学系等5个系，设有学术委员会、学位委员会、人力资源委员会、教学委员会等4个专门委员会；\n③机械工程学系：所有专业进入“工科试验班（工学）”招生；\n分析测试中心：建立于1981年，是浙江大学进行教学、科研的重要基地，是国家教育部直属高校中首批建成的分析测试中心之一。"));
        infos.add(new Info(120.131319,30.267374, R.drawable.yq, "第十二教学楼",
                "①物理学系；\n②浙江大学量子物质国家合作中心；\n③浙江近代物理中心。"));
        infos.add(new Info(120.128947,30.265077, R.drawable.yq, "曹光彪科技大楼东楼",
                "①教育部计算机辅助产品创新设计工程中心；\n②现代工业设计研究所；\n③计算机科学与技术学院。"));
        infos.add(new Info(120.128148,30.265319, R.drawable.yq, "曹光彪科技大楼主楼",
                "①浙江大学-微软视觉感知联合实验室：前身是1999年11月19日成立的“浙江大学－微软视觉感知联合实验室”，于2005年纳入教育部重点实验室管理体系；\n②材料科学与工程学系我国最早的综合性材料系，以培养高新材料研究开发能力的高素质人才为目标。该专业进入“工科试验班（工学）”大类招生。"));
        infos.add(new Info(120.127371,30.265767, R.drawable.yq, "曹光彪科技大楼西楼",
                "软件学院所在地。"));
        infos.add(new Info(120.129661,30.269596, R.drawable.yq, "老生仪楼",
                "内有浙江大学ESE工程中心，中心成立于2002，它是浙江大学CCNT实验室与车辆所联合成立的以汽车电子为研究方向的嵌入式系统工程中心，也是教育部直属的嵌入式系统工程研究中心，同时也是浙江省嵌入式系统工程中心。"));
        infos.add(new Info(120.126881,30.269553, R.drawable.yq, "图书馆",
                "浙江大学图书馆是我国历史最悠久的大学图书馆之一，其前身是始建于1897年的求是书院藏书楼。截至2010年12月31日，全馆实体馆藏总量已达518万余册，包括线装古籍18万余册，同时订购各类文献数据库400余个，中外文电子图书151万种，中外文电子期刊48626种，其数字化文献资源居国内高校图书馆前列，且已接近国际著名高校图书馆的水平。\n内有数字图书馆工程研究中心。"));
        infos.add(new Info(120.131431,30.269222, R.drawable.yq, "行政楼",
                "①工学部：成立于2008年11月，是由原浙江大学机械与能源工程学院、材料与化学工程学院、电气工程学院、建筑工程学院、航空航天学院组建而成。；\n②信息学部：成立于2009年2月，涵盖了光电信息工程学系，控制科学与工程学系，信息与电子工程学系，计算机科学与技术学院，软件学院，生物医学工程与仪器科学学院；\n③信息与电子工程学系：所有本科教学资源均为国家级平台：2个本科专业都是首批国家级特色专业；2个本科实验教学基地均属于浙江大学工程训练中心国家级实验教学示范中心；建有首批国家集成电路人才培养基地。学科与产业背景为毕业生提供了广阔的舞台，毕业生国内外深造率近55%。所有专业进入“工科试验班（信息）”大类招生。"));
        infos.add(new Info(120.131018,30.274754, R.drawable.yq, "浙大国际教育学园",
                ""));infos.add(new Info(120.131539,30.266988, R.drawable.yq, "外经贸楼",
                "①经济学院：所有专业进入“社会科学试验班”大类招生。；\n②公共管理学院：所有专业进入“社会科学试验班”大类招生；\n③民营经济研究中心：在国家教育部的关心和支持下，于2002年由浙江大学批准建立的我国高校首家以民营经济问题为研究重点的学术与政策研究机构。"));
        infos.add(new Info(120.129877,30.267409, R.drawable.yq, "电机工程楼",
                "①电力电子技术国家专业实验室：由教育部设立，浙江大学电气工程学院主管；\n②浙江大学-美国国家半导体联合实验室。"));
        infos.add(new Info(120.126535,30.26592, R.drawable.yq, "逸夫工商管理楼",
                "①数学系；\n②民政研究中心。"));
        infos.add(new Info(120.126481,30.266231, R.drawable.yq, "欧阳纯美楼",
                "内有高等数学研究所，研究所是浙江省从事数学与应用数学的理论研究和基础应用研究的主要基地之一。"));
        infos.add(new Info(120.127474,30.266571, R.drawable.yq, "控制科学与工程学系",
                "专业进入“工科试验班（信息）”大类招生。"));
        infos.add(new Info(120.128516,30.266867, R.drawable.yq, "周亦清科技大楼（新生仪楼）",
                "①生物传感器技术国家专业实验室：实验室是世界银行“重点学科发展项目”贷款资助的专业实验室。主要研究和开发生物医学领域中的传感器和检测技术，同时也兼顾研究农业及其他相关行业的传感器及检测技术；\n②生物医学工程与仪器科学学院：设有国内历史最为悠久的生物医学工程专业和电子信息技术及仪器专业，均建有相应的硕士、博士学位授予点和博士后流动站。所有专业进入“工科试验班（信息）”大类招生。"));
        infos.add(new Info(120.128148,30.267378, R.drawable.yq, "李达三能源楼",
                "建于2001年，由香港实业家李达三捐赠。能源工程学系所在地，所有专业进入“工科试验班”大类招生。"));
        infos.add(new Info(120.129068,30.267744, R.drawable.yq, "热力学楼",
                "为浙江大学热力学研究所所在地。"));
        infos.add(new Info(120.127348,30.267865, R.drawable.yq, "永谦教学大楼",
                "由浙江大学校友汤永谦先生捐资166万美元兴建，建筑面积为5800平方米。内有数学科学研究中心。"));
        infos.add(new Info(120.126746,30.267651, R.drawable.yq, "工控楼",
                "建于1992年，内有浙江大学工业自动化国家工程研究中心、浙江大学工业控制技术国家重点实验室、信息学科与工程学院控制科学与工程系等科研机构。"));
        infos.add(new Info(120.125008,30.268633, R.drawable.yq, "高分子大楼",
                "①高分子科学与工程学系：专业进入”工科试验班（工学）“大类招生。\n②高分子复合材料研究所：研究所成立于2000年，以高分子功能复合材料为重点研究对象，兼顾结构材料，着重在光电功能高分子材料、多组分/多相高分子材料共混改性与复合、聚合物流变学与粘弹性等领域开展基础与应用研究工作；\n③高分子科学研究所：主要研究方向为：稀土和过渡金属催化聚合及可控聚合研究；高分子光电功能与磁性材料；生物医用高分子材料；高分子分离膜材料与精细高分子研究；高分子物理及物理化学研究；\n④高分子合成与功能构造教育部重点实验室。"));
        infos.add(new Info(120.124756,30.269288, R.drawable.yq, "信电系大楼",
                "为信电系所在地，内有浙江省综合信息网技术重点实验室、浙江大学电子设计创新基地、浙江大学-美国德州仪器数字信号处理方案实验室和浙江大学信息与通信工程研究所等科研机构。"));
        infos.add(new Info(120.126863,30.271234, R.drawable.yq, "生产工程楼",
                ""));
        infos.add(new Info(120.127079,30.271737, R.drawable.yq, "水利楼",
                ""));
        infos.add(new Info(120.128399,30.270197, R.drawable.yq, "土木科技楼",
                ""));
        infos.add(new Info(120.130878,30.269897, R.drawable.yq, "大操场",
                ""));
        infos.add(new Info(120.130003,30.270957, R.drawable.yq, "邵逸夫体育馆",
                "建于1990年，由香港著名人士邵逸夫先生捐助兴建。体育馆占地13亩，总建筑面积5640平方米。体育馆固定座位3000个，另有体操房、乒乓球训练房。"));
        infos.add(new Info(120.132235,30.273097, R.drawable.yq, "网球场",
                ""));
        infos.add(new Info(120.133713,30.27217, R.drawable.yq, "乒乓球馆",
                ""));
        infos.add(new Info(120.129751,30.270154, R.drawable.yq, "篮球场",
                ""));
        infos.add(new Info(120.12932,30.270302, R.drawable.yq, "羽毛球馆",
                ""));
        infos.add(new Info(120.131844,30.26999, R.drawable.yq, "篮球场",
                ""));
        infos.add(new Info(120.132603,30.269592, R.drawable.yq, "游泳池",
                ""));
        infos.add(new Info(120.130479,30.275546, R.drawable.yq, "实验室与设备管理处",
                "主管全校实验室综合事务管理和仪器设备等资产管理工作的职能部门"));
        infos.add(new Info(120.127433,30.271074, R.drawable.yq, "能源清洁利用国家重点实验室",
                "①能源清洁利用国家重点实验室；\n②国家水煤浆工程研究中心浙江大学燃烧技术研究所：是国家水煤浆工程技术研究中心下属专业研究水煤浆燃烧技术的专门机构。"));
        infos.add(new Info(120.127887,30.270021, R.drawable.yq, "结构实验室",
                ""));
        infos.add(new Info(120.132855,30.274743, R.drawable.yq, "硅材料国家重点实验室",
                ""));
        infos.add(new Info(120.129365,30.267191, R.drawable.yq, "工业电子技术实验楼",
                "电力电子应用国家工程研究中心是以浙江大学相关学科为依托以电力电子技术学科群、电力电子技术国家专业实验室和国内外有关高校、院所为上游单位，以浙江大学三伊电气电子工程公司、浙江大学电工厂为生产实体，沟通科研 - 中试 - 生产的中间通道，及时地将科研成果转化为生产力。"));
        infos.add(new Info(120.129473,30.266808, R.drawable.yq, "振动噪声实验室",
                ""));
        infos.add(new Info(120.126131,30.268208, R.drawable.yq, "流体动力与机电系统国家重点实验室",
                "实验室在流体传动及控制、机械电子工程等方向开展研究工作。"));
        infos.add(new Info(120.128974,30.266832, R.drawable.yq, "低温研究所",
                ""));
        infos.add(new Info(120.129059,30.266972, R.drawable.yq, " 航天电气与微特电机研究所",
                "研究所以航天电机和驱动器为中心，一方面，拓展驱动器的内涵，电磁电机以永磁电机和航天电机为主，另开拓非电磁电机，如超声波电机和压电驱动器等；另一方面，延拓驱动器的外涵，向系统延伸，结合电力电子和自动化技术，尝试与机械、材料、力学等学科交叉结合。"));
        infos.add(new Info(120.12985,30.266465, R.drawable.yq, "动力机械与车辆工程研究所",
                ""));
        infos.add(new Info(120.129544,30.265838, R.drawable.yq, "浙江大学建筑设计研究院",
                "始建于1953年，是国家重点高校中最早成立的甲级设计研究院之一，此新楼于1988年所建，内有浙江大学建筑设计研究院、浙江大学教育部土木工程创新人才培养基地和浙江大学土木工程本科生实习基地。"));
        infos.add(new Info(120.128817,30.267249, R.drawable.yq, "制冷与低温工程研究所",
                "①制冷与低温工程研究所：我国高等院校中最早创办的制冷设备与低温技术专业之一；\n②热工与动力系统研究所：依托国家一级重点学科——动力工程及工程热物理，由原热工教研室和电厂热能动力及自动化研究所组建而成。"));
        infos.add(new Info(120.12782,30.267054, R.drawable.yq, "工业控制研究所",
                "①工业控制技术国家重点实验室：国家计委于1989年批准建设的第一批国家级高科技研究重点实验室之一，依托单位为浙江大学。1995年通过国家验收，正式对外开放；\n②工业控制研究所：研究所从事工业自动化、系统工程、模式识别与智能系统领域的理论、方法和应用研究，充分利用控制论、系统工程、应用数学等多学科交叉优势，研究复杂系统的描述与分析、控制与优化等重大科学命题;\n③智能系统与控制研究所：主要围绕控制理论与控制工程、模式识别与智能系统、检测技术与自动化装置等学科领域中有关建模、控制与优化, 分析仪器与生物传感器, 机器人, 可靠性、网络与通讯的科学和技术问题展开基础研究和应用研究。"));
        infos.add(new Info(120.128911,30.267491, R.drawable.yq, "联合化学反应工程研究所",
                "由浙江大学和中国石化集团公司联合成立。"));
        infos.add(new Info(120.126769,30.267974, R.drawable.yq, "机械电子控制工程研究所",
                ""));
        infos.add(new Info(120.124635,30.268922, R.drawable.yq, "微电子楼",
                "微电子系所在地，内有浙江大学微电子与光电子研究所、浙江大学-美国UCF大学ESD联合实验室和浙江大学微电子与光电子研究所。"));
        infos.add(new Info(120.124289,30.269124, R.drawable.yq, "浙江省综合信息网技术重点实验室",
                "实验室依托信息与通信工程研究所，主要研究方向为： 无线通信与网络、数字音视频技术、机器视觉导航与信息处理、系统芯片（SOC）设计、水下信息处理与通信工程。"));
        
        infos.add(new Info(120.132365,30.27355, R.drawable.yq, "浙大控股公司",
                ""));
        infos.add(new Info(120.132608,30.274287, R.drawable.yq, "后勤集团",
                ""));
        infos.add(new Info(120.132864,30.273655, R.drawable.yq, "浙江大学印务服务中心",
                ""));
        infos.add(new Info(120.130133,30.274423, R.drawable.yq, "教育超市",
                ""));
        infos.add(new Info(120.130012,30.271682, R.drawable.yq, "永谦活动中心",
                "建立于2000年，由浙江大学老校友汤永谦先生捐赠所建。内有就业指导中心以及大厅、报告厅、舞蹈房等各种活动场地。"));
        infos.add(new Info(120.126432,30.267085, R.drawable.yq, "邵逸夫科学馆",
                "建于1987年，内建有浙江大学会务中心，包括8个风格各异的小会议室，1个240个座位的学术演讲厅，以及餐厅、酒吧等配套设施。"));
        infos.add(new Info(120.128543,30.271425, R.drawable.yq, "国家电液工程控制中心",
                ""));
        infos.add(new Info(120.130919,30.266684, R.drawable.yq, "国家光学仪器工程技术研究中心",
                "研究中心依托浙江大学光电系和光学工程学科，在光学工程、光电子技术、图像处理传输等方面，取得许多重大成果。"));
        infos.add(new Info(120.130825,30.266497, R.drawable.yq, "光学仪器厂",
                ""));
        infos.add(new Info(120.13064,30.27585, R.drawable.yq, "校办工厂",
                ""));
    }

    public Info(double longitude, double latitude, int imgId, String name, String distance) {
        this.Latitude = latitude;
        this.Longitude = longitude;
        this.imgId = imgId;
        this.name = name;
        this.distance = distance;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

//    public int getZan() {
//        return zan;
//    }
//
//    public void setZan(int zan) {
//        this.zan = zan;
//    }
}
