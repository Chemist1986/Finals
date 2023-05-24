# 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”

CREATE DATABASE IF NOT EXISTS Друзья_человека;
Use Друзья_человека;

# 8. Создать таблицы с иерархией из диаграммы в БД

CREATE TABLE IF NOT EXISTS Animal_class
(class_id INT PRIMARY KEY AUTO_INCREMENT,
class_name VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Animal_types
(type_id INT PRIMARY KEY AUTO_INCREMENT,
type_name VARCHAR(20),
class_id INT,
FOREIGN KEY (class_id) REFERENCES Animal_class(class_id)
);

CREATE TABLE IF NOT EXISTS Commands
(cmd_id INT PRIMARY KEY AUTO_INCREMENT,
cmd_name VARCHAR(20),
cmd_action VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Animals
(id INT PRIMARY KEY AUTO_INCREMENT,
class_id INT,
type_id INT,
an_name VARCHAR(20),
birthday DATE,
command_id INT,
INDEX `id_idx` (`id` ASC) VISIBLE,
FOREIGN KEY (class_id) REFERENCES Animal_class(class_id),
FOREIGN KEY (type_id) REFERENCES Animal_types(type_id),
FOREIGN KEY (command_id) REFERENCES Commands(cmd_id)
);

# 9. Заполнить низкоуровневые таблицы именами(животных) командами, которые они выполняют и датами рождения
 
INSERT INTO Animal_class(class_name) VALUES
('Домашние животные'),
('Вьючные животные');

INSERT INTO Animal_types(type_name, class_id) VALUES
('Кошка',1),
('Собака',1),
('Хомяк',1),
('Лошадь',2),
('Верблюд',2),
('Осёл',2);

INSERT INTO Commands(cmd_name, cmd_action) VALUES
('Дай лапу', 'Дает лапу'),
('Лежать','Ложится'),
('Кыс-кыс', 'Бежит на голос'),
('Брысь', 'Убегает'),
('Сидеть', 'Садится'),
('Ннннооо','Начинает движение'),
('Стой','Останавливается');

INSERT INTO Animals(class_id, type_id, an_name, birthday, command_id) VALUES
(1,1,'Мурка','2023-01-01',3),
(1,2,'Жучка','2022-01-01',1),
(1,3,'Хома','2022-03-03',5),
(2,4,'Грач','2022-06-06',6),
(2,5,'Семён','2022-04-04',7),
(2,6,'Иа','2022-08-08',7),
(1,1,'Муся','2021-01-01',4),
(1,2,'Джерри','2021-02-02',2),
(1,3,'Шуша','2021-03-03',5),
(2,4,'Стрела','2021-06-06',6),
(2,5,'Федя','2021-04-04',7),
(2,6,'Орлик','2021-08-08',7),
(1,1,'Машка','2015-01-01',3),
(1,2,'Грета','2015-02-02',1),
(1,3,'Клепа','2016-03-03',5),
(2,4,'Буран','2017-06-06',7),
(2,5,'Лёва','2018-04-04',7),
(2,6,'Джордж','2020-02-02',7);
 
SELECT * FROM Animal_class;
SELECT * FROM Animal_types;
SELECT * FROM Commands;
 
SELECT An.id, Cl.class_name, Tp.type_name, An.an_name, An.birthday, Cmd.cmd_name, Cmd.cmd_action
FROM Animals AS An
JOIN Animal_class AS Cl
ON an.class_id=cl.class_id
JOIN Animal_types AS Tp
ON an.type_id=tp.type_id 
JOIN Commands AS Cmd
ON an.command_id=cmd.cmd_id
ORDER BY An.id ASC;

# 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади и ослы в одну таблицу.

CREATE TABLE IF NOT EXISTS Pack_animals
SELECT An.id, Cl.class_name, Tp.type_name, An.an_name, An.birthday, Cmd.cmd_name, Cmd.cmd_action
FROM Animals AS An
JOIN Animal_class AS Cl
ON an.class_id=cl.class_id
JOIN Animal_types AS Tp
ON an.type_id=tp.type_id 
JOIN Commands AS Cmd
ON an.command_id=cmd.cmd_id
WHERE Tp.type_name IN ('Лошадь','Осёл')
ORDER BY An.id ASC;

SELECT * FROM Pack_animals;

# 11. Создать новую таблицу “молодые животные”, в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
# до месяца подсчитать возраст животных в новой таблице

CREATE TABLE IF NOT EXISTS Молодые_животные
SELECT An.id, Cl.class_name, Tp.type_name, An.an_name, An.birthday, Cmd.cmd_name, Cmd.cmd_action, TIMESTAMPDIFF(MONTH, An.birthday, NOW()) as age_in_months
FROM Animals AS An
JOIN Animal_class AS Cl
ON an.class_id=cl.class_id
JOIN Animal_types AS Tp
ON an.type_id=tp.type_id 
JOIN Commands AS Cmd
ON an.command_id=cmd.cmd_id
WHERE TIMESTAMPDIFF(MONTH, An.birthday, NOW()) BETWEEN 12 AND 36
ORDER BY An.id ASC;

SELECT * FROM Молодые_животные;

# 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

SELECT *
FROM Animals AS An
JOIN Animal_class AS Cl
ON an.class_id=cl.class_id
JOIN Animal_types AS Tp
ON an.type_id=tp.type_id 
JOIN Commands AS Cmd
ON an.command_id=cmd.cmd_id
ORDER BY An.id ASC;