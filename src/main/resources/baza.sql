﻿DROP TABLE IF EXISTS TRANSACTIONS;
DROP TABLE IF EXISTS ORDER_DETAILS;
DROP TABLE IF EXISTS ORDERS;
DROP TABLE IF EXISTS MENU;
DROP TABLE IF EXISTS MEAL_TRANSLATION;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS MEAL_TYPE_DICTIONARY;
CREATE TABLE USERS (
USER_ID VARCHAR(32) NOT NULL,
USER_PASSWORD VARCHAR(255) NOT NULL,
USER_REAL_NAME VARCHAR(30),
USER_POSITION VARCHAR(32) NOT NULL,
CREATE_DATE TIMESTAMP NOT NULL,
IS_ENABLED BOOL NOT NULL,
PRIMARY KEY (USER_ID)
);
CREATE TABLE ORDERS (
ORDER_ID INT(6),
ORDER_DATE DATE NOT NULL,
ORDER_STATUS VARCHAR(11) NOT NULL,
USER_ID VARCHAR(12) NOT NULL,
PRIMARY KEY (ORDER_ID),
FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);
CREATE TABLE MEAL_TRANSLATION (
MEAL_ID INT(3) NOT NULL AUTO_INCREMENT,
MEAL_DESC_PL VARCHAR(100) NOT NULL,
MEAL_DESC_EN VARCHAR(100),
PRIMARY KEY (MEAL_ID)
);
CREATE TABLE MEAL_TYPE_DICTIONARY(
MEAL_TYPE_ID INT(4),
MEAL_TYPE_PL VARCHAR(25) NOT NULL,
MEAL_TYPE_EN VARCHAR(25),
PRIMARY KEY (MEAL_TYPE_ID)
);
CREATE TABLE MENU (
MENU_ID INT(3) NOT NULL AUTO_INCREMENT,
MEAL_TYPE_ID INT(8),
MEAL_TRANSLATION_ID INT(8) NOT NULL,
UNIT_PRICE DECIMAL(7,2) NOT NULL,
IS_VISIBLE VARCHAR(1) NOT NULL,
PRIMARY KEY (MENU_ID),
FOREIGN KEY (MEAL_TRANSLATION_ID) REFERENCES MEAL_TRANSLATION(MEAL_ID),
FOREIGN KEY (MEAL_TYPE_ID) REFERENCES MEAL_TYPE_DICTIONARY(MEAL_TYPE_ID)
);
CREATE TABLE ORDER_DETAILS (
ORDER_DETAILS_ID INT AUTO_INCREMENT,
ORDER_ID INT(6) NOT NULL,
DEVICE_ID VARCHAR(3),
MENU_ID INT(3) NOT NULL,
UNIT_PRICE DECIMAL(4,2) NOT NULL,
TIMESTAMP TIMESTAMP NOT NULL,
CLIENT_COMMENT VARCHAR(200),
PRIMARY KEY (ORDER_DETAILS_ID),
FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ORDER_ID),
FOREIGN KEY (MENU_ID) REFERENCES MENU(MENU_ID)
);
CREATE TABLE TRANSACTIONS (
TRANSACTION_ID INT(8),
DEVICE_ID VARCHAR(3),
ORDER_ID INT(6) NOT NULL,
TRANSACTION_DATE DATE NOT NULL,
TOTAL_COST DECIMAL(4,2) NOT NULL,
TOTAL_UNITS INT(2),
PAYMENT_TYPE CHARACTER(1),
USER_ID VARCHAR(12) NOT NULL,
TIMESTAMP TIMESTAMP NOT NULL,
PRIMARY KEY(TRANSACTION_ID),
FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ORDER_ID),
FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);
INSERT INTO MEAL_TYPE_DICTIONARY (MEAL_TYPE_ID,MEAL_TYPE_PL, MEAL_TYPE_EN) VALUES (101,'ZUPY','SOUP');
INSERT INTO MEAL_TYPE_DICTIONARY (MEAL_TYPE_ID,MEAL_TYPE_PL, MEAL_TYPE_EN) VALUES (201,'DANIA RYBNE','FISH');
INSERT INTO MEAL_TYPE_DICTIONARY (MEAL_TYPE_ID,MEAL_TYPE_PL, MEAL_TYPE_EN) VALUES (301,'DANIA MIĘSNE','MEAT');
INSERT INTO MEAL_TYPE_DICTIONARY (MEAL_TYPE_ID,MEAL_TYPE_PL, MEAL_TYPE_EN) VALUES (401,'DESERY','DESSERT');
INSERT INTO MEAL_TYPE_DICTIONARY (MEAL_TYPE_ID,MEAL_TYPE_PL, MEAL_TYPE_EN) VALUES (501,'SOKI','JUICE');
INSERT INTO MEAL_TYPE_DICTIONARY (MEAL_TYPE_ID,MEAL_TYPE_PL, MEAL_TYPE_EN) VALUES (601,'PIWO','BEER');
INSERT INTO MEAL_TYPE_DICTIONARY (MEAL_TYPE_ID,MEAL_TYPE_PL, MEAL_TYPE_EN) VALUES (701,'NAPOJE','DRINK');
INSERT INTO MEAL_TYPE_DICTIONARY (MEAL_TYPE_ID,MEAL_TYPE_PL, MEAL_TYPE_EN) VALUES (801,'KAWA','COFFEE');
INSERT INTO MEAL_TYPE_DICTIONARY (MEAL_TYPE_ID,MEAL_TYPE_PL, MEAL_TYPE_EN) VALUES (901,'HERBATA','TEA');
INSERT INTO MEAL_TYPE_DICTIONARY (MEAL_TYPE_ID,MEAL_TYPE_PL, MEAL_TYPE_EN) VALUES (1001,'WODA','WATER');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(10,'Żurek po polsku z białą kiełbasą','Polish white borsch with white sausage');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(11,'Rosół z makaronem domowym','Broth with home-made pasta');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(12,'Barszcz czerwony z kołdunami','Beetroot soup and dumplings stuffed with meat');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(13,'Zupa borowikowa','Mushroon soup');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(14,'Krem z pomidorów','Tomato cream');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(20,'Pstrąg smażony z ziemniakami i warzywami','Fried trout with potato and vegetables');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(21,'Halibut w sosie krewetkowym z ziemniakami i warzywami','Fried halibut in shrimp sauce with potato and vegetables');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(22,'Grillowany łosoś z frytkami i surówką z marchewki','Grilled salmon with french fries and carrot salad');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(30,'Soczyste panierowane polędwiczki z kurczaka podawane  z frytkami i surówką','Juicy breaded chicken fillets served with fries and salad');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(31,'Zrazy wołowe z pieczonymi ziemniakami i surówką','Wound beef chops with baked potato and salad');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(32,'Polędwica wołowa z masłem czosnkowym, pieczonymi ziemniakami i surówką','Beef fillet with garlic butter, baked potato and salad');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(33,'Kotlet schabowy podawany z ziemniakami i surówką','Pork chop with potato and salad');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(34,'Kaczka z konfiturą wiśniową i jabłkiem pieczonym, serowowana z pieczonymi ziemniakami','Duck with apples and cherry jam, served with baked potato');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(40,'Naleśniki z owocami i likierem','Pancakes with fruites and licquer');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(41,'Torcik lodowy waniliowy','Vanilla Ice Cream');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(42,'Creme brulee','Creme brulee');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(43,'Tort czekoladowy','Chocolate cake');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(44,'Tarta malinowa','Raspberry tart');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(45,'Galaretka owocowa','Fruit jelly');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(50,'Sok pomarańczowy','Orange juice');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(51,'Sok jabłkowy','Apple Juice');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(52,'Sok grejpfrutowy','Grapefruit juice');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(53,'Sok pomidorowy','Tomato juice');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(54,'Nektar z czarnej porzeczki','Blackcurrant nectar');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(55,'Heineken','Heineken');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(60,'Żywiec','Żywiec');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(61,'Warka','Warka');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(62,'Desperdos','Desperados');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(63,'Estrella','Estrella');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(70,'Cosmopolitan','Cosmopolitan');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(71,'Martini','Martini');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(72,'Whiskey','Whiskey');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(73,'Margherita truskawkowa','Strawberry margherita');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(74,'Mohito','Mohito');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(80,'Cappuccino','Cappuccino');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(81,'Espresso','Espresso');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(82,'Latte','Latte');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(83,'Kawa po irlandzku','Irish coffee');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(90,'Herbata czarna','Black tea');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(91,'Herbata zielona','Green tea');
INSERT INTO MEAL_TRANSLATION (MEAL_ID,MEAL_DESC_PL,MEAL_DESC_EN) VALUES(100,'Woda niegazowana/gazowana','Water/sparkling water');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(10,101,10,12,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(11,101,11,9,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(12,101,12,10,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(13,101,13,12,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(14,101,14,10,'N');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(20,201,20,36,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(21,201,21,55,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(22,201,22,34,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(30,301,30,28,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(31,301,31,35,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(32,301,32,35,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(33,301,33,25,'N');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(34,301,34,38,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(40,401,40,24,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(41,401,41,16,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(42,401,42,16,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(43,401,43,15,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(44,401,44,14,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(45,401,45,12,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(50,501,50,6,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(51,501,51,6,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(52,501,52,6,'N');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(53,501,53,6,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(54,501,54,6,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(55,501,55,8,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(60,601,60,8,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(61,601,61,8,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(62,601,62,9,'N');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(63,601,63,10,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(70,701,70,16,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(71,701,71,20,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(72,701,72,25,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(73,701,73,18,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(74,701,74,16,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(80,801,80,10,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(81,801,81,8,'N');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(82,801,82,12,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(83,801,83,14,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(90,901,90,7,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(91,901,91,6,'Y');
INSERT INTO MENU (MENU_ID,MEAL_TYPE_ID,MEAL_TRANSLATION_ID,UNIT_PRICE,IS_VISIBLE)  VALUES(100,1001,100,5,'Y');
INSERT INTO USERS (USER_ID,USER_PASSWORD,USER_REAL_NAME,USER_POSITION,CREATE_DATE,IS_ENABLED) VALUES('dgmerek','dgmerek','Dorota Gmerek','admin','2016-01-01',1);
INSERT INTO USERS (USER_ID,USER_PASSWORD,USER_REAL_NAME,USER_POSITION,CREATE_DATE,IS_ENABLED) VALUES('mzacniewski','macniewski','Mateusz Zacniewski','admin','2016-01-01',1);
INSERT INTO USERS (USER_ID,USER_PASSWORD,USER_REAL_NAME,USER_POSITION,CREATE_DATE,IS_ENABLED) VALUES('mchmielarz','mchmielarz','Michał Chmielarz','admin','2016-01-02',1);
INSERT INTO USERS (USER_ID,USER_PASSWORD,USER_REAL_NAME,USER_POSITION,CREATE_DATE,IS_ENABLED) VALUES('aduchna','aduchna','Artur Duchna','admin','2016-01-02',1);
INSERT INTO USERS (USER_ID,USER_PASSWORD,USER_REAL_NAME,USER_POSITION,CREATE_DATE,IS_ENABLED) VALUES('jkluk','jkluk','Jagna Kluk','admin','2016-01-03',1);
INSERT INTO USERS (USER_ID,USER_PASSWORD,USER_REAL_NAME,USER_POSITION,CREATE_DATE,IS_ENABLED) VALUES('testowy1','testowy1','User Testowy1','manager','2016-01-03',1);
INSERT INTO USERS (USER_ID,USER_PASSWORD,USER_REAL_NAME,USER_POSITION,CREATE_DATE,IS_ENABLED) VALUES('testowy2','testowy2','User Testowy2','waiter','2016-01-04',1);
INSERT INTO USERS (USER_ID,USER_PASSWORD,USER_REAL_NAME,USER_POSITION,CREATE_DATE,IS_ENABLED) VALUES('testowy3','testowy3','User Testowy3','kitchen','2016-01-05',0);
INSERT INTO ORDERS (ORDER_ID,ORDER_DATE,ORDER_STATUS,USER_ID) VALUES('20160001','2016-12-01','NEW','dgmerek');
INSERT INTO ORDERS (ORDER_ID,ORDER_DATE,ORDER_STATUS,USER_ID) VALUES('20160002','2016-01-03','IN PROGRESS','testowy1');
INSERT INTO ORDERS (ORDER_ID,ORDER_DATE,ORDER_STATUS,USER_ID) VALUES('20160003','2016-01-04','DONE','dgmerek');
INSERT INTO ORDERS (ORDER_ID,ORDER_DATE,ORDER_STATUS,USER_ID) VALUES('20160004','2016-01-05','CLOSED','testowy2');
INSERT INTO ORDERS (ORDER_ID,ORDER_DATE,ORDER_STATUS,USER_ID) VALUES('20160005','2016-01-05','NEW','mzacniewski');
INSERT INTO ORDERS (ORDER_ID,ORDER_DATE,ORDER_STATUS,USER_ID) VALUES('20160006','2016-01-05','IN PROGRESS','dgmerek');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160001','D01',10,12,'2016-12-01 18:08','Wszytsko ok');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160001','D01',11,9,'2016-12-01 18:08','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160001','D01',12,10,'2016-12-01 18:08','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160001','D01',13,12,'2016-12-01 18:08','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160002','D02',14,10,'2016-01-03 19:20','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160002','D02',20,36,'2016-01-03 19:20','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160002','D02',21,55,'2016-01-03 19:20','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160002','D02',22,34,'2016-01-03 19:20','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160003','D03',30,28,'2016-01-04 13:35','OK');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160003','D03',31,35,'2016-01-04 13:35','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160003','D03',32,35,'2016-01-04 13:35','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160003','D03',33,25,'2016-01-04 13:35','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160004','D04',34,38,'2016-01-05 14:11','Dziękujemy!');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160004','D04',40,24,'2016-01-05 14:11','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160004','D04',41,16,'2016-01-05 14:11','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160004','D04',42,16,'2016-01-05 14:11','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160005','D05',43,15,'2016-01-05 15:03','Jedzenie pyszne.');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160005','D05',44,14,'2016-01-05 15:03','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160005','D05',45,12,'2016-01-05 15:03','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160005','D05',50,6,'2016-01-05 15:03','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160006','D06',51,6,'2016-01-05 16:59','Super obsługa');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160006','D06',52,6,'2016-01-05 16:59','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160006','D06',53,6,'2016-01-05 16:59','null');
INSERT INTO ORDER_DETAILS (ORDER_ID,DEVICE_ID,MENU_ID,UNIT_PRICE,TIMESTAMP,CLIENT_COMMENT) VALUES('20160006','D06',54,6,'2016-01-05 16:59','null');
INSERT INTO TRANSACTIONS (TRANSACTION_ID,DEVICE_ID,ORDER_ID,TRANSACTION_DATE,TOTAL_COST,TOTAL_UNITS,PAYMENT_TYPE,USER_ID,TIMESTAMP) VALUES('10000001','D01','20160001','2016-12-01','12','2','1','dgmerek','2016-12-01 12:55');
INSERT INTO TRANSACTIONS (TRANSACTION_ID,DEVICE_ID,ORDER_ID,TRANSACTION_DATE,TOTAL_COST,TOTAL_UNITS,PAYMENT_TYPE,USER_ID,TIMESTAMP) VALUES('10000002','D02','20160002','2016-01-03','34','2','2','testowy1','2016-01-03 13:21');
INSERT INTO TRANSACTIONS (TRANSACTION_ID,DEVICE_ID,ORDER_ID,TRANSACTION_DATE,TOTAL_COST,TOTAL_UNITS,PAYMENT_TYPE,USER_ID,TIMESTAMP) VALUES('10000003','D01','20160003','2016-01-04','28','3','2','dgmerek','2016-01-04 14:22');
INSERT INTO TRANSACTIONS (TRANSACTION_ID,DEVICE_ID,ORDER_ID,TRANSACTION_DATE,TOTAL_COST,TOTAL_UNITS,PAYMENT_TYPE,USER_ID,TIMESTAMP) VALUES('10000004','D03','20160004','2016-01-05','38','2','1','testowy2','2016-01-05 14:55');
INSERT INTO TRANSACTIONS (TRANSACTION_ID,DEVICE_ID,ORDER_ID,TRANSACTION_DATE,TOTAL_COST,TOTAL_UNITS,PAYMENT_TYPE,USER_ID,TIMESTAMP) VALUES('10000005','D03','20160005','2016-01-05','15','2','1','mzacniewski','2016-01-05 15:01');
INSERT INTO TRANSACTIONS (TRANSACTION_ID,DEVICE_ID,ORDER_ID,TRANSACTION_DATE,TOTAL_COST,TOTAL_UNITS,PAYMENT_TYPE,USER_ID,TIMESTAMP) VALUES('10000006','D03','20160006','2016-01-05','6','1','2','dgmerek','2016-01-05 16:43');
