package qtx.util.MapaInteractivo;

public abstract class Seccion {
	static final int PERSONALIZADA = 1;
	static final int PERSONALIZADA_CIRCULAR = 2;
	static final int DEFAULT = 3;
	protected String nombreLinkAsociado;
	
	
	abstract String getFormaGeometrica();
	abstract String generarAreaEnHtml();
		

	public Seccion(String nombreLinkAsociado) {
		super();
		this.nombreLinkAsociado = nombreLinkAsociado;
	}
	static int getTipoSeccion(int tipoFigura){
		int tipoSeccion=0;
		
		switch (tipoFigura){
		case MapaInteractivo.CIRCULO:
			tipoSeccion=Seccion.PERSONALIZADA_CIRCULAR;
			break;
		case MapaInteractivo.DEFAULT:
			tipoSeccion=Seccion.DEFAULT;
			break;
		case MapaInteractivo.OVALO:
		case MapaInteractivo.POLIGONO:
		case MapaInteractivo.PUNTO:
		case MapaInteractivo.RECTANGULO:
			tipoSeccion=Seccion.PERSONALIZADA;
			break;
		}
		
		return tipoSeccion;
		
	}
	static Seccion crearSeccion(String nombreLinkAsociado, int[] arrPuntos,int tipoFigura, int radio ){
		int tipoSeccion = Seccion.getTipoSeccion(tipoFigura);
		Seccion nuevaSeccion=null;
		switch(tipoSeccion){
		case Seccion.DEFAULT:
			nuevaSeccion = new SeccionDefault(nombreLinkAsociado);
			break;
		case Seccion.PERSONALIZADA:
			nuevaSeccion = new SeccionPersonalizada(nombreLinkAsociado,arrPuntos,tipoFigura);
			break;
		case Seccion.PERSONALIZADA_CIRCULAR:
			nuevaSeccion = new SeccionPersonalizadaCircular(nombreLinkAsociado,arrPuntos,radio);
			break;
		
		}
		return nuevaSeccion;
		
	}
	static Seccion crearSeccion(String nombreLinkAsociado, int[] arrPuntos,int tipoFigura, int radio, int porcentajeAjuste){
		int tipoSeccion = Seccion.getTipoSeccion(tipoFigura);
		Seccion nuevaSeccion=null;
		switch(tipoSeccion){
		case Seccion.DEFAULT:
			nuevaSeccion = new SeccionDefault(nombreLinkAsociado);
			break;
		case Seccion.PERSONALIZADA:
			nuevaSeccion = new SeccionPersonalizada(nombreLinkAsociado,arrPuntos,tipoFigura,porcentajeAjuste);
			break;
		case Seccion.PERSONALIZADA_CIRCULAR:
			nuevaSeccion = new SeccionPersonalizadaCircular(nombreLinkAsociado,arrPuntos,radio,porcentajeAjuste);
			break;
		
		}
		return nuevaSeccion;
		
	}

}
