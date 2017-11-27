    <%@page pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adiciona Livro</title>
</head>
<body>
<div id="principal">
<c:import url="menu.jsp"/>
<div id="conteudo">
	<div id="topico-central">
	<form action="/projeto-books/livros" method="GET">
	    <input type="hidden" name="logica" value="AdicionaLivroLogica" />
		<p>
		<label>Título:</label>
		<input type="text" name="titulo" />
		</p>
		
		<p>
		<label>Gênero:</label> 
		<input type="text" name="genero" />
		</p>
		
		<p>
		<label>Autores:</label> 
		<input type="text" name="autores" />
		</p>
		
		<p>
		<label>Editora:</label> 
		<input type="text" name="editora" />
		</p>
		
		<p>
		<label>Ano: </label> 
		<input type="text" name="ano" />
		</p>
		<input type="submit" value="Gravar" />
	</form>
	</div>
	
</div>
<c:import url="rodape.html"/>
</div>
</body>
</html>