package dao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Chanteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	private String nom;
	private String nationalite;
	private String biographie;
	@ManyToMany(mappedBy = "chanteurs")
	private List<Chanson> chansons;

	public Chanteur() {
		super();
	}

	public Chanteur(int id, String nom, String nationalite, String biographie, List<Chanson> chansons) {
		super();
		this.id = id;
		this.nom = nom;
		this.nationalite = nationalite;
		this.biographie = biographie;
		this.chansons = chansons;
	}

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

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getBiographie() {
		return biographie;
	}

	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}

	public List<Chanson> getChansons() {
		return chansons;
	}

	public void setChansons(List<Chanson> chansons) {
		this.chansons = chansons;
	}

	@Override
	public String toString() {
		return "Chanteur [id=" + id + ", nom=" + nom + ", nationalite=" + nationalite + ", biographie=" + biographie
				+ ", chansons=" + chansons + "]";
	}
}
