package recoleccion;

import java.util.ArrayList;
import java.util.List;

import preguntaStrategy.Pregunta;


public class ProtocoloEncuesta {
    private List<Pregunta> preguntas;
    
    public ProtocoloEncuesta() {
    	this.preguntas = new ArrayList<Pregunta>();
    }
    
    public void agregarPregunta(Pregunta p) {
    	this.preguntas.add(p);
    }
    public List<Pregunta> preguntas(){
    	return this.preguntas;
    }
    


    

}
