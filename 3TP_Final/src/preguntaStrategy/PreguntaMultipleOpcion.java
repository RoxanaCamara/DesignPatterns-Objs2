package preguntaStrategy;

import java.util.ArrayList;
import java.util.List;

import recoleccion.Encuesta;
import respuesta.Respuesta;

public class PreguntaMultipleOpcion extends Pregunta{
     private List<String> opciones;
     
	public PreguntaMultipleOpcion(String tema) {
		super(tema);
		opciones = new ArrayList<String>();
	}
	
	
	public void agregarOpcion(String opcion) {
		this.opciones.add(opcion);
	}
	public List<String> opciones() {
		return this.opciones;
	}
	
	


	@Override
	public void respuestaPermitida(Respuesta r, Encuesta e) throws Exception {
		  if(this.opciones().containsAll(r.respuestas())) {
			  e.manejador().responderDeBasica(e, r);
			  this.notificar(e, r);
		  }
		  else {
			  throw new Exception ("respuesta invalida");
		  }
		
	}
}
