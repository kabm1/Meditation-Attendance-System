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

