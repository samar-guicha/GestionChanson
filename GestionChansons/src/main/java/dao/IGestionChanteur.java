package dao;

import java.util.List;

import dao.entities.Chanteur;




public interface IGestionChanteur {
	public void ajouterChanteur(Chanteur c);
	public List<Chanteur> getAllChanteur();
	public Chanteur getChanteur (int id);
	public void deleteChanteur(int id);
}
