package qtx.util.MapaInteractivo;

import qtx.util.CoordenadaMapa;

public class SeccionPersonalizadaCircular extends SeccionPersonalizada
{
	private int radioCirculo=0;

	public SeccionPersonalizadaCircular(String nombre,int[] arrPuntos, int radio) {
		super(nombre,arrPuntos,MapaInteractivo.CIRCULO);
		this.radioCirculo = radio;
	}
	public SeccionPersonalizadaCircular(String nombre,int[] arrPuntos, int radio, int porcentajeAjuste) {
		super(nombre,arrPuntos,MapaInteractivo.CIRCULO, porcentajeAjuste);
		this.radioCirculo = radio;
	}

	String getFormaGeometrica() {
		return "circle";
	}
	int getTipoSeccion() {
		return Seccion.PERSONALIZADA_CIRCULAR;
	}
	String getCadCoords(){
		String cadCoords="";
		int iCoord=0;
		int iUltCoord = this.listaCoordenadas.size()-1;
		for(CoordenadaMapa coord:this.listaCoordenadas){
			float fX =(float)coord.getX()*(this.porcentajeAjuste/(float)100);
			float fY =(float)coord.getY()*(this.porcentajeAjuste/(float)100);
			float fRadio = (float)this.radioCirculo*(this.porcentajeAjuste/(float)100);
			cadCoords+=(int)fX+","+(int)fY;
			if(iCoord==iUltCoord)// Si es la última coordenada de la lista
				cadCoords+=","+(int)fRadio; // agrega el radio del círculo como última coordenada
			else
				cadCoords+=",";
			iCoord++;
						
		}
		return cadCoords;
	}


}
