INSERT INTO appointment_status(id, status_value) VALUES (1, 0);
INSERT INTO appointment_status(id, status_value) VALUES (2, 2);
INSERT INTO appointment_status(id, status_value) VALUES (3, 2);
INSERT INTO appointment_status(id, status_value) VALUES (4, 1);
INSERT INTO appointment_status(id, status_value) VALUES (5, 0);
INSERT INTO appointment_status(id, status_value) VALUES (6, 1);
INSERT INTO appointment_status(id, status_value) VALUES (7, 2);
INSERT INTO appointment_status(id, status_value) VALUES (8, 0);
INSERT INTO appointment_status(id, status_value) VALUES (9, 0);
INSERT INTO appointment_status(id, status_value) VALUES (10, 1);

 
INSERT INTO appointment_type(id, appointment_type_value) VALUES (1, 0);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (2, 2);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (3, 2);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (4, 1);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (5, 0);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (6, 1);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (7, 2);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (8, 0);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (9, 0);
INSERT INTO appointment_type(id, appointment_type_value) VALUES (10, 1);


INSERT INTO dermatologist(id, name, last_name, type, email, password) VALUES (1, 'Mirina', 'Ikaric', 'dermatologist', 'mirina456ikaric@gmail.com', 'mirina3982');
INSERT INTO dermatologist(id, name, last_name, type, email, password) VALUES (2, 'Janko', 'Micic', 'dermatologist', 'janko307micic@gmail.com', 'janko320923');
INSERT INTO dermatologist(id, name, last_name, type, email, password) VALUES (3, 'Sofija', 'Josipovic', 'dermatologist', 'sofija2242josipovic@gmail.com', 'sofija25323');


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
INSERT INTO medicine_manufacturer(id, name) VALUES (2, 'Haffkine Bio-pharmaceuticals Corporation Ltd');
INSERT INTO medicine_manufacturer(id, name) VALUES (3, 'Bharat Serums & Vaccines Ltd');
INSERT INTO medicine_manufacturer(id, name) VALUES (4, 'Walter Bushnell');
INSERT INTO medicine_manufacturer(id, name) VALUES (5, 'Torrent Pharmaceuticals Ltd');


INSERT INTO medicine_shape(id, shape_value) VALUES (1, 0);
INSERT INTO medicine_shape(id, shape_value) VALUES (2, 1);
INSERT INTO medicine_shape(id, shape_value) VALUES (3, 2);


INSERT INTO patient(id, name, last_name, email, password) VALUES (4, 'Marko', 'Gojkovic', 'marko12653gojkovic@gmail.com', 'marko040234');
INSERT INTO patient(id, name, last_name, email, password) VALUES (5, 'Klara', 'Mitrovic', 'klara0430mitrovic@gmail.com', 'klara2352892');
INSERT INTO patient(id, name, last_name, email, password) VALUES (6, 'Mirko', 'Lazarevic', 'mirko1205lazarevic@gmail.com', 'mirko329855324');


INSERT INTO pharmacist(id, name, last_name, type, email, password) VALUES (7, 'Jovana', 'Stefanovic', 'pharmacist', 'jovana30356stefanovic@gmail.com', 'jovana437334');
INSERT INTO pharmacist(id, name, last_name, type, email, password) VALUES (8, 'Igor', 'Ostojic', 'pharmacist', 'igor3259ostojic@gmail.com', 'igor397829785');
INSERT INTO pharmacist(id, name, last_name, type, email, password) VALUES (9, 'Sanja', 'Petrovic', 'pharmacist', 'sanja205petrovic@gmail.com', 'sanja3523');


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


INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time)
VALUES (1, 250.35, 8, 10, 6, 3, '2020-09-25 12:00', '2020-09-25 13:00');
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time)
VALUES (2, 450.50, 4, 9, 5, 1, '2020-12-31 15:35', '2020-12-31 17:05');
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time)
VALUES (3, 259.99, 5, 2, 4, 2, '2020-05-04 10:10', '2020-05-04 11:11');
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time)
VALUES (4, 300.00, 1, 5, 4, 7, '2020-01-01 23:05', '2020-12-31 23:35');
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time)
VALUES (5, 150.50, 2, 7, 5, 9, '2020-07-22 13:20', '2020-07-22 15:00');
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time)
VALUES (6, 850.50, 9, 2, 4, 8, '2020-03-03 01:00', '2020-03-03 01:50');
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time)
VALUES (7, 310.99, 3, 9, 6, 8, '2020-08-29 14:00', '2020-08-29 14:14');
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time)
VALUES (8, 261.80, 7, 3, 5, 2, '2020-12-02 16:20', '2020-12-02 17:00');
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time)
VALUES (9, 700.00, 4, 5, 6, 9, '2020-05-17 08:05', '2020-05-17 09:00');
INSERT INTO appointment(id, price, appointment_type_id, status_id, patient_id, doctor_id, start_time, end_time)
VALUES (10, 451.00, 6, 9, 6, 3, '2020-02-13 00:20', '2020-02-13 00:50');


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

