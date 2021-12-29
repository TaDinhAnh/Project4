DROP DATABASE IF EXISTS AuctionProject;
CREATE DATABASE AuctionProject;
USE AuctionProject;
CREATE TABLE Account(
    Id int PRIMARY KEY AUTO_INCREMENT,
    Gmail varchar(250),
    Password varchar(250),
    Fullname varchar(250),
    Phone varchar(10),
    Dob date,
    Image varchar(250),
    Role tinyint,
    IsDelete boolean
 );
 
 CREATE TABLE Category(
 	Id int PRIMARY KEY AUTO_INCREMENT,
    Name varchar(250),
    PresentID int,
    IsDelete boolean,
    CONSTRAINT Fk_Category FOREIGN KEY (PresentID)
  	REFERENCES Category(Id)
 );
 
 CREATE TABLE Product(
    Id int PRIMARY KEY AUTO_INCREMENT,
    Name varchar(500),
    CateID int,
    PriceMin double,
    Image varchar(250),
    Description varchar(500),
    VendorId int, 
    Status tinyint,
    IsDelete boolean,
    IsAccept boolean,
   	CONSTRAINT FK_Product_Cate FOREIGN KEY (CateID)
  	REFERENCES Category(Id),
   	CONSTRAINT FK_Product_Account FOREIGN KEY (CateID)
  	REFERENCES Account(Id)
 );
 
 CREATE TABLE FeedBack(
   Id int PRIMARY KEY AUTO_INCREMENT,
   ProId int,
   AccountId int,
   Content varchar(250),
   IsDel boolean,
    CONSTRAINT FK_FeedBack_Pro FOREIGN KEY (ProId)
  	REFERENCES Product(Id),
   	CONSTRAINT FK_FeedBack_Account FOREIGN KEY (AccountId)
  	REFERENCES Account(Id)
 );
 
 CREATE TABLE Auction(
     Id int PRIMARY KEY AUTO_INCREMENT,
     HourStart time,
     HourEnd time,
     Eventdate date,
     Description varchar(250),
     Status tinyint,
     VendorId int,
     IsDel boolean,
   	CONSTRAINT FK_Auction_Account FOREIGN KEY (VendorId)
  	REFERENCES Account(Id)

 );
 
 CREATE TABLE AuctionProduct(
	AuctionId int,
    ProId int,
    Status boolean,
    CONSTRAINT PK_Key PRIMARY KEY (ProId, AuctionId),
    CONSTRAINT FK_AuctionProduct_Pro FOREIGN KEY (ProId)
  	REFERENCES Product(Id),
   	CONSTRAINT FK_AuctionProduct_Auction FOREIGN KEY (AuctionId)
  	REFERENCES Auction(Id)
 );
 
 CREATE TABLE AuctionHistory(
    Id int PRIMARY KEY AUTO_INCREMENT,
	AuctionId int,
    ProId int,
    AccountId int,
    Price double,
    Time Datetime,
    CONSTRAINT FK_AuctionHistory_Pro FOREIGN KEY (ProId)
  	REFERENCES Product(Id),
   	CONSTRAINT FK_AuctionHistory_Auction FOREIGN KEY (AuctionId)
  	REFERENCES Auction(Id),
    CONSTRAINT FK_AuctionHistory_Acction FOREIGN KEY (AccountId)
  	REFERENCES Account(Id)
 );
 
 CREATE TABLE Orders(
   Id int PRIMARY KEY AUTO_INCREMENT,
	AuctionId int,
    ProId int,
    AccountId int,
    SuccessDate date,
    Total double,
    Piad double,
     Address varchar(250),
     Status tinyint,
     CONSTRAINT FK_Orders_Pro FOREIGN KEY (ProId)
  	REFERENCES Product(Id),
   	CONSTRAINT FK_Orders_Auction FOREIGN KEY (AuctionId)
  	REFERENCES Auction(Id),
    CONSTRAINT FK_Orders_Acction FOREIGN KEY (AccountId)
  	REFERENCES Account(Id)
 );
 