package state;

import recoleccion.Encuesta;
import respuesta.Respuesta;

public class Cerrada implements Estado{

	public Cerrada() {
		
	}

	@Override
	public void cambia(Encuesta e) {
		
		
	}

	@Override
	public void responder(Respuesta r, Encuesta e) throws Exception {
	     throw new Exception("esta cerrada la encuesta");
		
	}

	@Override
	public boolean tieneDisponibilidad() {
		
		return false;
	}

}
