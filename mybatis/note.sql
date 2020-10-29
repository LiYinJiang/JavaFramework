create database eryingzhang;
use eryingzhang;
	drop table team_;
	create table team_(
	id int not null auto_increment,
	name varchar(30) not null,
	primary key(id)
	)auto_increment=1 default charset=utf8;
	
	delete from team_;
	insert into team_ values(1,'DK');
	insert into team_ values(2,'WINGS');
	insert into team_ values(3,'LIQUID');
	insert into team_ values(4,'LGD');
	
	drop table team_members_;
	create table team_members_(
	id int not null auto_increment,
	name varchar(20),
	tid int not null, 
	
	primary key(id)
	)auto_increment=1 default charset=utf8;
	insert into team_members_ values(null,'Burning',1);
	insert into team_members_ values(null,'Burning',1);
	insert into team_members_ values(null,'Burning',1);
	insert into team_members_ values(null,'Burning',1);
	insert into team_members_ values(null,'SKY',2);
	insert into team_members_ values(null,'SKY',2);
	insert into team_members_ values(null,'SKY',2);
	insert into team_members_ values(null,'SKY',2);
	

drop table hero_;
create table hero_(
	id int(11) not null auto_increment,
	name varchar(24) default null,
	
	primary key(id)
	)engine=MyISAM auto_increment=1 default charset=UTF8;
	
	insert into hero_ value(null,"storm");
	insert into hero_ value(null,"Shendelzare");
	insert into hero_ value(null,"Silkwood");
	insert into hero_ value(null,"Zeus");
	insert into hero_ value(null,"Aiushtha");
	insert into hero_ value(null,"Morphling");
	insert into hero_ value(null,"Sven");
	insert into hero_ value(null,"Slithice");
	insert into hero_ value(null,"Inverse");
	insert into hero_ value(null,"Rikimaru");
	
	
	use eryingzhang;
	

	drop table equipment_;
	create table equipment_(
	id int not null auto_increment,
	name varchar(30) not null,
	price float default 0,
	hid int,
	primary key(id)
	)auto_increment=1 default charset=utf8;
	
	delete from equipment_;
	insert into equipment_ values(1,'magicStick', 500);
	insert into equipment_ values(2,'dagger', 2000);
	insert into equipment_ values(3,'bot', 2050);
	insert into equipment_ values(4,'mek', 1850);
	insert into equipment_ values(5,'urm', 875);
	insert into equipment_ values(6,'forceStaff', 1854);
	insert into equipment_ values(7,'eul', 1703);
	insert into equipment_ values(8,'dagong', 6000);
	
	
	create table name_of_hero_ (
	id int not null auto_increment,
	tmId int not null,
	hid int not null,
	primary key(id)
	)auto_increment=1 default charset=utf8;
	insert into name_of_hero_ value(null,1,1);
	insert into name_of_hero_ value(null,1,2);
	insert into name_of_hero_ value(null,1,4);
	insert into name_of_hero_ value(null,1,3);
	insert into name_of_hero_ value(null,2,2);
	insert into name_of_hero_ value(null,2,3);
	insert into name_of_hero_ value(null,2,5);
	insert into name_of_hero_ value(null,2,6);
	
	create table professionalCompetition_ (
	id int not null auto_increment,
	name varchar(30) not null,
	primary key(id)
	)auto_increment=1 default charset=utf8;
	insert into professionalCompetition_ value(null,'theInternationInvitational');
	insert into professionalCompetition_ value(null,'theEpicenterCup');


	