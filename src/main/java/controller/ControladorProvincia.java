package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Provincia;

public class ControladorProvincia {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("provinciasymunicipios");
	
	public static List<Provincia> findAll() {
		
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM provincia;", Provincia.class);
		List<Provincia> l = (List<Provincia>) q.getResultList();
		
		em.close();
		return l;
	}
	
}
