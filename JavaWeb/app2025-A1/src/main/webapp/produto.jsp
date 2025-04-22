<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="dao.ProdutoDAO"%>
<%@ page import="model.Produto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>Cadastro de Produtos</title>
<script>
	function editarProdutos(id, nome, descricao, marca, valorUnitario, status) {
		document.getElementById("id").value = id;
		document.getElementById("nome").value = nome;
		document.getElementById("descricao").value = descricao;
		document.getElementById("marca").value = marca;
		document.getElementById("valorUnitario").value = valorUnitario;
		document.getElementById("status").checked = status === "true";
	}
</script>
</head>
<body>
	<h2>Cadastro de Produtos</h2>
	<form action="ProdutoControl" method="post">
		<input type="hidden" id="id" name="id"> 
		<label>Nome:</label> 
		<input type="text" id="nome" name="nome" required><br> 
		<label>Descrição:</label>
		<input type="text" id="descricao" name="descricao" required><br>
		<label>Marca:</label> 
		<input type="text" id="marca" name="marca" required><br> 
		<label>Valor Unitário:</label> 
		<input type="text" id="valorUnitario" name="valorUnitario" required><br>
		<label>Status:</label> 
		<input type="checkbox" id="status" name="status"><br> 
		<input type="submit" value="Salvar">
	</form>
	<br />
	<div id="container">
		<h2>Cadastro de Produtos</h2>
		<br /> <a href="HomeController?action=home">Voltar para Home</a>
	</div>
	<br />
	<h2>Produtos Cadastrados</h2>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Marca</th>
			<th>Valor Unitário</th>
			<th>Status</th>
			<th>Ações</th>
		</tr>

		<%
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtos = produtoDAO.selectAllProduto();
		for (Produto produto : produtos) {
		%>
		<tr>
			<td><%=produto.getId()%></td>
			<td><%=produto.getNome()%></td>
			<td><%=produto.getDescricao()%></td>
			<td><%=produto.getMarca()%></td>
			<td><%=produto.getValorUnitario()%></td>
			<td><%=produto.isStatus() ? "Ativo" : "Inativo"%></td>
			<td>
				<button
					onclick="editarProdutos('<%=produto.getId()%>', '<%=produto.getNome()%>', 
            '<%=produto.getDescricao()%>', '<%=produto.getMarca()%>', '<%=produto.getValorUnitario()%>', 
            '<%=produto.isStatus()%>')">Editar</button>
				<a href="ProdutoControl?action=delete&id=<%=produto.getId()%>">Excluir</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
