package proyecto;

import java.util.ArrayList;
import java.util.List;

import recoleccion.Encuesta;

public abstract class  Proyecto {
	 
	  private List<Encuesta> encuestas;
	  protected String nombre;
	  
	  public Proyecto(String nombre) {
	       this.encuestas = new ArrayList<Encuesta>();
	       this.nombre=nombre;
	  }
	  
	  
	  //al agregar la encuesta el protocolo ya debe estar finalizado por que 
	  //la encuesta se crea con ese protocolo
	 
	  public void agregarEncuesta(Encuesta e) {
		 
		  this.encuestas.add(e);
	  }

	  public List <Encuesta> encuestasFinalizadas(){
			
			List <Encuesta> lista= new ArrayList<Encuesta>();
			for(Encuesta encuesta:encuestas) {
				
				if(encuesta.estaTerminada()) {
					
					lista.add(encuesta) ;
				}
			}
			return lista;
		}
		
		
		
	  public List<Encuesta> encuestasDisponibles() {
			List <Encuesta> lista= new ArrayList<Encuesta>();
			for(Encuesta encuesta:encuestas) {
				
				if(!encuesta.estaTerminada()&& encuesta.presentaDisponibilidad()) {
					
					lista.add(encuesta) ;
				}
			}
			return lista;
	   }


	protected abstract boolean puedoAgregarSubproyecto(Proyecto proyecto);


	protected abstract void quitarSubproyecto(Proyecto p);

	
	public abstract void agregarSubproyecto(Proyecto p) ;
	public String getNombre() {
		return this.nombre;
	}


	public Integer cantidadDeEncuestas() {
		
		return encuestas.size();
	}


	public List<Encuesta> getEncuestas() {
		
		return this.encuestas;
	}
	   
	}
  
  
  

