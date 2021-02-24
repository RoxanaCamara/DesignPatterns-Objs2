package ordenadorSTRATEGY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import proyecto.Proyecto;
import recoleccion.Encuesta;
import recoleccion.SistemaCientopolis;

public class OrdenadorPorCantidadDeUsos implements Ordenador {

	@Override
	public List<Encuesta> ordenar(SistemaCientopolis sistema) {
		List<Encuesta> encuestas= new ArrayList<Encuesta>();
		
	   for(Encuesta e : this.encuestasDeUsos(sistema)) {
		 if(encuestas.size()<25) {
		   encuestas.add(e);
	   }
	   }
	   return encuestas;
	}

	public List<Encuesta> encuestasDeUsos(SistemaCientopolis sistema){
		List<Encuesta> encuestas= new ArrayList<Encuesta>();
		for(Proyecto p:ordenDeUsos(sistema)) {
			
		encuestas.addAll(p.encuestasDisponibles());
		}
		return encuestas;
	}
	
	public List<Proyecto> ordenDeUsos(SistemaCientopolis sistema){
	List<Proyecto> lista=sistema.proyectosDeTodoElSistema();
	Collections.sort(lista,new Comparator<Proyecto>() {
		
		@Override
public int compare(Proyecto e1 , Proyecto e2) {
	return e1.cantidadDeEncuestas().compareTo(e2.cantidadDeEncuestas());
		}
	});	
	 Collections.reverse(lista);
		return lista;
	} 
	
}
