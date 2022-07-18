package qtx.monitoreo;

import java.util.Hashtable;
import java.util.Map;

public class MonitorHilos {
	private Map<Long,Long> peticionesXhilo;
	private static int nMonitores = 0;
	
	public MonitorHilos(){
		this.peticionesXhilo = new Hashtable<Long,Long>();
		nMonitores++;
	}
	public void contabilizarPeticionActual(){
		Thread hiloActual = Thread.currentThread();
		long idHiloActual = hiloActual.getId();
//		System.out.println("Hilo actual (hash code):"+hashCodeHiloActual+", Id="+idHiloActual);
		
		if(this.peticionesXhilo.containsKey(idHiloActual)){
			long nPeticiones = this.peticionesXhilo.get(idHiloActual);
			nPeticiones++;
			this.peticionesXhilo.put(idHiloActual,nPeticiones);
		}
		else
			this.peticionesXhilo.put(idHiloActual, 1L);
	}
	public void mostrarEstadisticas(){
		System.out.println("============ Estadísticas x Hilo ===========");
		System.out.println("Hilos totales: " + this.peticionesXhilo.size());
		long totalPeticiones=0L;
		for(Long idHiloI:this.peticionesXhilo.keySet()){
			long nPeticionesAtendidasI = this.peticionesXhilo.get(idHiloI);
			totalPeticiones+=nPeticionesAtendidasI;
			System.out.println("El Hilo " + idHiloI + " atendi� " + nPeticionesAtendidasI + " peticiones");			
		}
		System.out.println("Total de peticiones atendidas:" + totalPeticiones);
		System.out.println("Monitores creados:"+MonitorHilos.nMonitores);
	}
}
