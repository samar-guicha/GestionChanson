package dao;

import java.util.List;

import dao.entities.Album;

public interface IGestionAlbum {

	public void ajouterAlbum(Album a);
	public List<Album> getAllAlbums();
	public Album getAlbum (int id);
	public void deleteAlbum(int id);
}
