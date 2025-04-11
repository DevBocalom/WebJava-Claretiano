<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<!-- Formulário com a ação para o servlet LoginServlet -->
	<form action="LoginServlet" method="POST">
		<label for="email">Email:</label> <input type="email" id="email"
			name="email" required><br> <br> <label for="senha">Senha:</label>
		<input type="password" id="senha" name="senha" required><br>
		<br>
		<button type="submit" name="entrar">Entrar</button>
	</form>
	<%
	String erro = request.getParameter("erro");
	if (erro != null) {
	%>
	<p style="color: red;">Email ou senha inválidos.</p>
	<%
	}
	%>
</body>
</html>
