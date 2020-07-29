# ����linux��mysql��Ҫ�ص���Сд���У�window����Ҫ
create table tbl_course_type(
   type_id int primary key auto_increment comment '�γ�����Id',
   type_name varchar(30) comment '�γ���������'
)engine=innodb default charset=utf8;

insert into tbl_course_type(type_name) values('רҵ����');
insert into tbl_course_type(type_name) values('רҵ��ѡ');
insert into tbl_course_type(type_name) values('Уѡ��');
insert into tbl_course_type(type_name) values('ר�ҽ���');

create table tbl_course(
   course_no varchar(100) primary key comment '�������γ̱��',
   course_name varchar(100) comment '�γ�����',
   type_id int not null comment '�γ�����Id',
   course_memo text comment '��ע˵��'
   constraint fk_course_type foreign key (type_id) references tbl_course_type(type_id)
)engine=innodb default charset=utf8;

create table tbl_users(
   user_no varchar(100) primary key comment '�û��˺�',
   user_pwd varchar(500) comment '����',
   user_name varchar(500) comment '�û�����'
)engine=innodb default charset=utf8;

insert into tbl_users values('000101','123456','������');
insert into tbl_users values('000102','123456','����');

create table tbl_admin(
   admin_no varchar(100) primary key comment '�û��˺�',
   admin_pwd varchar(500) comment '����',
   admin_name varchar(500) comment '�û�����'
)engine=innodb default charset=utf8;
insert into tbl_users values('Admin','Admin','Admin');
  

