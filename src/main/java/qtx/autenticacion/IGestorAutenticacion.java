package qtx.autenticacion;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IGestorAutenticacion {
	
	public IDirectorioUsuarios getDirUsuarios();
	public void setDirUsuarios(IDirectorioUsuarios dirUsuarios);
	
	public IGestorAccesosAutorizados getGestorAccesos();
	public void setGestorAccesos(IGestorAccesosAutorizados gestorAccesos);	
	
	//¿Convendría que fuera privado y dejarlo fuera de esta interfaz ?
	public String getTicketAccesoDeCookie(HttpServletRequest request);
	public boolean usuarioYaAutenticado(HttpServletRequest request);
	
	//¿Realemente necesita el request?
	public void setTicketAccesoEnCookie(Usuario usuarioAutenticado, HttpServletRequest request,
			HttpServletResponse response);
	public Usuario getUsuarioAutenticado(String nombreUsuario, String password);
	public void cancelarTicketAcceso(HttpServletRequest request, 
			HttpServletResponse response);

}
