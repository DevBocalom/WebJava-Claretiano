package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");

		if ("usuarioscadastro".equals(action)) {
			request.getRequestDispatcher("usuarioscadastro.jsp").forward(request, response);
		} 	else if ("produtoscadastro".equals(action)) {
			request.getRequestDispatcher("produto.jsp").forward(request, response);
		}	else {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}
	
}
