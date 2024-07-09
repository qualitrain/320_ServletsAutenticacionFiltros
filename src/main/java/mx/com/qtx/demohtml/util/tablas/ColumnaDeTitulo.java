package mx.com.qtx.demohtml.util.tablas;

public class ColumnaDeTitulo extends Columna {

	public ColumnaDeTitulo(int numColumnasFisicas,int numRenglonesFisicos, String contenido) {
		super(numColumnasFisicas,numRenglonesFisicos, contenido);
	}

	@Override
	public String toHtml() {
		if(this.numColumnasFisicas==1 && this.numRenglonesFisicos==1)
			return "<th>"+this.contenido+"</th>\n";
		else
			return "<th colspan=\""+this.numColumnasFisicas+"\" "+
			"rowspan=\""+this.numRenglonesFisicos+"\""+
			">"+this.contenido+"</th>\n";
	}

}
