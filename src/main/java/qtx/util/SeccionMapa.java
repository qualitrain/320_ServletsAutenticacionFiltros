package qtx.util;

import java.util.ArrayList;

public class SeccionMapa {
	private String nombreLinkAsociado;
	private int tipo;
	private int radioCirculo=0;
	private ArrayList<CoordenadaMapa>listaCoordenadas = new ArrayList<CoordenadaMapa>();
	public SeccionMapa(String nombre, int tipo, int[] arrPuntos) {
		super();
		this.nombreLinkAsociado = nombre;
		this.tipo = tipo;
		this.inicializarCoordenadas(arrPuntos);
	}
	public SeccionMapa(String nombre,int[] arrPuntos, int radio) {
		super();
		this.nombreLinkAsociado = nombre;
		this.tipo = MapaInteractivoHtml.CIRCULO;
		this.radioCirculo = radio;
		this.inicializarCoordenadas(arrPuntos);
	}
	public SeccionMapa(String nombre) {
		super();
		this.nombreLinkAsociado = nombre;
		this.tipo = MapaInteractivoHtml.DEFAULT;
	}

	private void inicializarCoordenadas(int[] arrPuntos){
		int i=0;
		while(true){
			if(i==arrPuntos.length||(i+1)==arrPuntos.length)
				break;
			
			CoordenadaMapa coordenada = new CoordenadaMapa(arrPuntos[i],arrPuntos[i+1]);
			this.agregarCoordenada(coordenada);
			i+=2;
		
		}
	}
	private void agregarCoordenada(CoordenadaMapa coordenada){
		this.listaCoordenadas.add(coordenada);
		
	}
	String getFormaGeometrica(){
		String formaGeometrica="";
		switch (this.tipo){
		case MapaInteractivoHtml.CIRCULO:
			formaGeometrica = "circle";
			break;
		case MapaInteractivoHtml.OVALO:
			formaGeometrica = "oval";
			break;
		case MapaInteractivoHtml.POLIGONO:
			formaGeometrica = "poly";
			break;
		case MapaInteractivoHtml.PUNTO:
			formaGeometrica = "point";
			break;
		case MapaInteractivoHtml.RECTANGULO:
			formaGeometrica = "rect";
			break;
		case MapaInteractivoHtml.DEFAULT:
			formaGeometrica = "default";
			break;
		default:
			formaGeometrica = "ERROR";
			break;
		}
		return formaGeometrica;
	}
	boolean esCircular(){
		return this.tipo == MapaInteractivoHtml.CIRCULO;
	}
	boolean esDefault(){
		return this.tipo == MapaInteractivoHtml.DEFAULT;
	}
	String getCadCoords(){
		String cadCoords="";
		int iCoord=0;
		int iUltCoord = this.listaCoordenadas.size()-1;
		for(CoordenadaMapa coord:this.listaCoordenadas){
			cadCoords+=coord.getX()+","+coord.getY();
			if(iCoord==iUltCoord)// Si es la última coordenada de la lista
				if(this.esCircular())
					cadCoords+=","+this.radioCirculo; // agrega el radio del círculo como última coordenada
				else
					; // No agrega la coma si es el último elemento
			else
				cadCoords+=",";
			iCoord++;
						
		}
		return cadCoords;
	}
	String getCadCoordsConAjuste(int base){
		String cadCoords="";
		if (base <=0)
			return "ERROR:Base errónea";
		int iCoord=0;
		int iUltCoord = this.listaCoordenadas.size()-1;
		for(CoordenadaMapa coord:this.listaCoordenadas){
			float fX =(float)coord.getX()*(base/(float)100);
			float fY =(float)coord.getY()*(base/(float)100);
			float fRadio = (float)this.radioCirculo*(base/(float)100);
			cadCoords+=(int)fX+","+(int)fY;
			if(iCoord==iUltCoord)// Si es la última coordenada de la lista
				if(this.esCircular())
					cadCoords+=","+(int)fRadio; // agrega el radio del círculo como última coordenada
				else
					; // No agrega la coma si es el último elemento
			else
				cadCoords+=",";
			iCoord++;
						
		}
		return cadCoords;
	}

	String generarAreaEnHtml(){
		String html="";
		html="<area " +
			"shape=\""+this.getFormaGeometrica()+"\" "+
			"coords=\""+this.getCadCoords()+"\" "+
			"href=\""+this.nombreLinkAsociado+"\">";
		return html;
	}
	String generarAreaDefaultEnHtml(){
		String html="";
		html="<area " +
			"shape=\""+this.getFormaGeometrica()+"\" "+
			"href=\""+this.nombreLinkAsociado+"\">";
		return html;
	}

	String generarAreaEnHtmlConAjuste(int base){
		String html="";
		html="<area " +
			"shape=\""+this.getFormaGeometrica()+"\" "+
			"coords=\""+this.getCadCoordsConAjuste(base)+"\" "+
			"href=\""+this.nombreLinkAsociado+"\">";
		return html;
	}

	
}
