package mx.com.qtx.demohtml.util.MapaInteractivo;

import java.io.PrintWriter;
import java.util.ArrayList;


public class MapaInteractivo {
	public static final int CIRCULO = 1;
	public static final int OVALO = 2;
	public static final int RECTANGULO =3;
	public static final int POLIGONO =4;
	public static final int PUNTO =5;
	public static final int DEFAULT =6;
	
	protected static String nombreSeccionMapa = "Mapa";
	protected static int numMapa = 1;

	protected String imagen;
	protected ArrayList<Seccion> listaSecciones = new ArrayList<Seccion>();
	protected PrintWriter salida;
	protected String idMapa;
	
	public static MapaInteractivo crarMapaInteractivo(String imagen, PrintWriter salida){
		return new MapaInteractivo(imagen,salida);
	}
	public static MapaInteractivo crarMapaInteractivo(String imagen, PrintWriter salida, int ancho, int alto){
		return new MapaInteractivoAjustable(imagen,salida,alto,ancho);
	}
	
	public MapaInteractivo(String imagen, PrintWriter salida) {
		super();
		this.imagen = imagen;
		this.salida = salida;
		this.idMapa = MapaInteractivo.nombreSeccionMapa + MapaInteractivo.numMapa;
		MapaInteractivo.numMapa++;
	}
	public static void main(String[] args){
//		MapaInteractivo.probarMapa();
		MapaInteractivo.probarMapaAjustado();
	}
	public void agregarSeccion(String nombre,int tipoFigura, int[] arrPuntos, int radio){
		Seccion seccion = Seccion.crearSeccion(nombre, arrPuntos,tipoFigura, radio);
		this.listaSecciones.add(seccion);
	}
	public void generarLinkPrincipalEnHtml(){
		this.salida.print("<a>\n<img ");
		
		this.salida.print("src=\""+this.imagen+"\" ");
		this.salida.print("usemap=\"#"+this.idMapa+"\" ismap");
		
		this.salida.println(">\n</a>");
	}
	public void generarMapasEnHtml(){
		this.salida.print("<map ");
		this.salida.println("name=\""+this.idMapa+"\">");
		for(Seccion seccionMapa:this.listaSecciones){
				this.salida.println(seccionMapa.generarAreaEnHtml());
		}
		this.salida.println("</map>");
	}
	public void generarHtml(){
		this.generarLinkPrincipalEnHtml();
		this.generarMapasEnHtml();
	}

	private static void probarMapa(){
		PrintWriter salida = new PrintWriter(System.out);
		MapaInteractivo mapa = MapaInteractivo.crarMapaInteractivo("cuadro.gif",salida);
		mapa.agregarSeccion("PaginaColorVerde.html", MapaInteractivo.RECTANGULO,new int[]{0,0,50,50},0);
		mapa.agregarSeccion("PaginaColorVioleta.html",MapaInteractivo.CIRCULO,new int[]{75,75},25);
		mapa.agregarSeccion("PaginaColorRojo.html", MapaInteractivo.RECTANGULO,new int[]{0,80,40,99},0);
		mapa.agregarSeccion("PaginaDefault.html",MapaInteractivo.DEFAULT,null,0);
		mapa.generarHtml();
		salida.close();
		
	}
	private static void probarMapaAjustado(){
		PrintWriter salida = new PrintWriter(System.out);
		MapaInteractivo mapa = MapaInteractivo.crarMapaInteractivo("cuadro.gif",salida,200,200);
		mapa.agregarSeccion("PaginaColorVerde.html", MapaInteractivo.RECTANGULO,new int[]{0,0,50,50},0);
		mapa.agregarSeccion("PaginaColorVioleta.html",MapaInteractivo.CIRCULO,new int[]{75,75},25);
		mapa.agregarSeccion("PaginaColorRojo.html", MapaInteractivo.RECTANGULO,new int[]{0,80,40,99},0);
		mapa.agregarSeccion("PaginaDefault.html",MapaInteractivo.DEFAULT,null,0);
		mapa.generarHtml();
		salida.close();
		
	}

}
