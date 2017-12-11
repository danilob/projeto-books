    
<!DOCTYPE html>

        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
<script>
$(document).ready(function(){ 
	$.ajax({  
	     data: "",  
	     dataType: 'json',  
	     url: '/projeto-books/ListaGenero',  
	     type: 'POST',  
	     success: function(data){  
	          var corpo = '<option>Selecione o Genero</option>';  
	          for (var i = 0, length = data.length; i < length; i++) {  
	                     var genero = data[i]; 
	                     if(genero.id == ${record.genero.id}){
	                    	 corpo += "<option value="+genero.id+" selected>"+genero.nome+"</option>";                                                        
	                     }else{
	                    	 corpo += "<option value="+genero.id+">"+genero.nome+"</option>";	 
	                     }
	                                                                             
	       } 
	       $('#generoSelect').html(corpo).show(); 
	     },  
	     error: function() {  
	       alert("Ocorreu um erro na requisição ajax");  
	     }  
	   }); 
	
	$.ajax({  
	     data: "",  
	     dataType: 'json',  
	     url: '/projeto-books/ListaEditora',  
	     type: 'POST',  
	     success: function(data){  
	          var corpo = '<option>Selecione a Editora</option>';  
	          for (var i = 0, length = data.length; i < length; i++) {  
	                     var editora = data[i]; 
	                     if(editora.id == ${record.editora.id}){
	                    	 corpo += "<option value="+editora.id+" selected>"+editora.nome+"</option>";
	                     }else{
	                    	 corpo += "<option value="+editora.id+">"+editora.nome+"</option>"; 
	                     }
	                     
	                     
	                                                        
	       } 
	       $('#editoraSelect').html(corpo).show(); 
	     },  
	     error: function() {  
	       alert("Ocorreu um erro na requisição ajax");  
	     }  
	   });
	
	$.ajax({  
	     data: "",  
	     dataType: 'json',  
	     url: '/projeto-books/ListaAutor?book='+${record.id},  
	     type: 'POST',  
	     success: function(data){  
	          var corpo = "";  
	          for (var i = 0, length = data.length; i < length; i++) {  
	                 var autor = data[i]; 
	                 if(autor.sel){
	                	 corpo += "<option value="+autor.id+" selected>"+autor.nome+"</option>";
	                 }else{
	                	 corpo += "<option value="+autor.id+">"+autor.nome+"</option>";
	                 }
	                 
	                     
	                                                        
	       } 
	       $('#autorSelect').html(corpo).show(); 
	     },  
	     error: function() {  
	       alert("Ocorreu um erro na requisição ajax");  
	     }  
	   });
	
	
});

function AddAutor(){
	   if ($("#autorNew").val()=="") return;
	   $.ajax({
		   url: "/projeto-books/autores?logica=AdicionaAutorLogica&nome=" + $("#autorNew").val(),
		   type: "get", //send it through get method
		   
		    //url: "/projeto-books/autores?logica=AdicionaAutorLogica&nome=" + $("#autorNew").val(),
		    //$.get("/projeto-books/autor", { logica: AdicionaAutorLogica , nome: $("#autorNew").val() } );
		    success: function(response) {
		        alert("Autor: "+$("#autorNew").val()+", adicionado com sucesso!");
		        $("#autorNew").val("");
		        $.ajax({  
				     data: "",  
				     dataType: 'json',  
				     url: '/projeto-books/ListaAutor',  
				     type: 'POST',  
				     success: function(data){  
				          var corpo = "";  
				          for (var i = 0, length = data.length; i < length; i++) {  
				                     var autor = data[i]; 
				                     corpo += "<option value="+autor.id+">"+autor.nome+"</option>";
				                                                        
				       } 
				       $('#autorSelect').html(corpo).show(); 
				       
				     },  
				     error: function() {  
				       alert("Ocorreu um erro na requisição ajax");  
				     }  
				   });
		    },
		    error: function(xhr) {
		        alert("Algo errado");
		    }
		});
	   
	   
	   
}
function AddGenero(){
	   if ($("#generoaNew").val()=="") return;
	   $.ajax({
		   url: "/projeto-books/genero?logica=AdicionaGeneroLogica&nome=" + $("#generoNew").val(),
		   type: "post", //send it through get method
		   
		    //url: "/projeto-books/autores?logica=AdicionaAutorLogica&nome=" + $("#autorNew").val(),
		    //$.get("/projeto-books/autor", { logica: AdicionaAutorLogica , nome: $("#autorNew").val() } );
		    success: function(response) {
		        alert("Genero: "+$("#generoNew").val()+", adicionado com sucesso!");
		        $("#generoNew").val("");
		        $.ajax({  
				     data: "",  
				     dataType: 'json',  
				     url: '/projeto-books/ListaGenero',  
				     type: 'POST',  
				     success: function(data){  
				    	 var corpo = '<option>Selecione a Editora</option>';  
				          for (var i = 0, length = data.length; i < length; i++) {  
				                     var genero = data[i]; 
				                     
				                     corpo += "<option value="+genero.id+">"+genero.nome+"</option>";
				                                                        
				       } 
				       $('#generoSelect').html(corpo).show(); 
				     },  
				     error: function() {  
				       alert("Ocorreu um erro na requisição ajax");  
				     }  
				   });
		    },
		    error: function(xhr) {
		        alert("Algo errado");
		    }
		});
	   
	   
	   
}
function AddEditora(){
	   if ($("#editoraNew").val()=="") return;
	   $.ajax({
		   url: "/projeto-books/editora?logica=AdicionaEditoraLogica&nome=" + $("#editoraNew").val(),
		   type: "get", //send it through get method
		   
		    //url: "/projeto-books/autores?logica=AdicionaAutorLogica&nome=" + $("#autorNew").val(),
		    //$.get("/projeto-books/autor", { logica: AdicionaAutorLogica , nome: $("#autorNew").val() } );
		    success: function(response) {
		        alert("Editora: "+$("#editoraNew").val()+", adicionado com sucesso!");
		        $("#editoraNew").val("");
		        $.ajax({  
				     data: "",  
				     dataType: 'json',  
				     url: '/projeto-books/ListaEditora',  
				     type: 'POST',  
				     success: function(data){  
				    	 var corpo = '<option>Selecione a Editora</option>';  
				          for (var i = 0, length = data.length; i < length; i++) {  
				                     var editora = data[i]; 
				                     corpo += "<option value="+editora.id+">"+editora.nome+"</option>";
				                                                        
				       } 
				       $('#editoraSelect').html(corpo).show(); 
				     },  
				     error: function() {  
				       alert("Ocorreu um erro na requisição ajax");  
				     }  
				   });
		    },
		    error: function(xhr) {
		        alert("Algo errado");
		    }
		});
	   
	   
	   
}
</script>
<title>Adiciona Livro</title>
</head>
<body>
<%@page pageEncoding="UTF-8"%>
<div id="principal">
<c:import url="/books/menu.jsp"/>
<div id="conteudo">
	<div id="topico-central">
	<form action="<c:url value="/livros"/>" method="POST">
		<input type="hidden" name="id" value="${record.id}" />
	    <input type="hidden" name="logica" value="AlteraLivroLogica" />
		<p>
		<label>Título:</label>
		<input type="text" name="titulo" value="${record.titulo}"/>
		</p>
		
		<p>
		<label>Gênero:</label> 
		<select id="generoSelect" name="genero">
  			<option>Selecione o Genero</option>
		</select>
		
		</p>
		
		<p>
		<label>Autores:</label> 
		<select id="autorSelect" name="autores" multiple>
 		</select>
		</p>
		
		<p>
		<label>Editora:</label> 
		<select id="editoraSelect" name="editora">
  			<option>Selecione a Editora</option>
		</select>
		</p>
		
		<p>
		
		<label>Ano: </label> 
		<input type="text" name="ano" value="${record.ano}"/>
		</p>
		<input type="submit" value="Gravar" />
	</form>
		</div>
		
		<center>
		<h4>Para adicionar novos campos adicione abaixo:</h4>
	<p><label>Autor:</label> <input type="text" id="autorNew" /><button onclick="AddAutor();">Add</button></p>
	<p><label>Editora:</label> <input type="text" id="editoraNew" /><button onclick="AddEditora();">Add</button></p>
	<p><label>Gênero:</label> <input type="text" id="generoNew" /><button onclick="AddGenero();">Add</button></p>
</center>
	
</div>
<c:import url="/books/rodape.html"/>
</div>
</body>
</html>