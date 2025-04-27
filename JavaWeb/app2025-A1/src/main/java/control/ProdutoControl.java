package control;

import dao.ProdutoDAO;
import model.Produto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ProdutoControl")
public class ProdutoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoDAO produtoDAO;

	public void init() {
		produtoDAO = new ProdutoDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String marca = request.getParameter("marca");
		Double valorUnitario = Double.parseDouble(request.getParameter("valorUnitario"));
		boolean status = request.getParameter("status") != null;
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setMarca(marca);
		produto.setValorUnitario(valorUnitario);
		produto.setStatus(status);
		if (id == null || id.isEmpty()) {
			produtoDAO.insertProduto(produto);
		} else {
			produto.setId(Long.parseLong(id));
			produtoDAO.updateProduto(produto);
		}
		response.sendRedirect("produto.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			produtoDAO.deleteProduto(id);
		}
		response.sendRedirect("produto.jsp");
	}
}