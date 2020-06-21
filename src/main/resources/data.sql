insert into curso(id_curso, nombre, descripcion) 
values(hibernate_sequence.nextval, 'Servlets', 'Crea servlets con la Servlet API' );
insert into curso(id_curso, nombre, descripcion) 
values(hibernate_sequence.nextval, 'Struts', 'Maneja el framework para proyectos web' );
insert into curso(id_curso, nombre, descripcion) 
values(hibernate_sequence.nextval, 'Spring', 'El framework de inyeción de dependencias y desarrollo modular' );
insert into curso(id_curso, nombre, descripcion) 
values(hibernate_sequence.nextval, 'Hibernate', 'Aprende a persistir datos de manera sencilla' );

insert into review(id, rating, descripcion, curso_id_curso) 
values (review_sequence.nextval, 4,'¡Muy bueno!', 2);
insert into review(id, rating, descripcion, curso_id_curso) 
values (review_sequence.nextval, 3,'Aprendí mucho', 1);
insert into review(id, rating, descripcion, curso_id_curso) 
values (review_sequence.nextval, 4,'Me ha encantado', 2);
insert into review(id, rating, descripcion, curso_id_curso) 
values (review_sequence.nextval, 4,'Volvería a hacerlo', 2);

insert into usuario(id_usuario, password, tipo)
values('aperez','password','Avanzado');
insert into usuario(id_usuario, password, tipo)
values('llopez2000','123456','Básico');
insert into usuario(id_usuario, password, tipo)
values('lama_m','000000','Básico');

insert into alumno (dni, nombre, apellidos, telefono, usuario_id_usuario)
values ('20000000P', 'Ana', 'Pérez', '666333111','aperez');
insert into alumno (dni, nombre, apellidos, telefono, usuario_id_usuario)
values ('11111111A', 'Luis', 'López', '600000001','llopez2000');
insert into alumno (dni, nombre, apellidos, telefono, usuario_id_usuario)
values ('34300600L', 'María', 'Lama', '744744744','lama_m');

insert into matricula (dni, id_curso) 
values ('20000000P',1);
insert into matricula (dni, id_curso) 
values ('11111111A',1);
insert into matricula (dni, id_curso) 
values ('34300600L',1);
insert into matricula (dni, id_curso) 
values ('20000000P',2);
