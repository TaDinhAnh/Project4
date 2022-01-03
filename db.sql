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
    REFERENCES Category(Id)
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
    CONSTRAINT FK_AuctionHistory_Account FOREIGN KEY (AccountId)
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
    CONSTRAINT FK_Orders_Account FOREIGN KEY (AccountId)
    REFERENCES Account(Id)
 );

insert into Account (Gmail, Password, Fullname, Phone, Dob, Image, Role, IsDelete) values ('lharragin0@friendfeed.com', 'ghnJLHd', 'Lil Harragin', '426 146 9220', '2020/01/06', 'Alcelaphus buselaphus cokii', 1, false);
insert into Account (Gmail, Password, Fullname, Phone, Dob, Image, Role, IsDelete) values ('swix1@ezinearticles.com', 'qKOlSboHctr', 'Suellen Wix', '758 759 5902', '2020/04/07', 'Pavo cristatus', 1, false);
insert into Account (Gmail, Password, Fullname, Phone, Dob, Image, Role, IsDelete) values ('bgerleit2@csmonitor.com', 'eqGfrWNnh', 'Bealle Gerleit', '208 563 7924', '2019/10/28', 'Gazella thompsonii', 1, false);
insert into Account (Gmail, Password, Fullname, Phone, Dob, Image, Role, IsDelete) values ('lpresnail3@thetimes.co.uk', 'qQd2yFg1zo', 'Loretta Presnail', '256 828 0265', '2019/08/26', 'Uraeginthus granatina', 2, false);
insert into Account (Gmail, Password, Fullname, Phone, Dob, Image, Role, IsDelete) values ('kmagrannell4@ucoz.com', 'lZZBuuE', 'Koressa Magrannell', '191 751 7597', '2020/07/26', 'Paroaria gularis', 1, false);
insert into Account (Gmail, Password, Fullname, Phone, Dob, Image, Role, IsDelete) values ('jwawer5@xrea.com', 'FM7FZr', 'Janith Wawer', '742 968 6232', '2019/12/24', 'Melursus ursinus', 2, false);
insert into Account (Gmail, Password, Fullname, Phone, Dob, Image, Role, IsDelete) values ('hayling6@mapquest.com', 'SvbUfAi', 'Halimeda Ayling', '532 577 0547', '2020/10/27', 'Cereopsis novaehollandiae', 0, false);
insert into Account (Gmail, Password, Fullname, Phone, Dob, Image, Role, IsDelete) values ('cbainbridge7@seesaa.net', 'U9QBiNppI', 'Cirilo Bainbridge', '934 566 6533', '2020/04/15', 'Tayassu pecari', 0, false);
insert into Account (Gmail, Password, Fullname, Phone, Dob, Image, Role, IsDelete) values ('xfearey8@canalblog.com', 'lc49KT', 'Xena Fearey', '298 388 5138', '2019/11/09', 'Eremophila alpestris', 1, true);
insert into Account (Gmail, Password, Fullname, Phone, Dob, Image, Role, IsDelete) values ('mgipp9@nifty.com', 'mQ7A19DSsh', 'Mia Gipp', '333 881 7563', '2020/01/13', 'Anitibyx armatus', 1, true);

insert into Category (Name , PresentID , IsDelete ) values ('Drywall & Acoustical (FED)', 1, true);
insert into Category (Name , PresentID , IsDelete ) values ('Marlite Panels (FED)', 1, true);
insert into Category (Name , PresentID , IsDelete ) values ('Painting & Vinyl Wall Covering', null, false);
insert into Category (Name , PresentID , IsDelete ) values ('Site Furnishings', null, true);
insert into Category (Name , PresentID , IsDelete ) values ('Temp Fencing, Decorative Fencing and Gates', null, false);
insert into Category (Name , PresentID , IsDelete ) values ('Granite Surfaces', null, false);
insert into Category (Name , PresentID , IsDelete ) values ('Framing (Steel)', null, false);
insert into Category (Name , PresentID , IsDelete ) values ('Soft Flooring and Base', null, false);
insert into Category (Name , PresentID , IsDelete ) values ('Hard Tile & Stone', 3, true);
insert into Category (Name , PresentID , IsDelete ) values ('Glass & Glazing', 3, false);
insert into Category (Name , PresentID , IsDelete ) values ('Roofing (Asphalt)', null, true);
insert into Category (Name , PresentID , IsDelete ) values ('Masonry', null, false);

insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Epoxy Flooring', 1, '5.32', 'Intrepid', 'Excise conjunctiv lesion', 2, 1, false, true);
insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Retaining Wall and Brick Pavers', 5, '9.47', 'LeBaron', 'Lid reconstr w graft NEC', 3, 1,  false, true);
insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Masonry', 1, '9.77', '9-7X', 'Lap periton adhesiolysis', 1, 0,  false, true);
insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Roofing (Asphalt)', 1, '7.53', 'S40', 'Tibia/fibul wedg osteot', 1, 1, true, false);
insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Electrical and Fire Alarm', 2, '7.61', 'Focus', 'Remove impl dev-humerus', 2, 0, false, true);
insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Epoxy Flooring', 5, '2.24', 'GT', 'Contr pulmon arteriogram', 1, 1, false, false);
insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Overhead Doors', 3, '9.08', 'Vanquish S', 'Tympanosympathectomy', 3, 0, true, true);
insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Waterproofing & Caulking', 2, '6.02', 'Odyssey', 'Bact smear-lower urinary', 1, 0, false, true);
insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Casework', 4, '8.81', 'V70', 'Incise cerebral meninges', 3, 1, false, true);
insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Curb & Gutter', 3, '6.22', 'Outlook', 'Mediastinal pneumogram', 1, 0, false, false);
insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Construction Clean and Final Clean', 4, '1.55', 'Safari', 'Contrast pancreatogram', 1, 0, true, true);
insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Masonry & Precast', 5, '7.27', 'Yukon', 'Micro exam-uppr urin NEC', 3, 1, false, false);
insert into Product (Name , CateId, PriceMin , Image , Description , VendorId , Status , IsDelete , IsAccept ) values ('Plumbing & Medical Gas', 3, '6.60', 'F-Series', 'Sm bowel dx proc NEC', 1, 0, true, true);

insert into FeedBack (Content , IsDel , ProId , AccountId ) values ('Closed thyroid gland bx', true, 3, 3);
insert into FeedBack (Content , IsDel , ProId , AccountId ) values ('Stretching of foreskin', true, 2, 2);
insert into FeedBack (Content , IsDel , ProId , AccountId ) values ('Oth rep int cervical os', true, 2, 2);
insert into FeedBack (Content , IsDel , ProId , AccountId ) values ('Abdperneal res rectm NOS', true, 3, 3);
insert into FeedBack (Content , IsDel , ProId , AccountId ) values ('Diphtheria toxoid admin', true, 1, 1);
insert into FeedBack (Content , IsDel , ProId , AccountId ) values ('Contr mammary ductogram', false, 2, 2);
insert into FeedBack (Content , IsDel , ProId , AccountId ) values ('Remove ureteral stimulat', false, 1, 1);
insert into FeedBack (Content , IsDel , ProId , AccountId ) values ('Dacryocystorhinostomy', false, 2, 3);
insert into FeedBack (Content , IsDel , ProId , AccountId ) values ('Leg artery resec w repla', true, 2, 3);
insert into FeedBack (Content , IsDel , ProId , AccountId ) values ('Closed testicular biopsy', false, 2, 1);
insert into FeedBack (Content , IsDel , ProId , AccountId ) values ('Blepharoptos repair NEC', false, 2, 3);

insert into Auction (HourStart , HourEnd , Eventdate , Description , Status , VendorId , IsDel ) values ('13:08', '9:43', '2021-12-10', 'Collaterl lig repair NEC', 1, 2, false);
insert into Auction (HourStart , HourEnd , Eventdate , Description , Status , VendorId , IsDel ) values ('16:26', '2:14', '2021-12-10', 'Body measurement', 2, 1, false);
insert into Auction (HourStart , HourEnd , Eventdate , Description , Status , VendorId , IsDel ) values ('3:40', '3:10', '2021-12-10', 'Open testicular biopsy', 2, 1, false);
insert into Auction (HourStart , HourEnd , Eventdate , Description , Status , VendorId , IsDel ) values ('22:11', '5:44', '2021-12-10', 'Bilat extend simp mastec', 0, 2, false);
insert into Auction (HourStart , HourEnd , Eventdate , Description , Status , VendorId , IsDel ) values ('1:06', '1:52', '2021-12-10', 'C & s NOS', 1, 1, false);
insert into Auction (HourStart , HourEnd , Eventdate , Description , Status , VendorId , IsDel ) values ('22:04', '10:27', '2021-12-10', 'Reimplan aberr renal ves', 0, 2, false);
insert into Auction (HourStart , HourEnd , Eventdate , Description , Status , VendorId , IsDel ) values ('8:30', '20:53', '2021-12-10', 'Intracranial 02 monitor', 1, 1, false);
insert into Auction (HourStart , HourEnd , Eventdate , Description , Status , VendorId , IsDel ) values ('18:41', '11:14', '2021-12-10', 'Excis cyst duct remnant', 2, 3, false);
insert into Auction (HourStart , HourEnd , Eventdate , Description , Status , VendorId , IsDel ) values ('23:19', '22:30', '2021-12-10', 'Salivary duct probing', 2, 3, false);
