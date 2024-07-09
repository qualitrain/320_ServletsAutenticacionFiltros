package mx.com.qtx.autenticacion.impl;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import mx.com.qtx.autenticacion.IGestorAccesosAutorizados;
import mx.com.qtx.autenticacion.Usuario;

public class GestorAccesosAutorizados_Map implements IGestorAccesosAutorizados{
	private Map<String,Acceso> accesosVigentes;

	public GestorAccesosAutorizados_Map() {
		this.accesosVigentes = new Hashtable<String, Acceso>();
	}
	
	public String agregarAcceso(Usuario usuario){
		long numTicket =(long) Math.random() * 1000000L;
		Acceso nuevoAcceso = new Acceso(numTicket,usuario, new Date(), true);
		String ticket = Long.toString(numTicket);
		this.accesosVigentes.put(ticket, nuevoAcceso);
		return ticket;
	}
	public boolean accesoEstaActivo(String ticket){
		Acceso acceso = this.accesosVigentes.get(ticket);
		if (acceso == null)
			return false;
		else
			return acceso.estaActivo();
	}

	public void cancelarAcceso(String ticketAcceso) {
		Acceso acceso = this.accesosVigentes.get(ticketAcceso);
		if (acceso == null)
			return;
		else
			acceso.setEstaActivo(false);		
	}
	

}
