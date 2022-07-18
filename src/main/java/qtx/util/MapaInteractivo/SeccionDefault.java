package qtx.util.MapaInteractivo;

public class SeccionDefault extends Seccion {

	public SeccionDefault(String nombreLinkAsociado) {
		super(nombreLinkAsociado);
	}

	@Override
	String getFormaGeometrica() {
		return "default";
	}

	String generarAreaEnHtml(){
		String html="";
		html="<area " +
			"shape=\""+this.getFormaGeometrica()+"\" "+
			"href=\""+this.nombreLinkAsociado+"\">";
		return html;
	}

}
