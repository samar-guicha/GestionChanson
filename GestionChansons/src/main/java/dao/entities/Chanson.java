package dao.entities;

import javax.persistence.JoinColumn;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Chanson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	private String title;
	private double duree;
	private String filename;

	@ManyToOne
	private Album album;
	@ManyToMany

	@JoinTable(name = "chanson_chanteur", joinColumns = @JoinColumn(name = "chanson_id"), inverseJoinColumns = @JoinColumn(name = "chanteur_id"))
	private List<Chanteur> chanteurs;

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Chanson(int id, String title, double duree, Album album, List<Chanteur> chanteurs) {
		super();
		this.id = id;
		this.title = title;
		this.duree = duree;
		this.album = album;
		this.chanteurs = chanteurs;
	}

	public List<Chanteur> getChanteurs() {
		return chanteurs;
	}

	public void setChanteurs(List<Chanteur> chanteurs) {
		this.chanteurs = chanteurs;
	}

	public Chanson(int id, String title, double duree, String filename, Album album, List<Chanteur> chanteurs) {
		super();
		this.id = id;
		this.title = title;
		this.duree = duree;
		this.filename = filename;
		this.album = album;
		this.chanteurs = chanteurs;
	}
	public Chanson( String title, double duree, String filename, Album album, List<Chanteur> chanteurs) {
		super();
		
		this.title = title;
		this.duree = duree;
		this.filename = filename;
		this.album = album;
		this.chanteurs = chanteurs;
	}
	public Chanson(int id, String title, double duree, Album album) {
		super();
		this.id = id;
		this.title = title;
		this.duree = duree;
		this.album = album;
	}

	public Chanson(String title, double duree) {
		super();
		this.title = title;
		this.duree = duree;

	}

	public Chanson(int id, String title, double duree) {
		super();
		this.id = id;
		this.title = title;
		this.duree = duree;

	}

	public Chanson() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "Chanson [id=" + id + ", title=" + title + ", duree=" + duree + "]";
	}

}
