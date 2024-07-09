package qtx.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import qtx.util.MapaInteractivo.MapaInteractivo;

/**
 * Servlet implementation class G_probadorMapaInteractivoC
 */
public class G_probadorMapaInteractivoC extends HttpServlet {
		private static final long serialVersionUID = 1L;
       
	       
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter salidaParaNavegador = response.getWriter(); 
			
			String docType = "<!doctype html>";
			salidaParaNavegador.println(docType +"<html>\n" + "<head>");
			salidaParaNavegador.println("<title>G_probadorMapaInteractivoC</title>");
			salidaParaNavegador.println("<meta charset=\"ISO-8859-1\"/>");
			salidaParaNavegador.println("</head>\n<body>");
			
			MapaInteractivo mapaHtml = MapaInteractivo.crarMapaInteractivo("imagenes/servlets.jpg",salidaParaNavegador);
			mapaHtml.agregarSeccion("HtmlE", MapaInteractivo.RECTANGULO,new int[]{27,168,206,244},0);
			mapaHtml.agregarSeccion("HtmlF",MapaInteractivo.RECTANGULO,new int[]{230,168,409,244},0);
			mapaHtml.agregarSeccion("HtmlGB", MapaInteractivo.RECTANGULO,new int[]{433,168,612,244},0);
			
			mapaHtml.generarHtml();
			
			salidaParaNavegador.println("\n</body>\n</html>");
	}
}
