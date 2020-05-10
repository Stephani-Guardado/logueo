package com.estefany.controladorDatos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.estefany.DAO.loginDAO;
import com.estefany.model.Logueo;

/**
 * Servlet implementation class serveletUser
 */
public class serveletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serveletUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String use = request.getParameter("usuario");
		String contrase = request.getParameter("contra");
		String cerrarsesion = request.getParameter("btncerrar");
		
		if (cerrarsesion !=null) {
			if (cerrarsesion.equals("CERRAR")) {
				
				HttpSession cerrarsesiones = (HttpSession) request.getSession();
				cerrarsesiones.invalidate();
				
				response.sendRedirect("index.jsp");
			}
		}
		else {
		
		Logueo user = new Logueo();
		loginDAO lDao = new loginDAO();
		
		user.setUsuario(use);
		user.setPassword(contrase);
		
		int ingresarDatos =lDao.ingresarUser(user).size();

		if (ingresarDatos==1) {
			HttpSession seccion = request.getSession(true);
			seccion.setAttribute("usuario", use);
			response.sendRedirect("Principal.jsp");
		
		} else {
			System.out.println("error");
		}
		}
	}

}
