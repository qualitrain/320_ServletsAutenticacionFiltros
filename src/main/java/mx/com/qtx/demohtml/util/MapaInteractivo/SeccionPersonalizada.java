package mx.com.qtx.demohtml.util.MapaInteractivo;

import java.util.ArrayList;

import mx.com.qtx.demohtml.util.CoordenadaMapa;
import mx.com.qtx.demohtml.util.MapaInteractivoHtml;

public class SeccionPersonalizada extends Seccion {
	private int tipoFigura;
	protected int porcentajeAjuste=100;

	protected ArrayList<CoordenadaMapa>listaCoordenadas = new ArrayList<CoordenadaMapa>();

	public SeccionPersonalizada(String nombreLinkAsociado, int[] arrPuntos, int tipoFigura) {
		super(nombreLinkAsociado);
		this.inicializarCoordenadas(arrPuntos);
		this.tipoFigura = tipoFigura;

	}
	public SeccionPersonalizada(String nombreLinkAsociado, int[] arrPuntos, int tipoFigura, int porcentajeAjuste) {
		super(nombreLinkAsociado);
		this.inicializarCoordenadas(arrPuntos);
		this.tipoFigura = tipoFigura;
		this.porcentajeAjuste = porcentajeAjuste;

	}
	
	protected void inicializarCoordenadas(int[] arrPuntos){
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
	@Override
	String getFormaGeometrica() {
		String formaGeometrica="";
		switch (this.tipoFigura){
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
		default:
			formaGeometrica = "ERROR";
			break;
		}
		return formaGeometrica;
	}
	String generarAreaEnHtml(){
		String html="";
		html="<area " +
			"shape=\""+this.getFormaGeometrica()+"\" "+
			"coords=\""+this.getCadCoords()+"\" "+
			"href=\""+this.nombreLinkAsociado+"\">";
		return html;
	}

	String getCadCoords(){
		String cadCoords="";
		int iCoord=0;
		int iUltCoord = this.listaCoordenadas.size()-1;
		for(CoordenadaMapa coord:this.listaCoordenadas){
			float fX =(float)coord.getX()*(this.porcentajeAjuste/(float)100);
			float fY =(float)coord.getY()*(this.porcentajeAjuste/(float)100);
			cadCoords+=(int)fX+","+(int)fY;
			if(iCoord==iUltCoord)// Si es la última coordenada de la lista
					; // No agrega la coma si es el último elemento
			else
				cadCoords+=",";
			iCoord++;
		}
		return cadCoords;
	}

}
