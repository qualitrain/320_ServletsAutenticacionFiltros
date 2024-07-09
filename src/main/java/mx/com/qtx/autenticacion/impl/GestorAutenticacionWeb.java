package mx.com.qtx.autenticacion.impl;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.qtx.autenticacion.IDirectorioUsuarios;
import mx.com.qtx.autenticacion.IGestorAccesosAutorizados;
import mx.com.qtx.autenticacion.IGestorAutenticacion;
import mx.com.qtx.autenticacion.Usuario;


public class GestorAutenticacionWeb implements IGestorAutenticacion{
	private IDirectorioUsuarios dirUsuarios;
	private IGestorAccesosAutorizados gestorAccesos;

	public GestorAutenticacionWeb() {
		this.dirUsuarios = new DirectorioUsuarios_Map();
		this.gestorAccesos = new GestorAccesosAutorizados_Map();
		System.out.println("*** GestorAutenticacionWeb() ***");
	}
	

	public IDirectorioUsuarios getDirUsuarios() {
		return dirUsuarios;
	}

	public void setDirUsuarios(IDirectorioUsuarios dirUsuarios) {
		this.dirUsuarios = dirUsuarios;
	}

	public IGestorAccesosAutorizados getGestorAccesos() {
		return gestorAccesos;
	}

	public void setGestorAccesos(IGestorAccesosAutorizados gestorAccesos) {
		this.gestorAccesos = gestorAccesos;
	}

	private Map<String,String> getMapaGalletas(HttpServletRequest request){
		Map<String,String> mapaGalletas = new HashMap<String,String>();
		Cookie[] galletas = request.getCookies();
		if (galletas == null)
			return null;
		for(Cookie cookieI:galletas){
			mapaGalletas.put(cookieI.getName(), cookieI.getValue());
		}
		return mapaGalletas;
	}
	//¿Debería ser privado?
	public String getTicketAccesoDeCookie(HttpServletRequest request){
		Map<String,String> mapaGalletas = this.getMapaGalletas(request);
		if(mapaGalletas == null)
			return null;
		else
			return mapaGalletas.get("ticketAcceso");
	}

	public boolean usuarioYaAutenticado(HttpServletRequest request) {
	
		String ticketAcceso = this.getTicketAccesoDeCookie(request);
		if(ticketAcceso == null)
			return false;
		return this.gestorAccesos.accesoEstaActivo(ticketAcceso);
	}
	// Sobra el parámetro request. Eliminar en sig versión
	public void setTicketAccesoEnCookie(Usuario usuarioAutenticado, HttpServletRequest request,
			HttpServletResponse response) {

		String ticketAcceso = this.gestorAccesos.agregarAcceso(usuarioAutenticado);
		Cookie galleta = new Cookie("ticketAcceso",ticketAcceso);
		response.addCookie(galleta);		
	}
	public Usuario getUsuarioAutenticado(String nombreUsuario, String password) {
		Usuario usuario = this.dirUsuarios.getUsuario(nombreUsuario);
		if(usuario == null)
			return null;
		if(usuario.passwordCorrecto(password))
			return usuario;
		else
			return null;
	}
	public void cancelarTicketAcceso(HttpServletRequest request, HttpServletResponse response) {
		String ticketAcceso = this.getTicketAccesoDeCookie(request);
		this.gestorAccesos.cancelarAcceso(ticketAcceso);
		
		Cookie galleta = new Cookie("ticketAcceso","");
		galleta.setMaxAge(0);
		galleta.setPath("/");
		response.addCookie(galleta);		

	}
	
}
