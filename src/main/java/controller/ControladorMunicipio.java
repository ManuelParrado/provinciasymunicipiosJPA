package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Municipio;



public class ControladorMunicipio {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("provinciasyalquileres");

	
	public static List<Municipio> findByLikeNombre (String nombre) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM municipio where nombre like ?;", Municipio.class);
		q.setParameter(1, "%" + nombre + "%");
		List<Municipio> l = (List<Municipio>) q.getResultList();
		
		em.close();
		return l;
	}
	
	

}
