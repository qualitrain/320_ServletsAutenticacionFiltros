package qtx.servlets;
import jakarta.servlet.http.*;

import java.io.*;

import jakarta.servlet.*;


public class A_probadorHtmlBasico extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2488086466929236395L;
	protected String saludo;
	protected String contenidoParrafo1;
	protected String contenidoParrafo2;
	protected int tamano=0;
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		/**************************************************
		 * Áreas de interés:estructura básica de un documento
		 * html. Inicio y final de etiquetas. Los caracteres 
		 * especiales.
		 ***************************************************/
		// Antes de escribir !!!
			response.setContentType("text/html");
			
			PrintWriter salidaParaNavegador = response.getWriter();
			String docType =
				"<!DOCTYPE HTML >";
			salidaParaNavegador.println(docType +
				"<HTML>\n" +
				"<HEAD>\n<TITLE>A_probadorHtmlBasico</TITLE>\n</HEAD>\n"+
				"<BODY>\n");
			if (this.tamano == 5)
				this.tamano=1;
			else
				this.tamano++;
			String etiquetaHtmlHeader = "H"+tamano;
			this.saludo="<"+etiquetaHtmlHeader+">" 
					+ "Hooola en HTML!!!" + "con &lt"+ etiquetaHtmlHeader
					+"&gt </"+etiquetaHtmlHeader+">";
			this.contenidoParrafo1="Este es nuestro primer parrafo (sin acento intencionalmente) ";
			this.contenidoParrafo2="Este es nuestro segundo parrafo (sin acento intencionalmente) ";
			
			salidaParaNavegador.println(saludo);
			salidaParaNavegador.println("<p>");
			for (int i=0;i<this.tamano;i++){
				salidaParaNavegador.println(this.contenidoParrafo1);
			}
			salidaParaNavegador.println("</p>");
			salidaParaNavegador.println("<p>");
			for (int i=0;i<this.tamano;i++){
				salidaParaNavegador.println(this.contenidoParrafo2);
			}
			salidaParaNavegador.println("</p>");
			salidaParaNavegador.println("</BODY>\n</HTML>");
			} 

}
