package mx.com.qtx.autenticacion;

public class Usuario {
	private String nombre;
	private String password;
	
	
	public Usuario(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", password=" + password + "]";
	}
	
	public boolean passwordCorrecto(String passwordRef){
		if (this.password.equals(passwordRef))
				return true;
		else
			return false;
	}
}
