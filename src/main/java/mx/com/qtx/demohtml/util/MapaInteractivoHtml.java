package mx.com.qtx.demohtml.util;

import java.io.PrintWriter;
import java.util.ArrayList;

public class MapaInteractivoHtml {
	public static final int CIRCULO = 1;
	public static final int OVALO = 2;
	public static final int RECTANGULO =3;
	public static final int POLIGONO =4;
	public static final int PUNTO =5;
	public static final int DEFAULT =6;
	
	private static String nombreSeccionMapa = "Mapa";
	private static int numMapa = 1;

	private String imagen;
	private ArrayList<SeccionMapa> listaSecciones = new ArrayList<SeccionMapa>();
	private PrintWriter salida;
	private String idMapa;
	private int alto;
	private int ancho;
	private boolean usaAjusteDeImagen=false; // Si se usa ajuste, se asume que las coordenadas
											//	de las secciones están en términos porcentuales
											//  en vez de términos absolutos
	
	public MapaInteractivoHtml(String imagen, PrintWriter salida) {
		super();
		this.imagen = imagen;
		this.salida = salida;
		this.idMapa = MapaInteractivoHtml.nombreSeccionMapa + MapaInteractivoHtml.numMapa;
		MapaInteractivoHtml.numMapa++;
	}
	public MapaInteractivoHtml(String imagen, PrintWriter salida,int ancho,int alto) {
		super();
		this.imagen = imagen;
		this.salida = salida;
		this.idMapa = MapaInteractivoHtml.nombreSeccionMapa + MapaInteractivoHtml.numMapa;
		MapaInteractivoHtml.numMapa++;
		this.ancho = ancho;
		this.alto = alto;
		this.usaAjusteDeImagen = true;
		
	}
	public void agregarSeccion(String nombre, int tipo, int[] arrPuntos){
		SeccionMapa seccion = new SeccionMapa(nombre,tipo,arrPuntos);
		this.listaSecciones.add(seccion);
	}
	public void agregarSeccionCircular(String nombre, int[] arrPuntos, int radio){
		SeccionMapa seccion = new SeccionMapa(nombre,arrPuntos,radio);
		this.listaSecciones.add(seccion);
	}
	public void agregarSeccionDefault(String nombre){
		SeccionMapa seccion = new SeccionMapa(nombre);
		this.listaSecciones.add(seccion);
	}
	public void generarLinkPrincipalEnHtml(){
		this.salida.print("<a>\n<img ");
		
		this.salida.print("src=\""+this.imagen+"\" ");
		if(this.usaAjusteDeImagen){
			this.salida.print("width="+this.ancho+
					" height="+this.alto+" ");
		}
		this.salida.print("usemap=\"#"+this.idMapa+"\" ismap");
		
		this.salida.println(">\n</a>");
	}
	public void generarMapasEnHtml(){
		this.salida.print("<map ");
		this.salida.println("name=\""+this.idMapa+"\">");
		for(SeccionMapa seccionMapa:this.listaSecciones){
			if(seccionMapa.esDefault())
				this.salida.println(seccionMapa.generarAreaDefaultEnHtml());
			else	
				this.salida.println(seccionMapa.generarAreaEnHtml());
		}
		this.salida.println("</map>");
	}
	public void generarMapasAjustadosEnHtml(){
		this.salida.print("<map ");
		this.salida.println("name=\""+this.idMapa+"\">");
		for(SeccionMapa seccionMapa:this.listaSecciones){
			if(seccionMapa.esDefault())
				this.salida.println(seccionMapa.generarAreaDefaultEnHtml());
			else	
				this.salida.println(seccionMapa.generarAreaEnHtmlConAjuste(this.ancho));
		}
		this.salida.println("</map>");
	}
	
	public void generarHtml(){
		this.generarLinkPrincipalEnHtml();
		if(this.usaAjusteDeImagen)
			this.generarMapasAjustadosEnHtml();
		else
			this.generarMapasEnHtml();
	}

	public static void main(String[] args){
//		MapaInteractivoHtml.probarMapa();
		MapaInteractivoHtml.probarMapaAjustado();
	}
	private static void probarMapa(){
		PrintWriter salida = new PrintWriter(System.out);
		MapaInteractivoHtml mapa = new MapaInteractivoHtml("cuadro.gif",salida);
		mapa.agregarSeccion("PaginaColorVerde.html", MapaInteractivoHtml.RECTANGULO,new int[]{0,0,50,50});
		mapa.agregarSeccionCircular("PaginaColorVioleta.html",new int[]{75,75},25);
		mapa.agregarSeccion("PaginaColorRojo.html", MapaInteractivoHtml.RECTANGULO,new int[]{0,80,40,99});
		mapa.agregarSeccionDefault("PaginaDefault.html");
		mapa.generarLinkPrincipalEnHtml();
		mapa.generarMapasEnHtml();
		salida.close();
		
	}
	private static void probarMapaAjustado(){
		PrintWriter salida = new PrintWriter(System.out);
		MapaInteractivoHtml mapa = new MapaInteractivoHtml("cuadro.gif",salida,200,200);
		mapa.agregarSeccion("PaginaColorVerde.html", MapaInteractivoHtml.RECTANGULO,new int[]{0,0,50,50});
		mapa.agregarSeccionCircular("PaginaColorVioleta.html",new int[]{75,75},25);
		mapa.agregarSeccion("PaginaColorRojo.html", MapaInteractivoHtml.RECTANGULO,new int[]{0,80,40,99});
		mapa.agregarSeccionDefault("PaginaDefault.html");
		mapa.generarHtml();
		salida.close();
		
	}

}
