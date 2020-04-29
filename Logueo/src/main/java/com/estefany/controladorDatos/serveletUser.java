package com.estefany.controladorDatos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		Logueo o = new Logueo();
		loginDAO dao = new loginDAO();
		
		String id= null;
		String nombre= null;
		String apellido = null;
		String correo = null;
		String usuario = null;
		String contra = null;
		
		try {
			
			nombre= request.getParameter("Nombre");
			apellido= request.getParameter("Nombres");
			correo= request.getParameter("cUsuario");
			usuario= request.getParameter("Usuario");
			contra= request.getParameter("Registra una contraseÃ±a");
				
			
			o.setIdlogueo(Integer.parseInt(id));
			o.setNombres_Usuario(nombre);
			o.setApellidos_Usuario(apellido);
			o.setCorre_Usuario(correo);
			o.setUsuario(usuario);
			o.setPassword(contra);
			} catch (Exception e) {
				// TODO: handle exception
			}
		String acction = request.getParameter("btn");
		if (acction.equals("GUARDAR")) {
			o.setIdlogueo(Integer.parseInt(id));
			o.setNombres_Usuario(nombre);
			o.setApellidos_Usuario(apellido);
			o.setCorre_Usuario(correo);
			o.setUsuario(usuario);
			o.setPassword(contra);
			dao.agregarDatos(o);
			
		}
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String use = request.getParameter("usuario");
		String contrase = request.getParameter("contra");
		
		Logueo user = new Logueo();
		loginDAO lDao = new loginDAO();
		
		user.setUsuario(use);
		user.setPassword(contrase);
		
		int ingresarDatos =lDao.ingresarUser(user).size();

		if (ingresarDatos==1) {
			
			System.out.println("bienvenido");
		
		} else {
			System.out.println("error");
		}
		response.sendRedirect("hola.jsp");
	}

}
