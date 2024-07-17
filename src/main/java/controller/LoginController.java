package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.*;
import model.dto.Usuario;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/views/login.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO uDAO = new UsuarioDAOImpl();
		String correo = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario u = new Usuario(correo,password);
		Usuario ur = uDAO.read(u);
		if(ur.getId()!=0) {
			request.setAttribute("usuario", ur);
			getServletContext().getRequestDispatcher("/views/home.jsp").forward(request,response);}
		else {
			getServletContext().getRequestDispatcher("/views/userNotFound.jsp").forward(request,response);
		}
		
	}

}
