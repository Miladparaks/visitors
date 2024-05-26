CREATE TABLE SERVICES
(
    id                 int primary key,
    name        nvarchar2(30),
    description long,
    service_type        nvarchar2(30),
    status      number(1)
);
create sequence services_seq start with 10 increment by 1;

CREATE TABLE PERSON
(
    id              number primary key,
    firstname       nvarchar2(30),
    lastname        nvarchar2(30),
    age             number,
    nationalId      nvarchar2(30),
    email           nvarchar2(30),
    gender          char(6),
    phoneNumber     nvarchar2(30),
    personStatus    char(10),
    personBirthdate timestamp,
    city            nvarchar2(30),
    username        nvarchar2(30),
    password        nvarchar2(60),
    role            nvarchar2(10),
    service_id references SERVICES
);

create sequence person_seq start with 10 increment by 1;


CREATE TABLE TIMING
(
    timeId    number primary key,
    startTime timestamp,
    endTime   timestamp,
    doctor_id references PERSON
);

create sequence timing_seq start with 10 increment by 1;


CREATE TABLE PAYMENT
(
    paymentId     number primary key,
    paymentTime   timestamp,
    paymentStatus nvarchar2(15),
    paymentType   char(30)
);
create sequence payment_seq start with 10 increment by 1;

CREATE TABLE VISIT
(
    visit_id int primary key,
    customer references PERSON,
    timing_id references TIMING,
    payment_id references PAYMENT,
    status number(1)
);
create sequence visit_seq start with 10 increment by 1;

