<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterando livro de id:"${record.id}"</title>
</head>
<body>

<div id="principal">
<c:import url="../../books/menu.jsp"/>
<div id="conteudo">
	<div id="info">
	Alterar conteúdo do ID: "${record.id}"
	</div>
	<div id="topico-central">
	<form action="livros" method="GET">
	    <input type="hidden" name="logica" value="AlteraLivroLogica" />
	    <input type="hidden" name="id" value="${record.id}" />
	    <p>
		<label>Título: </label>
		<input type="text" name="titulo" value="${record.titulo}"/>
		</p>
		
		<p>
		<label> Gênero: </label>
		<input type="text" name="genero" value="${record.genero}"/>
		</p>
		
		<p>
		<label>
		Autores: </label>
		<input type="text" name="autores" value="${record.autores}"/>
		</p>
		
		<p>
		<label>
		Editora: </label>
		<input type="text" name="editora" value="${record.editora}"/>
		</p>
		
		<p>
		<label>
		Ano: </label>
		<input type="text" name="ano" value="${record.ano}"/>
		</p>
		
		<p>
		<label></label>
		<input type="submit" value="Alterar" />
		</p>
	</form>
	</div>
</div>
<c:import url="/books/rodape.html"/>
</div>
</body>
</html>