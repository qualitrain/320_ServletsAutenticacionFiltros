package mx.com.qtx.demohtml.util.tablas;

public class ColumnaTipica extends Columna {
	public ColumnaTipica(int numColumnasFisicas, int numRenglonesFisicos,String contenido) {
		super(numColumnasFisicas,numRenglonesFisicos, contenido);
	}
	public String toHtml() {
		if(this.numColumnasFisicas==1 && this.numRenglonesFisicos==1)
			return "<td align = center valign = bottom>"+this.contenido+"</td>\n";
		else
			return "<td colspan=\""+this.numColumnasFisicas+"\" "+
			"rowspan=\""+this.numRenglonesFisicos+"\""+
			" align = center "+
			"valing = bottom " +
			">"+this.contenido+"</td>\n";
			
	}

}
