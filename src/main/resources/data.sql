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

