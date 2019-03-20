INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(1,'March,2019',TO_DATE('03/01/2019','MM/DD/YYYY') ,TO_DATE('03/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(2,'April,2019',TO_DATE('04/01/2019','MM/DD/YYYY') ,TO_DATE('04/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(3,'May,2019',TO_DATE('05/01/2019','MM/DD/YYYY') ,TO_DATE('05/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(4,'June,2019',TO_DATE('06/01/2019','MM/DD/YYYY') ,TO_DATE('06/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(5,'July,2019',TO_DATE('07/01/2019','MM/DD/YYYY') ,TO_DATE('07/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(6,'August,2019',TO_DATE('08/01/2019','MM/DD/YYYY') ,TO_DATE('08/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(7,'September,2019',TO_DATE('09/01/2019','MM/DD/YYYY') ,TO_DATE('09/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(8,'October,2018',TO_DATE('10/01/2018','MM/DD/YYYY') ,TO_DATE('10/30/2018','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(9,'November,2018',TO_DATE('11/01/2018','MM/DD/YYYY') ,TO_DATE('11/30/2018','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(10,'December,2018',TO_DATE('12/01/2018','MM/DD/YYYY') ,TO_DATE('12/30/2018','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(11,'January,2018',TO_DATE('01/01/2018','MM/DD/YYYY') ,TO_DATE('01/30/2018','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(12,'February,2018',TO_DATE('02/01/2018','MM/DD/YYYY') ,TO_DATE('02/30/2018','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(13,'August,2018',TO_DATE('08/01/2018','MM/DD/YYYY') ,TO_DATE('08/30/2018','MM/DD/YYYY'),22);

INSERT INTO EVENT_TYPE(id,name,short_name,description,start_time,end_time) VALUES(1,'Morning Meditation','MM','Morning meditation is help full',TO_DATE(' 01/01/2001 08:45 AM','MM/DD/YYYY HH:mi AM '),TO_DATE(' 01/01/2001 09:15 AM','MM/DD/YYYY HH:mi PM '));
INSERT INTO EVENT_TYPE(id,name,short_name,description,start_time,end_time) VALUES(2,'Retreat','RR','Help to get relaxed',TO_DATE(' 01/01/2001 07:30 AM','MM/DD/YYYY HH:mi AM '),TO_DATE(' 01/01/2001 09:15 PM','MM/DD/YYYY HH:mi PM '));
INSERT INTO EVENT_TYPE(id,name,short_name,description,start_time,end_time) VALUES(3,'DC Lecture','DC','extra knowledge',TO_DATE(' 01/01/2001 01:30 AM','MM/DD/YYYY HH:mi AM '),TO_DATE(' 01/01/2001 03:15 AM','MM/DD/YYYY HH:mi PM '));


INSERT INTO LOCATION(id,name,short_name,description,capacity) VALUES(1,'Dalbi hall ','DB','it is a hall which locate in algiro',150);
INSERT INTO LOCATION(id,name,short_name,description,capacity) VALUES(2,'Boys Golder Dome ','BGD','it is a wide dom ',500);
INSERT INTO LOCATION(id,name,short_name,description,capacity) VALUES(3,'Girls Golder Dome ','GGD','it is a wide dom',500);

INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(1,'event for meditation',1,1,1);
INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(2,'event for meditation',2,1,1);
INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(3,'event for meditation',3,1,1);
INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(4,'event for meditation',4,1,1);
INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(5,'event for meditation',5,1,1);
INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(6,'event for meditation',6,1,1);
INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(7,'event for meditation',7,1,1);
INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(8,'event for meditation',8,1,1);
INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(9,'event for meditation',9,1,1);
INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(10,'event for meditation',10,1,1);
INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(11,'event for meditation',11,1,1);
INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(12,'event for meditation',12,1,1);
INSERT INTO EVENT(id,description,duration,event_type,location) VALUES(13,'event for meditation',13,1,1);


INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (1,'000-98-1234','7888',TO_DATE('03/01/2019','MM/DD/YYYY'),'Michael','Berhanu','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (2,'000-98-1235','7326',TO_DATE('03/01/2019','MM/DD/YYYY'),'Seth','Barrera','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (3,'000-98-1236','7698',TO_DATE('03/01/2019','MM/DD/YYYY'),'Zachariah','Pratt','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (4,'000-98-1237','7417',TO_DATE('03/01/2019','MM/DD/YYYY'),'Janiyah','King','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (5,'000-98-1238','7839',TO_DATE('03/01/2019','MM/DD/YYYY'),'Cason','Mathis','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (6,'000-98-1239','7284',TO_DATE('03/01/2019','MM/DD/YYYY'),'Davion ','Mejia','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (7,'000-98-1230','7482',TO_DATE('03/01/2019','MM/DD/YYYY'),'Soren ','Thornton','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (8,'000-98-1231','7938',TO_DATE('03/01/2019','MM/DD/YYYY'),'Mina ','Stein','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (9,'000-98-1232','7870',TO_DATE('03/01/2019','MM/DD/YYYY'),'Annabel ','Gilbert','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (10,'000-98-1233','7623',TO_DATE('03/01/2019','MM/DD/YYYY'),'Diamond ','Hill','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (11,'000-98-1241','6047',TO_DATE('03/01/2019','MM/DD/YYYY'),'Zaniyah ','Sanders','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (12,'000-98-1242','6724',TO_DATE('03/01/2019','MM/DD/YYYY'),'Kameron ','Brandt','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (13,'000-98-1243','7649',TO_DATE('03/01/2019','MM/DD/YYYY'),'Johnathon ','Stanley','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (14,'000-98-1244','7664',TO_DATE('03/01/2019','MM/DD/YYYY'),'Ayla ','Nielsen','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (15,'000-98-1245','7532',TO_DATE('03/01/2019','MM/DD/YYYY'),'Kristopher ','Becker','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (16,'000-98-1246','7763',TO_DATE('03/01/2019','MM/DD/YYYY'),'Myah ','Clarke','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (17,'000-98-1247','7409',TO_DATE('03/01/2019','MM/DD/YYYY'),'Hamza ','Cordova','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (18,'000-98-1248','7862',TO_DATE('03/01/2019','MM/DD/YYYY'),'Gracie  ','Hammond','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (19,'000-98-1249','7946',TO_DATE('03/01/2019','MM/DD/YYYY'),'Michael','Owens','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (20,'000-98-1250','7433',TO_DATE('03/01/2019','MM/DD/YYYY'),'Osvaldo ','Coleman','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (21,'000-98-1251','7722',TO_DATE('03/01/2019','MM/DD/YYYY'),'Reese ','Summers','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (22,'000-98-1252','7375',TO_DATE('03/01/2019','MM/DD/YYYY'),'Natasha ','Alvarez','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (23,'000-98-1253','7359',TO_DATE('03/01/2019','MM/DD/YYYY'),'Santiago ','Santiago ','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (24,'000-98-1254','7441',TO_DATE('03/01/2019','MM/DD/YYYY'),'Jonah ','Poole','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (25,'000-98-1255','7490',TO_DATE('03/01/2019','MM/DD/YYYY'),'Kyra ','Vargas','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (26,'000-98-1256','7474',TO_DATE('03/01/2019','MM/DD/YYYY'),'Lindsey ','Estes','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (27,'000-98-1257','7334',TO_DATE('03/01/2019','MM/DD/YYYY'),'Manuel ','Chase','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (28,'000-98-1258','7342',TO_DATE('03/01/2019','MM/DD/YYYY'),'Amya ','Allen','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (29,'000-98-1259','7672',TO_DATE('03/01/2019','MM/DD/YYYY'),'David ','Collier','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (30,'000-98-1260','7383',TO_DATE('03/01/2019','MM/DD/YYYY'),'Viviana ','Middleton','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (31,'000-98-1261','5981',TO_DATE('03/01/2019','MM/DD/YYYY'),'Maribel ','Glass','mbernahu@mum.edu');
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email) VALUES (32,'000-98-1262','8001',TO_DATE('03/01/2019','MM/DD/YYYY'),'Estes','Jonah ','mbernahu@mum.edu');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(101,'319','614','0282');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(201,'319','614','0282');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(301,'319','614','0282');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(401,'319','614','0282');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(501,'319','614','0282');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(601,'319','614','0282');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(701,'319','614','0282');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(801,'319','614','0282');


INSERT INTO STUDENT(id,email,first_name,last_name,bar_code,entry,student_id,phone_id) VALUES(101,'andyhailu@email.com','Andualem','Abebe','7888',TO_DATE('08/07/2018','MM/DD/YYYY'),'986736',101);
INSERT INTO STUDENT(id,email,first_name,last_name,bar_code,entry,student_id,phone_id) VALUES(102,'mike@email.com','Mikael','Solomon','7326',TO_DATE('08/07/2018','MM/DD/YYYY'),'986737',201);
INSERT INTO STUDENT(id,email,first_name,last_name,bar_code,entry,student_id,phone_id) VALUES(103,'kabinad@email.com','Kabinad','Melaku','7698',TO_DATE('08/07/2018','MM/DD/YYYY'),'986735',301);
INSERT INTO STUDENT(id,email,first_name,last_name,bar_code,entry,student_id,phone_id) VALUES(104,'kassish@email.com','Kassahun','Mekonne ','7417',TO_DATE('08/07/2018','MM/DD/YYYY'),'986739',401);
INSERT INTO STUDENT(id,email,first_name,last_name,bar_code,entry,student_id,phone_id) VALUES(105,'bire@email.com','Birhane','Girmay','7839',TO_DATE('08/07/2018','MM/DD/YYYY'),'986731',501);
INSERT INTO STUDENT(id,email,first_name,last_name,bar_code,entry,student_id,phone_id) VALUES(106,'dave@email.com','Dawit','Habte','7284',TO_DATE('08/07/2018','MM/DD/YYYY'),'986732',601);
INSERT INTO STUDENT(id,email,first_name,last_name,bar_code,entry,student_id,phone_id) VALUES(107,'festus@email.com','Fustus','Ipito','7482',TO_DATE('08/07/2018','MM/DD/YYYY'),'986733',701);
INSERT INTO STUDENT(id,email,first_name,last_name,bar_code,entry,student_id,phone_id) VALUES(108,'ujwol@email.com','Unjwol','Chandra','7938',TO_DATE('08/07/2018','MM/DD/YYYY'),'986734',801);


