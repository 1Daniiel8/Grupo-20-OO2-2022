create schema if not exists `Grupo-20-OO2-2022`;
use `Grupo-20-OO2-2022`;
insert into perfil(createat, tipo, updateat)
values('2021-05-20', "ROLE_ADMIN",'2021-05-20');

insert into perfil(createat, tipo, updateat)
values('2021-05-20', "ROLE_AUDITOR",'2021-05-20');

-- persona

insert into persona(apellido, createat, dni, nombre, updateat)
values("Frutos", '2020-11-11', 43200626, "Daniel", '2020-11-11');

insert into persona(apellido, createat, dni, nombre, updateat)
values("Auditor", '2020-11-11', 43200625, "Usuario", '2020-11-11');

-- usuario=root password=admin

insert into usuario(email, password, username, id_persona, perfil_id_perfil)
values("daniel@gmail.com","$2a$10$KbD5zlop6D/W06fvqtHzLejYw3evJ3U3fWP/ffDpiiaWVQmFVhLZq", "root", 1, 1 );

-- usuario=user password=auditor

insert into usuario(email, password, username, id_persona, perfil_id_perfil)
values("usuario@gmail.com.ar","$2a$10$ePhKPkFp.Uti3gy3HI5PcupVWrckG3cEhKgbma62mjulO/K.GoalS", "user", 2, 2 );


SELECT * from Usuario;
SELECT * from NOTAPEDIDO;
SELECT * from CURSO;