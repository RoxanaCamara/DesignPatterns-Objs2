package ordenadorSTRATEGY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import proyecto.Proyecto;
import recoleccion.Encuesta;
import recoleccion.SistemaCientopolis;

public class OrdenadorPorProyectos implements Ordenador {


	
	

	public List <Proyecto> proyectosOrdenadosAlfabeticamente(SistemaCientopolis sistema){
		
		List <Proyecto> proyectos= sistema.proyectosDeTodoElSistema();
		Collections.sort(proyectos,new Comparator<Proyecto>() {

			@Override
			public int compare(Proyecto p1, Proyecto p2) {
				
				return p1.getNombre().compareTo(p2.getNombre()) ;
			}
			});	
		
			return proyectos;
		} 

	@Override
	public List<Encuesta> ordenar(SistemaCientopolis sistema) {
		
		List<Encuesta> encuestas= new ArrayList<Encuesta>();
		for(Proyecto p:proyectosOrdenadosAlfabeticamente(sistema)) {
			encuestas.addAll(p.encuestasDisponibles());
		}
		return encuestas;
	}
}