create schema logindatabase;

create table logindatabase.LoginInfo
    (
    U_Id int(10) unsigned NOT NULL AUTO_INCREMENT,
    UserId varchar(255) DEFAULT NULL,
    UserPassword varchar(255) DEFAULT NULL,
    Email varchar(255) DEFAULT NULL,
    primary key(U_Id),
    UNIQUE KEY `UserId` (`UserId`)
	);
    
INSERT INTO logindatabase.LoginInfo (U_Id, UserID, UserPassword, Email) VALUES (1, "test_user", "password", "testemail@aol.com");
INSERT INTO logindatabase.LoginInfo (U_Id, UserID, UserPassword, Email) VALUES (2, "Stephen M", "hunter2", "stephenmadigan@yahoo.com");
-- INSERT INTO logindatabase.LoginInfo (U_Id, Email) VALUES (3, "testemail@yahoo.com");