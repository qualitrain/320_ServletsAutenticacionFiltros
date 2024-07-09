package qtx.autenticacion.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import qtx.autenticacion.IGestorAutenticacion;

public class EscuchaCicloVidaContexto implements ServletContextListener {

    public EscuchaCicloVidaContexto() {
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println(" ***** contexto destruido *****");
    	ServletContext contextoServlet = arg0.getServletContext();
    	System.out.println("NombreContexto:"+contextoServlet.getServletContextName());
    	System.out.println("ServerInfo:"+contextoServlet.getServerInfo());
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println(" ***** contexto inicializado *****");
    	ServletContext contexto = arg0.getServletContext();
    	System.out.println("NombreContexto:"+contexto.getServletContextName());
    	System.out.println("ServerInfo:"+contexto.getServerInfo());
    	String nomGestorAutenticacion = contexto.getInitParameter("gestorAutenticacion");
    	try {
			Class<?> claseGestorAutenticacion = Class.forName(nomGestorAutenticacion);
			IGestorAutenticacion gestorAutenticacion = (IGestorAutenticacion) claseGestorAutenticacion.newInstance();
			contexto.setAttribute("gestorAutenticacion", gestorAutenticacion);
			System.out.println("Instanciación de IGestorAutenticacion exitosa");
		} 
    	catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println("Instanciación de IGestorAutenticacion fallida");
			System.out.println(e.getClass().getName() + ":" + e.getMessage());
			Throwable causa = e.getCause();
			if(causa != null) {
				System.out.println("Causada por " + ":" + causa.getClass().getName() + ":" + causa.getMessage());				
			}
		}
    	

    }
	
}
