package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.entities.Album;


public class GestionAlbumImp implements IGestionAlbum{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test"); //la relation entre l'entite et la ficher persistence
    EntityManager em=emf.createEntityManager();//on trouve tout les crud
	@Override
	public void ajouterAlbum(Album a) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(a);
		et.commit();
		
	}
	@Override
	public List<Album> getAllAlbums() {
		Query q =em.createQuery("select m from Album m");
		return q.getResultList();
	}
	@Override
	public Album getAlbum(int id) {
		return em.find(Album.class, id);
	}
	@Override
	public void deleteAlbum(int id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(getAlbum(id));
		et.commit();
		
	}

}
