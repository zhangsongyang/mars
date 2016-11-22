create table ACTIVITY_LONG_MARCH_COMMENT
(
   ID                   int(11)               not null auto_increment,
   USER_TYPE            int(11),
   USER_ID              int(11),
   AREA_ABB             VARCHAR(4),
   CREATE_TIME          datetime,
   CONTENT              VARCHAR(200),
   constraint PK_ACTIVITY_LONG_MARCH_COMMENT primary key (ID)
);