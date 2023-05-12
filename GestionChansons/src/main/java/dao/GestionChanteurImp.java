package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import dao.entities.Chanson;
import dao.entities.Chanteur;

public class GestionChanteurImp implements IGestionChanteur{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test"); 
    EntityManager em=emf.createEntityManager();
	
	@Override
	public void ajouterChanteur(Chanteur c) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		
	}
	@Override
	public List<Chanteur> getAllChanteur() {
		Query q =em.createQuery("select c from Chanteur c");
		return q.getResultList();
	}
	@Override
	public Chanteur getChanteur(int id) {
		return em.find(Chanteur.class, id);
	}
	@Override
	public void deleteChanteur(int id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(getChanteur(id));
		et.commit();
		
	}

}
