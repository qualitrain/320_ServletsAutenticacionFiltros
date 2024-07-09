package qtx.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class E_probadorLinks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static String[] links ={"/HtmlA",
		 			"HtmlA",
		 			"../HtmlA",
		 			"/paginasHtml/paginaEstatica.html",
		 			"paginasHtml/paginaEstatica.html"}; 
	 private static String[] titlesDeLinks ={"Url: &#47;HtmlA",
		 			"Url: HtmlA",
		 			"Url: ..&#47;HtmlA",
		 			"Url: &#47;paginasHtml&#47;paginaEstatica.html",
		 			"Url: paginasHtml&#47;paginaEstatica.html"}; 
	 private static String[] leyendasDeLinks ={"A_probadorHtmlBasico (/)","A_probadorHtmlBasico ( )","A_probadorHtmlBasico (../)",
		 			"Ejemplo p&aacute;gina est&aacute;tica (/)","Ejemplo p&aacute;gina est&aacute;tica ( )"}; 
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter salidaParaNavegador = response.getWriter(); 
		
		String docType = "<!doctype html>";
		salidaParaNavegador.println(docType +"<html>\n" + "<head>");
		salidaParaNavegador.println("<title>E_probadorLinks</title>");
		salidaParaNavegador.println("<meta charset=\"ISO-8859-1\"/>");
		salidaParaNavegador.println("</head>\n<body>");
		salidaParaNavegador.println("<h2>¿C&oacute;mo se usan correctamente las referencias absolutas y relativas?</h2>");
		
		salidaParaNavegador.println("<ul>");
		for (int i=0;i<links.length;i++){
			salidaParaNavegador.println("<li>");
			salidaParaNavegador.println("<a href=\""+links[i]+"\""+
								" title=\""+titlesDeLinks[i]+"\">"+
								leyendasDeLinks[i]+
								"</a>");
			salidaParaNavegador.println("</li>");
			
		}
		salidaParaNavegador.println("</ul>");
		

		salidaParaNavegador.println("\n</body>\n</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
