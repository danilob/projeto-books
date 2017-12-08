package br.com.flf.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** pay attention **/
public interface Logica {
	String executa(HttpServletRequest request, HttpServletResponse response) throws Exception;
}

