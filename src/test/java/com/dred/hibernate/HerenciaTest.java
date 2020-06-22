package com.dred.hibernate;

import javax.persistence.EntityManagerFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dred.hibernate.modelos.ProfesorFreelance;
import com.dred.hibernate.modelos.ProfesorPlantilla;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HerenciaTest {
	
	@Autowired
	private static final Logger LOGGER = 
	          LogManager.getLogger(HerenciaTest.class);


	/*@Autowired
	private EntityManagerFactory entityManagerFactory;*/
	
	@Test
	@Order(1)
	void getCursoTest() {
		System.out.println("################# Test getCurso ###################");
		ProfesorPlantilla pp = new ProfesorPlantilla(
				"David", "Sanz", "616161616",1800.0);
		ProfesorFreelance pf = new ProfesorFreelance(
				"Pedro", "Casas", "626262626",16.0);

				//entityManagerFactory.close();
	}

}
