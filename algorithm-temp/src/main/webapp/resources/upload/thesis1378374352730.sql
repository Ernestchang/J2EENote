/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/3/13 8:45:50                            */
/*==============================================================*/


drop table if exists T_MC;

drop table if exists T_MC_TYPE;

drop table if exists T_ORDER;

drop table if exists T_ORder_item;

drop table if exists t_user;

/*==============================================================*/
/* Table: T_MC                                                  */
/*==============================================================*/
create table T_MC
(
   id                   numeric(8,0) not null auto_increment,
   name                 varchar(20),
   info                 varchar(400),
   mintype              numeric(8,0),
   create_time          date,
   picture              varchar(30),
   price                numeric(10,2),
   maxtype              numeric(8,0),
   quantity             numeric(8,0),
   primary key (id)
);

/*==============================================================*/
/* Table: T_MC_TYPE                                             */
/*==============================================================*/
create table T_MC_TYPE
(
   id                   numeric(8,0) not null auto_increment,
   name                 varchar(20),
   parent_id            numeric(8,0),
   primary key (id)
);

/*==============================================================*/
/* Table: T_ORDER                                               */
/*==============================================================*/
create table T_ORDER
(
   id                   numeric(8,0) not null auto_increment,
   account              varchar(20),
   time                 date,
   pay_way              varchar(20),
   recive_way           varchar(20),
   types                numeric(8,0),
   quantity             numeric(8,0),
   total                numeric(10,2),
   state                varchar(10),
   message              varchar(100),
   admin                varchar(20),
   do_time              date,
   recive_name          varchar(20),
   address              varchar(60),
   postcode             char(6),
   tel                  char(11),
   email                varchar(20),
   primary key (id)
);

/*==============================================================*/
/* Table: T_ORder_item                                          */
/*==============================================================*/
create table T_ORder_item
(
   id                   numeric(8,0) not null auto_increment,
   order_id             numeric(8,0),
   mc_id                numeric(8,0),
   quantity             numeric(8,0),
   subtotal             numeric(10,2),
   primary key (id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   numeric(10,0) not null auto_increment,
   account              varchar(20),
   password             varchar(20),
   name                 varchar(20),
   birthday             date,
   email                varchar(20),
   tel                  varchar(20),
   address              varchar(100),
   postcode             char(6),
   sex                  char(2),
   login_times          numeric(8,0),
   last_Login           date,
   freezed              char(2),
   regist_time          date,
   primary key (id)
);

alter table T_MC add constraint FK_Reference_3 foreign key (mintype)
      references T_MC_TYPE (id) on delete restrict on update restrict;

alter table T_ORder_item add constraint FK_Reference_1 foreign key (order_id)
      references T_ORDER (id) on delete restrict on update restrict;

alter table T_ORder_item add constraint FK_mcid2mctable foreign key (mc_id)
      references T_MC (id) on delete restrict on update restrict;

