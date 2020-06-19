package com.dred.hibernate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.dred.hibernate.modelos.Curso;
import com.dred.hibernate.modelos.dao.CursoDAO;

@SpringBootTest
@ExtendWith(SpringExtension.class)

class CursoTest {

	@Autowired
	private CursoDAO cursoDAO;

	@Test
	void getCursoTest() {
		Curso c= cursoDAO.getCurso(1L);
		Assertions.assertTrue(c.getNombre().equals("Servlets")
	       && c.getDescripcion().equals("Crea servlets con la Servlet API"));
	}
	
	@Test
	void guardaCursoTest() {
		Curso curso= new Curso("PHP", "Lenguaje de servidor PHP");
		cursoDAO.guardarCurso(curso);
		//Recuperamos de la base de datos a través del id y lo comprobamos
		Curso cBD=cursoDAO.getCurso(curso.getIdCurso());
			
		Assertions.assertEquals(curso, cBD);
	}
	
	@Test
	void eliminarCursoTest() {
		Curso c= cursoDAO.getCurso(5L);
		cursoDAO.eliminarCurso(c.getIdCurso());
		
		//buscamos y si no está se ha eliminado
		Curso c2=cursoDAO.getCurso(5L);
		
		Assertions.assertNull(c2);
	}
	
	@Test
	void modificarCursoTest() {
		Curso c= cursoDAO.getCurso(4L);
		// modificamos el curso.
		c.setDescripcion(c.getDescripcion()+" Actualizado");
		cursoDAO.guardarCurso(c);
		// buscamos el curso en la base de datos
		Curso c2 = cursoDAO.getCurso(4L);
		
		Assertions.assertEquals(c,c2);
	}
	
	

}
