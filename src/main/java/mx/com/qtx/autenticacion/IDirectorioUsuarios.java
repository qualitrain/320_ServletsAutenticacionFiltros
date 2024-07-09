package mx.com.qtx.autenticacion;

public interface IDirectorioUsuarios {
	public Usuario getUsuario(String nombre);
	public boolean usuarioValido(String nombre, String password);
}
