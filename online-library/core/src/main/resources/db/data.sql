-- passwords qwe123
INSERT INTO USERS VALUES (1,'admin','$2a$10$vOKxQ5NibjiF1pwypqbNyOvDHSJAbdxJ5rCh0Gdee6OkiIawemBJ6','Админ','Петров','ACTIVE');

INSERT INTO USER_ROLES VALUES (1,'ROLE_USER');
INSERT INTO USER_ROLES VALUES (1,'ROLE_ADMIN');

INSERT INTO USERS VALUES (2,'user','$2a$10$vOKxQ5NibjiF1pwypqbNyOvDHSJAbdxJ5rCh0Gdee6OkiIawemBJ6','Юзер','Иванов','ACTIVE');

INSERT INTO USER_ROLES VALUES (2,'ROLE_USER');

INSERT INTO BOOK VALUES (1,'Война и Мир. Т.1','Толстой Л. Н.','',2010,10.12);
INSERT INTO BOOK VALUES (2,'Война и Мир. Т.2','Толстой Л. Н.','',2010,10.13);
INSERT INTO BOOK VALUES (3,'Архитектура корпоративных программных приложений','	Мартин Фаулер','Книга дает ответы на трудные вопросы, с которыми приходится сталкиваться всем разработчикам корпоративных систем.',2010,241454.13);