create database buyer;

USE buyer;




CREATE TABLE `Groups`  (
                           group_id int auto_increment primary key,
                           group_name varchar(255) not null

 );
 CREATE TABLE Students (
                           student_id int auto_increment primary key,
                          name varchar(255) not null,
                           group_id int,
                          foreign key (group_id) references `Groups` (group_id)
);

 ALTER TABLE Students
     DROP FOREIGN KEY Students_ibfk_1;


 ALTER TABLE Students
     ADD CONSTRAINT Students_ibfk_1 FOREIGN KEY (group_id)
         REFERENCES `Groups`  (group_id) ON DELETE SET NULL;
 ALTER TABLE Students MODIFY group_id INT NULL;


ALTER TABLE Students
     ADD CONSTRAINT FK_Student_Group FOREIGN KEY (group_id)
        REFERENCES `Groups`  (group_Id) ON DELETE SET NULL;