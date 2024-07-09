package mx.com.qtx.autenticacion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGestorAutenticacion gestorAutenticacion;
       
    public LoginServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	this.gestorAutenticacion = (IGestorAutenticacion) 
    			this.getServletContext().getAttribute("gestorAutenticacion");
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
		String raiz = this.getServletContext().getContextPath();

		String accion = request.getParameter("accion");
		if(accion==null ){
			response.sendRedirect(raiz);
			return;			
		}
		if(accion.equals("salir")==false){
			response.sendRedirect(raiz);
			return;						
		}
		if (this.gestorAutenticacion.usuarioYaAutenticado(request)==false){
			response.sendRedirect(raiz);
			return;									
		}
		this.gestorAutenticacion.cancelarTicketAcceso(request, response);
		response.sendRedirect(raiz+"/paginasHtml/SalirApp.html");
		return;
		
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String raiz = this.getServletContext().getContextPath();
		if (this.gestorAutenticacion.usuarioYaAutenticado(request)){
			response.sendRedirect(raiz+"/paginasHtml/paginasProtegidas.html");
			return;
		}

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		if(usuario.isEmpty() || password.isEmpty()){
			response.sendRedirect(raiz);
			return;
		}
		
		Usuario usuarioAutenticado = 
				this.gestorAutenticacion.getUsuarioAutenticado(usuario,password);
		if(usuarioAutenticado==null){
			response.sendRedirect(raiz+"/paginasHtml/Error.html");
			return;			
		}
		this.gestorAutenticacion.setTicketAccesoEnCookie(usuarioAutenticado,
																request, response);
		response.sendRedirect(raiz+"/paginasHtml/paginasProtegidas.html");
		return;
		
		
	}
	

}
