
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="info">
<c:if test="${livros.size()>0}">
<c:choose>
<c:when test="${livros.size()==1}">
<br>
Encontrada ${livros.size()} ocorrência! <br><br>

</c:when>
<c:otherwise>
<br>
Encontradas ${livros.size()} ocorrências! <br><br>

</c:otherwise>

</c:choose>
</div>
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
		<td>${livro.titulo}</td>
		<td>${livro.getNameAutores()}</td>
		<td>${livro.genero.descricao}</td>
		<td>${livro.editora.nome}</td>
		<td>${livro.ano}</td>
		<td><center>
		<a href="livros?logica=PreAlteraLivroLogica&id=${livro.id}">Alterar</a> - 
		<a href="livros?logica=ExcluiLivroLogica&id=${livro.id}">Excluir</a>
		</center>
		</td>
	</tr>
	</c:forEach>
</table>

</c:if>
</div>