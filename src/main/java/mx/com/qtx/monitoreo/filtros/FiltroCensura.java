package mx.com.qtx.monitoreo.filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FiltroCensura implements Filter {

    public FiltroCensura() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest peticion = (HttpServletRequest) request;
		HttpServletResponse respuesta = (HttpServletResponse) response;
		String uri = peticion.getServletPath();
		String imagenCensurada = "/imagenes/gato.gif";
		String imagenReemplazo = "/imagenes/censura.jpg";
		
		System.out.println("\n\tFiltroCensura(PRE-PROCESAMIENTO)");
		if(uri.equals(imagenCensurada)){
			System.out.println("\t\tCambiando "+imagenCensurada
												+" por "+ imagenReemplazo);
			respuesta.sendRedirect(peticion.getServletContext().getContextPath()+imagenReemplazo);
		}
		else{
			chain.doFilter(request, response);
			System.out.println("\tFiltroCensura(POST-PROCESAMIENTO)\n");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
