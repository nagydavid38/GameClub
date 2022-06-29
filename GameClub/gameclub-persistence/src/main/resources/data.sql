INSERT INTO GAMES (id, name, description, minimum_age, playtime_min, playtime_max, playernum_min, playernum_max) VALUES
( 1, 'Catan Telepesei', 'A Catan telepesei a legtöbb társasjáték rajongónak az első lépés ami túlmutat a gyermekkori klasszikus dobok és lépek játékokon.' ||
                        ' A játék célja Catan szigetén megszerezni az uralmat…', 10, 60, 120, 3, 4),
( 2, 'Pandemic', 'Megvan benned a képesség és a bátorság ahhoz, hogy megmentsd az emberiséget ? Az izgalmas stratégiai játékban egy járványelhárító csapat szakképzett tagjaként feladatod, ' ||
                 'hogy felfedezd a halálos járvány ellenszérumát, még mielőtt az világszerte elterjedne…', 8, 45, 60, 2, 4);

INSERT INTO GAME_CATEGORIES VALUES ( 1, 'STRATEGY' ), (2, 'STRATEGY');

INSERT INTO USERS(id, login_name, name, password, email) VALUES
                ( 1, 'nagys', 'Nagy Sándor', 'ns-secret', 'nagy.sandor@gmail.com'),
                ( 2, 'horvatha', 'Horváth Ádám', 'ha-secret', 'horvath.adam@gmail.com'),
                ( 3, 'kovacsp', 'Kovács Péter', 'kp-secret', 'kovacs.peter@gmail.com'),
                ( 4, 'kissi', 'Kiss István', 'ki-secret', 'kiss.istvan@gmail.com'),
                ( 5, 'nagyd', 'Nagy Dávid', 'nd-secret', 'nagy.david@gmail.com');

INSERT INTO USERS_GAMES VALUES ( 2, 1), ( 2, 2), ( 3, 1 ), (3,2), (4,2), (5,1);

INSERT INTO PLAYER_ROLES VALUES ( 1, 'SUPERUSER' ), ( 2, 'GROUPADMIN'), ( 2, 'PLAYER'), ( 3, 'PLAYER'), ( 3, 'GROUPADMIN'), ( 4, 'PLAYER'), ( 5, 'PLAYER'), ( 5, 'GROUPADMIN');

INSERT INTO GROUPS (id, name, admin_id) VALUES ( 1, 'Óbudai Informatika Játék Csoport', 2 );
INSERT INTO GROUPS (id, name, admin_id) VALUES ( 2, 'DnD csoport', 5 );
INSERT INTO GROUPS (id, name, admin_id) VALUES ( 3, 'Társas gang', 3 );

INSERT INTO GROUPS_MEMBERS VALUES ( 1, 3 ), (1, 4), (2, 1), (2, 2), (2, 3), (3, 4);

INSERT INTO JOIN_REQUEST VALUES
    (1, 4, 'ACCEPTED', 1, 4 ), ( 1, 5, 'REQUESTED', 1, 5);

INSERT INTO EVENTS VALUES
    ( 1, '2022-11-15 15:30:14.332', 'Szoki péntek', 'Enter Bar'),
    ( 2, '2022-05-19 16:30', 'Szülinap + catan', 'Józsinál'),
    ( 3, '2022-06-09 16:30', 'Spontán event', 'Barcraft'),
    ( 4, '2022-05-19 16:30', 'DnD party', 'Laci lakásán');

INSERT INTO EVENTS_PARTICIPANTS VALUES ( 1, 2 ), ( 1, 3), (2, 1), ( 2, 2);

INSERT INTO GROUPS_EVENTS VALUES (1, 1 ), (1, 2), (2, 4);
