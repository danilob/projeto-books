<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmação da adição do livro</title>
</head>
<body>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="principal">
<c:import url="../../books/menu.jsp"/>
<div id="conteudo">
<div id="topico-central">
Livro "${novoLivro.titulo}" adicionado com sucesso!
</div>
<div id="info">
<a href="index.html" >Início</a> - <a href="adiciona-livro.jsp" >Adicionar novamente?</a>
</div>
</div>
<c:import url="../../books/rodape.html"/>
</div>

</body>
</html>