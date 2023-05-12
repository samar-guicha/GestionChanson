package web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.GestionAlbumImp;
import dao.GestionChansonImp;
import dao.GestionChanteurImp;
import dao.GestionChansonImpJpa;
import dao.IGestionChanteur;
import dao.IGestionAlbum;
import dao.IGestionChanson;

import dao.entities.Album;
import dao.entities.Chanson;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
@MultipartConfig
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IGestionChanson gestion;
	private IGestionAlbum gestionAlbum;
	private IGestionChanteur gestionChanteur;

	public void init(ServletConfig config) throws ServletException {
		gestion = new GestionChansonImpJpa();
		gestionAlbum = new GestionAlbumImp();
		gestionChanteur = new GestionChanteurImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			String action = request.getParameter("action");

			if (action == null) {
				List<Chanson> liste = gestion.getAllChansons();
				request.setAttribute("liste", liste);
				request.getRequestDispatcher("Vue.jsp").forward(request, response);
			} else 
				if(action.equals("rechercher")) {
					String mc =request.getParameter("mc");
					request.setAttribute("liste", gestion.getChansonBMC(mc));
					request.getRequestDispatcher("Vue.jsp").forward(request, response);
				
				
			} else if (action.equals("supprimer")) {
				int id = Integer.parseInt(request.getParameter("id"));
				gestion.supprimerChanson(id);
				request.setAttribute("liste", gestion.getAllChansons());
				request.getRequestDispatcher("Vue.jsp").forward(request, response);
			} else if (action.equalsIgnoreCase("ajouter")) {
				request.setAttribute("album", gestionAlbum.getAllAlbums());
				request.getRequestDispatcher("ajoutChanson.jsp").forward(request, response);
			} else if (action.equalsIgnoreCase("ajouterform") && request.getMethod().equalsIgnoreCase("post")) {
				String title = request.getParameter("title");
				double duree = Double.parseDouble(request.getParameter("duree"));
				int idm = Integer.parseInt(request.getParameter("album"));
				Album album = gestionAlbum.getAlbum(idm);
				
				
				//image
				Part filePart = request.getPart("image");
				String fileName = filePart.getSubmittedFileName();
				String uploadDir = "C:\\Users\\samar\\eclipse-workspace\\GestionChansons\\src\\main\\webapp\\images\\" + fileName;

			
				FileOutputStream fos = new FileOutputStream(uploadDir);
				InputStream is = filePart.getInputStream();
				byte[] data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();

				String id = request.getParameter("id");
				if (id.equals("")) {
					Chanson c = new Chanson(title, duree);
					 c.setFilename(fileName);
					 c.setAlbum(album);
					gestion.ajouterChanson(c);
				} else {
					Chanson c = new Chanson();
					c.setId(Integer.parseInt(id));
					c.setTitle(title);
					c.setDuree(duree);
					c.setFilename(fileName);
					c.setAlbum(album);
					gestion.mettreAJourChanson(c);
				}

				request.setAttribute("liste", gestion.getAllChansons());
				request.getRequestDispatcher("Vue.jsp").forward(request, response);
			} else if (action.equals("getPage")) {
			    int page = Integer.parseInt(request.getParameter("page"));
			    int pageSize = 5; // Nombre d'éléments à afficher par page

			    List<Chanson> liste = gestion.getChansonsByPage(page, pageSize);
			    request.setAttribute("liste", liste);
			    request.getRequestDispatcher("ChansonTable.jsp").forward(request, response);
			    
			}else if (action.equalsIgnoreCase("modifier")) {
				int id = Integer.parseInt(request.getParameter("id"));
				Chanson chanson = gestion.getChanson(id);
				request.setAttribute("chanson", chanson);
				request.setAttribute("album", gestionAlbum.getAllAlbums());
				request.getRequestDispatcher("ajoutChanson.jsp").forward(request, response);
				
				
			} else {
				request.getRequestDispatcher("auth.js").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}