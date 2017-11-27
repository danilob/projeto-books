package br.com.flf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.flf.jdbc.Conexao;
import br.com.flf.models.Filme;
/* C�digo para cria��o do banco de dados Acervo:
 *  
	mysql -h localhost -u root -p
	
	create database Acervo
	
	use Acervo
	
	create table filme (
		id BIGINT NOT NULL AUTO_INCREMENT,
		titulo VARCHAR(400),
		genero VARCHAR(200),
		lancamento DATE,
		duracao integer,
		imdb real,
		primary key (id)
	);
	
	//postgres
	create table filme (
		id bigserial primary key,
		titulo VARCHAR(400),
		genero VARCHAR(200),
		lancamento DATE,
		duracao integer,
		imdb real
	);
 
 */



public class FilmeDao {
	
	public FilmeDao() {
		
	}
    // Conectar ao banco
    public void adiciona(Filme novo) throws Exception {
    	Conexao conx = new Conexao();
    	Connection conn = conx.abrir();
    	
    	
    	String sql = "insert into filme " +
    			"(titulo,genero,duracao,imdb,lancamento)" +
    			" values (?,?,?,?,?)";

    	try {
    		// prepared statement para inser��o
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		// seta os valores
    		stmt.setString(1,novo.getTitulo());
    		stmt.setString(2,novo.getGenero());
    		stmt.setInt(3,novo.getDuracao());
    		stmt.setFloat(4, novo.getImdb());
    		stmt.setDate(5, new java.sql.Date(novo.getLancamento().getTimeInMillis()));
    		// executa
    		stmt.execute();
    		stmt.close();
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
    	
    	conx.close(conn);
    	
    }
    
    public Filme getFilme(long id) throws Exception {

    	Filme record = new Filme();
    	try {
    		Conexao conx = new Conexao();
    		Connection conn = conx.abrir();
    		PreparedStatement stmt = conn.prepareStatement("select * from filme where id=?");
    		stmt.setLong(1,id);
    		ResultSet rs = stmt.executeQuery();

    		while (rs.next()) {
    			// criando o objeto Contato
    			record.setId(rs.getLong("id"));
    			record.setTitulo(rs.getString("titulo"));
                record.setDuracao(rs.getInt("duracao"));
                record.setGenero(rs.getString("genero"));
    			record.setImdb(rs.getFloat("imdb"));
    			// montando a data através do Calendar
    			Calendar data = Calendar.getInstance();
    			data.setTime(rs.getDate("lancamento"));
    			record.setLancamento(data);
                
    			// adicionando o objeto à lista
    			
    		}
    		rs.close();
    		stmt.close();
    		conx.close(conn);
    		return record;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}

    }
    
    public boolean deletaFilme(long id) throws Exception {

    	try {
    		Conexao conx = new Conexao();
    		Connection conn = conx.abrir();
    		PreparedStatement stmt = conn.prepareStatement("delete from filme where id=?");
    		stmt.setLong(1,id);
    		stmt.execute();
    		stmt.close();
    		conx.close(conn);
    		return true;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    		
    	}
    	

    }
    
    public void altera(Filme alter) throws Exception {
    	Conexao conx = new Conexao();
    	Connection conn = conx.abrir();
    	    	
    	String sql = "update filme set titulo=?, genero=?, duracao=?,imdb=?,lancamento=? where id=?";

    	try {
    		// prepared statement para inser��o
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		// seta os valores
    		stmt.setString(1,alter.getTitulo());
    		stmt.setString(2,alter.getGenero());
    		stmt.setInt(3,alter.getDuracao());
    		stmt.setFloat(4, alter.getImdb());
    		stmt.setDate(5, new java.sql.Date(alter.getLancamento().getTimeInMillis()));
    		stmt.setLong(6, alter.getId());
    		// executa
    		stmt.execute();
    		stmt.close();
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
    	
    	conx.close(conn);
    	
    }
    
    public List<Filme> getLista() throws Exception{
    	List<Filme> filmes = new ArrayList<Filme>();

    	try {
        	Conexao conx = new Conexao();
    		Connection conn = conx.abrir();
    		PreparedStatement stmt = conn.prepareStatement("select * from filme");
    		ResultSet rs = stmt.executeQuery();

    		while (rs.next()) {
    			// criando o objeto Contato
    			Filme record = new Filme();
    			record.setTitulo(rs.getString("titulo"));
                record.setDuracao(rs.getInt("duracao"));
    			//... inserir outros dados!!!

    			// montando a data através do Calendar
    			Calendar data = Calendar.getInstance();
    			data.setTime(rs.getDate("lancamento"));
    			record.setLancamento(data);

    			// adicionando o objeto à lista
    			filmes.add(record);
    		}
    		rs.close();
    		stmt.close();
    		conx.close(conn);
    		return filmes;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}

    }
    
    
    
    public List<Filme> getPesquisa(String key) throws Exception{
    	List<Filme> filmes = new ArrayList<Filme>();
    
    	try {
        	Conexao conx = new Conexao();
    		Connection conn = conx.abrir(); 
    		//Select * from filme where genero like 'Ação'
    		PreparedStatement stmt = conn.prepareStatement("select * from filme where genero like ?");
    		stmt.setString(1,key);
    		ResultSet rs = stmt.executeQuery();
        
    		while (rs.next()) {
    			
    			// criando o objeto Contato
    			Filme record = new Filme();
    			record.setTitulo(rs.getString("titulo"));
                record.setDuracao(rs.getInt("duracao"));
    			//... inserir outros dados!!!

    			// montando a data através do Calendar
    			Calendar data = Calendar.getInstance();
    			data.setTime(rs.getDate("lancamento"));
    			record.setLancamento(data);

    			// adicionando o objeto à lista
    			filmes.add(record);
    		}
    		rs.close();
    		stmt.close();
    		conx.close(conn);
    		return filmes;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}

    }
    
    public List<String> getListaGenero() throws Exception{
    	List<String> generos = new ArrayList<String>();

    	try {
        	Conexao conx = new Conexao();
    		Connection conn = conx.abrir();
    		PreparedStatement stmt = conn.prepareStatement("select genero from filme");
    		ResultSet rs = stmt.executeQuery();

    		while (rs.next()) {
    			// criando o objeto Contato
    			String s = new String();
    		
    			String record = rs.getString("genero");
    			System.out.println(record);
    			// adicionando o objeto à lista
    			generos.add(record);
    		}
    		rs.close();
    		stmt.close();
    		conx.close(conn);
    		return generos;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}

    }

}
