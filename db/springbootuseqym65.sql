/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.36 : Database - springbootuseqym65
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springbootuseqym65` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `springbootuseqym65`;

/*Table structure for table `config` */

DROP TABLE IF EXISTS `config`;

CREATE TABLE `config` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  `url` varchar(500) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='配置文件';

/*Data for the table `config` */

insert  into `config`(`id`,`name`,`value`,`url`) values 
(1,'picture1','upload/1.jpg',NULL),
(2,'picture2','upload/2.jpg',NULL),
(3,'picture3','upload/5.jpg',NULL);

/*Table structure for table `discussmeishicaipu` */

DROP TABLE IF EXISTS `discussmeishicaipu`;

CREATE TABLE `discussmeishicaipu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='美食菜谱评论表';

/*Data for the table `discussmeishicaipu` */

insert  into `discussmeishicaipu`(`id`,`addtime`,`refid`,`userid`,`avatarurl`,`nickname`,`content`,`reply`) values 
(3,'2025-03-25 21:18:23',43,1741596825875,'upload/1742884844835.jpg','19803648720','太好吃了-水煮牛肉-用户0',''),
(4,'2025-03-25 21:18:55',44,1741596825875,'upload/1742884844835.jpg','19803648720','好吃-菠萝古老肉-用户0',''),
(5,'2025-03-25 21:20:31',45,1741596825875,'upload/1742884844835.jpg','19803648720','很棒-白切鸡-用户0',''),
(6,'2025-03-25 21:41:19',43,1741596825875,'upload/1742884844835.jpg','19803648720','66666-水煮牛肉-用户0','');

/*Table structure for table `meishicaipu` */

DROP TABLE IF EXISTS `meishicaipu`;

CREATE TABLE `meishicaipu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `caipinmingcheng` varchar(200) DEFAULT NULL COMMENT '菜品名称',
  `shipufenlei` varchar(200) DEFAULT NULL COMMENT '食谱分类',
  `tupian` longtext COMMENT '图片',
  `cankaojiage` double DEFAULT NULL COMMENT '参考价格',
  `caipincailiao` longtext COMMENT '菜品材料',
  `caipinzuofa` longtext COMMENT '菜品做法',
  `zhizuoshichang` longtext COMMENT '制作市场',
  `zhizuoshipin` longtext COMMENT '制作视频',
  `fabushijian` date DEFAULT NULL COMMENT '发布时间',
  `caipinjianjie` longtext COMMENT '菜品简介',
  `sfsh` varchar(200) DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  `thumbsupnum` int DEFAULT '0' COMMENT '赞',
  `crazilynum` int DEFAULT '0' COMMENT '踩',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int DEFAULT '0' COMMENT '点击次数',
  `discussnum` int DEFAULT '0' COMMENT '评论数',
  `userid` bigint DEFAULT NULL COMMENT '用户id',
  `storeupnum` int DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb3 COMMENT='美食菜谱';

/*Data for the table `meishicaipu` */

insert  into `meishicaipu`(`id`,`addtime`,`caipinmingcheng`,`shipufenlei`,`tupian`,`cankaojiage`,`caipincailiao`,`caipinzuofa`,`zhizuoshichang`,`zhizuoshipin`,`fabushijian`,`caipinjianjie`,`sfsh`,`shhf`,`thumbsupnum`,`crazilynum`,`clicktime`,`clicknum`,`discussnum`,`userid`,`storeupnum`) values 
(43,'2025-03-25 15:32:20','水煮牛肉','麻辣江湖','upload/1742887855195.jpg',50,'1. **牛肉**：牛里脊300克（牛里脊肉质鲜嫩，纤维细腻，煮后不易变老，口感佳）\n2. **配菜**：黄豆芽150克、莴笋1根、豆皮100克（黄豆芽爽脆可口，莴笋增加清爽口感，豆皮吸收汤汁，丰富口感层次）\n3. **调料**：郫县豆瓣酱20克、火锅底料30克、干辣椒5个、花椒10克、姜1块、蒜3瓣、大葱1段、八角1个、桂皮1小块、盐2克、生抽10毫升、料酒10毫升、淀粉10克、蛋清1个、食用油适量、鸡精1克、葱花适量\n','1. **牛肉处理**：将牛里脊洗净，逆着纹理切成薄片，放入碗中。加入5毫升生抽、5毫升料酒、1克盐、蛋清和淀粉，用手抓匀，腌制15 - 20分钟，让牛肉充分吸收调料，变得嫩滑。\n2. **配菜准备**：黄豆芽去根洗净；莴笋去皮切成丝；豆皮切成宽条。姜、蒜切末，大葱切段，干辣椒剪成段。\n3. **焯水配菜**：锅中烧开水，加入少量盐和几滴食用油，先放入黄豆芽焯水1分钟，捞出沥干水分，铺在大碗底部。接着放入莴笋丝焯水30秒，捞出放在豆芽上，再将豆皮焯水1分钟，捞出放在莴笋丝上。\n4. **炒制底料**：锅中倒入适量食用油，油热后放入姜蒜末、葱段、八角、桂皮、花椒、干辣椒段炒香。加入郫县豆瓣酱和火锅底料，小火煸炒出红油，炒出浓郁香味。\n5. **煮汤调味**：往锅中加入适量清水，放入5毫升生抽、5毫升料酒、1克盐和1克鸡精，大火煮开后，煮2 - 3分钟，让汤汁充分融合底料味道。\n6. **煮牛肉**：将腌制好的牛肉片逐片放入锅中，用筷子轻轻拨开，避免粘连。煮至牛肉变色熟透，大约1 - 2分钟，连汤带肉一起倒入装有配菜的大碗中。\n7. **激发出香**：在牛肉上撒上葱花、干辣椒段和花椒，锅中再倒入适量食用油，烧至油冒烟，将热油淋在调料上，激发出香味。\n','总时长约30 - 40分钟，其中牛肉腌制15 - 20分钟，配菜处理及焯水5 - 8分钟，炒制底料及煮汤5 - 8分钟，煮牛肉1 - 2分钟，最后激发出香1 - 2分钟。','upload/1742887865437.mp4','2025-03-18','<p>水煮牛肉是一道经典的川菜，以“麻、辣、鲜、香、烫”为特点。牛肉鲜嫩爽滑，吸收了浓郁的汤汁，麻辣过瘾。配菜吸收了牛肉和汤汁的香味，口感丰富多样。这道菜起源于四川自贡，相传是由当地盐工将牛肉与辣椒、花椒等调料结合烹制而成，后经不断改良，成为家喻户晓的美食。它适合家庭聚餐、朋友聚会时制作，能为餐桌增添热烈气氛，让人食欲大增。&nbsp;</p>','是','',1,0,'2025-03-29 09:17:31',21,-1,1,0),
(44,'2025-03-25 15:38:44','菠萝咕咾肉','酸甜风暴','upload/1742888246079.png',60,'1. **主食材**：猪里脊肉300克（肉质细嫩，适合炸制后保持外酥里嫩）、菠萝1个（选成熟度高的凤梨更佳，口感清甜不涩）。  \n2. **配菜**：青红椒各1个（增添色彩与脆爽口感）。  \n3. **调料**：鸡蛋1个、淀粉50克、面粉20克、番茄酱40克、白醋30毫升、白糖20克、盐3克、料酒10毫升、白胡椒粉2克、食用油适量。','1. **预处理食材**：  \n   - 里脊肉切2厘米见方的小块，用刀背拍松，加3克盐、10毫升料酒、2克白胡椒粉抓匀，腌制15分钟。  \n   - 菠萝去皮切块，用盐水浸泡10分钟去涩；青红椒洗净切菱形块备用。  \n\n2. **腌制与挂糊**：  \n   - 腌好的里脊肉加入1个鸡蛋液抓匀，再分次加入淀粉和面粉，搅拌至肉块均匀裹上厚糊，静置5分钟。  \n\n3. **炸制肉块**：  \n   - 锅中倒油烧至六成热（约180℃），将肉块逐个放入，中小火炸至表面微黄捞出。  \n   - 升高油温至八成热，复炸肉块10秒，至表面金黄酥脆，控油备用。  \n\n4. **调制糖醋汁**：  \n   - 碗中加番茄酱40克、白醋30毫升、白糖20克，调匀后加2勺清水稀释，制成酸甜汁。  \n\n5. **炒制收汁**：  \n   - 锅中留少许底油，爆香青红椒块，倒入糖醋汁煮沸。  \n   - 放入菠萝块和炸好的肉块，快速翻炒均匀，使酱汁裹满食材，即可出锅。','总耗时约40-60分钟，其中腌制15分钟，炸制10分钟，调汁与炒制15分钟，备料及预处理10-20分钟。','upload/1742888269136.mp4','2025-03-22','<p>菠萝咕咾肉是经典粤菜系名菜，起源于清代，以酸甜可口、外酥里嫩的特点闻名。相传因外国友人喜爱糖醋排骨却不惯吐骨，广东厨师改良创制出无骨的咕咾肉，后加入菠萝增添果香，成为中外食客钟爱的佳肴。其金黄的色泽、酥脆的肉质与菠萝的清甜完美融合，既保留了传统粤菜的风味，又通过水果的加入提升了层次感。这道菜不仅是家庭聚餐的热门选择，更是海外中餐馆的代表菜品之一，承载了中华饮食文化的创新与包容。</p>','是','',1,0,'2025-03-26 07:46:09',4,1,1,0),
(45,'2025-03-25 15:40:21','白切鸡','咸香本味','upload/1742888350365.jpg',30,'1. **主食材**：新鲜三黄鸡或清远鸡1只（约1-1.5公斤，肉质鲜嫩适合白切）。  \n2. **辅料**：姜片10克、葱结2个、料酒15毫升、冰块适量。  \n3. **蘸料**：生姜1小块（剁蓉）、葱白2根（切末）、生抽20毫升、盐少许、热油15毫升。\n','1. **预处理**：  \n   - 鸡宰杀清理干净，去除鸡肺、鸡屁股，鸡爪塞入腹腔。  \n   - 锅中加足量清水，放入姜片、葱结、料酒，大火煮沸。  \n\n2. **三浸一泡**：  \n   - 手提鸡头，将鸡身浸入沸水3秒后提起，重复3次，使鸡皮快速收缩紧致。  \n   - 完全放入鸡，转小火保持水面微沸（约80℃），浸煮20-25分钟（根据鸡大小调整）。关火后加盖焖15分钟，利用余温让鸡肉更嫩滑。  \n\n3. **冰水锁鲜**：  \n   - 煮好的鸡立即放入冰水或纯净水中浸泡10分钟，使鸡皮脆爽，肉质紧实。  \n\n4. **切配与蘸料**：  \n   - 冷却后的鸡沥干水分，剁成小块摆盘。  \n   - 姜蓉、葱白末混合，加少许盐，淋入热油激发香味，再倒入生抽调匀，制成蘸料。\n','总耗时约1.5小时，其中浸煮及焖制50分钟，冰水冷却10分钟，备料及切配30分钟。','upload/1742888373766.mp4','2025-03-22','<p>白切鸡又称“白斩鸡”，是经典粤菜代表，以“肉熟骨红、皮爽肉滑、原汁原味”闻名。据传起源于清代，袁枚《随园食单》中将其列为鸡肴之首，誉为“太羹元酒之味”。2018年入选“广东十大经典名菜”，2022年被列入广州市非物质文化遗产。其制作讲究“三浸一泡一凉”，通过控制水温与时间保留鸡肉的鲜甜，搭配姜葱蘸料，既突出鸡肉本味，又增添层次鲜香。这道菜不仅是广府宴席的必备菜，更是游子心中的家乡味道，承载着岭南饮食文化的精髓。</p>','是','',1,0,'2025-03-26 07:46:18',4,1,1,0),
(46,'2025-03-25 15:41:55','京酱肉丝','酱香王者','upload/1742888458603.jpg',25,'1. **主食材**：猪通脊肉300克（肉质细嫩无筋，适合切丝后保持滑嫩口感）。  \n2. **配菜**：葱白1根（取外层薄皮切丝）、黄瓜半根（切条）、胡萝卜半根（切条）、豆腐皮2张。  \n3. **调料**：甜面酱40克、花雕酒15毫升、鸡蛋清1个、淀粉10克、姜1小块（切末）、盐2克、胡椒粉1克、香油10毫升、食用油适量。\n','1. **预处理食材**：  \n   - 猪通脊肉切成长8厘米、粗0.3厘米的细丝，用清水反复冲洗至无血水，攥干备用。  \n   - 葱白取外层薄皮切长丝，黄瓜、胡萝卜切条，豆腐皮焯水后切方块备用。  \n\n2. **腌制上浆**：  \n   - 肉丝加2克盐、1克胡椒粉、10毫升花雕酒抓匀，腌10分钟。  \n   - 分次加入鸡蛋清、淀粉，抓拌至肉丝表面形成均匀浆膜，最后加5毫升香油抓匀封油。  \n\n3. **炒制肉丝**：  \n   - 热锅凉油，油温四成热（约120℃）时下入肉丝，用筷子快速滑散至变色，捞出控油。  \n\n4. **炒酱调味**：  \n   - 另起锅加5毫升香油，小火煸香姜末，加入甜面酱炒出酱香。  \n   - 加5毫升花雕酒、少许清水稀释，小火翻炒至酱汁浓稠发亮。  \n\n5. **混合收汁**：  \n   - 倒入肉丝翻炒均匀，使每根肉丝裹满酱汁，关火淋少许香油增亮。  \n\n6. **摆盘食用**：  \n   - 豆腐皮铺底，依次码放肉丝、葱丝、黄瓜条、胡萝卜条，包裹后即可食用。\n','总耗时约50-60分钟，其中腌制15分钟，备料及预处理20分钟，炒制15-20分钟。','upload/1742888477694.mp4','2025-03-23','<p>京酱肉丝是一道融合南北风味的经典名菜，起源于清末民初。相传由四川厨师改良烤鸭吃法而来，以猪肉替代鸭肉，用甜面酱炒制出类似烤鸭酱的浓郁风味。2018年入选“北京十大经典名菜”，其酱香浓郁、肉丝滑嫩、配菜清爽的特点，完美体现了北方菜肴的厚重与南方调味的细腻。这道菜不仅是宴席常见菜，更是百姓家宴的宠儿，通过豆皮包裹的吃法，将肉香、酱香与蔬菜的脆爽巧妙结合，展现了中华饮食文化的包容性与创造性。&nbsp;</p>','是','',0,0,'2025-03-30 07:44:41',6,0,1,1),
(47,'2025-03-25 15:43:22','佛跳墙','鲜香暴击','upload/1742888545796.jpg',50,'1. **主食材**：  \n   - 水发海参5-6只（或即食海参）  \n   - 鲜鲍鱼6只（或鲍鱼罐头）  \n   - 干贝15粒（提前泡发）  \n   - 牛蹄筋100克（或猪蹄筋）  \n   - 老母鸡半只  \n   - 筒骨2根  \n2. **辅料**：  \n   - 花菇5朵（泡发）  \n   - 冬笋100克（切片）  \n   - 鹌鹑蛋8个（煮熟去壳）  \n   - 姜片、葱段适量  \n3. **调料**：  \n   - 花雕酒50毫升  \n   - 盐、白胡椒粉少许  \n   - 纯净水或高汤2000毫升\n','1. **预处理食材**：  \n   - 干贝、花菇提前温水泡发；牛蹄筋焯水去腥；老母鸡、筒骨切块焯水去血沫。  \n   - 鲍鱼刷洗干净，表面打花刀；冬笋切片后焯水备用。  \n\n2. **熬制高汤**：  \n   - 砂锅中放入老母鸡、筒骨、姜片、葱段，加纯净水没过食材，大火煮沸后转小火慢炖2-3小时，滤出清澈高汤备用。  \n\n3. **组装炖煮**：  \n   - 另取砂锅，底部铺姜片、冬笋片，依次码放牛蹄筋、花菇、鹌鹑蛋、干贝、鲍鱼、海参。  \n   - 倒入熬好的高汤，加花雕酒，大火煮沸后转小火慢炖1.5-2小时，至食材软烂入味。  \n   - 最后加盐、白胡椒粉调味，撒葱花即可出锅。\n','总耗时约4-6小时，其中高汤熬制2-3小时，食材处理及炖煮2-3小时。','upload/1742888562877.mp4','2025-03-23','<p>佛跳墙是福建经典名菜，相传起源于清代，原名“福寿全”，后因文人诗句“坛启荤香飘四邻，佛闻弃禅跳墙来”得名。这道菜以“山海八珍”汇聚一堂为特色，海参、鲍鱼、干贝等海鲜与鸡肉、筒骨等肉类同炖，通过长时间慢炖使滋味交融，形成浓郁鲜香、醇厚不腻的金汤。其制作工艺复杂，讲究食材的先后顺序与火候把控，是闽菜“一汤十变”的典范。2002年被评定为“中国十大经典名菜”，不仅是宴席上的压轴大菜，更承载了中华饮食文化中“包容与奢华”的美学追求，被誉为“菜中之王”。</p>','是','',0,0,'2025-03-29 12:49:26',12,0,1,1),
(48,'2025-03-29 20:47:42','aa','五香秘境','',10,'aa','aa','aa','','2025-03-28','aa','是','',0,0,'2025-03-29 12:48:12',2,0,1741596825875,0);

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `introduction` longtext COMMENT '简介',
  `typename` varchar(200) DEFAULT NULL COMMENT '分类名称',
  `name` varchar(200) DEFAULT NULL COMMENT '发布人',
  `headportrait` longtext COMMENT '头像',
  `clicknum` int DEFAULT '0' COMMENT '点击次数',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `thumbsupnum` int DEFAULT '0' COMMENT '赞',
  `crazilynum` int DEFAULT '0' COMMENT '踩',
  `storeupnum` int DEFAULT '0' COMMENT '收藏数',
  `picture` longtext NOT NULL COMMENT '图片',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb3 COMMENT='美食资讯';

/*Data for the table `news` */

insert  into `news`(`id`,`addtime`,`title`,`introduction`,`typename`,`name`,`headportrait`,`clicknum`,`clicktime`,`thumbsupnum`,`crazilynum`,`storeupnum`,`picture`,`content`) values 
(59,'2025-03-25 16:02:24','水煮牛肉｜麻辣鲜香，一口入魂的家庭版攻略','今天必须把这道让我连干三碗米饭的**水煮牛肉**秘方分享给你们！红亮亮的汤汁裹着嫩滑的牛肉，麻、辣、鲜、香在舌尖炸开，吃完直呼过瘾！关键是做法超详细，厨房小白也能轻松复刻～','麻辣江湖','admin','',1,'2025-03-25 08:18:58',0,0,0,'upload/1742889683801.jpg','<p>姐妹们！今天必须把这道让我连干三碗米饭的**水煮牛肉**秘方分享给你们！红亮亮的汤汁裹着嫩滑的牛肉，麻、辣、鲜、香在舌尖炸开，吃完直呼过瘾！关键是做法超详细，厨房小白也能轻松复刻～&nbsp;</p><p>&nbsp;</p><p> **这道菜的灵魂亮点**&nbsp;</p><p>1. **牛肉嫩滑到犯规**：逆纹切薄片+蛋清淀粉腌制，煮后完全不柴！&nbsp;</p><p>2. **麻辣鲜香层层递进**：郫县豆瓣酱+火锅底料双重提味，热油泼辣椒的瞬间，香味直接窜上天灵盖！&nbsp;</p><p>3. **配菜吸汁绝了**：豆芽、莴笋、豆皮吸饱了浓郁的汤汁，比肉还好吃！&nbsp;</p><p>&nbsp;</p><p>**详细步骤分解**&nbsp;</p><p>1. **处理牛肉**&nbsp;</p><p>&nbsp;&nbsp;- 牛里脊逆着纹理切薄片，加1勺生抽、半勺料酒、少许盐、1个蛋清、2勺淀粉，抓匀腌制20分钟。（逆纹切是嫩肉关键！）&nbsp;</p><p>2. **准备配菜**&nbsp;</p><p>&nbsp;&nbsp;- 豆芽掐根、莴笋切丝、豆皮切块，分别焯水后铺在碗底。（焯水时加点盐和油，蔬菜更翠绿！）&nbsp;</p><p>3. **炒香底料**&nbsp;</p><p>&nbsp;&nbsp;- 热油爆香姜蒜末、葱段、花椒、干辣椒，再加2勺郫县豆瓣酱+1块火锅底料，小火炒出红油和香味。&nbsp;</p><p>4. **煮汤汁**&nbsp;</p><p>&nbsp;&nbsp;- 加清水煮沸，放1勺生抽、半勺料酒、少许盐和鸡精调味，煮2分钟让汤汁更浓郁。&nbsp;</p><p>5. **煮牛肉**&nbsp;</p><p>&nbsp;&nbsp;- 转小火，一片片下入牛肉，煮至变色后连汤带肉倒入配菜碗中。&nbsp;</p><p>6. **灵魂泼油**&nbsp;</p><p>&nbsp;&nbsp;- 撒上葱花、干辣椒段、花椒，淋上一勺热油，“滋啦”一声，香味瞬间爆发！&nbsp;</p><p>&nbsp;</p><p> **超实用小贴士**&nbsp;</p><p>- **牛肉嫩滑秘诀**：腌制时加蛋清和淀粉，锁住水分；煮的时候要一片片下，避免粘连。&nbsp;</p><p>- **辣度调节**：不能吃辣的朋友可以减少干辣椒和火锅底料的量，或者用微辣火锅底料。&nbsp;</p><p>- **配菜升级**：可以加入木耳、藕片等耐煮的蔬菜，丰富口感。&nbsp;</p><p>&nbsp;</p><p> **总结**&nbsp;</p><p>这道水煮牛肉简直是下饭神器！周末约上好友来家里，端上这么一盆，热气腾腾、香气扑鼻，瞬间点燃餐桌气氛～ 记得多煮点米饭，因为真的会吃到光盘！</p>'),
(60,'2025-03-25 16:12:25','菠萝咕咾肉｜酸甜爆汁，外酥里嫩的神仙搭配！','今天必须安利这道让我一口就沦陷的**菠萝咕咾肉**！金黄酥脆的肉块裹着酸甜酱汁，咬下去还能尝到菠萝的清爽果香，简直是味觉的狂欢！做法超简单，厨房小白也能轻松拿捏，快收藏起来～','酸甜风暴','admin','',0,NULL,0,0,0,'upload/1742890299414.jpg','<p>今天必须安利这道让我一口就沦陷的**菠萝咕咾肉**！金黄酥脆的肉块裹着酸甜酱汁，咬下去还能尝到菠萝的清爽果香，简直是味觉的狂欢！做法超简单，厨房小白也能轻松拿捏，快收藏起来～&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **这道菜的神仙魅力**&nbsp;</p><p>1. **酸甜 balance 满分**：糖醋汁比例精准，甜而不腻，酸得恰到好处，开胃到舔盘！&nbsp;</p><p>2. **口感层次超丰富**：外酥里嫩的猪肉+爆汁的菠萝+脆爽的彩椒，每一口都有惊喜！&nbsp;</p><p>3. **颜值爆表**：金黄的菠萝、红绿彩椒搭配，端上桌瞬间成为焦点，拍照发圈秒获赞！&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **零失败步骤详解**&nbsp;</p><p>1. **处理食材**&nbsp;</p><p>&nbsp;&nbsp;- 猪里脊肉切小块，用刀背拍松，加少许盐、料酒、白胡椒粉腌15分钟。&nbsp;</p><p>&nbsp;&nbsp;- 菠萝切块用盐水泡10分钟去涩，彩椒切菱形块备用。&nbsp;</p><p>&nbsp;</p><p>2. **挂糊炸肉**&nbsp;</p><p>&nbsp;&nbsp;- 腌好的肉加鸡蛋液、淀粉、面粉调成厚糊，静置5分钟。&nbsp;</p><p>&nbsp;&nbsp;- 六成热油温下锅炸至微黄，捞出复炸10秒至金黄酥脆，控油备用。&nbsp;</p><p>&nbsp;</p><p>3. **熬制灵魂糖醋汁**&nbsp;</p><p>&nbsp;&nbsp;- 番茄酱+白醋+白糖+清水调成酱汁，热锅炒香彩椒，倒入酱汁煮至浓稠。&nbsp;</p><p>&nbsp;&nbsp;- 加入菠萝和炸好的肉块，快速翻炒裹匀酱汁，出锅！&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **关键技巧大公开**&nbsp;</p><p>- **肉嫩不柴的秘诀**：拍松肉块+两次油炸，外酥里嫩两不误！&nbsp;</p><p>- **菠萝更香甜**：用盐水浸泡可去除涩味，选成熟的凤梨口感更赞～&nbsp;</p><p>- **糖醋汁黄金比例**：番茄酱4勺+白醋3勺+白糖2勺，酸甜度超完美！&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **吃货总结**&nbsp;</p><p>这道菠萝咕咾肉简直是米饭杀手！酸酸甜甜的酱汁配上外酥里嫩的肉，再来口清爽的菠萝，幸福感直接拉满～ 周末在家做，孩子连吃三碗停不下来！招待朋友也超有面子，分分钟光盘的节奏！&nbsp;</p><p>&nbsp;</p><p>赶紧试试吧，让酸甜果香在你家厨房绽放～ 记得交作业哦！</p>'),
(61,'2025-03-25 16:14:17','白切鸡｜皮爽肉滑，一口尝到鸡肉本味的神仙做法！','今天必须教你们做这道**粤菜天花板——白切鸡**！皮脆肉嫩到跺脚，蘸上姜葱酱鲜掉眉毛！做法看似简单，实则暗藏玄机，跟着我的步骤来，小白也能复刻正宗广式风味～','咸香本味','admin','',0,NULL,0,0,0,'upload/1742890417005.jpg','<p>今天必须教你们做这道**粤菜天花板——白切鸡**！皮脆肉嫩到跺脚，蘸上姜葱酱鲜掉眉毛！做法看似简单，实则暗藏玄机，跟着我的步骤来，小白也能复刻正宗广式风味～&nbsp;</p><p>&nbsp;</p><p><br></p><p>&nbsp;</p><p> **这道菜的致命诱惑**&nbsp;</p><p>1. **皮爽肉滑到尖叫**：“三浸一泡”的古法工艺，让鸡皮Q弹脆爽，鸡肉嫩到能掐出水！&nbsp;</p><p>2. **原汁原味才是王**：不加多余调料，全靠鸡肉本身的鲜甜和姜葱酱提味，鲜得舌头打颤！&nbsp;</p><p>3. **宴客神器倍有面**：金黄油亮的卖相，搭配简约摆盘，端上桌瞬间成为焦点，亲戚夸爆！&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **手把手教学，零翻车攻略**&nbsp;</p><p>1. **选鸡是关键**&nbsp;</p><p>&nbsp;&nbsp;- 首选三黄鸡或清远鸡（约1.2斤），肉质紧实鲜嫩，煮后不柴。&nbsp;</p><p>&nbsp;</p><p>2. **三浸一泡锁鲜法**&nbsp;</p><p>&nbsp;&nbsp;- ① 沸水烫皮：提着鸡头在沸水里“洗澡”3秒，反复3次，鸡皮瞬间紧致！&nbsp;</p><p>&nbsp;&nbsp;- ② 浸煮入味：转小火浸煮25分钟（中途翻动2次），关火焖15分钟，利用余温让鸡肉更嫩滑。&nbsp;</p><p>&nbsp;&nbsp;- ③ 冰水暴击：煮好的鸡立刻泡冰水10分钟，鸡皮脆到能听到“咔嚓”声！&nbsp;</p><p>&nbsp;</p><p>3. **灵魂姜葱酱**&nbsp;</p><p>&nbsp;&nbsp;- 姜末+葱白末+少许盐，淋热油爆香，再加生抽搅匀，鲜得眉毛飞起来！&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **本地人都不知道的小秘密**&nbsp;</p><p>- **鸡皮脆爽秘诀**：煮鸡时加一勺料酒，冰水浸泡时加冰块，鸡皮瞬间开挂！&nbsp;</p><p>- **鸡肉不柴技巧**：一定要用小火浸煮，避免沸腾的水花破坏肉质纤维。&nbsp;</p><p>- **懒人版福音**：没时间熬汤？用现成的鸡汁加水代替，鲜味照样足！&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **吃货终极总结**&nbsp;</p><p>这道白切鸡简直是肉食爱好者的天堂！原汁原味的鲜甜，搭配姜葱酱的辛香，每一口都在舌尖跳舞～ 周末 family day 做它，全家抢着光盘！学会这招，你就是朋友圈的粤菜大师啦！&nbsp;</p><p>&nbsp;</p><p>赶紧收藏码住，这个周末就给家人安排上，让他们尝尝你的手艺吧！</p>'),
(62,'2025-03-25 16:16:29','京酱肉丝｜酱香浓郁到舔盘，卷着吃一口封神！','今天必须把这道让我连炫三张饼的**京酱肉丝**秘方掏出来！酱红的肉丝裹着油亮的甜面酱，搭配脆爽的葱丝黄瓜，卷在薄饼里咬下去，酱香、肉香、蔬菜香在嘴里炸开，好吃到跺脚！关键做法超详细，厨房小白也能秒变北方大厨～','酱香王者','admin','',1,'2025-03-25 12:15:31',0,0,0,'upload/1742890548651.jpg','<p>今天必须把这道让我连炫三张饼的**京酱肉丝**秘方掏出来！酱红的肉丝裹着油亮的甜面酱，搭配脆爽的葱丝黄瓜，卷在薄饼里咬下去，酱香、肉香、蔬菜香在嘴里炸开，好吃到跺脚！关键做法超详细，厨房小白也能秒变北方大厨～&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p>**这道菜的封神亮点**&nbsp;</p><p>1. **酱香味浓到上头**：甜面酱炒出焦糖色，咸甜适中不齁喉，每根肉丝都裹满酱汁，空口吃都停不下来！&nbsp;</p><p>2. **肉丝嫩到能掐水**：通脊肉逆纹切细丝，蛋清淀粉上浆，滑炒后软嫩不柴，老人孩子都爱吃～&nbsp;</p><p>3. **吃法超有仪式感**：薄饼卷着肉丝、葱丝、黄瓜，一口下去层次丰富，像在吃中式taco，过瘾！&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **保姆级步骤，跟着做零翻车**&nbsp;</p><p>1. **处理肉丝**&nbsp;</p><p>&nbsp;&nbsp;- 猪通脊肉切细丝，加1勺料酒、半勺盐、少许胡椒粉抓匀，腌10分钟。&nbsp;</p><p>&nbsp;&nbsp;- 加1个蛋清、2勺淀粉，抓拌到肉丝黏糊糊的，最后淋点香油封浆，嫩到犯规！&nbsp;</p><p>&nbsp;</p><p>2. **炒酱灵魂时刻**&nbsp;</p><p>&nbsp;&nbsp;- 热锅凉油滑散肉丝，变色后盛出备用。&nbsp;</p><p>&nbsp;&nbsp;- 另起锅爆香姜末，加3勺甜面酱小火炒出酱香，加1勺糖、半勺水稀释，炒到酱汁浓稠发亮。&nbsp;</p><p>&nbsp;</p><p>3. **完美融合**&nbsp;</p><p>&nbsp;&nbsp;- 倒入肉丝翻炒均匀，让每根肉丝都穿上酱红色的“外衣”，关火前淋点香油增亮～&nbsp;</p><p>&nbsp;</p><p>4. **仪式感摆盘**&nbsp;</p><p>&nbsp;&nbsp;- 薄饼加热，铺一层葱白丝、黄瓜丝、胡萝卜丝，堆上满满一勺京酱肉丝，卷起来咬一大口，幸福感爆棚！&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **本地人不外传的小技巧**&nbsp;</p><p>- **肉丝嫩滑秘诀**：切肉时一定要逆着纹理，上浆后冷藏半小时更入味～&nbsp;</p><p>- **甜面酱不发苦**：炒酱时全程小火，不停翻炒避免糊锅，加点糖能中和苦味更提鲜！&nbsp;</p><p>- **懒人版福音**：没有薄饼？用生菜叶、春卷皮代替，清爽又解腻～&nbsp;</p><p>&nbsp;</p><p>---</p><p><br></p><p> **吃货总结**&nbsp;</p><p>这道京酱肉丝简直是下饭界的“天花板”！无论是配米饭、卷饼还是夹馒头，都好吃到停不下来～ 周末在家做，一家人围坐分享，连挑食的孩子都抢着吃！关键做法简单，20分钟就能搞定，妥妥的家庭聚餐必备菜！&nbsp;</p><p>&nbsp;</p><p>赶紧收藏这份攻略，这个周末就给家人安排上，让他们尝尝你的“北方胃”手艺吧！</p>'),
(63,'2025-03-25 16:18:30','佛跳墙｜在家熬制山海盛宴，一口鲜掉眉毛的神仙汤！','今天必须挑战这道被誉为“菜中之王”的**佛跳墙**！汇聚海参、鲍鱼、干贝等山珍海味，经过数小时慢炖，汤汁浓郁如琼浆，每一口都是舌尖的奢华享受！别被它的名字吓到，跟着我的家庭版攻略，小白也能轻松复刻！','鲜香暴击','admin','',5,'2025-03-29 12:50:08',1,0,1,'upload/1742890674904.jpg','<p>今天必须挑战这道被誉为“菜中之王”的**佛跳墙**！汇聚海参、鲍鱼、干贝等山珍海味，经过数小时慢炖，汤汁浓郁如琼浆，每一口都是舌尖的奢华享受！别被它的名字吓到，跟着我的家庭版攻略，小白也能轻松复刻！&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **这碗汤的致命吸引力**&nbsp;</p><p>1. **山海八珍一锅鲜**：海参的软糯、鲍鱼的弹牙、干贝的鲜甜、鸡肉的醇厚，全部融在金黄的汤汁里，层次感炸裂！&nbsp;</p><p>2. **暖心又暖胃**：秋冬来一碗，从胃暖到脚尖，滋补又养生，喝完感觉全身都充满了能量～&nbsp;</p><p>3. **宴客C位担当**：揭开陶坛的瞬间，香气扑鼻，颜值与实力并存，招待贵客绝对倍有面！&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **家庭版简化攻略，零翻车步骤**&nbsp;</p><p>1. **食材准备（懒人版）**&nbsp;</p><p>&nbsp;&nbsp;- 直接买即食海参、鲍鱼罐头、牛蹄筋，省去泡发烦恼！&nbsp;</p><p>&nbsp;&nbsp;- 老母鸡半只+筒骨熬高汤，没有的话用浓汤宝加水也能救场～&nbsp;</p><p>&nbsp;</p><p>2. **煮出黄金高汤**&nbsp;</p><p>&nbsp;&nbsp;- 鸡肉、筒骨焯水后，加姜片、葱段炖2小时，滤出清澈高汤，这是鲜味的灵魂！&nbsp;</p><p>&nbsp;</p><p>3. **层层叠叠的鲜味密码**&nbsp;</p><p>&nbsp;&nbsp;- 砂锅底铺冬笋、花菇，依次码放蹄筋、干贝、鲍鱼、海参，倒入高汤。&nbsp;</p><p>&nbsp;&nbsp;- 小火慢炖1.5小时，让所有食材的精华彻底释放，汤汁变得浓稠金亮～&nbsp;</p><p>&nbsp;</p><p>4. **点睛之笔**&nbsp;</p><p>&nbsp;&nbsp;- 出锅前撒点白胡椒粉，滴几滴花雕酒，鲜味直接飙升！&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **省钱又省时的小妙招**&nbsp;</p><p>- **食材平替**：用鹌鹑蛋代替鸽蛋，用普通香菇代替花菇，成本减半但鲜味不减！&nbsp;</p><p>- **提前预制**：高汤和食材可以分批次准备，周末花2小时熬汤，工作日直接组装炖煮，超省心～&nbsp;</p><p>- **保温技巧**：炖好后别急着开盖，焖半小时更入味，冬天还能保持温度～&nbsp;</p><p>&nbsp;</p><p>---</p><p>&nbsp;</p><p> **吃货终极感悟**&nbsp;</p><p>这碗佛跳墙简直是“鲜”的终极教科书！每一勺都能舀到不同的食材，汤汁浓郁得能挂在碗壁上，喝完忍不住舔碗底！虽然过程有点耗时，但看到家人喝得精光的满足表情，一切都值了～&nbsp;</p><p>&nbsp;</p><p>快收藏这份攻略，过年过节露一手，让亲朋好友尝尝你熬的山海盛宴！记住，真正的美味值得等待，而你值得拥有这口极致的鲜甜！</p>');

/*Table structure for table `newstype` */

DROP TABLE IF EXISTS `newstype`;

CREATE TABLE `newstype` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `typename` varchar(200) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb3 COMMENT='美食资讯分类';

/*Data for the table `newstype` */

insert  into `newstype`(`id`,`addtime`,`typename`) values 
(49,'2025-03-25 15:54:36','麻辣江湖'),
(50,'2025-03-25 15:54:50','酸甜风暴'),
(51,'2025-03-25 15:55:06','咸香本味'),
(52,'2025-03-25 15:55:12','酱香王者'),
(53,'2025-03-25 15:55:28','鲜香暴击'),
(54,'2025-03-25 15:55:41','五香秘境'),
(55,'2025-03-25 15:55:51','蒜香炸弹'),
(56,'2025-03-25 15:56:09','香辣觉醒'),
(57,'2025-03-25 15:56:20','酸辣开胃'),
(58,'2025-03-25 15:56:29','甜辣诱惑');

/*Table structure for table `shipufenlei` */

DROP TABLE IF EXISTS `shipufenlei`;

CREATE TABLE `shipufenlei` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shipufenlei` varchar(200) NOT NULL COMMENT '食谱分类',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shipufenlei` (`shipufenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COMMENT='食谱分类';

/*Data for the table `shipufenlei` */

insert  into `shipufenlei`(`id`,`addtime`,`shipufenlei`) values 
(21,'2024-01-19 19:31:10','麻辣江湖'),
(22,'2024-01-19 19:31:10','酸甜风暴'),
(23,'2024-01-19 19:31:10','咸香本味'),
(24,'2024-01-19 19:31:10','酱香王者'),
(25,'2024-01-19 19:31:10','鲜香暴击'),
(26,'2024-01-19 19:31:10','五香秘境'),
(27,'2024-01-19 19:31:10','蒜香炸弹'),
(28,'2024-01-19 19:31:10','香辣觉醒'),
(29,'2025-03-12 15:12:44','酸辣开胃'),
(30,'2025-03-12 15:19:05','甜辣诱惑');

/*Table structure for table `storeup` */

DROP TABLE IF EXISTS `storeup`;

CREATE TABLE `storeup` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint NOT NULL COMMENT '用户id',
  `refid` bigint DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext NOT NULL COMMENT '图片',
  `type` varchar(200) DEFAULT '1' COMMENT '类型',
  `inteltype` varchar(200) DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COMMENT='收藏表';

/*Data for the table `storeup` */

insert  into `storeup`(`id`,`addtime`,`userid`,`refid`,`tablename`,`name`,`picture`,`type`,`inteltype`,`remark`) values 
(9,'2025-03-29 17:41:00',1741596825875,47,'meishicaipu','佛跳墙','upload/1742888545796.jpg','1','鲜香暴击',NULL),
(10,'2025-03-29 17:41:18',1741596825875,46,'meishicaipu','京酱肉丝','upload/1742888458603.jpg','1','酱香王者',NULL),
(11,'2025-03-29 20:49:16',1741596825875,63,'news','佛跳墙｜在家熬制山海盛宴，一口鲜掉眉毛的神仙汤！','upload/1742890674904.jpg','1',NULL,NULL),
(12,'2025-03-29 20:49:17',1741596825875,63,'news','佛跳墙｜在家熬制山海盛宴，一口鲜掉眉毛的神仙汤！','upload/1742890674904.jpg','21',NULL,NULL);

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='token表';

/*Data for the table `token` */

insert  into `token`(`id`,`userid`,`username`,`tablename`,`role`,`token`,`addtime`,`expiratedtime`) values 
(2,1,'admin','users','管理员','cdu9zxyrjo9ura6qbtj4tqtoi2t823yd','2025-03-10 16:30:34','2025-03-30 08:29:15'),
(3,1741596825875,'19803648720','yonghu','用户','qxt71vd1mbyb4dldulaon47hy7k05h9j','2025-03-10 16:53:57','2025-03-30 08:42:46');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `image` varchar(200) DEFAULT NULL COMMENT '头像',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='用户表';

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`image`,`role`,`addtime`) values 
(1,'admin','admin','upload/1742891342828.jpg','管理员','2024-01-19 19:31:10');

/*Table structure for table `yonghu` */

DROP TABLE IF EXISTS `yonghu`;

CREATE TABLE `yonghu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) NOT NULL COMMENT '用户账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `yonghuxingming` varchar(200) NOT NULL COMMENT '用户姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` varchar(200) DEFAULT NULL COMMENT '年龄',
  `youxiang` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `shoujihao` varchar(200) DEFAULT NULL COMMENT '手机号',
  `touxiang` longtext COMMENT '头像',
  `openid` varchar(200) DEFAULT NULL COMMENT '微信openid',
  `nickname` varchar(200) DEFAULT NULL COMMENT '微信昵称',
  `avatarurl` varchar(200) DEFAULT NULL COMMENT '微信头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yonghuzhanghao` (`yonghuzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1742287909939 DEFAULT CHARSET=utf8mb3 COMMENT='用户';

/*Data for the table `yonghu` */

insert  into `yonghu`(`id`,`addtime`,`yonghuzhanghao`,`mima`,`yonghuxingming`,`xingbie`,`nianling`,`youxiang`,`shoujihao`,`touxiang`,`openid`,`nickname`,`avatarurl`) values 
(1741596825875,'2025-03-10 16:53:45','19803648720','123456','没所谓','男','22','123456@qq.com','19803648720','upload/1742884844835.jpg','','','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
