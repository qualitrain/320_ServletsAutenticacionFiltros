package qtx.autenticacion;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltroAutenticacion
 */
public class FiltroAutenticacion implements Filter {
	private Map<String,String> paginasProtegidas;
	private IGestorAutenticacion gestorAutenticacion;
	
    public FiltroAutenticacion() {
		this.paginasProtegidas = new Hashtable<String,String>();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
							throws IOException, ServletException {
		System.out.println("\t\tFiltroAutenticacion ANTES del Servlet: Pre-Procesamiento");

		HttpServletRequest peticion = (HttpServletRequest) request;
		HttpServletResponse respuesta = (HttpServletResponse) response;
		ServletContext contexto = peticion.getServletContext();
		String raiz = contexto.getContextPath();

		String recursoSolicitado = peticion.getServletPath();
		if(this.esRecursoProtegido(recursoSolicitado)){
			if(this.gestorAutenticacion.usuarioYaAutenticado(peticion)==false){
				respuesta.sendRedirect(raiz);
				return;
			}
		}
		chain.doFilter(request, response);
	}

	private boolean esRecursoProtegido(String recursoSolicitado) {
		if(this.paginasProtegidas.get(recursoSolicitado)==null) 
			return false;
		else
			return true;
					
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		//Cargar páginas restringidas desde la configuración
		Enumeration<String> parametrosFiltro = fConfig.getInitParameterNames();
		while(parametrosFiltro.hasMoreElements()){
			String parametroI = parametrosFiltro.nextElement();
			this.paginasProtegidas.put(fConfig.getInitParameter(parametroI), parametroI);
		}
		//establecer el gestor de Autenticación del filtro, desde el contexto de la app
		this.gestorAutenticacion = (IGestorAutenticacion) 
				fConfig.getServletContext()
				       .getAttribute("gestorAutenticacion");
		
	}

}
