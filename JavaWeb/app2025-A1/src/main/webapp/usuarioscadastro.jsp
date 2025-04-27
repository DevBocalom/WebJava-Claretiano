<%@ page import="java.util.List"%>
<%@ page import="dao.UsuarioDAO"%>
<%@ page import="model.Usuario"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<jsp:include page="/includes/header.jsp" />

<h2>Cadastro de Usuário</h2>
<form action="UsuarioControl" method="post" class="form-usuario">
	<input type="hidden" id="id" name="id">

	<div class="form-group">
		<label for="nome">Nome:</label> <input type="text" id="nome"
			name="nome" class="form-control" required>
	</div>

	<div class="form-group">
		<label for="email">Email:</label> <input type="email" id="email"
			name="email" class="form-control" required>
	</div>

	<div class="form-group">
		<label for="senha">Senha:</label> <input type="password" id="senha"
			name="senha" class="form-control" required>
	</div>

	<div class="form-group">
		<label for="telefone">Telefone:</label> <input type="text"
			id="telefone" name="telefone" class="form-control" required>
	</div>

	<div class="form-group checkbox-group">
		<label for="status">Status:</label> <input type="checkbox" id="status"
			name="status" class="form-checkbox">
	</div>

	<div class="form-group">
		<input type="submit" value="Salvar" class="btn-submit">
	</div>
</form>

<h2>Usuários Cadastrados</h2>

<table class="tabela-usuarios">
	<thead>
		<tr class="cabecalho">
			<th>ID</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>Status</th>
			<th>Ações</th>
		</tr>
	</thead>
	<tbody>
		<%
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDAO.selectAllUsuarios();
		for (Usuario usuario : usuarios) {
		%>
		<tr class="linha-usuario">
			<td class="celula-id"><%=usuario.getId()%></td>
			<td class="celula-nome"><%=usuario.getNome()%></td>
			<td class="celula-email"><%=usuario.getEmail()%></td>
			<td class="celula-telefone"><%=usuario.getTelefone()%></td>
			<td
				class="celula-status <%=usuario.isStatus() ? "ativo" : "inativo"%>">
				<%=usuario.isStatus() ? "Ativo" : "Inativo"%>
			</td>
			<td class="celula-acoes">
				<button class="botao-editar"
					onclick="editarUsuario('<%=usuario.getId()%>', '<%=usuario.getNome()%>', 
                        '<%=usuario.getEmail()%>', '<%=usuario.getSenha()%>', '<%=usuario.getTelefone()%>', 
                        '<%=usuario.isStatus()%>')">Editar</button>
				<a href="UsuarioControl?action=delete&id=<%=usuario.getId()%>"
				class="botao-excluir">Excluir</a>
			</td>
		</tr>
		<%
		}
		%>
	</tbody>
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