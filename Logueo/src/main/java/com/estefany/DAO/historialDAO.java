package com.estefany.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.estefany.model.TbHistorial;

public class historialDAO {

public void agregardatos (TbHistorial His) {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	emf = Persistence.createEntityManagerFactory("Logueo");
	em = emf.createEntityManager();
	
	em.getTransaction().begin();
	em.persist(His);
	em.flush();
	em.getTransaction().commit();
}

}
