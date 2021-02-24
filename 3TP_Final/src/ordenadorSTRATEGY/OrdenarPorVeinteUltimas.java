package ordenadorSTRATEGY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import recoleccion.Encuesta;
import recoleccion.SistemaCientopolis;

public class OrdenarPorVeinteUltimas implements Ordenador{

	@Override
	public List<Encuesta> ordenar(SistemaCientopolis sistema) {
		List<Encuesta> encuestas= new ArrayList<Encuesta>();
		for(Encuesta e:this.ordenarFechas(sistema)) {
			if(encuestas.size()<20) {
				encuestas.add(e);
			}
		}
		return encuestas;
	
	}

	
	public List<Encuesta> ordenarFechas(SistemaCientopolis sistema){
		List<Encuesta> lista=sistema.encuestasDisponiblesDelSistema();
		Collections.sort(lista,new Comparator<Encuesta>() {
			
			@Override
	public int compare(Encuesta e1 , Encuesta e2) {
		return e1.getFechaDeCreacion().compareTo(e2.getFechaDeCreacion());
			}
		});	
		 Collections.reverse(lista);
			return lista;
		} 
}

