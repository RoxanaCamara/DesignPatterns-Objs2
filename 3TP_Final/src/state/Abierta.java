package state;

import recoleccion.Encuesta;
import respuesta.Respuesta;

public class Abierta implements Estado{
   public Abierta() {
	   
   }

   @Override
   public void cambia(Encuesta e) {
	  e.setEstado(new Cerrada());
	
   }

   @Override
   public void responder(Respuesta r, Encuesta e) throws Exception {
	    e.manejador().responder(r, e);
	
    }


@Override
public boolean tieneDisponibilidad() {
	
	return true;
}

}
