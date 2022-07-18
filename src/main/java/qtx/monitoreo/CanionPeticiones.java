package qtx.monitoreo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CanionPeticiones {
		public static final String PROTOCOLO = "http";
		public static final String IP = "localhost";
		public static final String PUERTO = "8081";
		public static final String RECURSO = "ProbadorHtml/HtmlB";
		public static final boolean MOSTRAR_RESPUESTA = false;
	public static void main(String[] args) {
		String cadUrl = PROTOCOLO + "://" + IP + ":" + PUERTO + "/" + RECURSO;
		URL url = null;
		try {
//			url = new URL("http://localhost:8080/ProbadorHtml/HtmlB");
			url = new URL(cadUrl);
		} 
		catch (MalformedURLException e) {
			System.out.println("MalformedURLException");
		}
		 System.out.println("URL1: " + url.toString());
		 bombardearURL(url,1000L);

	}
	public static void bombardearURL(URL url, long nPeticiones){
		for(long i=0; i<nPeticiones; i++){
			 generarPeticion(url);
			 if(i%1000==0){
				 System.out.print(i+",");
			 }
		}
	}
	public static void generarPeticion(URL url){
		
		 try{
			 InputStream urlStream = url.openStream();
			 BufferedReader brUrlStream = 
					 new BufferedReader(
					     new InputStreamReader(urlStream));
			 
			 if(MOSTRAR_RESPUESTA){
				 System.out.println("Contenido de Url Stream:");
			 }
			 while(true){
				 String linea = brUrlStream.readLine();
				 if(linea==null){
					 if(MOSTRAR_RESPUESTA){
						 System.out.println("Fin del flujo");
					 }
					 break;
				 }
				 if(MOSTRAR_RESPUESTA){
					 System.out.println(linea);					 
				 }
			 }
			 
		 }catch(Exception ex){
			 System.out.println("Exception:"+ex.getClass().getSimpleName());
		 }

	}
}
