<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Home</title>
</head>
<body>
	<div id="container">
		<h2>Bem-vindo ao Sistema!</h2>
		<h2>Página Home</h2>
		<br />
		<h4>Login realizado com sucesso!</h4>
		<br /> <a href="HomeController?action=usuarioscadastro">Ir para
			Cadastro de Usuários</a> <br /> <br />
		<!-- Botão de Logout -->
		
		<form action="LoginServlet" method="POST">
			<input type="hidden" name="action" value="logout">
			<button type="submit">Logout</button>
		</form>
	</div>
</body>
</html>