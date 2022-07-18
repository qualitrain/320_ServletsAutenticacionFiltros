package qtx.autenticacion.web;

import java.util.Date;

import qtx.autenticacion.Usuario;

public class Acceso {
	private long numTicket;
	private Usuario usuario;
	private Date fechaAcceso;
	private boolean estaActivo;	
	
	public Acceso(long numTicket, Usuario usuario, Date date,
			boolean estaActivo) {
		super();
		this.numTicket = numTicket;
		this.usuario = usuario;
		this.fechaAcceso = date;
		this.estaActivo = estaActivo;
	}

	public long getNumTicket() {
		return numTicket;
	}

	public void setNumTicket(long numTicket) {
		this.numTicket = numTicket;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaAcceso() {
		return fechaAcceso;
	}

	public void setFechaAcceso(Date fechaAcceso) {
		this.fechaAcceso = fechaAcceso;
	}

	public boolean estaActivo() {
		return estaActivo;
	}

	public void setEstaActivo(boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	@Override
	public String toString() {
		return "Acceso [numTicket=" + numTicket + ", usuario=" + usuario
				+ ", fechaAcceso=" + fechaAcceso + ", estaActivo=" + estaActivo
				+ "]";
	}

}
