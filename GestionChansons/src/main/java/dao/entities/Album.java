package dao.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private double prix;
	private int quantite;
	private String description;

	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	private List<Chanson> liste;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Chanson> getListe() {
		return liste;
	}

	public void setListe(List<Chanson> liste) {
		this.liste = liste;
	}	
	public Album(int id, String nom, double prix, int quantite, String description, List<Chanson> liste) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.description = description;
		this.liste = liste;
	}

	public Album(String nom, double prix, int quantite, String description, List<Chanson> liste) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.description = description;
		this.liste = liste;
	}

	public Album() {

	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", nom=" + nom + ", prix=" + prix + ", quantite=" + quantite + ", description="
				+ description + "]";
	}

}
