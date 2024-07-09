package qtx.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class F_probadorImagenes
 */
public class F_probadorImagenes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String[] imagenes ={"desierto.jpg","gato.gif","osoPolar.jpg",
			"snoopy.JPG","servlets.jpg"}; 
	private static int iTipoLista=0;
	private static String[] links ={"HtmlA","HtmlB",
			"HtmlC","HtmlD","HtmlE"}; 
 
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter salidaParaNavegador = response.getWriter(); 
		
		String docType = "<!doctype html>";
		salidaParaNavegador.println(docType +"<html>\n" + "<head>");
		salidaParaNavegador.println("<title>F_probadorImagenes</title>");
		salidaParaNavegador.println("<meta charset=\"ISO-8859-1\"/>");
		salidaParaNavegador.println("</head>\n<body>");
		if(iTipoLista == 5)
			iTipoLista=0;
		
		switch (iTipoLista){
		case 0:
			this.muestraImagenesSimples(salidaParaNavegador);
			break;
		case 1:
			this.muestraListaDeImagenesSimples(salidaParaNavegador);
			break;
		case 2:
			this.muestraImagenesLinkSimples(salidaParaNavegador);
			break;
		default:
			this.muestraListaDeImagenesModificadas(salidaParaNavegador, 100*iTipoLista, 120*iTipoLista);
			break;
		}
		salidaParaNavegador.println("\n</body>\n</html>");
		iTipoLista++;
	}
 	private void muestraImagenesLinkSimples(PrintWriter salidaParaNavegador){
		for (int i=0;i<imagenes.length;i++){
			salidaParaNavegador.println("<a href=\""+links[i]+"\">"+
					"<img src=\"imagenes/"+
					imagenes[i]+"\""+
					" width="+300+
					" height="+300+
					"/>" +links[i]+
					"</a>");
		}
 	}
 	private void muestraImagenesSimples(PrintWriter salidaParaNavegador){
		for (int i=0;i<imagenes.length;i++){
			salidaParaNavegador.println("<img src=\"imagenes/"+imagenes[i]+"\""+
					" width="+300+
					" height="+300+
					"/>");
		}
 	}

 	private void muestraListaDeImagenesSimples(PrintWriter salidaParaNavegador){
		salidaParaNavegador.println("<ul>");
		for (int i=0;i<imagenes.length;i++){
			salidaParaNavegador.println("<li>");
			salidaParaNavegador.println("<img src=\"imagenes/"+imagenes[i]+"\"/>");
			salidaParaNavegador.println("</li>");
		}
		salidaParaNavegador.println("</ul>");	
 	}
 	private void muestraListaDeImagenesModificadas(PrintWriter salidaParaNavegador, int ancho, int largo){
		salidaParaNavegador.println("<ol>");
		for (int i=0;i<imagenes.length;i++){
			salidaParaNavegador.println("<li>");
			salidaParaNavegador.println("<img src=\"imagenes/"+imagenes[i]+"\""+
					" width="+ancho+
					" height="+largo+
					"/>");
			salidaParaNavegador.println("</li>");
		}
		salidaParaNavegador.println("</ol>");	
 	}
}
