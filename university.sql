create table academic_titles
(
    id     int auto_increment
        primary key,
    title  varchar(64)    null,
    salary decimal(10, 2) null,
    constraint title
        unique (title)
);

create table people
(
    id         int auto_increment
        primary key,
    first_name varchar(64) null,
    last_name  varchar(64) null,
    email      varchar(64) null,
    phone      varchar(11) null,
    birth_date date        null,
    address    varchar(64) null
);

create table students
(
    student_number varchar(7)                               not null
        primary key,
    person_id      int                                      not null,
    date_enrolled  date                                     null,
    status         enum ('active', 'graduated', 'inactive') null,
    constraint person_id
        unique (person_id),
    constraint student_person_id_fk
        foreign key (person_id) references people (id)
            on update cascade
);

create table teachers
(
    id                int auto_increment
        primary key,
    person_id         int  not null,
    date_hired        date null,
    academic_title_id int  null,
    constraint person_id
        unique (person_id),
    constraint teacher_academic_title_fk
        foreign key (academic_title_id) references academic_titles (id)
            on update cascade,
    constraint teacher_person_id_fk
        foreign key (person_id) references people (id)
            on update cascade
);

create table courses
(
    id                     int auto_increment
        primary key,
    name                   varchar(64)   not null,
    coordinator_teacher_id int           null,
    ects                   decimal(3, 1) null,
    constraint course_coordinator_teacher_fk
        foreign key (coordinator_teacher_id) references teachers (id)
            on update cascade
);

create table `groups`
(
    id            int auto_increment
        primary key,
    course_id     int                                                                                 not null,
    teacher_id    int                                                                                 null,
    group_number  int                                                                                 null,
    date_started  time                                                                                null,
    date_finished time                                                                                null,
    day_of_week   enum ('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday') null,
    type          enum ('lecture', 'class', 'lab')                                                    null,
    constraint group_course_fk
        foreign key (course_id) references courses (id)
            on update cascade on delete cascade,
    constraint group_teacher_fk
        foreign key (teacher_id) references teachers (id)
            on update cascade
);

create table students_groups
(
    id         int auto_increment
        primary key,
    student_id varchar(7) not null,
    group_id   int        not null,
    constraint student_group_unique
        unique (student_id, group_id),
    constraint student_group_group_fk
        foreign key (group_id) references `groups` (id)
            on update cascade on delete cascade,
    constraint student_group_student_fk
        foreign key (student_id) references students (student_number)
            on update cascade on delete cascade
);

create
    definer = root@localhost procedure add_student(IN student_number varchar(7), IN first_name varchar(64),
                                                   IN last_name varchar(64), IN email varchar(64), IN phone varchar(11),
                                                   IN birth_date date, IN address varchar(64), IN date_enrolled date)
BEGIN
    INSERT INTO people (first_name, last_name, email, phone, birth_date, address)
    VALUES (first_name, last_name, email, phone, birth_date, address);
    SET @person_id = LAST_INSERT_ID();
    INSERT INTO students (student_number, person_id, date_enrolled, status)
    VALUES (student_number, @person_id, date_enrolled, 'active');
END;


-- INSERT INTO


## INSERT INTO

INSERT INTO people (first_name, last_name, email, phone, birth_date, address)
VALUES ('Andrew', 'Brown', 'andrewbrown@student.edu', '1234567890', '1990-01-01', 'ul. Brown 4, Cracow');

INSERT INTO people (first_name, last_name, email, phone, birth_date, address)
VALUES ('John', 'Smith', 'johnsmith@university.edu', '0987654321', '1980-01-01', 'ul. Smith 4, Cracow');

INSERT INTO people (first_name, last_name, email, phone, birth_date, address)
VALUES ('Nicolaus', 'Copernicus', 'copernicus@university.edu', '444555666', '1473-02-19', 'ul. Copernicus 4, Torun');

INSERT INTO people (first_name, last_name, email, phone, birth_date, address)
VALUES ('Marie', 'Sklodowska-Curie', 'msk@university.edu', '111222333', '1867-11-07', 'ul. Curie 4, Warsaw');

INSERT INTO people (first_name, last_name, email, phone, birth_date, address)
VALUES ('Tair', 'Nizov', 'tairn@univesity@edu', '656565656', '1999-11-17', 'ul. Nizov 59, Cracow');

INSERT INTO academic_titles (title, salary)
VALUES ('Professor', 10000.00),
       ('Associate Professor', 9000.00),
       ('Adjunct', 5000.00);

INSERT INTO students (student_number, person_id, date_enrolled, status)
VALUES ('1170001', 1, '2020-10-01', 'active'),
       ('1180013', 5, '2021-10-01', 'active');

INSERT INTO teachers (person_id, date_hired, academic_title_id)
VALUES (2, '2010-10-01', 2),
       (3, '2015-10-01', 1),
       (4, '1500-10-01', 1);

INSERT INTO courses (name, coordinator_teacher_id, ects)
VALUES ('Geography', 1, 5.0),
       ('Chemistry', 2, 6.0),
       ('Astronomy', 3, 4.0);

INSERT INTO `groups` (course_id, teacher_id, group_number, date_started, date_finished, day_of_week, type)
VALUES (1, 1, 10, '08:00', '10:00', 'Wednesday', 'lecture'),
       (1, 1, 11, '10:00', '12:00', 'Wednesday', 'class'),
       (1, 1, 12, '10:00', '12:00', 'Monday', 'class');

INSERT INTO `groups` (course_id, teacher_id, group_number, date_started, date_finished, day_of_week, type)
VALUES (2, 2, 20, '12:00', '14:00', 'Wednesday', 'lecture'),
       (2, 2, 21, '14:00', '16:00', 'Wednesday', 'class'),
       (2, 2, 22, '8:00', '10:00', 'Monday', 'class');

INSERT INTO `groups` (course_id, teacher_id, group_number, date_started, date_finished, day_of_week, type)
VALUES (3, 3, 30, '16:00', '18:00', 'Wednesday', 'lecture'),
       (3, 3, 31, '18:00', '20:00', 'Wednesday', 'lab'),
       (3, 3, 32, '12:00', '14:00', 'Monday', 'lab');

INSERT INTO students_groups (student_id, group_id)
VALUES ('1170001', 1),
       ('1170001', 2),
       ('1180013', 1),
       ('1180013', 3),
       ('1180013', 4),
       ('1180013', 5),
       ('1170001', 7),
       ('1170001', 8);


CALL add_student('1170002', 'Jan', 'Kowalski',
                 'jankowalski@university.edu', '133133133', '1998-05-05', 'ul. Kowalska 4. Cracow',
                 '2020-10-01');

CALL add_student('1170003', 'Anna', 'Nowak',
                 'annanowak@university.edu', '144144144', '1999-06-06', 'ul. Nowaka 4. Wroclaw',
                 '2020-10-01');

CALL add_student('1170004', 'Piotr', 'Wozniak',
                 'piotrwozniak@university.edu', '123098874', '1999-10-20', 'ul. Wozniaka 4. Gdansk',
                 '2020-10-01');


insert into people (first_name, last_name, email, phone, birth_date, address)
values ('Barbara', 'Strug', 'strug@university.edu', '555 555 555', '1961-08-08', 'ul. Struga 10, Poznan');

insert into teachers (person_id, date_hired, academic_title_id)
values (8, '2010-10-01', 3);