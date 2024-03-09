SHOW DATABASES;
CREATE DATABASE Payments_App_CLI;

USE Payments_App_CLI;

CREATE TABLE User_info(
Id INT PRIMARY KEY,
First_Name VARCHAR(50) NOT NULL,
Last_Name VARCHAR(50) NOT NULL,
Phone_Number  VARCHAR(15) UNIQUE NOT NULL,
Date_Of_Birth VARCHAR(20) NOT NULL,
Address VARCHAR(150) NOT NULL,
Password VARCHAR(15) NOT NULL
);

DESC User_info;
SELECT * FROM User_info;
-- DROP TABLE User_info;

show tables;

CREATE TABLE Bank_Account_Type(
Id INT PRIMARY KEY,
Acct_Type_Code VARCHAR(3) UNIQUE,
Acct_Type_Name VARCHAR(15)
);
INSERT INTO Bank_Account_Type(Id,Acct_Type_Code,Acct_Type_Name) 
VALUES (1,"SA","SAVINGS"),
(2,"CA","CURRENT"),
(3,"LA","LOAN"),
(4,"SL","SALARY");

DESC Bank_Account_Type;
SELECT * FROM Bank_Account_Type;

CREATE TABLE BankAccount_Details(
Id INT PRIMARY KEY,
Account_Number INT UNIQUE NOT NULL,
Acct_IFSC VARCHAR(20) NOT NULL,
Bank_Name VARCHAR(30) NOT NULL,
Bank_Acct_Pin VARCHAR(15) NOT NULL,
Acct_Type INT(3) NOT NULL, 
FOREIGN KEY(Acct_Type) REFERENCES Bank_Account_Type(Id),
User_Id  INT NOT NULL, FOREIGN KEY(User_Id) REFERENCES User_info(Id)
);

DESC BankAccount_Details;
SELECT * FROM BankAccount_Details;

CREATE TABLE Transaction_Details(
Id INT PRIMARY KEY,
Date_Time VARCHAR(20) NOT NULL,
Txn_Amount DOUBLE NOT NULL,
Txn_Type ENUM("CREDIT","DEBIT"),
Txn_Mode_Type ENUM("BANK_ACCOUNT","WALLET","CASH"),
User_Id  INT NOT NULL, FOREIGN KEY(User_Id) REFERENCES User_info(Id)
);

DESC Transaction_Details;
SELECT * FROM Transaction_Details;
