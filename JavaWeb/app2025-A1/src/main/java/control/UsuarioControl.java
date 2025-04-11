package control;

import dao.UsuarioDAO;
import model.Usuario;
/*
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/UsuarioControl")
public class UsuarioControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;

	public void init() {
		usuarioDAO = new UsuarioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		boolean status = request.getParameter("status") != null;
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setTelefone(telefone);
		usuario.setStatus(status);
		if (id == null || id.isEmpty()) {
			usuarioDAO.insertUsuario(usuario);
		} else {
			usuario.setId(Long.parseLong(id));
			usuarioDAO.updateUsuario(usuario);
		}
		response.sendRedirect("usuarioscadastro.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			usuarioDAO.deleteUsuario(id);
		}
		response.sendRedirect("usuarioscadastro.jsp");
	}
}