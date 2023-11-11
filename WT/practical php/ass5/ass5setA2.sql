create table event(eno int primary key,title varchar(20),date date);

        insert into event values(1,'Adivisory Event','9/7/2012');
        insert into event values(2,'Petition Event','5/6/2015');
        insert into event values(3,'Ruling Event','7/6/2017');



create table committee(cno int primary key,name varchar(40),head varchar(30),from_time time,to_time time,status varchar(20));

        insert into committee values(12,'Business Advisory Committee','Manager','12:00','2:30','non-working');
        insert into committee values(11,'Committee on Petitions','Chairman','1:00','3:00','non-working');
        insert into committee values(13,'Committee on Rules','Chairman','3:00','4:30','non-working');



create table event_committee(eno int references event(eno) on delete cascade,cno int references committee(cno) on delete cascade);

        insert into event_committee values(1,12);
        insert into event_committee values(2,11);
        insert into event_committee values(3,13);
