<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de Livros</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="principal">
<c:import url="/books/menu.jsp"/>
<div id="conteudo">
<div id="topico-central">
<table>
	<tr>
	   <th>Título</th>
	   <th>Autores</th>
	   <th>Genero</th>
	   <th>Editora</th>
	   <th>Ano</th>
	   <th>Ações</th>
	</tr>
	<c:forEach var="livro" items="${livros}">
	<tr>
		<td>${livro.getTitulo()}</td>
		<td>${livro.getNameAutores()}</td>
		<td>${livro.genero.descricao}</td>
		<td>${livro.editora.nome}</td>
		<td>${livro.ano}</td>
		<td>
		<center>
		<a href="livros?logica=PreAlteraLivroLogica&id=${livro.id}">Alterar</a> - 
		<a href="livros?logica=ExcluiLivroLogica&id=${livro.id}">Excluir</a>
		</center>
		</td>
	</tr>
	</c:forEach>
</table>
</div>
</div>
<c:import url="/books/rodape.html"/>
</div>
</body>
</html>