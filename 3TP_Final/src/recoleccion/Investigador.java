package recoleccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import preguntaStrategy.Pregunta;
import proyecto.Proyecto;
import respuesta.Respuesta;

public class Investigador {
    private List<Notificacion> notificaciones;
	private Integer identificacion;
	private String nombre;
	private List <Proyecto> proyectos;

	public Integer getIdentificacion() {
		return identificacion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public Investigador(Integer identificacion, String nombre) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		proyectos= new ArrayList<Proyecto>();
		this.notificaciones = new ArrayList<Notificacion>();
	}
	
	
	public List <Encuesta>  encuestasFinalizadasDeTodosLosProyectos(){
		
		List<Encuesta> finalizadas=new ArrayList<Encuesta>();
		for(Proyecto p : proyectos) {
			finalizadas.addAll(p.encuestasFinalizadas());
		}
		return finalizadas;
	}

	
	 public void  agregarProyecto(Proyecto proyecto){
		  proyectos.add(proyecto);
	  }
	 
	 public void notificacion(Pregunta p,Respuesta r, Encuesta e) {
		 this.notificaciones.add(new Notificacion(p,r,e));
	 }
	 
	 public List<Notificacion> notificaciones(){
		 return this.notificaciones;
	 }
	
}
