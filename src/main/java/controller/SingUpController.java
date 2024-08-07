package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.*;
import model.dto.Usuario;


@WebServlet("/SingUpController")
public class SingUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SingUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/views/singUp.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		UsuarioDAO uDAO= new UsuarioDAOImpl();
		Usuario u = null;
		String nick = request.getParameter("nick");
		String correo = request.getParameter("email");
		String nombre = request.getParameter("name");
		String password = request.getParameter("password");
		int peso= Integer.parseInt(request.getParameter("weight"));
		
		u=new Usuario(correo,nick,nombre,password,peso);
		Usuario uRSU=uDAO.read(u);
		if(uRSU.getCorreo()==u.getCorreo()) {
			request.setAttribute("usuarioSU", u);
			getServletContext().getRequestDispatcher("/views/userAlreadyExist.jsp").forward(request,response);	
		}
		else {
			uDAO.create(u);
			request.setAttribute("usuario", u);
			getServletContext().getRequestDispatcher("/views/home.jsp").forward(request,response);
		}
		
		}catch(NumberFormatException e) {
			System.out.println("ERROR");
			getServletContext().getRequestDispatcher("/SingUpController").forward(request,response);
		}
	}

}
