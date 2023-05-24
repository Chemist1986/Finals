/*
В подключенном MySQL репозитории создать базу данных “Друзья человека”
*/
CREATE DATABASE IF NOT exists Human_friends;

USE Human_friends;

/*
Создать таблицы с иерархией из диаграммы в БД
*/

CREATE TABLE animal_classes
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
	Class_name VARCHAR(20)
);

INSERT INTO animal_classes (Class_name)
VALUES ('вьючные'),
('домашние');


CREATE TABLE packed_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO packed_animals (Genus_name, Class_id)
VALUES ('Лошади', 1),
('Ослы', 1),
('Верблюды', 1);

CREATE TABLE home_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO home_animals (Genus_name, Class_id)
VALUES ('Кошки', 2),
('Собаки', 2),
('Хомяки', 2);

CREATE TABLE cats
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

/*
Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
*/

INSERT INTO cats (Name, Birthday, Commands, Genus_id)
VALUES ('Барсик', '2011-01-01', 'кс-кс-кс', 1),
('Муся', '2016-01-01', "отставить!", 1),
('Тишка', '2017-01-01', "", 1);

CREATE TABLE dogs
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (Name, Birthday, Commands, Genus_id)
VALUES ('Барбос', '2020-01-01', 'ко мне, лежать, лапу, голос', 2),
('Барон', '2022-06-12', "сидеть, лежать, лапу", 2),
('Шарик', '2019-03-01', "сидеть, лежать, лапу, след, фас", 2),
('Лайка', '2020-05-10', "сидеть, лежать, фу, место", 2);

CREATE TABLE hamsters
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamsters (Name, Birthday, Commands, Genus_id)
VALUES ('Дуся', '2020-10-12', '', 3),
('Пуся', '2021-03-12', "атака сверху", 3),
('Нуся', '2022-07-11', NULL, 3),
('Люся', '2022-05-10', NULL, 3);

CREATE TABLE horses
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (Name, Birthday, Commands, Genus_id)
VALUES ('Пикник', '2020-01-12', 'бегом, шагом', 1),
('Марс', '2017-03-12', "бегом, шагом, хоп", 1),
('Сникерс', '2016-07-12', "бегом, шагом, хоп, брр", 1),
('Натс', '2020-11-10', "бегом, шагом, хоп", 1);

CREATE TABLE donkeys
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (Name, Birthday, Commands, Genus_id)
VALUES ('Первый', '2019-04-10', NULL, 2),
('Второй', '2020-03-12', "", 2),
('Третий', '2021-07-12', "", 2),
('Четвертый', '2022-12-10', NULL, 2);

CREATE TABLE camels
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camels (Name, Birthday, Commands, Genus_id)
VALUES ('Лохматый', '2022-04-10', 'вернись', 3),
('Лысый', '2019-03-12', "остановись", 3),
('Бородатый', '2015-07-12', "плевок", 3),
('Хвостатый', '2022-12-10', "улыбнись", 3);

/*
Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку.
Объединить таблицы лошади, и ослы в одну таблицу.
*/

SET SQL_SAFE_UPDATES = 0;
DELETE FROM camels;

SELECT Name, Birthday, Commands FROM horses
UNION SELECT  Name, Birthday, Commands FROM donkeys;

/*
Создать новую таблицу “молодые животные” в которую попадут все животные
старше 1 года, но младше 3 лет и в отдельном столбце
с точностью до месяца подсчитать возраст животных в новой таблице
*/

CREATE TEMPORARY TABLE animals AS
SELECT *, 'Лошади' as genus FROM horses
UNION SELECT *, 'Ослы' AS genus FROM donkeys
UNION SELECT *, 'Собаки' AS genus FROM dogs
UNION SELECT *, 'Кошки' AS genus FROM cats
UNION SELECT *, 'Хомяки' AS genus FROM hamsters;

CREATE TABLE yang_animal AS
SELECT Name, Birthday, Commands, genus, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);

SELECT * FROM yang_animal;


/*
Объединить все таблицы в одну, при этом сохраняя поля,
указывающие на прошлую принадлежность к старым таблицам.
*/

SELECT h.Name, h.Birthday, h.Commands, pa.Genus_name, ya.Age_in_month
FROM horses h
LEFT JOIN yang_animal ya ON ya.Name = h.Name
LEFT JOIN packed_animals pa ON pa.Id = h.Genus_id
UNION
SELECT d.Name, d.Birthday, d.Commands, pa.Genus_name, ya.Age_in_month
FROM donkeys d
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN packed_animals pa ON pa.Id = d.Genus_id
UNION
SELECT c.Name, c.Birthday, c.Commands, ha.Genus_name, ya.Age_in_month
FROM cats c
LEFT JOIN yang_animal ya ON ya.Name = c.Name
LEFT JOIN home_animals ha ON ha.Id = c.Genus_id
UNION
SELECT d.Name, d.Birthday, d.Commands, ha.Genus_name, ya.Age_in_month
FROM dogs d
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN home_animals ha ON ha.Id = d.Genus_id
UNION
SELECT hm.Name, hm.Birthday, hm.Commands, ha.Genus_name, ya.Age_in_month
FROM hamsters hm
LEFT JOIN yang_animal ya ON ya.Name = hm.Name
LEFT JOIN home_an