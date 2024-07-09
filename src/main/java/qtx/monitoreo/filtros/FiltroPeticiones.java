package qtx.monitoreo.filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FiltroPeticiones implements Filter {

    public FiltroPeticiones() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		System.out.println("*** FiltroPeticiones ANTES del Servlet: Pre-Procesamiento *****");
		HttpServletRequest peticion = (HttpServletRequest) request;
		System.out.println("Verbo Http:"+peticion.getMethod());
		System.out.println("url:"+peticion.getRequestURI());
		peticion.getHeader("Referer");
		String referer = peticion.getHeader("Referer");
		System.out.println("referer:"+referer);
		String recurso = peticion.getServletPath();
		System.out.println("recurso:"+recurso);
		chain.doFilter(request, response);
		
		System.out.println("*** FiltroPeticiones DESPUES del Servlet: Post-Procesamiento ***");
		HttpServletResponse respuesta = (HttpServletResponse) response;
		int statusHttp = respuesta.getStatus();
		
		System.out.println("StatusHttp de Respuesta:"+statusHttp);
		System.out.println("**********************************************************");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
