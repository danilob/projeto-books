<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style-livro.css" />" />
<title>Insert title here</title>
</head>
<body>
<%@page pageEncoding="UTF-8"%>
	<div id="header">
		<center>
			<img src="<c:url value="/imagens/books-varios.png"/>"
			height="140px"/>
		</center>
	</div>
	<div id="menu">
		<ul>
			<li><a href="<c:url value="/books/adiciona-livro.jsp" />">Adicionar</a></li>
			<li><a href="<c:url value="/books/pesquisa-livro.jsp" />">Pesquisar</a></li>
			<li><a href="/projeto-books/livros?logica=ListaLivroLogica">Listar</a></li>
		</ul>
	</div>
</body>
</html>