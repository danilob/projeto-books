package br.com.flf.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.flf.models.Filme;
import br.com.flf.models.Livro;

public class LivroDao {
	
	Connection theConnection;

	public LivroDao() {}
	
	public LivroDao(Connection connection) {
		theConnection = connection;
	}
	
	public void adiciona(Livro novo) throws Exception {
    	
    	
    	String sql = "insert into livro " +
    			"(titulo,genero,autores,editora,ano)" +
    			" values (?,?,?,?,?)";

    	try {
    		// prepared statement para inserção
    		PreparedStatement stmt = theConnection.prepareStatement(sql);
    		// seta os valores
    		stmt.setString(1,novo.getTitulo());
    		stmt.setString(2,novo.getGenero());
    		stmt.setString(3, novo.getAutores());
    		stmt.setString(4, novo.getEditora());
    		stmt.setInt(5,novo.getAno());
    		stmt.execute();
    		stmt.close();
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
    	
    	
    }
	
	public List<Livro> getLista() throws Exception{
    	List<Livro> livros = new ArrayList<Livro>();

    	try {
        	
    		PreparedStatement stmt = theConnection.prepareStatement("select * from livro order by id asc");
    		ResultSet rs = stmt.executeQuery();

    		while (rs.next()) {
    			// criando o objeto Contato
    			Livro record = new Livro();
    			record.setId(rs.getInt("id"));
    			record.setTitulo(rs.getString("titulo"));
    			record.setAutores(rs.getString("autores"));
    			record.setEditora(rs.getString("editora"));
    			record.setGenero(rs.getString("genero"));
    			record.setAno(rs.getInt("ano"));
    			
    			// adicionando o objeto à lista
    			livros.add(record);
    		}
    		rs.close();
    		stmt.close();
    		return livros;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}

    }
	
	public Livro getLivro(long id) throws Exception {

    	Livro record = new Livro();
    	try {
    		PreparedStatement stmt = theConnection.prepareStatement("select * from livro where id=?");
    		stmt.setLong(1,id);
    		ResultSet rs = stmt.executeQuery();

    		while (rs.next()) {
    			// criando o objeto Contato
    			record.setId(rs.getLong("id"));
    			record.setTitulo(rs.getString("titulo"));
                record.setAno(rs.getInt("ano"));
                record.setGenero(rs.getString("genero"));
    			record.setAutores(rs.getString("autores"));
    			record.setEditora(rs.getString("editora"));
    			
    		}
    		rs.close();
    		stmt.close();
    		return record;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}

    }
	
	public Livro getLivros(long id) throws Exception {

    	Livro record = new Livro();
    	try {
    		PreparedStatement stmt = theConnection.prepareStatement("select * from livros where id=?");
    		stmt.setLong(1,id);
    		ResultSet rs = stmt.executeQuery();

    		while (rs.next()) {
    			// criando o objeto Contato
    			record.setId(rs.getLong("id"));
    			record.setTitulo(rs.getString("titulo"));
                record.setAno(rs.getInt("ano"));
                record.setGenero(rs.getString("genero"));
    			record.setAutores(rs.getString("autores"));
    			record.setEditora(rs.getString("editora"));
    			
    		}
    		rs.close();
    		stmt.close();
    		return record;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}

    }
	
	public void altera(Livro alter) throws Exception {
    	
    	    	
    	String sql = "update livro set titulo=?, genero=?, autores=?, editora=?,ano=? where id=?";

    	try {
    		// prepared statement para inser��o
    		PreparedStatement stmt = theConnection.prepareStatement(sql);
    		// seta os valores
    		stmt.setString(1,alter.getTitulo());
    		stmt.setString(2,alter.getGenero());
    		stmt.setString(3,alter.getAutores());
    		stmt.setString(4, alter.getEditora());
    		stmt.setInt(5, alter.getAno());
    		stmt.setLong(6, alter.getId());
    		// executa
    		stmt.execute();
    		stmt.close();
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
    	

    	
    }
	
	public boolean exclui(long id) throws Exception {

    	try {
    		PreparedStatement stmt = theConnection.prepareStatement("delete from livro where id=?");
    		stmt.setLong(1,id);
    		stmt.execute();
    		stmt.close();
    		return true;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    		
    	}
    	

    }
	
	public List<Livro> getPesquisa(String key) throws Exception{
    	List<Livro> livros = new ArrayList<Livro>();
    
    	try {
    		PreparedStatement stmt = theConnection.prepareStatement("select * from livro where titulo like ?");
    		stmt.setString(1,'%'+key+'%');
    		ResultSet rs = stmt.executeQuery();
        
    		while (rs.next()) {
    			System.out.println("Aqui");
    			// criando o objeto Contato
    			Livro record = new Livro();
    			record.setId(rs.getInt("id"));
    			record.setTitulo(rs.getString("titulo"));
    			record.setAutores(rs.getString("autores"));
    			record.setEditora(rs.getString("editora"));
    			record.setGenero(rs.getString("genero"));
    			record.setAno(rs.getInt("ano"));
    			
    			// adicionando o objeto à lista
    			livros.add(record);
    		}
    		rs.close();
    		stmt.close();
    		return livros;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}

    }
}
