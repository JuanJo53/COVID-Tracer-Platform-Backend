/*Role inserts*/
insert into role values (null, "ROLE_ADMIN", 1, 1, "127.0.0.1", 0, "2021-06-04");
insert into role values (null, "ROLE_USER", 1, 2, "127.0.0.1", 0, "2021-06-04");

/*Person inserts*/
insert into person values(null, "Juan", "Rocha", "Cruz", 1, 3, "127.0.0.1", 0, "2021-06-04");

/*User inserts password=abc12345*/
insert into user values(null, 1, "juanrocha@gmail.com", "juanrocha", "$2a$10$bCwH7ZxnvItj5AjIYtbHAuFiEC0vp8yB0HpAjLoJzWWmK.1YJcM2G", 1, 4, "127.0.0.1", 0, "2021-06-04");

/*User_Role inserts*/
insert into user_role values(null, 1, 1, 1, 5, "127.0.0.1", 0, "2021-06-04");

/*Transaction inserts*/
insert into transaction values(null, "127.0.0.1", 0, "2021-06-04");
insert into transaction values(null, "127.0.0.1", 0, "2021-06-04");
insert into transaction values(null, "127.0.0.1", 0, "2021-06-04");
insert into transaction values(null, "127.0.0.1", 0, "2021-06-04");
insert into transaction values(null, "127.0.0.1", 0, "2021-06-04");