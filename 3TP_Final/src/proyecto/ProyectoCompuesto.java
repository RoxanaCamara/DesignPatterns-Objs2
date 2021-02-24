package proyecto;

import java.util.ArrayList;
import java.util.List;

import recoleccion.Encuesta;

public class ProyectoCompuesto extends Proyecto{
    private List<Proyecto> subproyectos;
	public ProyectoCompuesto(String nombre) {
	   super(nombre);
	   this.subproyectos = new ArrayList<Proyecto>();
   }
	public List<Proyecto> subproyectos(){
		return this.subproyectos;
	}
	@Override
	public void agregarSubproyecto(Proyecto p) {
		 if(p.puedoAgregarSubproyecto(this)) {
		    this.subproyectos.add(p);	 
		 }
	}
	@Override
	public boolean puedoAgregarSubproyecto(Proyecto proyecto) {
		  boolean puede = this.subproyectos.contains(proyecto);
		  for(Proyecto p :this.subproyectos) {
			  puede= puede&& p.puedoAgregarSubproyecto(proyecto);
		  }
		return !puede;
	}
	@Override
	public void quitarSubproyecto(Proyecto p) {
		this.subproyectos.remove(p);
		for(Proyecto proyec:this.subproyectos) {
			proyec.quitarSubproyecto(p);
		}
	}
	@Override
	public List<Encuesta> encuestasFinalizadas() {
		List <Encuesta> l= super.encuestasFinalizadas();
		for(Proyecto p:this.subproyectos) {
			l.addAll(p.encuestasFinalizadas());
		}
		return l;
	}
	@Override
	public List<Encuesta> encuestasDisponibles(){
		List<Encuesta> l =super.encuestasDisponibles();
		for(Proyecto p:this.subproyectos) {
			l.addAll(p.encuestasDisponibles());
		}
		return l;
		
	}
}
