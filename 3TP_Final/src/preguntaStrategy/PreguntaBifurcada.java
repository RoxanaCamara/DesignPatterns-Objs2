package preguntaStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import recoleccion.Encuesta;
import respuesta.Respuesta;

public class PreguntaBifurcada extends Pregunta{
    private Map<String,Pregunta> preguntasPosibles;
    
    public PreguntaBifurcada(String tema) {
    	 super(tema);
    	 preguntasPosibles= new HashMap<String,Pregunta>();
    }
    
    public void agregarPreguntaAOpcion(Pregunta p,String opcion) {
    	this.preguntasPosibles.put(opcion, p);
    }
    
    public Set<String> opciones(){
    	return this.preguntasPosibles.keySet();
    }
    @Override
    public Pregunta preguntaSiguiente(Respuesta r) {
    	return this.preguntasPosibles.get(r.respuesta());
    }
 



	@Override
	public Pregunta esBifurcada(Encuesta e) throws Exception {
		return e.manejador().preguntaSiguienteDeBifurcada(e);
	}

	@Override
	public void respuestaPermitida(Respuesta r, Encuesta e) throws Exception {
        if(this.opciones().contains(r.respuesta())) {
        	e.manejador().responderDeBifurcada(e, r);
        	this.notificar(e, r);
        }
        else {
        	throw new Exception("respuesta invalida");
        }
	}
    
   
} 
