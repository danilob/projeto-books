
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${livros.size()>0}">
<c:choose>
<c:when test="${livros.size()==1}">
<br>
Encontrada ${livros.size()} ocorr�ncia! <br><br>

</c:when>
<c:otherwise>
<br>
Encontradas ${livros.size()} ocorr�ncias! <br><br>

</c:otherwise>

</c:choose>

<table>
	<tr>
	   <th>T�tulo</th>
	   <th>Autores</th>
	   <th>Genero</th>
	   <th>Editora</th>
	   <th>Ano</th>
	   <th>A��es</th>
	</tr>
	<c:forEach var="livro" items="${livros}">
	<tr>
		<td>${livro.titulo}</td>
		<td>${livro.autores}</td>
		<td>${livro.genero}</td>
		<td>${livro.editora}</td>
		<td>${livro.ano}</td>
		<td>
		<a href="livros?logica=PreAlteraLivroLogica&id=${livro.id}">Alterar</a> - 
		<a href="livros?logica=ExcluiLivroLogica&id=${livro.id}">Excluir</a>
		</td>
	</tr>
	</c:forEach>
</table>

</c:if>
