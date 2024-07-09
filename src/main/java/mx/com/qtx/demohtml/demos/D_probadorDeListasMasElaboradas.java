package mx.com.qtx.demohtml.demos;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class D_probadorDeListasMasElaboradas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String[] dias = {"Lunes","Martes","Miercoles","Jueves",
    	"Viernes","Sábado","Domingo"};
    private static String[] descripcionDias = {"Primer día laboral de la semana, a veces de cruda",
    			"Segundo día laboral de la semana",
    			"Mitad de la semana laboral, día de cine",
    			"También conocido como Jue-bebes, cerca el descanso y la pachanga",
    			"Último día laboral de la semana. Día social, Casual(Fachual) day",
    			"Dia de descanso y diversión",
    			"Día para descansar del sábado. Familiar por definición"};
    private static String[] turnos={"Matutino","Vespertino","Nocturno"};
    private static int iTipoLista=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter salidaParaNavegador = response.getWriter();
		
		String docType = "<!doctype html>";
		salidaParaNavegador.println(docType +"<html>\n" + "<head>");
		salidaParaNavegador.println("<title>D_probadorDeListasMasElaboradas</title>");
		salidaParaNavegador.println("<meta charset=\"ISO-8859-1\"/>");
		salidaParaNavegador.println("</head>\n<body>");
		
		if(iTipoLista == 5)
			iTipoLista=0;
		
		switch (iTipoLista){
		case 0:
			this.dibujaListaDeDefiniciones(salidaParaNavegador);
			break;
		case 1:
			this.dibujaListaAnidada(salidaParaNavegador);
			break;
		default:
			this.dibujarListaConMasMargenes(salidaParaNavegador, iTipoLista);
			break;
		}
		salidaParaNavegador.println("\n</body>\n</html>");
		iTipoLista++;
	}
	private void dibujaListaDeDefiniciones(PrintWriter salidaParaNavegador){
		salidaParaNavegador.println("<h2>Lista de definiciones </h2>");
		salidaParaNavegador.println("<dl>");
		for(int i=0;i<dias.length;i++){
			salidaParaNavegador.println("<dt>"+dias[i]+"</dt>");
			salidaParaNavegador.println("<dd>"+descripcionDias[i]+"</dd>");
		}
		salidaParaNavegador.println("</dl>");
	}
	private void dibujaListaAnidada(PrintWriter salidaParaNavegador){
		salidaParaNavegador.println("<h2>Lista anidada </h2>");
		salidaParaNavegador.println("<ol>");
		for(int i=0;i<dias.length;i++){
			salidaParaNavegador.println("<li><b>"+dias[i]+"</b></li>");
			salidaParaNavegador.println("<ul>\n");	
			for(int k=0;k<turnos.length;k++){
				salidaParaNavegador.println("<li>"+turnos[k]+"</li>");
			}
			salidaParaNavegador.println("</ul>");
		}
		salidaParaNavegador.println("</ol>");
	}
	private void dibujarListaConMasMargenes(PrintWriter salidaParaNavegador, int margen){
		salidaParaNavegador.println("<h2>Lista con "+margen+ " margenes </h2>");
		salidaParaNavegador.println("<ul>");
		for(int i=0;i<dias.length;i++){
			for(int k=0;k<margen;k++){
				salidaParaNavegador.println("<ul>");
			}
			salidaParaNavegador.println("<li>"+dias[i]+"</li>");
			for(int k=0;k<margen;k++){
				salidaParaNavegador.println("</ul>");
			}

		}
		salidaParaNavegador.println("</ul>");
	}
}
