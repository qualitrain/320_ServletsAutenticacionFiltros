package mx.com.qtx.demohtml.util.tablas;

public abstract class Columna {
	protected int numColumnasFisicas;
	protected int numRenglonesFisicos;
	
	protected String contenido;
	protected Columna(int numColumnasFisicas, int numRenglonesFisicos,String contenido) {
		super();
		this.numColumnasFisicas = numColumnasFisicas;
		this.numRenglonesFisicos = numRenglonesFisicos;
		this.contenido = contenido;
	}
	public static Columna crearColumnaDeTitulo(int numColumnasFisicas, int numRenglonesFisicos,String contenido){
		Columna nuevaColumna= null;
		nuevaColumna = new ColumnaDeTitulo(numColumnasFisicas, numRenglonesFisicos, contenido);
		return nuevaColumna;
	}
	public static Columna crearColumna(int numColumnasFisicas, int numRenglonesFisicos, String contenido){
		Columna nuevaColumna= null;
		nuevaColumna = new ColumnaTipica(numColumnasFisicas, numRenglonesFisicos, contenido);
		return nuevaColumna;
	}
	@Override
	public String toString() {
		return "\n\tColumna [numColumnasFisicas=" + numColumnasFisicas
				+ ", contenido=" + contenido + "]";
	}
	abstract public String toHtml();
	

}
