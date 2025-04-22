<%@ page import="java.util.List"%>
<%@ page import="dao.ProdutoDAO"%>
<%@ page import="model.Produto"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<jsp:include page="/includes/header.jsp" />
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
				<a href="ProdutoControl?action=delete&id=<%=produto.getId()%>"
				style="background-color:#007bff; color:white; border:none; padding:5px 10px; border-radius:5px; text-decoration:none; display:inline-block;">Excluir</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
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
</body>
</html>
