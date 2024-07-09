package mx.com.qtx.autenticacion.impl;

import java.util.Hashtable;
import java.util.Map;

import mx.com.qtx.autenticacion.IDirectorioUsuarios;
import mx.com.qtx.autenticacion.Usuario;

public class DirectorioUsuarios_Map implements IDirectorioUsuarios{
	Map<String, Usuario> usuarios;

	public DirectorioUsuarios_Map() {
		this.usuarios = new Hashtable<String, Usuario>();
		this.cargaUsuarios();
		
	}
	
	private void cargaUsuarios(){
		this.usuarios.put("carlos", new Usuario("carlos", "c4r105"));
		this.usuarios.put("ramiro", new Usuario("ramiro", "3lp3rr0tr15te"));
		this.usuarios.put("lupita", new Usuario("lupita", "l480a10c4"));
		this.usuarios.put("olga", new Usuario("olga", "5n0op1ch4r113"));
	}
	
	public Usuario getUsuario(String nombre){
		return this.usuarios.get(nombre);
	}
	public boolean usuarioValido(String nombre, String password){
		Usuario usuario = this.getUsuario(nombre);
		if(usuario.passwordCorrecto(password))
			return true;
		else
			return false;
	}
	

}
