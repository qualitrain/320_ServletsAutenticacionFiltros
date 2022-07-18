package qtx.util.tablas;

import java.util.ArrayList;

public class Tabla {
	private String titulo;
	private int borde;
	private int anchoEnPixeles;
	ArrayList<Renglon> listaRenglones = new ArrayList<Renglon>();
	
	
	public Tabla(String titulo, int borde, int anchoEnPixeles) {
		super();
		this.titulo = titulo;
		this.borde = borde;
		this.anchoEnPixeles = anchoEnPixeles;
	}
	public void agregarRenglon(){
		Renglon nuevoRenglon = new Renglon();
		this.listaRenglones.add(nuevoRenglon);
	}
	public void agregarNrenglones(int nRenglones){
		for (int i=0;i<nRenglones;i++)
			this.agregarRenglon();
	}
	public void agregarColumnaDeTitulo(String valor, int numRenglon, int ancho, int alto){
		Renglon renglon = this.listaRenglones.get(numRenglon);
		renglon.agregarColumnaDeTitulo(valor, ancho, alto);
	}
	public void agregarColumna(String valor, int numRenglon, int ancho, int alto){
		Renglon renglon = this.listaRenglones.get(numRenglon);
		renglon.agregarColumna(valor, ancho, alto);
	}


	@Override
	public String toString() {
		return "Tabla [titulo=" + titulo + ", borde=" + borde
				+ ", anchoEnPixeles=" + anchoEnPixeles + ", \nlistaRenglones="
				+ listaRenglones + "]";
	}
	public String toHtml(){
		String cadHtmlTabla="";
		cadHtmlTabla+="<table";
		cadHtmlTabla+=" border=\""+this.borde+"\" "+
				"width=\""+this.anchoEnPixeles+"\""
				+">\n";
		if(this.titulo!=null){
			cadHtmlTabla+="<caption>";
			cadHtmlTabla+=this.titulo;
			cadHtmlTabla+="</caption>\n";
		}
		for(Renglon ren:this.listaRenglones){
			cadHtmlTabla+=ren.toHtml();
		}
		cadHtmlTabla+="</table>\n";
		
		return cadHtmlTabla;
	}
	public static void main(String[] args){
		Tabla unaTabla = new Tabla("Tabla Ejemplo",0,600);
		unaTabla.agregarNrenglones(5);
		unaTabla.agregarColumnaDeTitulo("Título doble de columna", 0, 2,2);
		unaTabla.agregarColumnaDeTitulo("Tit Simple", 0, 1,1);
		int numRenglon=1;
		for (int i=1; i<=(3*3);i++){
			unaTabla.agregarColumna(Integer.toString(i*5), numRenglon, 1,1);
			if (i%3==0) 		// Cada 3 columnas cambia de renglón
				numRenglon++;
		}
		for (int i=1; i<=3;i++){
			unaTabla.agregarColumna(Integer.toString(i*5), 4, 1,2);
		}

		System.out.println(unaTabla);
		System.out.println(unaTabla.toHtml());
	}

}
