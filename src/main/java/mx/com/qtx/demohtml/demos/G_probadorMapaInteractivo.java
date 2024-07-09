package mx.com.qtx.demohtml.demos;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.qtx.demohtml.util.MapaInteractivoHtml;

public class G_probadorMapaInteractivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	float[] factor={.5f,1f,1.5f,2f,2.5f};
	private static int numEjecucion=0;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter salidaParaNavegador = response.getWriter(); 
		
		String docType = "<!doctype html>";
		salidaParaNavegador.println(docType +"<html>\n" + "<head>");
		salidaParaNavegador.println("<title>G_probadorMapaInteractivo</title>");
		salidaParaNavegador.println("<meta charset=\"ISO-8859-1\"/>");
		salidaParaNavegador.println("</head>\n<body>");
		if(numEjecucion==factor.length)
			numEjecucion=0;
		
		int ancho=(int)(100f*factor[numEjecucion]);
		int alto=(int)(100f*factor[numEjecucion]);
		MapaInteractivoHtml mapaHtml = new MapaInteractivoHtml("imagenes/cuadro.gif",salidaParaNavegador,ancho,alto);
		mapaHtml.agregarSeccion("paginasHtml/PaginaColorVerde.html", MapaInteractivoHtml.RECTANGULO,new int[]{0,0,50,50});
		mapaHtml.agregarSeccionCircular("paginasHtml/PaginaColorVioleta.html",new int[]{75,75},25);
		mapaHtml.agregarSeccion("paginasHtml/PaginaColorRojo.html", MapaInteractivoHtml.RECTANGULO,new int[]{0,80,40,99});
		
		mapaHtml.agregarSeccionDefault("HtmlA"); 
		/************************************************************************************************
		 *  IMPORTANTE: La seccion default pertenece a html 5. Probar en un navegador que lo soporte
		 *  No funciona con todos los navegadores (incluyendo lo que est�n incrustados en algunas
		 *  versiones del ide eclipse
		 * 
		 ***********************************************************************************************/
		
//		Qu� suceder� si se descomenta la l�nea siguiente ? -Considere que la figura base NO cambia, pero el mapeo de ella s�
//		mapaHtml.agregarSeccion("htmlF", MapaInteractivoHtml.POLIGONO,new int[]{51,0,99,0,75,50}); 

		mapaHtml.generarHtml();
		
		salidaParaNavegador.println("\n</body>\n</html>");
		numEjecucion++;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
