package qtx.util.MapaInteractivo;

import java.io.PrintWriter;

public class MapaInteractivoAjustable extends MapaInteractivo {
	private int alto;
	private int ancho;
	
	public MapaInteractivoAjustable(String imagen, PrintWriter salida,
			int alto, int ancho) {
		super(imagen, salida);
		this.alto = alto;
		this.ancho = ancho;
	}
	public void agregarSeccion(String nombre,int tipoFigura, int[] arrPuntos, int radio){
		Seccion seccion = Seccion.crearSeccion(nombre, arrPuntos,tipoFigura, radio,this.ancho);
		this.listaSecciones.add(seccion);
	}

	public void generarLinkPrincipalEnHtml(){
		this.salida.print("<a>\n<img ");
		
		this.salida.print("src=\""+this.imagen+"\" ");
		this.salida.print("width="+this.ancho+
					" height="+this.alto+" ");
		this.salida.print("usemap=\"#"+this.idMapa+"\" ismap");
		
		this.salida.println(">\n</a>");
	}

}
