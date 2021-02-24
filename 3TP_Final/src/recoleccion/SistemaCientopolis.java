package recoleccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ordenadorSTRATEGY.Ordenador;
import proyecto.Proyecto;

public class SistemaCientopolis {
	
	private List <Investigador> investigadores;

	
	public List<Investigador> getInvestigadores() {
		return investigadores;
	}

	public SistemaCientopolis() {
		
		investigadores= new ArrayList<Investigador>();
	}
	
public List <Encuesta>  encuestasFinalizadasDeTodosLosInvestigadores(){
		
		List<Encuesta> finalizadas=new ArrayList<Encuesta>();
		for(Investigador inv : investigadores) {
			finalizadas.addAll(inv.encuestasFinalizadasDeTodosLosProyectos());
		}
		return finalizadas;
	}


public List<Encuesta> encuestasFinalizadasConMayorCantidadDeRespuestas(){
	List<Encuesta> lista=this.encuestasFinalizadasDeTodosLosInvestigadores();
	Collections.sort(lista,new Comparator<Encuesta>() {
		
		@Override
public int compare(Encuesta e1 , Encuesta e2) {
	return e1.cantidadDeRespuestas().compareTo(e2.cantidadDeRespuestas());
		}
	});	
	 Collections.reverse(lista);
		return lista;
	} 

public List<Encuesta> encuestasDisponiblesDelSistema() {
	
	List<Encuesta> encuestas= new ArrayList<Encuesta>();
	for(Proyecto p:proyectosDeTodoElSistema()) {
		encuestas.addAll(p.encuestasDisponibles());
	}
	return encuestas;
}
public List<Proyecto> proyectosDeTodoElSistema() {
	
	List<Proyecto> proyectos= new ArrayList<Proyecto>();
	
	for(Investigador inv:investigadores) {
		
		proyectos.addAll(inv.getProyectos());
	}
	
	return proyectos;
}

public List <Encuesta> ordenarPor(Ordenador unaFormaDeOrden){
	
	return unaFormaDeOrden.ordenar(this);
}

public void agregarInvestigador(Investigador inv) {
	
	this.investigadores.add(inv);
}

}
