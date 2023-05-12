package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dao.entities.Chanson;

public class GestionChansonImpJpa implements IGestionChanson {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test"); 
    EntityManager em=emf.createEntityManager();
	@Override
	public void ajouterChanson(Chanson c) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		
	}
	@Override
	public void supprimerChanson(int id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(getChanson(id));
		et.commit();
		
	}
	@Override
	public void mettreAJourChanson(Chanson c) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(c);
		et.commit();
		
	}
	@Override
	public List<Chanson> getAllChansons() {
		Query q =em.createQuery("select c from Chanson c");
		return q.getResultList();
	}
	@Override
	public List<Chanson> getChansonBMC(String motcle) {
		Query q=em.createQuery("select c from Chanson c where c.title like :x");
		q.setParameter("x","%"+motcle+"%");
		return q.getResultList();
	}

	@Override
	public Chanson getChanson(int id) {
		return em.find(Chanson.class, id);
	}

	@Override
	public List<Chanson> getChansonsByPage(int page, int pageSize) {
		int startIndex = (page - 1) * pageSize; // Calcul de l'index de départ pour la page spécifiée

		TypedQuery<Chanson> query = em.createQuery("SELECT c FROM Chanson c", Chanson.class);
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		List<Chanson> liste = query.getResultList();

		return liste;
	}

}
