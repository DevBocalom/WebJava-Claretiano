<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilo.css">
<style>
.login-container {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	background-color: #f4f4f4;
}

.login-box {
	background-color: #fff;
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0 0 12px rgba(0, 0, 0, 0.15);
	width: 100%;
	max-width: 400px;
}

.login-box h2 {
	margin-bottom: 20px;
	text-align: center;
	color: #333;
}

.form-group {
	margin-bottom: 15px;
}

.form-group label {
	display: block;
	margin-bottom: 6px;
	color: #555;
}

.form-group input {
	width: 94%;
	padding: 10px;
	border-radius: 6px;
	border: 1px solid #ccc;
}

.btn-login {
	width: 45%;
	background-color: #007bff;
	color: white;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 16px;
	cursor: pointer;
}

.btn-login:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="login-container">
		<div class="login-box">
			<h2>Login</h2>
			<form action="${pageContext.request.contextPath}/LoginServlet"
				method="get">
				<div class="form-group">
					<label for="email">E-mail</label> <input type="text" id="email"
						name="email" required />
				</div>
				<div class="form-group">
					<label for="senha">Senha</label> <input type="password" id="senha"
						name="senha" required />
				</div>
				<input type="hidden" name="action" value="login">
				<div style="display: flex; gap: 10px;">
					<button type="submit" class="btn-login" style="flex: 1;">Entrar</button>
					<a
						href="${pageContext.request.contextPath}/LoginServlet?action=usuarioscadastro"
						class="btn-login" style="flex: 1; text-align: center; text-decoration: none; line-height: 38px;">Cadastrar</a>
				</div>

			</form>
		</div>
	</div>
</body>
</html>
