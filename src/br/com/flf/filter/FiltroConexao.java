package br.com.flf.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.postgresql.core.ConnectionFactory;

import br.com.flf.jdbc.*;
/**
 * Servlet Filter implementation class FiltroConexao
 */
@WebFilter("/*")
public class FiltroConexao implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroConexao() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// abre uma conexão
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Acervo");
		EntityManager manager = factory.createEntityManager();
		// indica que o processamento do request deve prosseguir
		
		// "pendura um objeto no Request"
		request.setAttribute("manager", manager);
		
		chain.doFilter(request, response);
		manager.close();
		// fecha conexão
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
