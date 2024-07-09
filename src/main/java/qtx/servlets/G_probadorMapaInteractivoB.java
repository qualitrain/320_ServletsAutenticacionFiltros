package qtx.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import qtx.util.MapaInteractivo.MapaInteractivo;

/*********************************************************************************
 * 
 * Este ejemplo es funcionalmente equivalente a G_probadorMapaInteractivo.
 * Sin embargo las clases de utilería usadas han sido rediseñadas para facilitar
 * el mantenimiento futuro y para simplificar la estructura de la solución
 * Compare las clases del paquete qtx.util vs qtx.util.MapaInteractivo (rediseñadas)
 * 
 * @author ALEJANDRO CRUZ
 *********************************************************************************/

public class G_probadorMapaInteractivoB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	float[] factor={.5f,1f,1.5f,2f,2.5f};
	private static int numEjecucion=0;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter salidaParaNavegador = response.getWriter(); 
		
		String docType = "<!doctype html>";
		salidaParaNavegador.println(docType +"<html>\n" + "<head>");
		salidaParaNavegador.println("<title>G_probadorMapaInteractivoB</title>");
		salidaParaNavegador.println("<meta charset=\"ISO-8859-1\"/>");
		salidaParaNavegador.println("</head>\n<body>");
		if(numEjecucion==factor.length)
			numEjecucion=0;
		
		int ancho=(int)(100f*factor[numEjecucion]);
		int alto=(int)(100f*factor[numEjecucion]);
		MapaInteractivo mapaHtml = MapaInteractivo.crarMapaInteractivo("imagenes/cuadro.gif",salidaParaNavegador,ancho,alto);
		mapaHtml.agregarSeccion("paginasHtml/PaginaColorVerde.html", MapaInteractivo.RECTANGULO,new int[]{0,0,50,50},0);
		mapaHtml.agregarSeccion("paginasHtml/PaginaColorVioleta.html",MapaInteractivo.CIRCULO,new int[]{75,75},25);
		mapaHtml.agregarSeccion("paginasHtml/PaginaColorRojo.html", MapaInteractivo.RECTANGULO,new int[]{0,80,40,99},0);
		
		mapaHtml.agregarSeccion("HtmlA",MapaInteractivo.DEFAULT,null,0); 
		/************************************************************************************************
		 *  IMPORTANTE: La seccion default pertenece a html 5. Probar en un navegador que lo soporte.
		 *  No funciona con todos los navegadores (incluyendo lo que están incrustados en algunas
		 *  versiones del ide eclipse
		 * 
		 ***********************************************************************************************/
		
//		Qué sucederá si se descomenta la línea siguiente ? -Considere que la figura base NO cambia, pero el mapeo de ella sí
//		mapaHtml.agregarSeccion("htmlF", MapaInteractivoHtml.POLIGONO,new int[]{51,0,99,0,75,50},0); 

		mapaHtml.generarHtml();
		
		salidaParaNavegador.println("\n</body>\n</html>");
		numEjecucion++;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
