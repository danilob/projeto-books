<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmação de alteração</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="principal">
<c:import url="../../books/menu.jsp"/>
<div id="conteudo">
<div id="topico-central">
Livro "${alterado.titulo}" alterado com sucesso!<br>
</div>
<div id="info">
<a href="index.html" >Início</a> - <a href="livros?logica=PreAlteraLivroLogica&id=${alterado.id}" >Alterar Novamente?</a>
</div>
</div>
<c:import url="../../books/rodape.html"/>
</div>
</body>
</html>