CREATE TABLE member_tbl_02 (
	custno number(6) NOT NULL,
	custname varchar2(20),
	phone varchar2(13),
	address varchar2(60),
	joindate date,
	grade char(1),
	city char(2),
	CONSTRAINT member_tbl_custno_pk PRIMARY KEY (custno)
);

INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(100001, '김행복', '010-1111-2222', '서울 동대문구 휘경1동', '20151202', 'A', '01');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(100002, '이축복', '010-1111-3333', '서울 동대문구 휘경2동', '20151206', 'B', '01');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(100003, '장믿음', '010-1111-4444', '울릉군 울릉읍 독도1리', '20151001', 'B', '30');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(100004, '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', '20151113', 'A', '30');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(100005, '진평화', '010-1111-6666', '제주도 제주시 외나무골', '20151225', 'B', '60');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(100006, '차공단', '010-1111-7777', '제주도 제주시 감나무골', '20151211', 'C', '60');

select * from member_tbl_02;

CREATE TABLE money_tbl_02 (
	custno number(6) NOT NULL,
	saleno number(8) NOT NULL,
	pcost number(8),
	amount number(4),
	price number(8),
	pcode varchar(4),
	sdate date,
	CONSTRAINT money_tbl_pk PRIMARY KEY (custno, saleno),
	CONSTRAINT custno_fk FOREIGN KEY (custno) REFERENCES member_tbl_02 (custno)
);

create sequence seq_num increment by 1 start with 100007 nocycle nocache;
drop sequence seq_num;
insert into emp(num, name, age, score) values(seq_num.nextval, 'kim', 17, 75);

INSERT INTO money_tbl_02(custno, saleno, pcost, amount, price, pcode, sdate) VALUES(100001, 20160001, 500, 5, 2500, 'A001', '20160101');
INSERT INTO money_tbl_02(custno, saleno, pcost, amount, price, pcode, sdate) VALUES(100001, 20160002, 1000, 4, 4000, 'A002', '20160101');
INSERT INTO money_tbl_02(custno, saleno, pcost, amount, price, pcode, sdate) VALUES(100001, 20160003, 500, 3, 1500, 'A008', '20160101');
INSERT INTO money_tbl_02(custno, saleno, pcost, amount, price, pcode, sdate) VALUES(100002, 20160004, 2000, 1, 2000, 'A004', '20160102');
INSERT INTO money_tbl_02(custno, saleno, pcost, amount, price, pcode, sdate) VALUES(100002, 20160005, 500, 1, 500, 'A001', '20160103');
INSERT INTO money_tbl_02(custno, saleno, pcost, amount, price, pcode, sdate) VALUES(100003, 20160006, 1500, 2, 3000, 'A003', '20160103');
INSERT INTO money_tbl_02(custno, saleno, pcost, amount, price, pcode, sdate) VALUES(100004, 20160007, 500, 2, 1000, 'A001', '20160104');
INSERT INTO money_tbl_02(custno, saleno, pcost, amount, price, pcode, sdate) VALUES(100004, 20160008, 300, 1, 300, 'A005', '20160104');
INSERT INTO money_tbl_02(custno, saleno, pcost, amount, price, pcode, sdate) VALUES(100004, 20160009, 600, 1, 600, 'A006', '20160104');
INSERT INTO money_tbl_02(custno, saleno, pcost, amount, price, pcode, sdate) VALUES(100004, 20160010, 3000, 1, 3000, 'A007', '20160106');

select * from money_tbl_02;

select a.custno, a.custname, decode(a.grade, 'A', 'VIP', 'B', '일반', 'C', '직원') grade, SUM(b.price) from member_tbl_02 a, money_tbl_02 b where a.custno = b.custno group by(a.custno, custname, grade) order by price desc;
select me.custno, custname, grade, sum(price) from member_tbl_02 me, money_tbl_02 mo where me.custno = mo.custno group by(me.custno, custname, grade);



