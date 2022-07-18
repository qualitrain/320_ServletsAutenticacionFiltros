package qtx.autenticacion;

public interface IGestorAccesosAutorizados {
	public String agregarAcceso(Usuario usuario);
	public boolean accesoEstaActivo(String ticketAcceso);
	public void cancelarAcceso(String ticketAcceso);
}
