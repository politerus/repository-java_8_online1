create database buyer;

USE buyer;




CREATE TABLE `groups`  (
                           group_id int auto_increment primary key,
                           group_name varchar(255) not null

 );
 CREATE TABLE students (
                           student_id int auto_increment primary key,
                          name varchar(255) not null,
                           group_id int,
                          foreign key (group_id) references `groups` (group_id)
);

 ALTER TABLE students
     DROP FOREIGN KEY Students_ibfk_1;


 ALTER TABLE students
     ADD CONSTRAINT Students_ibfk_1 FOREIGN KEY (group_id)
         REFERENCES `groups`  (group_id) ON DELETE SET NULL;
 ALTER TABLE students MODIFY group_id INT NULL;


ALTER TABLE students
     ADD CONSTRAINT FK_Student_Group FOREIGN KEY (group_id)
        REFERENCES `groups`  (group_Id) ON DELETE SET NULL;