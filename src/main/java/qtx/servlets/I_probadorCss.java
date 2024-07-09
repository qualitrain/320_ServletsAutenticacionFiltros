package qtx.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class I_probadorCss extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo",
    					"Junio","Julio","Agosto","Septiembre","Octubre",
    					"Noviembre","Diciembre"};
    private static String[] cadTipoLista={"Bullet","Numerado"};
    private static String[] cadHtmlTipoLista={"ul","ol"};
    private static int numPeticion=0;
    
    private static String[] coloresFondo={"#d0e4fe","#6495ed","#e0ffff","#b0c4de","#bcf5a9","#f5a9d0","#f7be81"};
    private static String[] colores={"orange","DarkRed","MediumVioletRed","OrangeRed","DarkKhaki","Indigo","DarkSlateBlue",
    							"DarkGreen","DarkOliveGreen","Blue","MidnightBlue","SaddleBrown","DarkSlateGray "};
    private static String[] alineacionesTexto={"center","left","right"};
    private static String[] familiasDeFuentes={"Times New Roman","Georgia","serif","Palatino Linotype","Book Antiqua","Palatino",
    							"Times","Arial","Helvetica","sans-serif","Arial Black","Comic Sans MS","cursive"};
    private static String[] tamaniosFuente={"10px","13px","16px","19px","22px","25px","28px","40px"};
    	
    
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter salidaParaNavegador = response.getWriter();
		
		String docType = "<!doctype html>";
		salidaParaNavegador.println(docType +"<html>\n" + "<head>");
		salidaParaNavegador.println("<title>I_probadorCss</title>");
		salidaParaNavegador.println("<meta charset=\"ISO-8859-1\"/>");
		
		this.insertarEstiloCSS(salidaParaNavegador,numPeticion);
		
		salidaParaNavegador.println("</head>\n<body>");
		
		salidaParaNavegador.println("<table>");
		salidaParaNavegador.println("<caption><h2>Ejemplo de una tabla que contiene listas</h2></caption>");
		salidaParaNavegador.println("<tr>");
		salidaParaNavegador.println("<td>");
		this.insertarLista(salidaParaNavegador, 0);
		salidaParaNavegador.println("</td>");
		salidaParaNavegador.println("<td>");
		this.insertarLista(salidaParaNavegador, 1);
		salidaParaNavegador.println("</td>");
		salidaParaNavegador.println("</tr></table>");
		
		salidaParaNavegador.println("\n</body>\n</html>");
		numPeticion++;
 	}
 	private void insertarLista(PrintWriter salidaParaNavegador, int iTipoLista){
		salidaParaNavegador.println("<h2>Lista tipo "+cadTipoLista[iTipoLista]
		                            +" (&lt"+cadHtmlTipoLista[iTipoLista]+"&gt)"+"</h2>");
		                                		
		salidaParaNavegador.println("<"+cadHtmlTipoLista[iTipoLista]+">");
		for (int i=0;i<meses.length;i++){
		   salidaParaNavegador.println("<li>"+meses[i]+"</li>");
		}
		salidaParaNavegador.println("</"+cadHtmlTipoLista[iTipoLista]+">");
 	}
 	private void insertarEstiloCSS(PrintWriter salidaParaNavegador, int i){
 		int numColor = i % coloresFondo.length;
		salidaParaNavegador.println("<style>");
		salidaParaNavegador.println("body{");
		salidaParaNavegador.println("background-color:"+coloresFondo[numColor]+";");
		salidaParaNavegador.println("margin-left:"+i*10+"px;");
		salidaParaNavegador.println("}");

		numColor = i % colores.length;
		int numAlineacion = i % alineacionesTexto.length;
		salidaParaNavegador.println("h2{");
		salidaParaNavegador.println("color:"+colores[numColor]+";");
		salidaParaNavegador.println("text-align:"+alineacionesTexto[numAlineacion]+";");
		salidaParaNavegador.println("}");
		
		int numFamiliaFte = i % familiasDeFuentes.length;
		int numTamanioFte = i % tamaniosFuente.length;
		salidaParaNavegador.println("ol{");
		salidaParaNavegador.println("font-family:\""+familiasDeFuentes[numFamiliaFte]+"\";");
		salidaParaNavegador.println("font-size:"+tamaniosFuente[numTamanioFte]+";");
		salidaParaNavegador.println("}");

		numFamiliaFte = (i+1) % familiasDeFuentes.length;
		numTamanioFte = (i+1) % tamaniosFuente.length;
		salidaParaNavegador.println("ul{");
		salidaParaNavegador.println("font-family:"+familiasDeFuentes[numFamiliaFte]+";");
		salidaParaNavegador.println("font-size:"+tamaniosFuente[numTamanioFte]+";");
		salidaParaNavegador.println("}");

		salidaParaNavegador.println("table{");
		salidaParaNavegador.println("border:solid 2px black;");
		salidaParaNavegador.println("}");

		salidaParaNavegador.println("td{");
		salidaParaNavegador.println("border:solid 2px black;");
		salidaParaNavegador.println("}");
		
		salidaParaNavegador.println("</style>");

 	}
}
