<%@ page import="java.util.List"%>
<%@ page import="dao.UsuarioDAO"%>
<%@ page import="model.Usuario"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<jsp:include page="/includes/header.jsp" />
	<h2>Cadastro de Usuário</h2>
	<form action="UsuarioControl" method="post">
		<input type="hidden" id="id" name="id"> <label>Nome:</label> <input
			type="text" id="nome" name="nome" required><br> <label>Email:</label>
		<input type="email" id="email" name="email" required><br>
		<label>Senha:</label> <input type="password" id="senha" name="senha"
			required><br> <label>Telefone:</label> <input
			type="text" id="telefone" name="telefone" required><br>
		<label>Status:</label> <input type="checkbox" id="status"
			name="status"><br> <input type="submit" value="Salvar">
	</form>
	<br />
	<h2>Usuários Cadastrados</h2>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>Status</th>
			<th>Ações</th>
		</tr>

		<%
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDAO.selectAllUsuarios();
		for (Usuario usuario : usuarios) {
		%>
		<tr>
			<td><%=usuario.getId()%></td>
			<td><%=usuario.getNome()%></td>
			<td><%=usuario.getEmail()%></td>
			<td><%=usuario.getTelefone()%></td>
			<td><%=usuario.isStatus() ? "Ativo" : "Inativo"%></td>
			<td>
				<button
					onclick="editarUsuario('<%=usuario.getId()%>', '<%=usuario.getNome()%>', 
            '<%=usuario.getEmail()%>', '<%=usuario.getSenha()%>', '<%=usuario.getTelefone()%>', 
            '<%=usuario.isStatus()%>')">Editar</button>
				<a href="UsuarioControl?action=delete&id=<%=usuario.getId()%>">Excluir</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<script>
		function editarUsuario(id, nome, email, senha, telefone, status) {
			document.getElementById("id").value = id;
			document.getElementById("nome").value = nome;
			document.getElementById("email").value = email;
			document.getElementById("senha").value = senha;
			document.getElementById("telefone").value = telefone;
			document.getElementById("status").checked = status === "true";
		}
	</script>
</body>
</html>
