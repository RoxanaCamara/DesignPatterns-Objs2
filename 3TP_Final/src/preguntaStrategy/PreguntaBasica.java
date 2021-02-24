package preguntaStrategy;

import recoleccion.Encuesta;
import respuesta.Respuesta;

public class PreguntaBasica extends Pregunta {
    
	
	public PreguntaBasica(String tema) {
		super(tema);
	}
	
	
	
	@Override
	public void respuestaPermitida(Respuesta r,Encuesta e) throws Exception{
		
		e.manejador().responderDeBasica(e, r);
	    this.notificar(e, r);
	}

}
