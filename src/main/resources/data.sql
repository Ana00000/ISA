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

/*password-mirina3982 ovaj dermatologist ima malo podataka*/
INSERT INTO dermatologist(id, name, last_name, type, email, password, address, phone_number, active) VALUES (1, 'Mirina', 'Ikaric', 'dermatologist', 'mirina46ikaric@gmail.com', '$2a$10$QqMGdVGgZ1/4XfawMUObzOhTbHNa2rBb.PnNf1t6reW7yFmEhMzn2','Beograd ulica 2','065870094', 'TRUE');
/*password-janko320923*/
INSERT INTO dermatologist(id, name, last_name, type, email, password, address, phone_number, active) VALUES (2, 'Janko', 'Micic', 'dermatologist', 'janko307micic@gmail.com', '$2a$10$QIr3Owwuak7feKrEdQiN.u8RNQkbzbnTqmY50uCAtpOB6Ene.BxZu','Beograd ulica 3','021888654', 'TRUE');
/*password-sofija25323*/
INSERT INTO dermatologist(id, name, last_name, type, email, password, address, phone_number, active) VALUES (3, 'Sofija', 'Josipovic', 'dermatologist', 'sofija2242josipovic@gmail.com', '$2a$10$OD1CAVFcuoeq3jFpd/DKS.UXOo.mPMAYsj2zdymtEAZcr/hNpJCim','Beograd ulica 4','063870637', 'TRUE');


INSERT INTO medicine_ingredient(id, name) VALUES (1, 'Ceftaroline');
INSERT INTO medicine_ingredient(id, name) VALUES (2, 'Zonisamide');
INSERT INTO medicine_ingredient(id, name) VALUES (3, 'Menthol');
INSERT INTO medicine_ingredient(id, name) VALUES (4, 'Bergamot oil');
INSERT INTO medicine_ingredient(id, name) VALUES (5, 'Alosetron');
INSERT INTO medicine_ingredient(id, name) VALUES (6, 'Selenium');
INSERT INTO medicine_ingredient(id, name) VALUES (7, 'Magnesium');
INSERT INTO medicine_ingredient(id, name) VALUES (8, 'Cellulose');
INSERT INTO medicine_ingredient(id, name) VALUES (9, 'Betaholol');
INSERT INTO medicine_ingredient(id, name) VALUES (10, 'Adapalene');

INSERT INTO allergy(id, medicine_ingredient_id) VALUES (1, 9);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (2, 7);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (3, 1);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (4, 6);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (5, 5);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (6, 4);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (7, 10);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (8, 8);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (9, 2);
INSERT INTO allergy(id, medicine_ingredient_id) VALUES (10, 3);


INSERT INTO medicine_manufacturer(id, name) VALUES (1, 'Allergan India Pvt Ltd');
INSERT INTO medicine_manufacturer(id, name) VALUES (2, 'Haffkine Bio pharmaceuticals Corporation Ltd');
INSERT INTO medicine_manufacturer(id, name) VALUES (3, 'Bharat Serums and Vaccines Ltd');
INSERT INTO medicine_manufacturer(id, name) VALUES (4, 'Walter Bushnell');
INSERT INTO medicine_manufacturer(id, name) VALUES (5, 'Torrent Pharmaceuticals Ltd');


INSERT INTO medicine_shape(id, shape_value) VALUES (1, 0);
INSERT INTO medicine_shape(id, shape_value) VALUES (2, 1);
INSERT INTO medicine_shape(id, shape_value) VALUES (3, 2);


/*password-marko040234*/
INSERT INTO patient(id, name, last_name, email, password, address, phone_number, active, penalties, subscribed_to_promotions, points) VALUES (4, 'Marko', 'Gojkovic', 'mile.knezevic98@gmail.com', '$2a$10$MsR7mrUJ3w32rD21cMynjO.X1nr37ARqpCyUBkahvoTRgIu7gJQe2', 'Novi sad Futoska 2', '061497607', 'TRUE', 0, 'TRUE',0);
/*password-klara2352892*/
INSERT INTO patient(id, name, last_name, email, password, address, phone_number, active, penalties, subscribed_to_promotions, points) VALUES (5, 'Klara', 'Mitrovic', 'klara56mitrov@gmail.com', '$2a$10$8j7UHWHgLSA3RAhHuUxxy.DAd0Ih13iOHKB.zcq/qvM/WW5OyYVIu', 'Novi sad Futoska 22', '061/637603', 'TRUE', 1, 'FALSE', 0);
/*password-hadziCar*/
INSERT INTO patient(id, name, last_name, email, password, address, phone_number, active, penalties, subscribed_to_promotions, points) VALUES (6, 'Aleksandar', 'Hadzibabic', 'hadziCar@gmail.com', '$2a$10$xmmsjxIhhY/CXRbdhcHOBuWgx7F16ef7OU8axXNw1VnA2dGwJs/km', 'Branimira Cosica 33', '06138909132', 'TRUE', 1, 'FALSE',0);



INSERT INTO allergies_of_patient(allergy_id, patient_id) VALUES(4, 4);
INSERT INTO allergies_of_patient(allergy_id, patient_id) VALUES(5, 4);
INSERT INTO allergies_of_patient(allergy_id, patient_id) VALUES(6, 4);
INSERT INTO allergies_of_patient(allergy_id, patient_id) VALUES(5, 5);
INSERT INTO allergies_of_patient(allergy_id, patient_id) VALUES(6, 6);
INSERT INTO allergies_of_patient(allergy_id, patient_id) VALUES(5, 6);


INSERT INTO pharmacy(id, name, contact, country, city, street, number, longitude, latitude, average_grade) VALUES (13, 'Lekic', '021765873', 'Serbia', 'Novi Sad', 'Danila Kisa', '1', 19.83766985, 45.249441, 4);
INSERT INTO pharmacy(id, name, contact, country, city, street, number, longitude, latitude, average_grade) VALUES (14, 'Zegin', '021643251', 'Serbia', 'Novi Sad', 'Kralja Petra', '12', 19.83478635, 45.26154741, 5);
INSERT INTO pharmacy(id, name, contact, country, city, street, number, longitude, latitude, average_grade) VALUES (15, 'Ivancic i sinovi', '02106958', 'Serbia', 'Novi Sad', 'Slobodana Jovanovica', '22', 19.8035717, 45.254534, 6);


/*password-jovana437334 ovaj pharmacist ima malo podataka*/
INSERT INTO pharmacist(id, name, last_name, type, email, password, address, phone_number, active, pharmacy_id) VALUES (7, 'Jovana', 'Stefanovic', 'pharmacist', 'jovana3035stefanovic@gmail.com', '$2a$10$.YCwwaB.Kk97ooP8fTPbweefVgoc5gWmGCJ9rjm15dOCbgSK0ppiy', 'Smederevo Smederevska 14', '065856-880', 'TRUE', 13);
/*password-gojkic*/
INSERT INTO pharmacist(id, name, last_name, type, email, password, address, phone_number, active, pharmacy_id) VALUES (8, 'Gojko', 'Ostojic', 'pharmacist', 'gojko@gmail.com', '$2a$10$yBd0w059I67GfhwwOIN8YOsmhBF2TF9TL3tBpizUyCcPb2gynAYpW', 'Smederevo Smederevska 15', '061/785587', 'TRUE', 14);
/*password-sanja3523*/
INSERT INTO pharmacist(id, name, last_name, type, email, password, address, phone_number, active, pharmacy_id) VALUES (9, 'Sanja', 'Petrovic', 'pharmacist', 'sanja20petrovic@gmail.com', '$2a$10$ubZ6XLKqO6WMyiS/pV9sjelyLxKKuWG7SfK4.g4HWJw0jj/tgh4Ve', 'Smederevo Smederevska 28', '063/956-231', 'TRUE', 15);


/*password-markovic*/
INSERT INTO pharmacy_admin(id, name, last_name, email, password, address, phone_number, active, pharmacy_id) VALUES (10, 'Marko', 'Markovic', 'markovic@gmail.com', '$2a$10$nPX7M5pCUiVnUcKjx4hMzuAjvjgeXux7kGwLlI3ipUxm4QetL4WMG', 'Novi Sad, Kralja Milana 10', '064765432', 'TRUE', 13);
/*password-jevtic*/
INSERT INTO pharmacy_admin(id, name, last_name, email, password, address, phone_number, active, pharmacy_id) VALUES (11, 'Atanasije', 'Jevtic', 'jevtic@gmail.com', '$2a$10$WiRklAMPLmZOMenKcpRj0eD/ETboMv.R023hcJqM8RDdA2O6GI8au', 'Novi Sad, Baje Pivljanina 2', '063123456', 'TRUE', 14);
/*password-nikolovic*/
INSERT INTO pharmacy_admin(id, name, last_name, email, password, address, phone_number, active, pharmacy_id) VALUES (12, 'Milan', 'Nikolovic', 'nikolovic@gmail.com', '$2a$10$/7WZ6z4KabOS6YucNOESqOuTBnkwUxtddeoEKbFO1ibziiBCSFYtu', 'Novi Sad, Marka Miljanova 21', '062875621', 'TRUE', 14);


INSERT INTO dermatologist_in_pharmacy(pharmacy_id, dermatologist_id) VALUES (14, 1);
INSERT INTO dermatologist_in_pharmacy(pharmacy_id, dermatologist_id) VALUES (13, 2);
INSERT INTO dermatologist_in_pharmacy(pharmacy_id, dermatologist_id) VALUES (14, 2);
INSERT INTO dermatologist_in_pharmacy(pharmacy_id, dermatologist_id) VALUES (15, 2);
INSERT INTO dermatologist_in_pharmacy(pharmacy_id, dermatologist_id) VALUES (13, 3);


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


INSERT INTO patients_on_promotion(patient_id, promotion_id) VALUES (4, 1);
INSERT INTO patients_on_promotion(patient_id, promotion_id) VALUES (4, 2);
INSERT INTO patients_on_promotion(patient_id, promotion_id) VALUES (4, 3);
INSERT INTO patients_on_promotion(patient_id, promotion_id) VALUES (5, 1);
INSERT INTO patients_on_promotion(patient_id, promotion_id) VALUES (6, 2);
INSERT INTO patients_on_promotion(patient_id, promotion_id) VALUES (6, 1);
INSERT INTO patients_on_promotion(patient_id, promotion_id) VALUES (6, 3);

INSERT INTO patient_subscribed_to_pharmacy(patient_id, pharmacy_id) VALUES(4, 14);
INSERT INTO patient_subscribed_to_pharmacy(patient_id, pharmacy_id) VALUES(5, 13);
INSERT INTO patient_subscribed_to_pharmacy(patient_id, pharmacy_id) VALUES(5, 15);
INSERT INTO patient_subscribed_to_pharmacy(patient_id, pharmacy_id) VALUES(6, 13);
INSERT INTO patient_subscribed_to_pharmacy(patient_id, pharmacy_id) VALUES(6, 14);



INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (1000, 250.35, 811, 1022, 6, 3, '2021-09-25 12:00', '2021-09-25 13:00', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (2000, 450.50, 411, 922, 5, 1, '2021-12-31 15:35', '2021-12-31 17:05', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (3000, 259.99, 511, 222, 4, 2, '2021-05-04 10:10', '2021-05-04 11:11', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (4000, 300.00, 111, 522, 4, 8, '2021-01-01 23:05', '2021-12-31 23:35', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (5000, 150.50, 211, 422, 5, 9, '2021-07-22 13:20', '2021-07-22 15:00', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (6000, 850.50, 911, 222, 4, 8, '2021-03-03 01:00', '2021-03-03 01:50', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (7000, 310.99, 311, 922, 6, 2, '2021-08-29 14:00', '2021-08-29 14:14', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (8000, 261.80, 711, 322, 5, 2, '2021-12-02 16:20', '2021-12-02 17:00', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (9000, 700.00, 411, 522, 6, 9, '2021-05-17 08:05', '2021-05-17 09:00', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (10000, 451.00, 611, 422, 6, 3, '2021-02-13 00:20', '2021-02-13 00:50', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (11000, 251.00, 1111, 1122, null, 3, '2022-07-13 12:20', '2022-07-13 12:50', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (12000, 150.00, 1211, 1222, null, 1, '2023-05-15 12:20', '2023-05-15 12:30', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (13000, 440.00, 1311, 1322, null, 2, '2022-03-13 12:50', '2022-03-13 14:50', 0,0);
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time, penalty, user_discount)
VALUES (14000, 240.00, 1411, 1422, null, 3, '2022-02-13 12:50', '2022-02-13 14:50', 0,0);


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

INSERT INTO medicine_type(id,type) VALUES(401,'ANTIBIOTIK');
INSERT INTO medicine_type(id,type) VALUES(402,'ANESTETIK');
INSERT INTO medicine_type(id,type) VALUES(403,'ANTIHISTAMINIK');

INSERT INTO medicine( name, recipe_need, medicine_manufacturer_id, medicine_shape_id,recommended_intake, points, code, contraindications, medicine_type_id)
VALUES ( 'Ibuprofen', False, 5, 1, 2, 2,'d123asd','None', 401);
INSERT INTO medicine( name, recipe_need, medicine_manufacturer_id, medicine_shape_id,recommended_intake, points, code, contraindications, medicine_type_id)
VALUES ( 'Adderall', False, 4, 3, 3, 1,'1d23asd','None', 401);
INSERT INTO medicine( name, recipe_need, medicine_manufacturer_id, medicine_shape_id,recommended_intake, points, code, contraindications, medicine_type_id)
VALUES ( 'Lexapro', True, 1, 1, 2, 3,'123dasd','None', 401);
INSERT INTO medicine( name, recipe_need, medicine_manufacturer_id, medicine_shape_id,recommended_intake, points, code, contraindications, medicine_type_id)
VALUES ( 'Methadone', False, 2, 3, 2, 4, '123asd1','None', 402);
INSERT INTO medicine( name, recipe_need, medicine_manufacturer_id, medicine_shape_id,recommended_intake, points, code, contraindications, medicine_type_id)
VALUES ( 'Zofran', True, 1, 1, 1, 2, '1231asd','None', 402);
INSERT INTO medicine( name, recipe_need, medicine_manufacturer_id, medicine_shape_id,recommended_intake, points, code, contraindications, medicine_type_id)
VALUES ( 'Ketamine', False, 3, 1, 1, 1, '1223asd','None', 402);
INSERT INTO medicine( name, recipe_need, medicine_manufacturer_id, medicine_shape_id,recommended_intake, points, code, contraindications, medicine_type_id)
VALUES ( 'Vitamin B1', False, 3, 3, 3, 2, '1232asd','None', 402);
INSERT INTO medicine( name, recipe_need, medicine_manufacturer_id, medicine_shape_id,recommended_intake, points, code, contraindications, medicine_type_id)
VALUES ( 'Sinemet', True, 2, 2, 2, 2, '123as4d','None', 403);
INSERT INTO medicine( name, recipe_need, medicine_manufacturer_id, medicine_shape_id,recommended_intake, points, code, contraindications, medicine_type_id)
VALUES ( 'Otezla', True, 5, 2, 4, 2, '1232d','None', 403);
INSERT INTO medicine( name, recipe_need, medicine_manufacturer_id, medicine_shape_id,recommended_intake, points, code, contraindications, medicine_type_id)
VALUES ( 'Codeine', False, 1, 3, 2, 1, '123a5sd','None', 403);


INSERT INTO medicine_in_pharmacy(pharmacy_id, medicine_id) VALUES (13, 1);
INSERT INTO medicine_in_pharmacy(pharmacy_id, medicine_id) VALUES (14, 2);
INSERT INTO medicine_in_pharmacy(pharmacy_id, medicine_id) VALUES (15, 3);
INSERT INTO medicine_in_pharmacy(pharmacy_id, medicine_id) VALUES (13, 4);
INSERT INTO medicine_in_pharmacy(pharmacy_id, medicine_id) VALUES (14, 5);
INSERT INTO medicine_in_pharmacy(pharmacy_id, medicine_id) VALUES (15, 6);


INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 13, 1, 20,200,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 13, 2, 20,150,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 13, 3, 20,130,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 13, 4, 20,120,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 13, 5, 20,100,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 13, 6, 20,200,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 13, 7, 20,150,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 13, 8, 20,130,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 13, 9, 20,120,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 13, 10, 20,100,1);

INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 14, 6, 5,500,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 14, 7, 2,400,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 14, 8, 2,300,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 14, 9, 1,600,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 14, 10, 1,800,1);

INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 15, 1, 2,200,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 15, 2, 2,100,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 15, 3, 2,200,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 15, 4, 2,100,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 15, 5, 2,800,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 15, 6, 2,1300,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 15, 7, 2,200,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 15, 8, 2,100,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 15, 9, 2,800,1);
INSERT INTO pharmacy_medicine( pharmacy_id, medicine_id, quantity, price,version) VALUES ( 15, 10, 2,1300,1);


INSERT INTO alternative_medicine(main_medicine_id, alternative_medicine_id) VALUES (1, 3);
INSERT INTO alternative_medicine(main_medicine_id, alternative_medicine_id) VALUES (5, 2);
INSERT INTO alternative_medicine(main_medicine_id, alternative_medicine_id) VALUES (7, 9);


INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (1, 1);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (1, 7);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (2, 2);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (2, 9);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (3, 2);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (4, 3);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (4, 4);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (4, 5);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (4, 6);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (5, 4);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (5, 10);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (5, 8);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (6, 1);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (6, 2);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (6, 4);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (6, 9);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (7, 2);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (7, 4);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (8, 5);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (9, 1);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (9, 4);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (9, 7);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (9, 8);
INSERT INTO ingredients_of_medicine(ingredient_id, medicine_id) VALUES (10, 10);


INSERT INTO medicine_reservation_status(id, status_value) VALUES (1, 0);
INSERT INTO medicine_reservation_status(id, status_value) VALUES (2, 1);


INSERT INTO medicine_reservation(id, pick_up_date, quantity, reservation_status, medicine_id, patient_id, pharmacy_id, user_discount) VALUES (1, '2021-03-03 00:00:00', 3, 'ACTIVE', 1, 6, 13, 0);
INSERT INTO medicine_reservation(id, pick_up_date, quantity, reservation_status, medicine_id, patient_id, pharmacy_id, user_discount) VALUES (2, '2021-03-03 00:00:00', 5, 'ACTIVE', 4, 6, 13, 0);
INSERT INTO medicine_reservation(id, pick_up_date, quantity, reservation_status, medicine_id, patient_id, pharmacy_id, user_discount) VALUES (3, '2021-07-03 00:00:00', 6, 'ACTIVE', 5, 6, 14, 0);
INSERT INTO medicine_reservation(id, pick_up_date, quantity, reservation_status, medicine_id, patient_id, pharmacy_id, user_discount) VALUES (4, '2021-07-03 00:00:00', 6, 'ACTIVE', 5, 6, 14, 0);
INSERT INTO medicine_reservation(id, pick_up_date, quantity, reservation_status, medicine_id, patient_id, pharmacy_id, user_discount) VALUES (5, '2021-07-03 00:00:00', 6, 'ACTIVE', 5, 5, 14, 0);
INSERT INTO medicine_reservation(id, pick_up_date, quantity, reservation_status, medicine_id, patient_id, pharmacy_id, user_discount) VALUES (6, '2021-07-03 00:00:00', 6, 'ACTIVE', 5, 4, 14, 0);


INSERT INTO AUTHORITY (name) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_DERMATOLOGIST');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_PHARMACIST');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_PHARMACY_ADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_SUPPLIER');


INSERT INTO user_authority (user_id, authority_id) VALUES (1, 3);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 3);
INSERT INTO user_authority (user_id, authority_id) VALUES (3, 3);
INSERT INTO user_authority (user_id, authority_id) VALUES (4, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (5, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (6, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (7, 4);
INSERT INTO user_authority (user_id, authority_id) VALUES (8, 4);
INSERT INTO user_authority (user_id, authority_id) VALUES (9, 4);
INSERT INTO user_authority (user_id, authority_id) VALUES (10, 5);
INSERT INTO user_authority (user_id, authority_id) VALUES (11, 5);
INSERT INTO user_authority (user_id, authority_id) VALUES (12, 5);
INSERT INTO user_authority (user_id, authority_id) VALUES (19, 7);
INSERT INTO user_authority (user_id, authority_id) VALUES (20, 7);
INSERT INTO user_authority (user_id, authority_id) VALUES (300, 6);


INSERT INTO vacation(id, vacation_status_value, doctor_id, start_time, end_time) VALUES (101, 0, 1, '2021-02-17 00:00', '2021-02-18 00:00');
INSERT INTO vacation(id, vacation_status_value, doctor_id, start_time, end_time) VALUES (102, 0, 2, '2021-02-13 00:00', '2021-02-20 00:00');
INSERT INTO vacation(id, vacation_status_value, doctor_id, start_time, end_time) VALUES (103, 2, 8, '2021-03-21 00:00', '2021-03-24 00:00');
INSERT INTO vacation(id, vacation_status_value, doctor_id, start_time, end_time) VALUES (105, 0, 7, '2021-02-19 00:00', '2021-02-20 00:00');


INSERT INTO medicine_order (id, deadline, pharmacy_admin_id) VALUES (1, '2022-11-11 10:00', 11);
INSERT INTO medicine_order (id, deadline, pharmacy_admin_id) VALUES (2, '2022-11-12 15:00', 12);


INSERT INTO medicine_order_mapping (order_id, medicine_id, medicine_order_amount) VALUES (1, 3, 30);
INSERT INTO medicine_order_mapping (order_id, medicine_id, medicine_order_amount) VALUES (1, 1, 25);
INSERT INTO medicine_order_mapping (order_id, medicine_id, medicine_order_amount) VALUES (2, 1, 250);


INSERT INTO report(id, end_time, start_time, doctor_id, medicine_id, patient_id, therapy_in_days, description) VALUES (10001, '2021-01-13 12:50', '2021-01-13 13:50', 3, 8, 5, 2, 'For therapy I recommend medicine Sinemet. Therapy should last 2 days.');
INSERT INTO report(id, end_time, start_time, doctor_id, medicine_id, patient_id, therapy_in_days, description) VALUES (10002, '2021-01-11 12:50', '2021-01-11 13:30', 9, 7, 4, 4, 'For therapy I recommend medicine Vitamin B1. Therapy should last 4 days.');


INSERT INTO medicine_prescription(id, medicine_id, patient_id, doctor_id, local_date, status) VALUES (1, 7, 6, 3, '2021-01-11', 'NEW');
INSERT INTO medicine_prescription(id, medicine_id, patient_id, doctor_id, local_date, status) VALUES (2, 8, 6, 3, '2021-03-11', 'DENIED');
INSERT INTO medicine_prescription(id, medicine_id, patient_id, doctor_id, local_date, status) VALUES (3, 7, 6, 9, '2021-02-20', 'PROCESSED');
INSERT INTO medicine_prescription(id, medicine_id, patient_id, doctor_id, local_date, status) VALUES (4, 8, 6, 9, '2021-05-14', 'NEW');
INSERT INTO medicine_prescription(id, medicine_id, patient_id, doctor_id, local_date, status) VALUES (5, 8, 4, 9, '2021-05-14', 'NEW');
INSERT INTO medicine_prescription(id, medicine_id, patient_id, doctor_id, local_date, status) VALUES (6, 8, 5, 9, '2021-05-14', 'NEW');
INSERT INTO medicine_prescription(id, medicine_id, patient_id, doctor_id, local_date, status) VALUES (7, 8, 6, 9, '2021-05-14', 'NEW');


/*password-nenadovic*/
INSERT INTO supplier(id, name, last_name, email, password, address, phone_number, active, is_logged_first_time) VALUES (19, 'Aleksa', 'Nenadovic', 'nenadovic@gmail.com', '$2a$10$x1WBCRVmwfkjetdsSYcSj.zUVGq2QIvUWKRlHJw4JhcQi.ccgb8t.', 'Kneza Lazara 76', '061343145', 'TRUE', 'TRUE');
/*password-nenadovic*/
INSERT INTO supplier(id, name, last_name, email, password, address, phone_number, active, is_logged_first_time) VALUES (20, 'Mateja', 'Nenadovic', 'nenadovic.mateja@gmail.com', '$2a$10$x1WBCRVmwfkjetdsSYcSj.zUVGq2QIvUWKRlHJw4JhcQi.ccgb8t.', 'Kneza Lazara 76', '062343145', 'TRUE', 'TRUE');


INSERT INTO medicine_offer( supplier_id, medicine_order_id, cost, status, time) VALUES (19, 1, 500, 'WAITING','2022-08-28 00:00:00');
INSERT INTO medicine_offer( supplier_id, medicine_order_id, cost, status, time) VALUES (20, 1, 750, 'WAITING','2022-08-28 00:00:00');
INSERT INTO medicine_offer( supplier_id, medicine_order_id, cost, status, time) VALUES (20, 2, 350, 'WAITING','2022-08-28 00:00:00');

/*password-stefan*/
INSERT INTO system_admin(id, name, last_name, email, password, address, phone_number, active, is_logged_first_time) VALUES (300, 'Stefan', 'Petrovic', 'stefan@gmail.com', '$2a$10$AjZC.QsU9rFl.IrUGaZvyOovamqNWiVYURj71q1KjBZjSks.kyizy', 'Novi Sad, Kralja Milana 14', '064764652', 'TRUE','TRUE');
INSERT INTO system_admin(id, name, last_name, email, password, address, phone_number, active, is_logged_first_time) VALUES (301, 'Nikola', 'Nikola', 'nikola@gmail.com', '$2a$10$R5gmTNA4BwVhYPWNwEL/tO96DrSa/VCYVbFvXSU5iW8o6ygImhPW6', 'Novi Sad, Kralja Milana 14', '064764652', 'TRUE','TRUE');


INSERT INTO complaint(text,doctor_id,patient_id,pharmacy_id) VALUES ('nije dobar lekar...', 1, 4, null);
INSERT INTO complaint(text,doctor_id,patient_id,pharmacy_id) VALUES ('nije dobara apoteka nema taj lek...', null, 4, 13);
INSERT INTO complaint(text,doctor_id,patient_id,pharmacy_id) VALUES ('jako drzak...', 3, 5, null);
INSERT INTO complaint(text,doctor_id,patient_id,pharmacy_id) VALUES ('nisu mi dali lek bez recepta o ovoj apoteci...', null, 6, 15);

INSERT INTO loyalty_program(points_for_consultation,points_for_examination,points_for_silver,points_for_gold,discaunt_for_silver,discaunt_for_gold, version) VALUES (2, 3, 15, 30,3,6,1);

INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (19, 400, 1);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (19, 32, 2);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (19, 45, 3);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (19, 17, 4);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (19, 13, 5);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (19, 300, 6);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (19, 34, 7);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (19, 44, 8);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (19, 11, 9);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (19, 13, 10);

INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (20, 12, 1);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (20, 49, 2);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (20, 88, 3);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (20, 55, 4);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (20, 83, 5);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (20, 12, 6);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (20, 39, 7);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (20, 28, 8);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (20, 25, 9);
INSERT INTO medicine_order_mapping_supplier(supplier_id, medicine_order_amount, medicine_id) VALUES (20, 13, 10);

INSERT INTO recipe(id, date_of_issue, patient_id) VALUES (1001, '2021-03-02 17:00', 4);
INSERT INTO recipe(id, date_of_issue, patient_id) VALUES (1002, '2021-01-02 17:00', 4);
INSERT INTO recipe(id, date_of_issue, patient_id) VALUES (1003, '2021-02-02 17:00', 5);
INSERT INTO recipe(id, date_of_issue, patient_id) VALUES (1004, '2021-03-02 17:00', 5);
INSERT INTO recipe(id, date_of_issue, patient_id) VALUES (1005, '2021-02-04 17:00', 6);
INSERT INTO recipe(id, date_of_issue, patient_id) VALUES (1006, '2021-03-05 17:00', 6);
INSERT INTO recipe(id, date_of_issue, patient_id) VALUES (1007, '2021-03-05 17:00', 6);
INSERT INTO recipe(id, date_of_issue, patient_id) VALUES (1008, '2021-03-05 17:00', 6);
INSERT INTO recipe(id, date_of_issue, patient_id) VALUES (1009, '2021-03-05 17:00', 6);
INSERT INTO recipe(id, date_of_issue, patient_id) VALUES (1010, '2021-03-05 17:00', 6);

INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1001, 7, 1);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1001, 2, 2);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1001, 6, 3);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1001, 1, 4);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1001, 1, 5);

INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1002, 5, 6);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1002, 1, 7);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1002, 2, 8);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1002, 1, 9);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1002, 1, 10);

INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1003, 1, 6);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1003, 3, 7);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1003, 2, 8);

INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1004, 5, 6);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1004, 1, 7);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1004, 2, 8);

INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1005, 1, 6);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1005, 1, 7);

INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1006, 2, 8);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1006, 2, 9);

INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1007, 3, 5);

INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1008, 3, 4);

INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1009, 1, 3);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1009, 1, 2);

INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1010, 2, 1);
INSERT INTO medicine_recipe_mapping(recipe_id, medicine_recipe_amount, medicine_id) VALUES(1010, 2, 8);
