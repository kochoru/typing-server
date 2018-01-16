# データベース作成
`create database appdb;`

`\l`

# データベース接続
`\c appdb`

# ロールの作成
`create role appusr with login password 'appusr';`

`\du`

# スキーマの作成
`create schema typing_app;`

`\dn`


# テーブルの作成
```sql
create table typing_app.t_player (
    id                  char(8)     unique not null,
    name                varchar     not null,
    handle_name         varchar,
    department          varchar     not null,
    ip_address          char(15)    not null,
    last_play_time      timestamp,
    score               integer     not null,
    challenge_count     integer     default 0 not null,
    admin_flg           boolean     default false not null,
    display_name_enable boolean     default false not null,
    PRIMARY KEY(id,ip_address)
);

```

`\dt`

# 権限の作成
`grant connect on database appdb to appusr;`

`grant usage on schema typing_app to appusr;`

`grant select, update, insert, delete on all tables in schema typing_app to appusr;`

# レコードの作成
```sql
insert into typing_app.t_player (id,name,handle_name,department,ip_address,score,challenge_count,admin_flg,display_name_enable)
values ('00000000','hoge','hnhoge','aaa','127.0.0.1',0,0,true,true);

insert into typing_app.t_player (id,name,handle_name,department,ip_address,score,challenge_count,admin_flg,display_name_enable)
values ('00000001','bar','hnbar','aaa','127.0.0.1',0,0,false,false);

insert into typing_app.t_player (id,name,handle_name,department,ip_address,score,challenge_count,admin_flg,display_name_enable)
values ('00000002','foo','hnfoo','aaa','127.0.0.1',0,0,false,true);

insert into typing_app.t_player (id,name,handle_name,department,ip_address,score,challenge_count,admin_flg,display_name_enable)
values ('00000003','kochoru','hnkochoru','bbb','127.0.0.1',0,0,false,true);

insert into typing_app.t_player (id,name,handle_name,department,ip_address,score,challenge_count,admin_flg,display_name_enable)
values ('00000004','test','hntest','ccc','127.0.0.1',0,0,false,true);

insert into typing_app.t_player (id,name,handle_name,department,ip_address,score,challenge_count,admin_flg,display_name_enable)
values ('00000005','Ribbons Almark','Innovator','Celestial Being','127.0.0.1',0,0,true,true);

```
