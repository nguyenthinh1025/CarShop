Create database Assignment_NguyenPhuThinh
go
use Assignment_NguyenPhuThinh
go

create table tblUsers(
    userID char(10) primary key,
	fullName nvarchar(50),
	password nvarchar(10),
	role nvarchar(10)
)
create table tblCatagory (
	catagoryID char (10) primary key,
	catagoryName nvarchar(50)
)
go
create table tblProducts (
 otoID char(10) primary key,
 otoName nvarchar(50),
 image nvarchar(200),
 price float(20),
 quantity int,
 catagoryID char(10) 
 
)
create table tblOrders (
 orderID char(10) primary key,
 orderDate Date,
 totalPrice float,
 userID char(10) foreign key references tblUsers(userID)
)
go
create table tblOrderDetail (
 orderDetailId char(10) primary key(otoID,orderID),
 price float,
 quantity int,
 orderID char(10) foreign key references tblOrders(orderID),
 otoID char(10) foreign key references tblProducts(otoID),
)
go


insert into tblUsers(userID,fullName,password,role) values ('Admin','Phu Thinh', '123','AD')
insert into tblUsers(userID,fullName,password,role) values ('User','Nguyen Phu Thinh', '123','US')

insert into tblCatagory values ('BMW','BMW')
insert into tblCatagory values ('FE','Ferrari')
insert into tblCatagory values ('PO','Porsche')
insert into tblCatagory values ('MEC','Mercedes')
insert into tblCatagory values ('W','W Motors')
insert into tblProducts(otoID,otoName,image,price,quantity,catagoryID) values ('B1', 'BMW i8', N'https://autopro8.mediacdn.vn/zoom/600_315/2018/6/27/photo1530105953950-1530105953951857737361.jpg', '200','17','BMW')
insert into tblProducts(otoID,otoName,image,price,quantity,catagoryID) values ('F1', 'Ferrari 458 Speciale', N'https://autopro8.mediacdn.vn/2020/12/18/ferrari-458-speciale-1-16082773017231873327516.jpg', '400', '15','FE')
insert into tblProducts(otoID,otoName,image,price,quantity,catagoryID) values ('P1', 'Porsche 911 Turbo S', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRo7pWBERxBDDkMnSHXNuCG-mru4g5UvYdqnj21V0EzAIDj7MbS55LkEafcDcLWw93jCfU&usqp=CAU', '350', '20','PO')
insert into tblProducts(otoID,otoName,image,price,quantity,catagoryID) values ('B2', 'BMW 5', N'https://static.carmudi.vn/wp-content/uploads/2020-06/W06KeKsMmb.jpg', '250', '50','BMW')
insert into tblProducts(otoID,otoName,image,price,quantity,catagoryID) values ('M1', 'G63', N'https://media1.nguoiduatin.vn/thumb_x600x600/media/nguyen-ngoc-linh/2019/03/26/bulletproofmercedesamgg63byinkas3.jpg', '150', '12','MEC')
insert into tblProducts(otoID,otoName,image,price,quantity,catagoryID) values ('M2', ' Maybach Exelero ', N'https://vnn-imgs-a1.vgcloud.vn/image.anninhthudo.vn/h500/uploaded/206/2019_10_24/mercedes_2.jpg', '500', '5','MEC')
insert into tblProducts(otoID,otoName,image,price,quantity,catagoryID) values ('F2', 'Ferrari LaFerrari', N'https://static1.cafeauto.vn/cafeautoData/upload/tintuc/thitruong/2019/01/tuan-01/laferrarirevoluzionbyrevozport-1546877173.jpg', '450', '10','FE')
insert into tblProducts(otoID,otoName,image,price,quantity,catagoryID) values ('W1', 'Fenyr Supersport', N'https://xehay.vn/uploads/images/2015/11/03/xehay-fenyr-141115-11.JPG', '500', '10','W')
insert into tblProducts(otoID,otoName,image,price,quantity,catagoryID) values ('W2', 'Lykan HyperSport', N'https://www.techsignin.com/wp-content/uploads/2015/04/techsignin-lykan-hypersport-1.jpg', '450', '6','W')
