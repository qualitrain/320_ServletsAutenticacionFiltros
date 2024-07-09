package qtx.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import qtx.monitoreo.MonitorHilos;

/**
 * Servlet implementation class B_probadorCaracteresEspeciales
 */

public class B_probadorCaracteresEspeciales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String[] setCaracteres = {"UTF-8","ISO-8859-1","ISO-8859-7"};
	private static int iSetCaracteres = 0;
	private MonitorHilos monitorHilos = new MonitorHilos();

       
     public B_probadorCaracteresEspeciales() {    	 
        super();
        System.out.println("****** CONSTRUCTOR B_probadorCaracteresEspeciales() ******");
    }

     
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		super.service(arg0, arg1);
        System.out.println("****** service() ******");
		
	}


	@Override
	public void destroy() {
		super.destroy();
        System.out.println("****** destroy(): Servlet a punto de morir... ******");
	}


	@Override
	public void init() throws ServletException {
		super.init();
        System.out.println("****** init(): Servlet inicializ�ndose... ******");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.monitorHilos.contabilizarPeticionActual();
		if(request.getParameter("hilos")!=null){
			this.monitorHilos.mostrarEstadisticas();
		}
				
		
		if(iSetCaracteres==setCaracteres.length)
			iSetCaracteres=0;
		response.setContentType("text/html;charset="+setCaracteres[iSetCaracteres]);
		PrintWriter salidaParaNavegador = response.getWriter();
		String docType =
			"<!doctype html>";
		salidaParaNavegador.println(docType +"<html>\n" + "<head>");
		salidaParaNavegador.println("<title>B_probadorCaracteresEspeciales</title>");
		

		salidaParaNavegador.println("<meta charset=\""+setCaracteres[iSetCaracteres]+"\"/>");

		salidaParaNavegador.println("</head>\n<body>");
		
		salidaParaNavegador.println("<h1>Efecto del set de caracteres \""+setCaracteres[iSetCaracteres]+"\" </h1>" );	
		
		salidaParaNavegador.println("<h2>Vocales con acento </h2>" );	
		salidaParaNavegador.println("<h3>A con acento: � �rbol</h3>" );
		salidaParaNavegador.println("<h3>E con acento: � �rase</h3>" );
		salidaParaNavegador.println("<h3>I con acento: � �ndice</h3>" );
		salidaParaNavegador.println("<h3>O con acento: � �rale</h3>" );
		salidaParaNavegador.println("<h3>U con acento: � �ltimo</h3>" );
		salidaParaNavegador.println("<h3>a con acento: � Sof�</h3>" );
		salidaParaNavegador.println("<h3>e con acento: � S�ptimo</h3>" );
		salidaParaNavegador.println("<h3>i con acento: � Ca�er�a</h3>" );
		salidaParaNavegador.println("<h3>o con acento: � Rat�n</h3>" );
		salidaParaNavegador.println("<h3>u con acento: � Rag�</h3>" );
		salidaParaNavegador.println("<p><hr>"); // otro p�rrafo + linea horizontal

		salidaParaNavegador.println("<h2>Vocales con acento usando notaci&oacuten &</h2>" );	
		salidaParaNavegador.println("<h3>A con acento: &Aacute; &Aacute;rbol</h3>" );
		salidaParaNavegador.println("<h3>E con acento: &Eacute; &Eacute;rase</h3>" );
		salidaParaNavegador.println("<h3>I con acento: &Iacute &Iacutendice</h3>" );
		salidaParaNavegador.println("<h3>O con acento: &Oacute &Oacuterale</h3>" );
		salidaParaNavegador.println("<h3>U con acento: &Uacute &Uacuteltimo</h3>" );
		salidaParaNavegador.println("<h3>a con acento: &aacute Sof&aacute</h3>" );
		salidaParaNavegador.println("<h3>e con acento: &eacute S&eacuteptimo</h3>" );
		salidaParaNavegador.println("<h3>i con acento: &iacute Ca&ntildeer&iacutea</h3>" );
		salidaParaNavegador.println("<h3>o con acento: &oacute Rat&oacuten</h3>" );
		salidaParaNavegador.println("<h3>u con acento: &uacute Rag&uacute</h3>" );
		salidaParaNavegador.println("<p><hr>");
		
		salidaParaNavegador.println("<h2>Caracteres especiales &#</h2>" );	
		for (int i=0; i<256;i++){
			salidaParaNavegador.print("("+i+": &#"+i+"),");

		}

		
		salidaParaNavegador.println("\n</body>\n</html>");
		iSetCaracteres++;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
