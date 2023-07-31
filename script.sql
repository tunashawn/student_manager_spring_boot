create table students
(
    id            uuid not null
        constraint students_pk
            primary key,
    first_name    varchar,
    last_name     varchar,
    gender        varchar,
    date_of_birth date,
    phone_number  varchar,
    enroll_year   integer
);

alter table students
    owner to shawn;

create table courses
(
    id          varchar not null
        constraint "Courses_pk"
            primary key,
    course_name varchar,
    max_slot    integer,
    description text
);

alter table courses
    owner to shawn;

create table professors
(
    id         uuid not null
        constraint "Professors_pk"
            primary key,
    first_name varchar,
    last_name  varchar
);

alter table professors
    owner to shawn;

create table enrolled_courses
(
    student_id uuid    not null
        constraint "EnrolledCourses_students_id_fk"
            references students,
    course_id  varchar not null
        constraint "EnrolledCourses_Courses_id_fk"
            references courses,
    prof_id    uuid    not null
        constraint "EnrolledCourses_professors_id_fk"
            references professors,
    semester   integer not null,
    grade      char,
    status     varchar,
    constraint "EnrolledCourses_pk"
        primary key (prof_id, semester, student_id, course_id)
);

alter table enrolled_courses
    owner to shawn;


