package qtx.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class C_probadorDeListas
 */
public class C_probadorDeListas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo",
    					"Junio","Julio","Agosto","Septiembre","Octubre",
    					"Noviembre","Diciembre"};
    private static String[] cadTipoLista={"Bullet","Numerado"};
    private static String[] cadHtmlTipoLista={"ul","ol"};
    private static int iTipoLista=0;
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter salidaParaNavegador = response.getWriter();
		
		String docType = "<!doctype html>";
		salidaParaNavegador.println(docType +"<html>\n" + "<head>");
		salidaParaNavegador.println("<title>C_probadorDeListas</title>");
		salidaParaNavegador.println("<meta charset=\"ISO-8859-1\"/>");
		salidaParaNavegador.println("</head>\n<body>");
		
		if(iTipoLista == cadTipoLista.length)
			iTipoLista=0;
		
		salidaParaNavegador.println("<h2>Lista tipo "+cadTipoLista[iTipoLista]
		                   +" (&lt"+cadHtmlTipoLista[iTipoLista]+"&gt)"+"</h2>");
		
		salidaParaNavegador.println("<"+cadHtmlTipoLista[iTipoLista]+">");
		
		for (int i=0;i<meses.length;i++){
			salidaParaNavegador.println("<li>"+meses[i]+"</li>");
			
		}
		salidaParaNavegador.println("</"+cadHtmlTipoLista[iTipoLista]+">");
		salidaParaNavegador.println("\n</body>\n</html>");
		iTipoLista++;
		
	}

}
