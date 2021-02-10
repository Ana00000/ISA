INSERT INTO appointment_status(id, status_value) VALUES (122, 0);
INSERT INTO appointment_status(id, status_value) VALUES (222, 2);
INSERT INTO appointment_status(id, status_value) VALUES (322, 2);
INSERT INTO appointment_status(id, status_value) VALUES (422, 1);
INSERT INTO appointment_status(id, status_value) VALUES (522, 0);
INSERT INTO appointment_status(id, status_value) VALUES (622, 1);
INSERT INTO appointment_status(id, status_value) VALUES (722, 2);
INSERT INTO appointment_status(id, status_value) VALUES (822, 0);
INSERT INTO appointment_status(id, status_value) VALUES (922, 0);
INSERT INTO appointment_status(id, status_value) VALUES (1022, 0);
INSERT INTO appointment_status(id, status_value) VALUES (1122, 0);
INSERT INTO appointment_status(id, status_value) VALUES (1222, 0);
INSERT INTO appointment_status(id, status_value) VALUES (1322, 0);
INSERT INTO appointment_status(id, status_value) VALUES (1422, 0);

 
INSERT INTO appointment_type(id, appointment_type_value) VALUES (111, 0);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (211, 0);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (311, 1);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (411, 0);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (511, 1);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (611, 1);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (711, 1);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (811, 1);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (911, 0);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (1011, 1);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (1111, 1);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (1211, 1);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (1311, 1);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (1411, 1);

/*password-mirina3982*/
INSERT INTO dermatologist(id, name, last_name, type, email, password, address, phone_number, active) VALUES (1, 'Mirina', 'Ikaric', 'dermatologist', 'mirina456ikaric@gmail.com', '$2a$10$xhd/SpXVM6Kc15Jz2UPuNutpqR2LoJgr3.vbnEPwnNPoRKe0He26S','Beograd ulica 2','065870094', 'TRUE');
/*password-janko320923*/
INSERT INTO dermatologist(id, name, last_name, type, email, password, address, phone_number, active) VALUES (2, 'Janko', 'Micic', 'dermatologist', 'janko307micic@gmail.com', '$2a$10$0dWKPjlB0zzJRjSNWzOuFuuCCW5Ds./Jof7cO75SEjSgHyzvhjMI6','Beograd ulica 3','021888654', 'TRUE');
/*password-sofija25323*/
INSERT INTO dermatologist(id, name, last_name, type, email, password, address, phone_number, active) VALUES (3, 'Sofija', 'Josipovic', 'dermatologist', 'sofija2242josipovic@gmail.com', '$2a$10$kQnV8QlLXyHLayldfTd0ney0fJscvCxN6HVlfAXKqD7fUMr7Q0Ye.','Beograd ulica 4','063870637', 'TRUE');


INSERT INTO medicine_ingredient(id, name) VALUES (100, 'Ceftaroline');
INSERT INTO medicine_ingredient(id, name) VALUES (200, 'Zonisamide');
INSERT INTO medicine_ingredient(id, name) VALUES (300, 'Menthol');
INSERT INTO medicine_ingredient(id, name) VALUES (400, 'Bergamot oil');
INSERT INTO medicine_ingredient(id, name) VALUES (500, 'Alosetron');
INSERT INTO medicine_ingredient(id, name) VALUES (600, 'Selenium');
INSERT INTO medicine_ingredient(id, name) VALUES (700, 'Magnesium');
INSERT INTO medicine_ingredient(id, name) VALUES (800, 'Cellulose');
INSERT INTO medicine_ingredient(id, name) VALUES (900, 'Betaholol');
INSERT INTO medicine_ingredient(id, name) VALUES (1000, 'Adapalene');


INSERT INTO allergy(id, medicine_ingredient_id) VALUES (1, 900);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (2, 700);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (3, 100);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (4, 600);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (5, 500);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (6, 400);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (7, 1000);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (8, 800);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (9, 200);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (10, 300);


INSERT INTO medicine_manufacturer(id, name) VALUES (1, 'Allergan India Pvt Ltd');
INSERT INTO medicine_manufacturer(id, name) VALUES (2, 'Haffkine Bio-pharmaceuticals Corporation Ltd');
INSERT INTO medicine_manufacturer(id, name) VALUES (3, 'Bharat Serums & Vaccines Ltd');
INSERT INTO medicine_manufacturer(id, name) VALUES (4, 'Walter Bushnell');
INSERT INTO medicine_manufacturer(id, name) VALUES (5, 'Torrent Pharmaceuticals Ltd');


INSERT INTO medicine_shape(id, shape_value) VALUES (1, 0);
INSERT INTO medicine_shape(id, shape_value) VALUES (2, 1);
INSERT INTO medicine_shape(id, shape_value) VALUES (3, 2);


/*password-marko040234*/
INSERT INTO patient(id, name, last_name, email, password, address, phone_number, active, subscribed_to_promotions) VALUES (4, 'Marko', 'Gojkovic', 'mile.knezevic98@gmail.com', '$2a$10$1bC7jlRWy07HDwy0/.NDm.N5J5Z17nKm4bFb4nDJvBVT.4kmdW.4m', 'Novi sad Futoska 2', '061497607', 'TRUE', 'TRUE');
/*password-klara2352892*/
INSERT INTO patient(id, name, last_name, email, password, address, phone_number, active, subscribed_to_promotions) VALUES (5, 'Klara', 'Mitrovic', 'klara56mitrov@gmail.com', '$2a$10$lJD44wzUcg16lKdLQ2e9Gur8.DOQo/MuQ6Qob6azFdWL94W2dStQi', 'Novi sad Futoska 22', '061/637603', 'TRUE', 'FALSE');
/*password-mirko329855324*/
INSERT INTO patient(id, name, last_name, email, password, address, phone_number, active, subscribed_to_promotions) VALUES (6, 'Mirko', 'Lazarevic', 'xdotdotx422@gmail.com', '$2a$10$C5Fl8.LEF.nfIDcSr8F/uOZUPon.2MmUDfJ1UIAich6gwV79W6D3S', 'Novi sad Futoska 23', '061/387-007', 'TRUE', 'TRUE');


INSERT INTO pharmacy(id, name, contact, country, city, street, number, longitude, latitude, average_grade) VALUES (13, 'Lekic', '021765873', 'Serbia', 'Novi Sad', 'Danila Kisa', '1', 19.83766985, 45.249441, 0);
INSERT INTO pharmacy(id, name, contact, country, city, street, number, longitude, latitude, average_grade) VALUES (14, 'Zegin', '021643251', 'Serbia', 'Novi Sad', 'Kralja Petra', '12', 19.83478635, 45.26154741, 0);
INSERT INTO pharmacy(id, name, contact, country, city, street, number, longitude, latitude, average_grade) VALUES (15, 'Ivancic i sinovi', '02106958', 'Serbia', 'Novi Sad', 'Slobodana Jovanovica', '22', 19.8035717, 45.254534, 0);

/*password-jovana437334*/
INSERT INTO pharmacist(id, name, last_name, type, email, password, address, phone_number, active, pharmacy_id) VALUES (7, 'Jovana', 'Stefanovic', 'pharmacist', 'jovana30356stefanovic@gmail.com', '$2a$10$jE2y9.zdTbKRg9usCa7mP.Gbda96riobY/v8gtM6Kj6SLM65e99GW', 'Smederevo Smederevska 14', '065856-880', 'TRUE', 13);
/*password-igor397829785*/
INSERT INTO pharmacist(id, name, last_name, type, email, password, address, phone_number, active, pharmacy_id) VALUES (8, 'Igor', 'Ostojic', 'pharmacist', 'igor3259ostojic@gmail.com', '$2a$10$12UAB/2GFEuVdoFk55SJFuYbHem61cbMjj5PtKhaPFph/Q5CdXUc.', 'Smederevo Smederevska 15', '061/785587', 'TRUE', 14);
/*password-sanja3523*/
INSERT INTO pharmacist(id, name, last_name, type, email, password, address, phone_number, active, pharmacy_id) VALUES (9, 'Sanja', 'Petrovic', 'pharmacist', 'sanja205petrovic@gmail.com', '$2a$10$pZxrk6lTEFPp8mJf4KO06.80cekPFgss4LvNOyFxpcBtxXmqIDZw6', 'Smederevo Smederevska 28', '063/956-231', 'TRUE', 15);


/*password-markovic*/
INSERT INTO pharmacy_admin(id, name, last_name, email, password, address, phone_number, active, pharmacy_id) VALUES (10, 'Marko', 'Markovic', 'markovic@gmail.com', '$2a$10$nPX7M5pCUiVnUcKjx4hMzuAjvjgeXux7kGwLlI3ipUxm4QetL4WMG', 'Novi Sad, Kralja Milana 10', '064765432', 'TRUE', 13);
/*password-jevtic*/
INSERT INTO pharmacy_admin(id, name, last_name, email, password, address, phone_number, active, pharmacy_id) VALUES (11, 'Atanasije', 'Jevtic', 'jevtic@gmail.com', '$2a$10$WiRklAMPLmZOMenKcpRj0eD/ETboMv.R023hcJqM8RDdA2O6GI8au', 'Novi Sad, Baje Pivljanina 2', '063123456', 'TRUE', 14);
/*password-nikolovic*/
INSERT INTO pharmacy_admin(id, name, last_name, email, password, address, phone_number, active, pharmacy_id) VALUES (12, 'Milan', 'Nikolovic', 'nikolovic@gmail.com', '$2a$10$/7WZ6z4KabOS6YucNOESqOuTBnkwUxtddeoEKbFO1ibziiBCSFYtu', 'Novi Sad, Marka Miljanova 21', '062875621', 'TRUE', 15);


INSERT INTO dermatologist_in_pharmacy(pharmacy_id, dermatologist_id) VALUES (14, 1);
INSERT INTO dermatologist_in_pharmacy(pharmacy_id, dermatologist_id) VALUES (13, 2);
INSERT INTO dermatologist_in_pharmacy(pharmacy_id, dermatologist_id) VALUES (14, 2);
INSERT INTO dermatologist_in_pharmacy(pharmacy_id, dermatologist_id) VALUES (15, 2);
INSERT INTO dermatologist_in_pharmacy(pharmacy_id, dermatologist_id) VALUES (13, 3);


--INSERT INTO pharmacist_in_pharmacy(pharmacy_id, pharmacist_id) VALUES (13, 7);
--INSERT INTO pharmacist_in_pharmacy(pharmacy_id, pharmacist_id) VALUES (14, 8);
--INSERT INTO pharmacist_in_pharmacy(pharmacy_id, pharmacist_id) VALUES (15, 9);


INSERT INTO type_of_medicine(id, medicine_type) VALUES (1, 1);
INSERT INTO type_of_medicine(id, medicine_type) VALUES (2, 1);
INSERT INTO type_of_medicine(id, medicine_type) VALUES (3, 0);
INSERT INTO type_of_medicine(id, medicine_type) VALUES (4, 0);
INSERT INTO type_of_medicine(id, medicine_type) VALUES (5, 0);
INSERT INTO type_of_medicine(id, medicine_type) VALUES (6, 1);
INSERT INTO type_of_medicine(id, medicine_type) VALUES (7, 0);
INSERT INTO type_of_medicine(id, medicine_type) VALUES (8, 1);
INSERT INTO type_of_medicine(id, medicine_type) VALUES (9, 1);
INSERT INTO type_of_medicine(id, medicine_type) VALUES (10, 0);


INSERT INTO promotion(id, start_time, end_time, description, pharmacy_id) VALUES (1, '2021-09-25 12:00', '2021-12-02 17:00', 'Promocija 1', 13);
INSERT INTO promotion(id, start_time, end_time, description, pharmacy_id) VALUES (2, '2021-10-25 12:00', '2021-03-02 17:00', 'Promocija 2', 13);
INSERT INTO promotion(id, start_time, end_time, description, pharmacy_id) VALUES (3, '2021-07-25 12:00', '2021-10-02 17:00', 'Promocija 3', 14);

INSERT INTO patients_on_promotion(promotion_id, patient_id) VALUES (4, 1);
INSERT INTO patients_on_promotion(promotion_id, patient_id) VALUES (4, 2);
INSERT INTO patients_on_promotion(promotion_id, patient_id) VALUES (4, 3);
INSERT INTO patients_on_promotion(promotion_id, patient_id) VALUES (5, 1);
INSERT INTO patients_on_promotion(promotion_id, patient_id) VALUES (6, 2);

INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (1000, 250.35, 811, 1022, 6, 3, '2021-09-25 12:00', '2021-09-25 13:00', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (2000, 450.50, 411, 922, 5, 1, '2021-12-31 15:35', '2021-12-31 17:05', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (3000, 259.99, 511, 222, 4, 2, '2021-05-04 10:10', '2021-05-04 11:11', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (4000, 300.00, 111, 522, 4, 7, '2021-01-01 23:05', '2021-12-31 23:35', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (5000, 150.50, 211, 722, 5, 9, '2021-07-22 13:20', '2021-07-22 15:00', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (6000, 850.50, 911, 222, 4, 8, '2021-03-03 01:00', '2021-03-03 01:50', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (7000, 310.99, 311, 922, 6, 2, '2021-08-29 14:00', '2021-08-29 14:14', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (8000, 261.80, 711, 322, 5, 2, '2021-12-02 16:20', '2021-12-02 17:00', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (9000, 700.00, 411, 522, 6, 9, '2021-05-17 08:05', '2021-05-17 09:00', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (10000, 451.00, 611, 922, 6, 3, '2021-02-13 00:20', '2021-02-13 00:50', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (11000, 251.00, 1111, 1122, null, 3, '2022-07-13 12:20', '2022-07-13 12:50', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (12000, 150.00, 1211, 1222, null, 1, '2023-05-15 12:20', '2023-05-15 12:30', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (13000, 440.00, 1311, 1322, null, 2, '2022-03-13 12:50', '2022-03-13 14:50', 0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty)
VALUES (14000, 240.00, 1411, 1422, null, 3, '2022-02-13 12:50', '2022-02-13 14:50', 0);


INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (13, 1000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (14, 2000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (15, 3000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (13, 4000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (15, 5000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (14, 6000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (14, 7000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (13, 8000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (15, 9000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (13, 10000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (13, 11000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (14, 12000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (13, 13000);
INSERT INTO appointment_in_pharmacy(pharmacy_id, appointment_id) VALUES (13, 14000);


INSERT INTO medicine(id, name, recipe_need, medicine_manufacturer_id, medicine_shape_id)
VALUES (1, 'Ibuprofen', False, 5, 1);
INSERT INTO medicine(id, name, recipe_need, medicine_manufacturer_id, medicine_shape_id)
VALUES (2, 'Adderall', False, 4, 3);
INSERT INTO medicine(id, name, recipe_need, medicine_manufacturer_id, medicine_shape_id)
VALUES (3, 'Lexapro', True, 1, 1);
INSERT INTO medicine(id, name, recipe_need, medicine_manufacturer_id, medicine_shape_id)
VALUES (4, 'Methadone', False, 2, 3);
INSERT INTO medicine(id, name, recipe_need, medicine_manufacturer_id, medicine_shape_id)
VALUES (5, 'Zofran', True, 1, 1);
INSERT INTO medicine(id, name, recipe_need, medicine_manufacturer_id, medicine_shape_id)
VALUES (6, 'Ketamine', False, 3, 1);
INSERT INTO medicine(id, name, recipe_need, medicine_manufacturer_id, medicine_shape_id)
VALUES (7, 'Vitamin B1', False, 3, 3);
INSERT INTO medicine(id, name, recipe_need, medicine_manufacturer_id, medicine_shape_id)
VALUES (8, 'Sinemet', True, 2, 2);
INSERT INTO medicine(id, name, recipe_need, medicine_manufacturer_id, medicine_shape_id)
VALUES (9, 'Otezla', True, 5, 2);
INSERT INTO medicine(id, name, recipe_need, medicine_manufacturer_id, medicine_shape_id)
VALUES (10, 'Codeine', False, 1, 3);


INSERT INTO medicine_in_pharmacy(pharmacy_id, medicine_id) VALUES (13, 1);
INSERT INTO medicine_in_pharmacy(pharmacy_id, medicine_id) VALUES (14, 2);
INSERT INTO medicine_in_pharmacy(pharmacy_id, medicine_id) VALUES (15, 3);
INSERT INTO medicine_in_pharmacy(pharmacy_id, medicine_id) VALUES (13, 4);
INSERT INTO medicine_in_pharmacy(pharmacy_id, medicine_id) VALUES (14, 5);
INSERT INTO medicine_in_pharmacy(pharmacy_id, medicine_id) VALUES (15, 6);

INSERT INTO pharmacy_medicine(pharmacy_id, medicine_id, quantity) VALUES (13, 1, 20);
INSERT INTO pharmacy_medicine(pharmacy_id, medicine_id, quantity) VALUES (14, 2, 30);
INSERT INTO pharmacy_medicine(pharmacy_id, medicine_id, quantity) VALUES (15, 3, 10);
INSERT INTO pharmacy_medicine(pharmacy_id, medicine_id, quantity) VALUES (13, 4, 25);
INSERT INTO pharmacy_medicine(pharmacy_id, medicine_id, quantity) VALUES (14, 5, 4);
INSERT INTO pharmacy_medicine(pharmacy_id, medicine_id, quantity) VALUES (15, 6, 100);


INSERT INTO alternative_medicine(main_medicine_id, alternative_medicine_id) VALUES (1, 3);
INSERT INTO alternative_medicine(main_medicine_id, alternative_medicine_id) VALUES (5, 2);
INSERT INTO alternative_medicine(main_medicine_id, alternative_medicine_id) VALUES (7, 9);


INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Cellulose', 'Ibuprofen');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Zonisamide', 'Ibuprofen');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Magnesium', 'Ibuprofen');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Betaholol', 'Ibuprofen');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Bergamot oil', 'Adderall');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Ceftaroline', 'Adderall');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Magnesium', 'Adderall');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Zonisamide', 'Lexapro');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Adapalene', 'Lexapro');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Ceftaroline', 'Methadone');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Alosetron', 'Methadone');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Magnesium', 'Methadone');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Adapalene', 'Methadone');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Betaholol', 'Zofran');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Cellulose', 'Ketamine');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Bergamot oil', 'Ketamine');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Ceftaroline', 'Ketamine');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Ceftaroline', 'Vitamin B1');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Magnesium', 'Vitamin B1');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Bergamot oil', 'Vitamin B1');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Adapalene', 'Sinemet');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Zonisamide', 'Otezla');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Bergamot oil', 'Codeine');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Selenium', 'Codeine');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Alosetron', 'Codeine');
INSERT INTO ingredients_of_medicine(ingredient_name, medicine_name) VALUES ('Magnesium', 'Codeine');

INSERT INTO medicine_reservation_status(id, status_value) VALUES (1, 0);
INSERT INTO medicine_reservation_status(id, status_value) VALUES (2, 1);

INSERT INTO medicine_reservation(id, pick_up_date, quantity, reservation_status, medicine_id, patient_id, pharmacy_id ) VALUES (1, '2021-03-03 00:00:00', 3, 'ACTIVE', 1, 4, 13);
INSERT INTO medicine_reservation(id, pick_up_date, quantity, reservation_status, medicine_id, patient_id, pharmacy_id ) VALUES (2, '2021-03-03 00:00:00', 5, 'ACTIVE', 4, 4, 13);
INSERT INTO medicine_reservation(id, pick_up_date, quantity, reservation_status, medicine_id, patient_id, pharmacy_id ) VALUES (3, '2020-03-03 00:00:00', 6, 'ACTIVE', 5, 4, 14);


INSERT INTO AUTHORITY (name) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_DERMATOLOGIST');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_PHARMACIST');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_PHARMACY_ADMIN');


INSERT INTO vacation(id, vacation_status_value, doctor_id, start_time, end_time) VALUES (101, 0, 1, '2021-02-17 00:00', '2021-02-18 00:00');
INSERT INTO vacation(id, vacation_status_value, doctor_id, start_time, end_time) VALUES (102, 0, 2, '2021-02-13 00:00', '2021-02-20 00:00');
INSERT INTO vacation(id, vacation_status_value, doctor_id, start_time, end_time) VALUES (103, 2, 8, '2021-03-21 00:00', '2021-03-24 00:00');
INSERT INTO vacation(id, vacation_status_value, doctor_id, start_time, end_time) VALUES (105, 0, 7, '2021-02-19 00:00', '2021-02-20 00:00');

INSERT INTO report(id, end_time, start_time, doctor_id, medicine_id, patient_id, therapy_in_days) VALUES (10001, '2021-01-13 12:50', '2021-01-13 13:50', 3, 8, 5, 2);
INSERT INTO report(id, end_time, start_time, doctor_id, medicine_id, patient_id, therapy_in_days) VALUES (10002, '2021-01-11 12:50', '2021-01-11 13:30', 9, 7, 4, 4);


