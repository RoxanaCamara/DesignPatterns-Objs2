package state;

import recoleccion.Encuesta;
import respuesta.Respuesta;

public class EnEdicion implements Estado{
    public EnEdicion() {
    	
    }

	@Override
	public void cambia(Encuesta e) {
          e.setEstado(new Abierta());		
	}

	@Override
	public void responder(Respuesta r, Encuesta e) throws Exception {
		  throw new Exception("esta en edicion");
		
	}

	@Override
	public boolean tieneDisponibilidad() {
		
		return false;
	}

   
}
