<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style-livro.css" />
<title>Pesquisa Livro</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="principal">
<c:import url="/books/menu.jsp"/>
<div id="conteudo">
<div id="topico-central">
<form action="/projeto-books/livros">
    <input type="hidden" name="logica" value="PesquisaLivroLogica" />
    Chave de pesquisa: <input type="text" name="key" />
   <button type="submit" value="Submit">Search</button> 
</form>
</div>

<c:catch var="exception">

<c:import url='${resultado}' charEncoding="UTF-8"/>

</c:catch>




</div>
<c:import url="/books/rodape.html"/>
</div>

</body>
</html>