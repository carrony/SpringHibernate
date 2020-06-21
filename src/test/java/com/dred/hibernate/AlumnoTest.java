package com.dred.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.dred.hibernate.modelos.Alumno;
import com.dred.hibernate.modelos.Usuario;
import com.dred.hibernate.modelos.dao.AlumnoDAO;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AlumnoTest {
	
	@Autowired
	AlumnoDAO alumnoDAO;
	
	@Autowired
	private static final Logger LOGGER = 
	          LogManager.getLogger(CursoTest.class);

	@Test
	@Order(1)
	void guardaCursoTest() {
		System.out.println("################# Test guardarAlumno ###################");
		Alumno alumno= new Alumno("20000000P", "Eva", "Pérez", "666333111");
		Usuario usuario = new Usuario("simancas_eva", "000000", "Avanzado");
		alumno.setUsuario(usuario);
		
		alumnoDAO.guardarAlumno(alumno);

		//Recuperamos de la base de datos a través del id y lo comprobamos
		Alumno al = alumnoDAO.getAlumno(alumno.getDni());
		// Lo imprimo en el log para verlos
		LOGGER.info("Alumno recuperado: " + al);
			
		Assertions.assertEquals(alumno, al);
	}
	
	@Test
	@Order(2)
	@Transactional
	void mostrarCursosAlumnoTest() {
		System.out.println("################# Test mostrarCursos ###################");
		
		Alumno alumno= alumnoDAO.getAlumno("20000000P");
		LOGGER.info("Alumno recuperado: " + alumno);
		LOGGER.info("Cursos Matriculados: " + alumno.getCursos());
			
		Assertions.assertEquals(2, alumno.getCursos().size());
	}

}
