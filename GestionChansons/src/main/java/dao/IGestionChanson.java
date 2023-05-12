package dao;

import java.util.List;

import dao.entities.Chanson;

public interface IGestionChanson {
	
	public void ajouterChanson(Chanson c);
	public void supprimerChanson(int id);
	public void mettreAJourChanson(Chanson c);
	public List<Chanson> getAllChansons();
	public List<Chanson> getChansonBMC(String motcle);
	public Chanson getChanson(int id);
	public List<Chanson> getChansonsByPage(int page, int pageSize);
	
}
