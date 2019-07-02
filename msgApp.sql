create database msg_app;

use msg_app;
create table userTable (
UserId int NOT NULL AUTO_INCREMENT,
UserName varchar(255) Not null UNIQUE,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
PRIMARY KEY (userId)
);

INSERT INTO userTable (UserName, LastName, FirstName)
VALUES ('F_Yasein', 'Yasein', 'Fatima');

INSERT INTO userTable (UserName, LastName, FirstName)
VALUES ('A_Ali', 'Ali', 'Ahmed');

create table groupTable (
GroupId int NOT NULL AUTO_INCREMENT,
GroupName varchar(255) Not null UNIQUE,
UsersIds int,
PRIMARY KEY (GroupId),
FOREIGN KEY (UsersIds) REFERENCES userTable(UserId)
);

INSERT INTO groupTable (GroupName, UsersIds)
VALUES ('Group1',1);

INSERT INTO groupTable (GroupName, UsersIds)
VALUES ('Group2',2);

create table message (
MsgId int NOT NULL AUTO_INCREMENT,
MsgContent text,
Sender varchar(255),
GroupReceiver varchar(255),
UserReceiver varchar(255),
PRIMARY KEY (MsgId),
FOREIGN KEY (Sender) REFERENCES userTable(UserName),
FOREIGN KEY (GroupReceiver) REFERENCES groupTable(GroupName),
FOREIGN KEY (UserReceiver) REFERENCES userTable(UserName)

);



