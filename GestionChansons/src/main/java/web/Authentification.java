package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GestionUserImp;
import dao.IGestionUser;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/userAuth")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
	IGestionUser gestion;
	public void init() {
		gestion = new GestionUserImp();
	}
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action =request.getParameter("action");
		if (action == null)
		request.getRequestDispatcher("auth.jsp").forward(request, response);
		else
		{
			HttpSession session =request.getSession(false);
			if(session!=null) {
				session.invalidate();
				response.sendRedirect(request.getContextPath()+"/");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String username = gestion.getUsername(login, password);
		if(username==null)
		{
			request.setAttribute("erreur", "login ou mot de passe incorrecte ");
			System.out.print("erreeeoyr");
			request.getRequestDispatcher("auth.jsp").forward(request, response);
		}
		else {
			HttpSession session =request.getSession();
			session.setAttribute("username", username);
			
			response.sendRedirect("FirstServlet");
		}
	}

}
