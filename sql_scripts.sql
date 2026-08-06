CREATE TABLE students
(
    id         SERIAL PRIMARY KEY,
    first_name varchar(50) NOT NULL,
    last_name  varchar(250),
    age        integer     not null CHECK ( age > 0 ),
    email      varchar(100) UNIQUE,
    created_at timestamp default current_timestamp
);

create table courses
(
    id    serial primary key,
    title varchar not null
);

create table students_courses_link
(
    student_id integer references students (id),
    course_id  integer references courses (id),
    created_at timestamp default current_timestamp,
    primary key (student_id, course_id)
);

INSERT INTO students (first_name, last_name, age, email)
VALUES ('Иван', 'Петров', 20, 'ivan@example.com'),
       ('Мария', 'Сидорова', 19, 'maria@example.com'),
       ('Петр', 'Иванов', 21, 'petr@example.com'),
       ('Анна', 'Кузнецова', 20, 'anna@example.com');

insert into courses(title)
values ('Математика'),
       ('Физика'),
       ('Информатика'),
       ('База данных');


select *
from courses;

insert into students_courses_link (student_id, course_id)
values (1, 1),
       (1, 2),
       (2, 3),
       (3, 3),
       (4, 2),
       (4, 4);

select first_name
from students
where first_name in ('Иван', 'Сергей');

select students.first_name
from students
where age = 20
   or age = 21;
select students.first_name
from students
where age in (20, 21);

select students.first_name, students.last_name
from students
order by age DESC, last_name;

select *
from students
order by students.age desc
limit 2 offset 2;

select students.first_name
from students;

select *
from students
where email is null;

select count(first_name)
from students
where age = 20;

select avg(students.age)
from students;

select max(students.age) as max_age, min(students.age) as min_age
from students;

select sum(students.age)
from students;

select age, count(*)
from students
group by age
order by age;
/*
 if-else switch
 */

-- ===== ТАБЛИЦА СТУДЕНТОВ =====
CREATE TABLE students
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    age        INTEGER CHECK (age > 0 AND age < 100),
    email      VARCHAR(100) UNIQUE,
    phone      VARCHAR(20),
    city       VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users_phone
(
    user_id  INTEGER REFERENCES students (id),
    phone    varchar not null,
    position integer not null default 0,
    CONSTRAINT unique_user_contact_phone UNIQUE (user_id, phone)
);

-- ===== ТАБЛИЦА КУРСОВ =====
CREATE TABLE courses
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(100) NOT NULL,
    description TEXT,
    credits     INTEGER   DEFAULT 3 CHECK (credits BETWEEN 1 AND 6),
    language_id INTEGER   DEFAULT 1,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ===== ТАБЛИЦА ПРЕПОДАВАТЕЛЕЙ =====
CREATE TABLE teachers
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(100) UNIQUE,
    department VARCHAR(50)
);

-- ===== ТАБЛИЦА ЗАПИСИ НА КУРСЫ =====
CREATE TABLE enrollments
(
    student_id      INTEGER REFERENCES students (id) ON DELETE CASCADE,
    course_id       INTEGER REFERENCES courses (id) ON DELETE CASCADE,
    teacher_id      INTEGER REFERENCES teachers (id),
    enrollment_date DATE DEFAULT CURRENT_DATE,
    grade           INTEGER CHECK (grade BETWEEN 1 AND 5),
    PRIMARY KEY (student_id, course_id)
);

-- ===== ТАБЛИЦА ОЦЕНОК (для агрегаций) =====
CREATE TABLE grades
(
    id         SERIAL PRIMARY KEY,
    student_id INTEGER REFERENCES students (id) ON DELETE CASCADE,
    course_id  INTEGER REFERENCES courses (id) ON DELETE CASCADE,
    grade      INTEGER CHECK (grade BETWEEN 1 AND 5),
    exam_date  DATE DEFAULT CURRENT_DATE,
    UNIQUE (student_id, course_id, exam_date)
);
INSERT INTO students (first_name, last_name, age, email, phone, city)
VALUES ('Иван', 'Петров', 20, 'ivan.petrov@example.com', '+7-999-123-45-67', 'Москва'),
       ('Мария', 'Сидорова', 19, 'maria.sidorova@example.com', '+7-999-234-56-78', 'Санкт-Петербург'),
       ('Петр', 'Иванов', 21, 'petr.ivanov@example.com', '+7-999-345-67-89', 'Москва'),
       ('Анна', 'Кузнецова', 20, 'anna.kuznetsova@example.com', '+7-999-456-78-90', 'Казань'),
       ('Сергей', 'Смирнов', 22, 'sergey.smirnov@example.com', NULL, 'Москва'),
       ('Елена', 'Попова', 18, 'elena.popova@example.com', '+7-999-567-89-01', 'Новосибирск'),
       ('Алексей', 'Соколов', 23, 'alexey.sokolov@example.com', '+7-999-678-90-12', 'Екатеринбург'),
       ('Ольга', 'Михайлова', 20, 'olga.mikhailova@example.com', '+7-999-789-01-23', 'Москва'),
       ('Дмитрий', 'Федоров', 19, 'dmitry.fedorov@example.com', '+7-999-890-12-34', 'Санкт-Петербург'),
       ('Наталья', 'Морозова', 21, 'natalia.morozova@example.com', '+7-999-901-23-45', 'Казань'),
       ('Андрей', 'Волков', 20, 'andrey.volkov@example.com', '+7-999-012-34-56', 'Москва'),
       ('Татьяна', 'Алексеева', 22, 'tatyana.alekseeva@example.com', NULL, 'Новосибирск'),
       ('Игорь', 'Лебедев', 18, 'igor.lebedev@example.com', '+7-999-123-45-67', 'Екатеринбург'),
       ('Светлана', 'Егорова', 19, 'svetlana.egorova@example.com', '+7-999-234-56-78', 'Москва'),
       ('Владимир', 'Николаев', 24, 'vladimir.nikolaev@example.com', '+7-999-345-67-89', 'Санкт-Петербург'),
       ('Екатерина', 'Павлова', 20, 'ekaterina.pavlova@example.com', '+7-999-456-78-90', 'Казань'),
       ('Александр', 'Семенов', 21, 'alexander.semenov@example.com', '+7-999-567-89-01', 'Москва'),
       ('Юлия', 'Григорьева', 19, 'yulia.grigorieva@example.com', '+7-999-678-90-12', 'Новосибирск'),
       ('Николай', 'Антонов', 22, 'nikolay.antonov@example.com', NULL, 'Екатеринбург'),
       ('Анастасия', 'Фролова', 20, 'anastasia.frolova@example.com', '+7-999-789-01-23', 'Москва'),
       ('Константин', 'Макаров', 18, 'konstantin.makarov@example.com', '+7-999-890-12-34', 'Санкт-Петербург'),
       ('Дарья', 'Орлова', 21, 'darya.orlova@example.com', '+7-999-901-23-45', 'Казань'),
       ('Георгий', 'Белов', 23, 'georgy.belov@example.com', '+7-999-012-34-56', 'Москва'),
       ('Оксана', 'Тихонова', 20, 'oksana.tikhonova@example.com', '+7-999-123-45-67', 'Новосибирск'),
       ('Максим', 'Козлов', 19, 'maxim.kozlov@example.com', '+7-999-234-56-78', 'Екатеринбург'),
       ('Алина', 'Давыдова', 22, 'alina.davydova@example.com', '+7-999-345-67-89', 'Москва'),
       ('Артем', 'Пономарев', 20, 'artem.ponomarev@example.com', NULL, 'Санкт-Петербург'),
       ('Виктория', 'Романова', 18, 'viktoria.romanova@example.com', '+7-999-456-78-90', 'Казань'),
       ('Роман', 'Зайцев', 21, 'roman.zaytsev@example.com', '+7-999-567-89-01', 'Москва'),
       ('Евгения', 'Мельникова', 19, 'evgeniya.melnikova@example.com', '+7-999-678-90-12', 'Новосибирск');

INSERT INTO teachers (first_name, last_name, email, department)
VALUES ('Алексей', 'Иванов', 'alexey.ivanov@university.edu', 'Математика'),
       ('Мария', 'Петрова', 'maria.petrova@university.edu', 'Физика'),
       ('Сергей', 'Сидоров', 'sergey.sidorov@university.edu', 'Информатика'),
       ('Елена', 'Кузнецова', 'elena.kuznetsova@university.edu', 'Математика'),
       ('Андрей', 'Смирнов', 'andrey.smirnov@university.edu', 'Физика'),
       ('Ольга', 'Попова', 'olga.popova@university.edu', 'Информатика'),
       ('Дмитрий', 'Соколов', 'dmitry.sokolov@university.edu', 'Биология'),
       ('Наталья', 'Михайлова', 'natalia.mikhailova@university.edu', 'Математика');

INSERT INTO courses (title, description, credits, language_id)
VALUES ('Математический анализ', 'Основы дифференциального и интегрального исчисления', 4, 1),
       ('Линейная алгебра', 'Векторные пространства, матрицы, определители', 3, 1),
       ('Общая физика', 'Механика, термодинамика, электродинамика', 4, 1),
       ('Программирование на Java', 'Основы Java, ООП, коллекции, потоки', 5, 1),
       ('Базы данных', 'Реляционные базы данных, SQL, нормализация', 4, 1),
       ('Теория вероятностей', 'Основы теории вероятностей и статистики', 3, 1),
       ('Алгоритмы и структуры данных', 'Базовые алгоритмы и структуры', 5, 1),
       ('Операционные системы', 'Основы архитектуры ОС, управление памятью', 3, 1),
       ('Дифференциальные уравнения', 'Методы решения ДУ', 3, 1),
       ('Web-разработка', 'HTML, CSS, JavaScript, серверный JavaScript', 4, 1),
       ('Искусственный интеллект', 'Введение в AI, машинное обучение', 5, 1),
       ('Математическая статистика', 'Основы статистического анализа данных', 3, 1);
INSERT INTO enrollments (student_id, course_id, teacher_id, enrollment_date, grade)
VALUES
-- Студент 1 (Иван Петров)
(1, 1, 1, '2024-01-15', 5),
(1, 2, 1, '2024-01-15', 4),
(1, 4, 3, '2024-01-15', 5),
-- Студент 2 (Мария Сидорова)
(2, 1, 1, '2024-01-15', 4),
(2, 5, 3, '2024-01-15', 5),
(2, 6, 4, '2024-01-15', 3),
-- Студент 3 (Петр Иванов)
(3, 2, 1, '2024-01-15', 3),
(3, 3, 2, '2024-01-15', 4),
(3, 7, 5, '2024-01-15', 4),
-- Студент 4 (Анна Кузнецова)
(4, 1, 1, '2024-01-15', 5),
(4, 4, 3, '2024-01-15', 5),
(4, 5, 3, '2024-01-15', 4),
-- Студент 5 (Сергей Смирнов)
(5, 3, 2, '2024-01-15', 3),
(5, 6, 4, '2024-01-15', 5),
-- Студент 6 (Елена Попова)
(6, 1, 1, '2024-01-15', 4),
(6, 4, 3, '2024-01-15', 3),
(6, 8, 5, '2024-01-15', 4),
-- Студент 7 (Алексей Соколов)
(7, 2, 1, '2024-01-15', 5),
(7, 5, 3, '2024-01-15', 4),
(7, 9, 6, '2024-01-15', 3),
-- Студент 8 (Ольга Михайлова)
(8, 1, 1, '2024-01-15', 4),
(8, 3, 2, '2024-01-15', 4),
(8, 7, 5, '2024-01-15', 5),
-- Студент 9 (Дмитрий Федоров)
(9, 4, 3, '2024-01-15', 3),
(9, 6, 4, '2024-01-15', 4),
-- Студент 10 (Наталья Морозова)
(10, 1, 1, '2024-01-15', 5),
(10, 2, 1, '2024-01-15', 4),
(10, 5, 3, '2024-01-15', 5),
-- Студент 11 (Андрей Волков)
(11, 3, 2, '2024-01-15', 3),
(11, 4, 3, '2024-01-15', 4),
(11, 8, 5, '2024-01-15', 3),
-- Студент 12 (Татьяна Алексеева)
(12, 1, 1, '2024-01-15', 4),
(12, 2, 1, '2024-01-15', 5),
-- Студент 13 (Игорь Лебедев)
(13, 5, 3, '2024-01-15', 4),
(13, 6, 4, '2024-01-15', 3),
-- Студент 14 (Светлана Егорова)
(14, 1, 1, '2024-01-15', 4),
(14, 4, 3, '2024-01-15', 4),
(14, 7, 5, '2024-01-15', 4),
-- Студент 15 (Владимир Николаев)
(15, 2, 1, '2024-01-15', 3),
(15, 3, 2, '2024-01-15', 4),
(15, 9, 6, '2024-01-15', 3),
-- Студент 16 (Екатерина Павлова)
(16, 1, 1, '2024-01-15', 5),
(16, 5, 3, '2024-01-15', 5),
-- Студент 17 (Александр Семенов)
(17, 4, 3, '2024-01-15', 4),
(17, 6, 4, '2024-01-15', 3),
(17, 8, 5, '2024-01-15', 4),
-- Студент 18 (Юлия Григорьева)
(18, 1, 1, '2024-01-15', 4),
(18, 3, 2, '2024-01-15', 5),
-- Студент 19 (Николай Антонов)
(19, 2, 1, '2024-01-15', 3),
(19, 5, 3, '2024-01-15', 3),
-- Студент 20 (Анастасия Фролова)
(20, 1, 1, '2024-01-15', 4),
(20, 4, 3, '2024-01-15', 5),
(20, 7, 5, '2024-01-15', 4),
-- Студент 21 (Константин Макаров)
(21, 3, 2, '2024-01-15', 3),
(21, 6, 4, '2024-01-15', 4),
-- Студент 22 (Дарья Орлова)
(22, 1, 1, '2024-01-15', 5),
(22, 2, 1, '2024-01-15', 4),
(22, 5, 3, '2024-01-15', 5),
-- Студент 23 (Георгий Белов)
(23, 4, 3, '2024-01-15', 4),
(23, 8, 5, '2024-01-15', 3),
-- Студент 24 (Оксана Тихонова)
(24, 1, 1, '2024-01-15', 4),
(24, 3, 2, '2024-01-15', 4),
(24, 9, 6, '2024-01-15', 3),
-- Студент 25 (Максим Козлов)
(25, 2, 1, '2024-01-15', 3),
(25, 4, 3, '2024-01-15', 4),
-- Студент 26 (Алина Давыдова)
(26, 1, 1, '2024-01-15', 5),
(26, 5, 3, '2024-01-15', 5),
(26, 7, 5, '2024-01-15', 4),
-- Студент 27 (Артем Пономарев)
(27, 3, 2, '2024-01-15', 4),
(27, 6, 4, '2024-01-15', 3),
-- Студент 28 (Виктория Романова)
(28, 1, 1, '2024-01-15', 4),
(28, 4, 3, '2024-01-15', 4),
-- Студент 29 (Роман Зайцев)
(29, 2, 1, '2024-01-15', 5),
(29, 5, 3, '2024-01-15', 4),
(29, 8, 5, '2024-01-15', 3),
-- Студент 30 (Евгения Мельникова)
(30, 1, 1, '2024-01-15', 4),
(30, 3, 2, '2024-01-15', 5);

select students.first_name, students.last_name, coalesce(students.phone, 'Не указан')
from students
limit 20;

select students.first_name, students.last_name, coalesce(students.phone, students.email, 'No contact') as contact
from students;

select students.first_name, students.last_name, nullif(students.email, '') as email
from students;

select students.first_name,
       students.last_name,
       age,
       CASE students.age
           when 18 then 'Young'
           when 19 then 'Middle'
           else 'Old'
           END as category
from students
order by age;
select count(students.first_name)
from students;
select count(students.phone)
from students;

select students.city, count(*) as total
from students
group by city;

select *
from students
where age > 20;

select students.city, count(*) as total
from students
group by city
HAVING count(*) > 2;
/*
 WHERE
 GROUP BY
 HAVING
 ORDER BY LIMIT
 */
select count(id)
from students;
select count(id)
from courses;

SELECT s.first_name, s.last_name, e.grade
FROM students s,
     enrollments e
WHERE s.id = e.student_id;
/*
 Nested Loop  (cost=13.01..31.69 rows=77 width=634)
 */

SELECT s.first_name, s.last_name, s.phone, e.grade, c.title, t.first_name
FROM students s
         INNER JOIN enrollments e ON s.id = e.student_id
         INNER JOIN courses c ON e.course_id = c.id
         INNER JOIN teachers t ON e.teacher_id = t.id;

SELECT s.first_name, s.last_name, s.phone, e.grade, c.title
FROM students s,
     enrollments e,
     courses c
WHERE s.id = e.student_id
  and e.course_id = c.id;

INSERT INTO students (first_name, last_name, age, email, phone, city)
VALUES ('Аркадий', 'Паровозов', 20, 'arkadiy.parovozov@example.com', '+7-999-111-22-33', 'Москва'),
       ('Зинаида', 'Петрова', 19, 'zinaida.petrova@example.com', '+7-999-222-33-44', 'Санкт-Петербург'),
       ('Фёдор', 'Сумкин', 21, 'fyodor.sumkin@example.com', NULL, 'Казань');

INSERT INTO enrollments (student_id, course_id, teacher_id, enrollment_date, grade)
VALUES (31, 1, 1, '2024-01-15', 4),
       (32, 5, 3, '2024-01-15', 5),
       (1, 6, 4, '2024-01-15', 3),
       (2, 2, 1, '2024-01-15', 4);



SELECT s.first_name,
       s.last_name,
       COALESCE(e.grade::text, 'Нет оценки') AS grade
FROM students s
         LEFT JOIN enrollments e ON s.id = e.student_id
ORDER BY e.grade DESC NULLS LAST;

/*
 WHERE
 GROUP BY
 HAVING
 ORDER BY LIMIT
 */

SELECT t.first_name || ' ' || t.last_name AS teacherS,
       s.first_name || ' ' || s.last_name AS studentS,
       c.title                            AS course,
       e.grade
FROM teachers t
         LEFT JOIN enrollments e ON t.id = e.teacher_id
         LEFT JOIN students s ON e.student_id = s.id
         LEFT JOIN courses c ON e.course_id = c.id
ORDER BY t.last_name, e.grade DESC NULLS LAST;

SELECT c.title,
       COUNT(e.student_id)         AS student_count,
       coalesce(AVG(e.grade), 0.0) AS avg_grade
FROM courses c
         LEFT JOIN enrollments e ON c.id = e.course_id
GROUP BY c.id, c.title
ORDER BY student_count DESC;

SELECT avg(students.age)
from students;

select students.first_name, students.last_name, students.age
from students
where age > (SELECT avg(students.age) from students);

SELECT course_stats.course_title, course_stats.avg_grade
FROM (SELECT c.title      AS course_title,
             AVG(e.grade) AS avg_grade
      FROM courses c
               JOIN enrollments e ON c.id = e.course_id
      GROUP BY c.id, c.title) AS course_stats
WHERE course_stats.avg_grade > 4.0
ORDER BY course_stats.avg_grade DESC;

SELECT first_name, last_name
FROM students s
WHERE EXISTS (SELECT 465465654654
              FROM enrollments e
              WHERE e.student_id = s.id);


select students.first_name, students.last_name, students.age
from students
where age > (select avg(age) from students);

select first_name, last_name
from students st
where exists (select 1 from enrollments e where st.id = e.student_id);

select first_name, last_name
from students st
where id IN (select student_id from enrollments);

-- CTE --
WITH name_cte AS (select *
                  from students)
select name_cte.first_name
from name_cte;

with avr_grade as (select avg(grade) as avr_global
                   from enrollments)
select st.first_name, st.last_name, avg(e.grade)
from students st
         join enrollments e on st.id = e.student_id
group by st.id, st.first_name, st.last_name
having avg(e.grade) > (select avr_global from avr_grade);

-- я хочу получить фамилию имя студента с оценками и количеством преподавателей
-- этого студента студент учитель курс оценка если учитель на двух предметах - средняя оценка предметов

select students.first_name,
       students.last_name,
       students.age,
       students.age + 10 as age_10,
       students.age * 2  as double
from students;

SELECT title,
       courses.credits,
       ROUND(credits * 1.0 / 2, 2) AS half_credits,
       FLOOR(credits / 2.0)        AS floor_credits,
       CEIL(credits / 2.0)         AS ceil_credits,
       ABS(credits - 4)            AS diff_from_4
FROM courses
LIMIT 10;

SELECT COUNT(*) AS total,
       AVG(age) AS avg_age,
       MIN(age) AS min_age,
       MAX(age) AS max_age,
       SUM(age) AS sum_ages
FROM students;

SELECT enrollment_date,
       enrollment_date + INTERVAL '1 year'   AS year_later,
       enrollment_date - INTERVAL '6 months' AS six_months_before,
       enrollment_date + INTERVAL '7 days'   AS week_later
FROM enrollments
LIMIT 10;

SELECT enrollment_date,
       TO_CHAR(enrollment_date, 'DD.MM.YYYY')       AS date_ru,
       TO_CHAR(enrollment_date, 'Month DD, YYYY')   AS date_us,
       TO_CHAR(enrollment_date, 'Day, DD Mon YYYY') AS long_date
FROM enrollments
LIMIT 10;

select *
from students
where id = 1;
update students
set age = 21
where id = 1;
update students
set email = 'ivan.petrov@example.net',
    city= 'Пермь'
where email = 'ivan.petrov@example.ru';

explain analyse
WITH updated_avg AS (SELECT student_id, AVG(grade) AS avg_grade
                     FROM enrollments
                     GROUP BY student_id)
UPDATE students
SET age = age + 1
FROM updated_avg
WHERE students.id = updated_avg.student_id
  AND updated_avg.avg_grade > 4.5;

DELETE
FROM students
where id = 32;

select *
from enrollments
where student_id = 32;

alter table students
    add column birth_date date not null default now();
alter table students
    drop column birth_date;

alter table students
    alter column last_name type varchar(100);
alter table students
    rename column last_name TO last_name_2;

-- DDL(CREATE ALTER DROP TRUNCATE) DML (SELECT INSERT UPDATE DELETE)
-- DCL (GRANT REVOKE DENY) TCL (COMMIT ROLlBACK SAVEPOINT)

INSERT INTO students (first_name, last_name, age, email, phone, city)
VALUES ('Аркадий2', 'Паровозов2', 21, 'arkadiy2.parovozov@example.com', '+7-999-111-22-33', 'Москва')
returning id;

CREATE OR REPLACE FUNCTION before_student_insert()
    RETURNS TRIGGER AS
$$
BEGIN
    -- Если created_at не указан, ставим текущую дату
    IF NEW.created_at IS NULL THEN
        NEW.created_at = CURRENT_TIMESTAMP;
    END IF;

    -- Если возраст меньше 16, выбрасываем ошибку
    IF NEW.age < 16 THEN
        RAISE EXCEPTION 'Возраст студента не может быть меньше 16 лет';
    END IF;

    -- Возвращаем обновлённую строку
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TABLE students_backup AS TABLE students WITH NO DATA;

-- Копирование студентов из Москвы с изменением email
INSERT INTO students_backup (first_name, last_name, age, email, city)
SELECT first_name,
       last_name,
       age,
       LOWER(CONCAT(first_name, '.', last_name, '@example.com')) AS email,
       city
FROM students
WHERE city = 'Москва';

UPDATE students
SET email = LOWER(CONCAT(first_name, '.', last_name, '@university.edu'))
WHERE email IS NULL;

BEGIN;
select *
from students
WHERE city = 'Москва';
UPDATE students
set age = age + 1
WHERE city = 'Москва';
insert into enrollments (student_id, course_id, teacher_id, grade)
VALUES (31, 1, 1, 5);
select *
from students
WHERE city = 'Москва';
commit;
rollback;

BEGIN;
--INSERT INTO students SET age = age + 1 WHERE city = 'Москва';
UPDATE students
SET age = age + 1
WHERE city = 'Москва';
-- Точка сохранения
SAVEPOINT before_insert;
INSERT INTO enrollments (student_id, course_id, teacher_id, grade)
VALUES (999, 1, 1, 5);
-- Ошибка! Student 999 не существует
-- Откат только до точки сохранения
ROLLBACK TO SAVEPOINT before_insert;
-- Теперь можно сделать другой INSERT
INSERT INTO enrollments (student_id, course_id, teacher_id, grade)
VALUES (31, 1, 1, 5);
COMMIT;


BEGIN;
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
SELECT *
FROM students;
COMMIT;

explain analyse
select *
from students
where age = 20;
create index on students (age);
--create index on students(email) using hash;
select *
from students
where email like '%com';
select *
from students
order by age;
--Seq Scan on students  (cost=0.00..11.25 rows=1 width=746) (actual time=0.016..0.020 rows=8 loops=1)
--Filter: (age = 20)
--Rows Removed by Filter: 25
--Planning Time: 0.079 ms
--Execution Time: 0.046 ms

create index on students (city, age, first_name);
SELECT *
FROM students
WHERE city = 'Москва'
  AND age = 20
  AND first_name = 'Иван';
SELECT *
FROM students
WHERE city = 'Москва'
  AND age = 20;
SELECT *
FROM students
WHERE city = 'Москва';
SELECT *
FROM students
WHERE age = 20;


update students
set age = age + 1
where exists(select * from grades where grades.student_id = students.id and grade in (4, 5));

select students.first_name, students.last_name, age
from students
where exists(select * from grades where grades.student_id = students.id and grade in (4, 5));

select distinct s.id, s.first_name, s.last_name
from students s
         join enrollments e on s.id = e.student_id
where e.grade in (4, 5);

select count(id)
from students;

alter table students
    add column photo bytea;
alter table students
    add column preferences jsonb;
alter table students
    add column documents xml;

CREATE TABLE passport
(
    id         SERIAL PRIMARY KEY,
    student_id INTEGER UNIQUE REFERENCES students (id),
    series     VARCHAR(10),
    number     VARCHAR(20)
);


create table authors
(
    id      serial primary key,
    name    varchar(100) not null unique,
    country varchar(20)
);

create table books
(
    id               serial primary key,
    title            varchar(200) not null,
    publication_year INTEGER,
    author_id        integer references authors (id)
);

create table genres
(
    id   serial primary key,
    name varchar(100) not null unique
);

create table book_genres
(
    book_id  integer references books (id),
    genre_id integer references genres (id),
    primary key (book_id, genre_id)
);

-- Вставляем тестовые данные
INSERT INTO authors (name, country)
VALUES ('Лев Толстой', 'Россия'),
       ('Фёдор Достоевский', 'Россия'),
       ('Джордж Оруэлл', 'Великобритания'),
       ('Михаил Булгаков', 'Россия');

INSERT INTO books (title, author_id, publication_year)
VALUES ('Война и мир', 1, 1869),
       ('Анна Каренина', 1, 1877),
       ('Преступление и наказание', 2, 1866),
       ('Идиот', 2, 1869),
       ('1984', 3, 1949),
       ('Скотный двор', 3, 1945),
       ('Мастер и Маргарита', 4, 1967),
       ('Собачье сердце', 4, 1925);

INSERT INTO genres (name)
VALUES ('Роман'),
       ('Антиутопия'),
       ('Сатира'),
       ('Философский роман');


INSERT INTO book_genres (book_id, genre_id)
VALUES (1, 1),
       (1, 4), -- Война и мир: Роман, Философский роман
       (2, 1), -- Анна Каренина: Роман
       (3, 1),
       (3, 4), -- Преступление и наказание: Роман, Философский роман
       (4, 1), -- Идиот: Роман
       (5, 2),
       (5, 4), -- 1984: Антиутопия, Философский роман
       (6, 3), -- Скотный двор: Сатира
       (7, 1),
       (7, 4), -- Мастер и Маргарита: Роман, Философский роман
       (8, 3); -- Собачье сердце: Сатира

CREATE TABLE IF NOT EXISTS users
(
    id                SERIAL PRIMARY KEY,
    name              VARCHAR(100) NOT NULL,
    email             VARCHAR(100) UNIQUE,
    age               INTEGER,
    status            VARCHAR(20) DEFAULT 'ACTIVE',
    is_active         BOOLEAN     DEFAULT TRUE,
    is_verified       integer     DEFAULT 0,
    birth_date        DATE,
    registration_time TIMESTAMP,
    last_login_time   TIME,
    height            INTEGER,
    weight            INTEGER,
    created_at        TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP   DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS employees
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    street     VARCHAR(100),
    city       VARCHAR(50),
    zip_code   VARCHAR(20),
    country    VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_avatars
(
    id          SERIAL PRIMARY KEY,
    user_id     INTEGER REFERENCES users (id),
    avatar_data BYTEA,
    file_name   VARCHAR(100),
    file_type   VARCHAR(50),
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_preferences
(
    id          SERIAL PRIMARY KEY,
    user_id     INTEGER REFERENCES users (id),
    preferences JSONB,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- CREATE TABLE IF NOT EXISTS employees (
--                                          id SERIAL PRIMARY KEY,
--                                          first_name VARCHAR(50),
--                                          last_name VARCHAR(50),
--                                          street VARCHAR(100),
--                                          city VARCHAR(50),
--                                          zip_code VARCHAR(20),
--                                          country VARCHAR(50),
--                                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
-- );


CREATE TABLE IF NOT EXISTS employees
(
    id           SERIAL PRIMARY KEY,
    first_name   VARCHAR(50),
    last_name    VARCHAR(50),
    home_street  VARCHAR(100),
    home_city    VARCHAR(50),
    home_zip     VARCHAR(20),
    home_country VARCHAR(50),
    work_street  VARCHAR(100),
    work_city    VARCHAR(50),
    work_zip     VARCHAR(20),
    work_country VARCHAR(50),
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



-- ===== ТАБЛИЦЫ ДЛЯ @ELEMENTCOLLECTION =====
-- Таблица пользователей
CREATE TABLE IF NOT EXISTS new_users
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    email      VARCHAR(100) UNIQUE,
    age        INTEGER,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Вспомогательная таблица для хранения телефонов (List/Set)
CREATE TABLE IF NOT EXISTS new_users_phones
(
    user_id  INTEGER REFERENCES users (id) ON DELETE CASCADE,
    phone    VARCHAR(20) NOT NULL,
    position INTEGER -- для List (позиция в списке)
);

-- Вспомогательная таблица для хранения адресов (Map)
CREATE TABLE IF NOT EXISTS new_users_addresses
(
    user_id       INTEGER REFERENCES users (id) ON DELETE CASCADE,
    address_key   VARCHAR(50)  NOT NULL, -- ключ для Map (например, "home", "work")
    address_value VARCHAR(200) NOT NULL
);

-- Вспомогательная таблица для хранения социальных сетей (Set)
CREATE TABLE IF NOT EXISTS new_users_social
(
    user_id        INTEGER REFERENCES users (id) ON DELETE CASCADE,
    social_network VARCHAR(50)  NOT NULL,
    social_handle  VARCHAR(100) NOT NULL,
    UNIQUE (user_id, social_network)
);
----------------------------------
CREATE TABLE IF NOT EXISTS genres
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE IF NOT EXISTS authors
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    country    VARCHAR(50),
    birth_year INTEGER
);
CREATE TABLE IF NOT EXISTS publishers
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    address      TEXT,
    founded_year INTEGER
);

CREATE TABLE IF NOT EXISTS books
(
    id               SERIAL PRIMARY KEY,
    title            VARCHAR(200) NOT NULL,
    author_id        INTEGER REFERENCES authors (id),
    publication_year INTEGER,
    isbn             VARCHAR(20) UNIQUE,
    price            DECIMAL(10, 2),
    publisher_id     INTEGER REFERENCES publishers (id)
);

CREATE TABLE IF NOT EXISTS book_genres
(
    book_id  INTEGER REFERENCES books (id) ON DELETE CASCADE,
    genre_id INTEGER REFERENCES genres (id) ON DELETE CASCADE,
    PRIMARY KEY (book_id, genre_id)
);

CREATE TABLE IF NOT EXISTS readers
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE
);

CREATE TABLE IF NOT EXISTS reader_books
(
    reader_id     INTEGER REFERENCES readers (id) ON DELETE CASCADE,
    book_id       INTEGER REFERENCES books (id) ON DELETE CASCADE,
    borrowed_date DATE DEFAULT CURRENT_DATE,
    return_date   DATE,
    PRIMARY KEY (reader_id, book_id)
);



INSERT INTO authors (name, country, birth_year)
VALUES ('Лев Толстой', 'Россия', 1828),
       ('Фёдор Достоевский', 'Россия', 1821),
       ('Джордж Оруэлл', 'Великобритания', 1903),
       ('Михаил Булгаков', 'Россия', 1891),
       ('Антон Чехов', 'Россия', 1860),
       ('Джейн Остин', 'Великобритания', 1775),
       ('Эрнест Хемингуэй', 'США', 1899);

INSERT INTO books (title, author_id, publication_year, isbn, price)
VALUES ('Война и мир', 1, 1869, '978-5-699-12345-6', 750.00),
       ('Анна Каренина', 1, 1877, '978-5-699-23456-7', 650.00),
       ('Преступление и наказание', 2, 1866, '978-5-699-34567-8', 550.00),
       ('Идиот', 2, 1869, '978-5-699-45678-9', 500.00),
       ('1984', 3, 1949, '978-5-699-56789-0', 450.00),
       ('Скотный двор', 3, 1945, '978-5-699-67890-1', 350.00),
       ('Мастер и Маргарита', 4, 1967, '978-5-699-78901-2', 600.00),
       ('Собачье сердце', 4, 1925, '978-5-699-89012-3', 400.00),
       ('Чайка', 5, 1895, '978-5-699-90123-4', 300.00),
       ('Гордость и предубеждение', 6, 1813, '978-5-699-01234-5', 480.00),
       ('Старик и море', 7, 1952, '978-5-699-12345-9', 380.00);

INSERT INTO genres (name, description)
VALUES ('Роман', 'Крупное эпическое произведение'),
       ('Антиутопия', 'Изображение тоталитарного общества'),
       ('Сатира', 'Осмеяние пороков общества'),
       ('Философский роман', 'Осмысление бытийных вопросов'),
       ('Приключения', 'Путешествия и опасности'),
       ('Драма', 'Конфликтные и эмоциональные произведения');

INSERT INTO book_genres (book_id, genre_id)
VALUES (1, 1),
       (1, 4),
       (2, 1),
       (3, 1),
       (3, 4),
       (4, 1),
       (5, 2),
       (5, 4),
       (6, 3),
       (7, 1),
       (7, 4),
       (8, 3),
       (10, 1);

INSERT INTO publishers (name, address, founded_year)
VALUES ('Эксмо', 'г. Москва, ул. Пушкина, д. 10', 1991),
       ('АСТ', 'г. Москва, ул. Ленина, д. 5', 1992),
       ('Оксфорд Юниверсити Пресс', 'Великобритания, Оксфорд', 1478);

UPDATE books
SET publisher_id = 1
WHERE id IN (1, 2, 3, 4, 7, 8);
UPDATE books
SET publisher_id = 2
WHERE id IN (5, 6, 9);
UPDATE books
SET publisher_id = 3
WHERE id IN (10, 11);

INSERT INTO readers (name, email)
VALUES ('Иван Читатель', 'ivan.reader@example.com'),
       ('Мария Книголюб', 'maria.reader@example.com'),
       ('Петр Библиофил', 'petr.reader@example.com');

INSERT INTO reader_books (reader_id, book_id, borrowed_date, return_date)
VALUES (1, 1, '2024-01-15', '2024-02-15'),
       (1, 2, '2024-01-20', NULL), -- ещё не вернул
       (1, 5, '2024-02-01', '2024-02-28'),
       (2, 3, '2024-01-10', '2024-02-10'),
       (2, 7, '2024-02-01', NULL), -- ещё не вернул
       (3, 4, '2024-01-05', '2024-01-30'),
       (3, 6, '2024-02-10', '2024-03-10');

CREATE TABLE IF NOT EXISTS passports
(
    id         SERIAL PRIMARY KEY,
    author_id  INTEGER UNIQUE REFERENCES authors (id) ON DELETE CASCADE,
    series     VARCHAR(10) NOT NULL,
    number     VARCHAR(20) NOT NULL,
    issued_at  DATE,
    expires_at DATE
);


SELECT a.name, b.title
FROM authors a
         LEFT JOIN books b on a.id = b.author_id;

CREATE TABLE students
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    email         VARCHAR(100) UNIQUE,
    faculty       VARCHAR(50),
    year_of_study INTEGER,
    average_grade DECIMAL(3, 2)
);

CREATE TABLE teachers
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    email      VARCHAR(100) UNIQUE,
    department VARCHAR(50),
    degree     VARCHAR(50),
    salary     DECIMAL(10, 2)
);

CREATE TABLE persons
(
    id            SERIAL PRIMARY KEY,
    dtype         VARCHAR(50)  NOT NULL,
    name          VARCHAR(100) NOT NULL,
    email         VARCHAR(100) UNIQUE,
    -- Поля для Student
    faculty       VARCHAR(50),
    year_of_study INTEGER,
    average_grade DECIMAL(3, 2),
    -- Поля для Teacher
    department    VARCHAR(50),
    degree        VARCHAR(50),
    salary        DECIMAL(10, 2)
);

CREATE TABLE persons_base (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR(100) NOT NULL,
                              email VARCHAR(100) UNIQUE
);

CREATE TABLE students_joined (
                                 id INTEGER PRIMARY KEY REFERENCES persons_base(id),
                                 faculty VARCHAR(50),
                                 year_of_study INTEGER,
                                 average_grade DECIMAL(3, 2)
);

CREATE TABLE teachers_joined (
                                 id INTEGER PRIMARY KEY REFERENCES persons_base(id),
                                 department VARCHAR(50),
                                 degree VARCHAR(50),
                                 salary DECIMAL(10, 2)
);

CREATE TABLE persons_tpc (
                             id SERIAL PRIMARY KEY,
                             name VARCHAR(100) NOT NULL,
                             email VARCHAR(100) UNIQUE
);

CREATE TABLE students_tpc (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR(100) NOT NULL,
                              email VARCHAR(100) UNIQUE,
                              faculty VARCHAR(50),
                              year_of_study INTEGER,
                              average_grade DECIMAL(3, 2)
);

CREATE TABLE teachers_tpc (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR(100) NOT NULL,
                              email VARCHAR(100) UNIQUE,
                              department VARCHAR(50),
                              degree VARCHAR(50),
                              salary DECIMAL(10, 2)
);

SELECT * from authors order by id desc , country asc ;

SELECT a.id, a.name, count(b.id) from authors a
    left join books b on b.author_id = a.id group by a.id, a.name;