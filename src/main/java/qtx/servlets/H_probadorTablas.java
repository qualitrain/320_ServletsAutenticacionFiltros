package qtx.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import qtx.util.tablas.Tabla;

public class H_probadorTablas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int numPeticion = 0;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter salidaParaNavegador = response.getWriter(); 
		
		String docType = "<!doctype html>";
		salidaParaNavegador.println(docType +"<html>\n" + "<head>");
		salidaParaNavegador.println("<title>H_probadorTablas</title>");
		salidaParaNavegador.println("<meta charset=\"ISO-8859-1\"/>");
		salidaParaNavegador.println("</head>\n<body>");

		if(numPeticion==4)
			numPeticion=0;
		Tabla unaTabla=null;
		switch(numPeticion){
		case 0:
			unaTabla = this.generaTablaSimple();
			break;
		case 1:
			unaTabla = this.generaTablaIrregular();
			break;
		case 2:
			unaTabla = this.generaTablaDeImagenes();
			break;
		case 3:
			unaTabla = this.generaTablaDeImagenesYtextos();
			break;
		}
		salidaParaNavegador.println(unaTabla.toHtml());
		
		salidaParaNavegador.println("\n</body>\n</html>");
		numPeticion++;

	}
	private Tabla generaTablaIrregular(){
		Tabla unaTabla = new Tabla("Tabla con celdas irregulares",1,600);
		unaTabla.agregarNrenglones(6);
		unaTabla.agregarColumnaDeTitulo("Título de doble renglón y columna", 0, 2,2);
		unaTabla.agregarColumnaDeTitulo("Tit Simple", 0, 1,1);
		unaTabla.agregarColumnaDeTitulo("&nbsp", 1, 1,1);
		int numRenglon=2;
		for (int i=1; i<=(3*3);i++){
			unaTabla.agregarColumna(Integer.toString(i*5), numRenglon, 1,1);
			if (i%3==0) 		// Cada 3 columnas cambia de renglón
				numRenglon++;
		}
		unaTabla.agregarColumna(Integer.toString(100), 5, 1,2);
		unaTabla.agregarColumna(Integer.toString(200), 5, 2,1);
		return unaTabla;
	}
	private Tabla generaTablaSimple(){
		Tabla unaTabla = new Tabla("Tabla Ejemplo",1,300);
		unaTabla.agregarNrenglones(5);
		unaTabla.agregarColumnaDeTitulo("Título 1", 0, 1,1);
		unaTabla.agregarColumnaDeTitulo("Titulo 2", 0, 1,1);
		unaTabla.agregarColumnaDeTitulo("Titulo 3", 0, 1,1);
		int numRenglon=1;
		for (int i=1; i<=(3*4);i++){
			unaTabla.agregarColumna(Integer.toString(i*50), numRenglon, 1,1);
			if (i%3==0) 		// Cada 3 columnas cambia de renglón
				numRenglon++;
		}
		return unaTabla;
	}
	private Tabla generaTablaDeImagenes(){
		Tabla unaTabla = new Tabla("Tabla de Imágenes",10,400);
		unaTabla.agregarNrenglones(2);
		unaTabla.agregarColumna("<img src=\"imagenes/snoopy.JPG\"   width=300 height=360/>", 0, 1, 1);
		unaTabla.agregarColumna("<img src=\"imagenes/gato.gif\"     width=300 height=360/>", 0, 1, 1);
		unaTabla.agregarColumna("<img src=\"imagenes/osoPolar.jpg\" width=300 height=360/>", 1, 1, 1);
		unaTabla.agregarColumna("<img src=\"imagenes/desierto.jpg\" width=300 height=360/>", 1, 1, 1);
		
		return unaTabla;
	}
	
	private Tabla generaTablaDeImagenesYtextos(){
		Tabla unaTabla = new Tabla("Tabla de Imágenes con textos",1,300);
		unaTabla.agregarNrenglones(5);
		unaTabla.agregarColumna("Un perro muy famoso", 0, 1, 1);
		unaTabla.agregarColumna("Un gato muy loco", 0, 1, 1);
		unaTabla.agregarColumna("<img src=\"imagenes/snoopy.JPG\"   width=150 height=150/>", 1, 1, 1);
		unaTabla.agregarColumna("<img src=\"imagenes/gato.gif\"     width=150 height=150/>", 1, 1, 1);
		
		unaTabla.agregarColumna("<img src=\"imagenes/Arcoiris.jpg\"     width=300 height=100/>", 2, 2, 1);
		
		unaTabla.agregarColumna("Un oso del ártico", 3, 1, 1);
		unaTabla.agregarColumna("Un habitat bastante desolado", 3, 1, 1);
		unaTabla.agregarColumna("<img src=\"imagenes/osoPolar.jpg\" width=150 height=150/>", 4, 1, 1);
		unaTabla.agregarColumna("<img src=\"imagenes/desierto.jpg\" width=150 height=150/>", 4, 1, 1);
		
		return unaTabla;
	}

}
