package qtx.util.tablas;

import java.util.ArrayList;

public class Renglon {
	private ArrayList<Columna> columnas = new ArrayList<Columna>();
	public Renglon() {
		super();
	}
	void agregarColumnaDeTitulo(String valor, int ancho, int alto){
		Columna nuevaColumna = Columna.crearColumnaDeTitulo(ancho,alto, valor);
		this.columnas.add(nuevaColumna);
	}
	void agregarColumna(String valor, int ancho, int alto){
		Columna nuevaColumna = Columna.crearColumna(ancho,alto, valor);
		this.columnas.add(nuevaColumna);
	}
	@Override
	public String toString() {
		return "\nRenglon [columnas=" + columnas + 
				 "]";
	}
	public String toHtml(){
		String cadHtmlRenglon = "";
		cadHtmlRenglon+="<tr>\n";
		for(Columna col:this.columnas){
			cadHtmlRenglon+=col.toHtml();
		}
		cadHtmlRenglon+="</tr>\n";
		return cadHtmlRenglon;
	}
	
}
