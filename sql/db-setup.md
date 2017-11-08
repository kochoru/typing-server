# データベース作成
`create database appdb;`

`\l`

# ロールの作成
`create role appusr with login password 'appusr';`

# スキーマの作成
`create schema typing_app;`

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

# 権限の作成
`grant select, update, insert, delete on all tables in schema typing_app to appusr;`