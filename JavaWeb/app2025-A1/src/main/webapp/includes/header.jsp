<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Minha Aplicação</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
<div class="navbar">
    <div class="nav-left">
        <a href="HomeController?action=home">Home</a>
		<a href="HomeController?action=usuarioscadastro">Cadastro de Usuários</a> 
		<a href="HomeController?action=produtoscadastro">Cadastro de Produtos</a>
    </div>
    <div class="nav-right">
        <a href="${pageContext.request.contextPath}/LoginServlet?action=logout">Sair</a>
    </div>
</div>
