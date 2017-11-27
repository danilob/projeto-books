<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/style-livro.css"/>" />
<title>Página Inicial - Livro</title>
</head>
<body>
    <div id="header"> 
        <c:import url="cabecalho.html" charEncoding="UTF-8"/>
    </div>
    <div id="conteudo">
    	<div id="menu">
    	<ul>
    	<li><a href="adiciona-livro.jsp">Adicionar</a></li>
    	<li><a href="/projeto-books/livros?logica=ListaLivroLogica">Listar</a></li>
    	<li><a href="pesquisa-livro.jsp">Pesquisar</a></li>
    	</ul>
    	
    	</div>
    	<div id="principal"></div>
    </div>
    <div id="rodape">
        <c:import url="rodape.html" charEncoding="UTF-8"/>
    </div>

</body>
</html>