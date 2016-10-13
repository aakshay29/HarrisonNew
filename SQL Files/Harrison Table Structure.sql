create table harrisonCourse(
  courseID number generated by default on null as identity primary key,
  subjectCode number,
  courseName varchar(50),
  courseDescription varchar(200),
  numberOFCredits number,
  available number
);

create table harrisonInstructor(
  instructorID number generated by default on null as identity primary key,
  userID number,
  department varchar(50),
  officeNumber number
);

create table harrisonStudent(
  studentID number generated by default on null as identity primary key,
  userID number,
  major varchar(50),
  yearOfEntry number
);

drop table harrisonClass;

create table harrisonClass(
  classID number generated by default on null as identity primary key,
  courseID number,
  instructorID number,
  classRoom varchar(10),
  schedule varchar(50),
  status number,
  semester varchar(50),
  FOREIGN key (COURSEID) references harrisonCourse(COURSEID),
  Foreign key (instructorid) references harrisonInstructor(instructorid)
);

create table harrisonUser(
  userID number generated by default on null as identity primary key,
  name varchar(100),
  email varchar(50),
  password varchar2(200),
  role number
);

create table harrisonEnrollment(
  enrollmentID number generated by default on null as identity primary key,
  studentID number,
  classID number,
  status number,
  grade varchar2(50),
  FOREIGN key (studentid) references harrisonStudent(studentid),
  Foreign key (classid) references harrisonclass(classid)
);
drop table harrisonEnrollment;