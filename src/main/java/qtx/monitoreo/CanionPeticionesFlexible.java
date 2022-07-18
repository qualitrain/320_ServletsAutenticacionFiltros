package qtx.monitoreo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CanionPeticionesFlexible {
		public static final String PROTOCOLO = "http";
		public static final String IP = "localhost";
		public static final String PUERTO = "8090";
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
		 bombardearURL(url,1L);

	}
	public static void bombardearURL(URL url, long nPeticiones){
		for(long i=0; i<nPeticiones; i++){
			 generarPeticion(url);
		}
	}
	public static void generarPeticion(URL url){
		URLConnection conexion = null;
		try {
			conexion = url.openConnection();
			conexion.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 "
					+ "Firefox/49.0 Accept: */*");
			conexion.setRequestProperty("Host", "198.23.4.56:8090");
			conexion.connect();
			 InputStream urlStream = conexion.getInputStream();
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
			 ex.printStackTrace();
		 }

	}
}
