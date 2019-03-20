INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(1,'March,2019',TO_DATE('03/01/2019','MM/DD/YYYY') ,TO_DATE('03/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(2,'April,2019',TO_DATE('04/01/2019','MM/DD/YYYY') ,TO_DATE('04/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(3,'May,2019',TO_DATE('05/01/2019','MM/DD/YYYY') ,TO_DATE('05/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(4,'June,2019',TO_DATE('06/01/2019','MM/DD/YYYY') ,TO_DATE('06/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(5,'July,2019',TO_DATE('07/01/2019','MM/DD/YYYY') ,TO_DATE('07/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(6,'August,2019',TO_DATE('08/01/2019','MM/DD/YYYY') ,TO_DATE('08/30/2019','MM/DD/YYYY'),22);
INSERT INTO DURATION (id,name, start_date, end_date, number_of_days) VALUES(7,'September,2019',TO_DATE('09/01/2019','MM/DD/YYYY') ,TO_DATE('09/30/2019','MM/DD/YYYY'),22);

INSERT INTO EVENT_TYPE(id,name,short_name,description,start_time,end_time) VALUES(1,'Morning Meditation','MM','Morning meditation is help full',TO_DATE(' 01/01/2001 08:45 AM','MM/DD/YYYY HH:mi AM '),TO_DATE(' 01/01/2001 09:15 AM','MM/DD/YYYY HH:mi PM '));
INSERT INTO EVENT_TYPE(id,name,short_name,description,start_time,end_time) VALUES(2,'Retreat','RR','Help to get relaxed',TO_DATE(' 01/01/2001 07:30 AM','MM/DD/YYYY HH:mi AM '),TO_DATE(' 01/01/2001 09:15 PM','MM/DD/YYYY HH:mi PM '));
INSERT INTO EVENT_TYPE(id,name,short_name,description,start_time,end_time) VALUES(3,'DC Lecture','DC','extra knowledge',TO_DATE(' 01/01/2001 01:30 AM','MM/DD/YYYY HH:mi AM '),TO_DATE(' 01/01/2001 03:15 AM','MM/DD/YYYY HH:mi PM '));


INSERT INTO LOCATION(id,name,short_name,description,capacity) VALUES(1,'Dalbi hall ','DB','it is a hall which locate in algiro',150);
INSERT INTO LOCATION(id,name,short_name,description,capacity) VALUES(2,'Boys Golder Dome ','BGD','it is a wide dom ',500);
INSERT INTO LOCATION(id,name,short_name,description,capacity) VALUES(3,'Girls Golder Dome ','GGD','it is a wide dom',500);

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


