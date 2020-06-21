package com.dred.hibernate;

import java.util.List;

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

import com.dred.hibernate.modelos.Curso;
import com.dred.hibernate.modelos.dao.CursoDAO;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CursoTest {

	@Autowired
	private CursoDAO cursoDAO;
	
	@Autowired
	private static final Logger LOGGER = 
	          LogManager.getLogger(CursoTest.class);


	@Test
	@Order(1)
	void getCursoTest() {
		System.out.println("################# Test getCurso ###################");
		Curso c= cursoDAO.getCurso(1L);
		Assertions.assertTrue(c.getNombre().equals("Servlets")
	       && c.getDescripcion().equals("Crea servlets con la Servlet API"));
	}
	
	@Test
	@Order(2)
	void guardaCursoTest() {
		System.out.println("################# Test guardarCurso ###################");
		Curso curso= new Curso("PHP", "Lenguaje de servidor PHP");
		cursoDAO.guardarCurso(curso);
		//Recuperamos de la base de datos a través del id y lo comprobamos
		Curso cBD=cursoDAO.getCurso(curso.getIdCurso());
			
		Assertions.assertEquals(curso, cBD);
	}
	
	@Test
	@Order(3)
	void eliminarCursoTest() {
		System.out.println("################# Test eliminarCurso ###################");
		Curso c= cursoDAO.getCurso(5L);
		cursoDAO.eliminarCurso(c.getIdCurso());
		
		//buscamos y si no está se ha eliminado
		Curso c2=cursoDAO.getCurso(5L);
		
		Assertions.assertNull(c2);
	}
	
	@Test
	@Order(4)
	void modificarCursoTest() {
		System.out.println("################# Test modificarCurso ###################");
		Curso c= cursoDAO.getCurso(4L);
		// modificamos el curso.
		c.setDescripcion(c.getDescripcion()+" Actualizado");
		cursoDAO.guardarCurso(c);
		// buscamos el curso en la base de datos
		Curso c2 = cursoDAO.getCurso(4L);
		LOGGER.info("Curso Modificado: " + c2.getDescripcion());
		
		Assertions.assertEquals(c,c2);
	}
	
	@Test
	@Order(5)
	void getListaCursosTest() {
		System.out.println("################# Test getListaCursos ###################");
		List<Curso> listaCursos = cursoDAO.getListaCursos();
	
		// Lo imprimo en el log para verlos
		LOGGER.info("Lista de cursos " + listaCursos);
	
		
		Assertions.assertEquals(4, listaCursos.size());
	}
	
	@Test
	@Order(6)
	void getListaCursosDescTest() {
		System.out.println("################# Test getListaCursosDesc ###################");
		List<Curso> listaCursos = cursoDAO.getListaCursos("framework");
	
		// Lo imprimo en el log para verlos
		LOGGER.info("Lista de cursos Desc" + listaCursos);
	
		
		Assertions.assertEquals(2, listaCursos.size());
	}
	
	@Test
	@Order(7)
	void getListaNativeTest() {
		System.out.println("################# Test getListaNative ###################");
		List<Curso> listaCursos = cursoDAO.getListaCursosNativa();
	
		// Lo imprimo en el log para verlos
		LOGGER.info("Lista de cursos Desc" + listaCursos);
	
		
		Assertions.assertEquals(4, listaCursos.size());
	}

}
