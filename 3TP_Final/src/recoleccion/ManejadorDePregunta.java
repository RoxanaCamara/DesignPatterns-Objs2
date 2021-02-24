package recoleccion;

import preguntaStrategy.Pregunta;
import respuesta.Respuesta;

public class ManejadorDePregunta {
	private GuardaPregunta guardador;
	private int nroPreguntaActual;
	
    public ManejadorDePregunta() {
    	this.guardador = new GuardaPregunta();
	    this.nroPreguntaActual=0;
    }  
    

    public Pregunta preguntaActual(Encuesta e) throws Exception{
             if(this.guardador.tienePregunta()) {
            	 return this.guardador.damePregunta();
             }    	
             else if(this.nroPreguntaActual >= e.protocolo().preguntas().size()) {
            	 throw new Exception ("no hay preguntas");
             }
             else {
            	 return e.protocolo().preguntas().get(this.nroPreguntaActual);
             }
    }
 
    
    public Pregunta preguntaSiguiente(Encuesta e) throws Exception {
    	return this.preguntaActual(e).esBifurcada(e);
    }
    
    public Pregunta preguntaSiguienteDeBasica(Encuesta e) throws Exception{
    	if(e.protocolo().preguntas().size() > this.nroPreguntaActual +1  ) {
    	 return e.protocolo().preguntas().get(this.nroPreguntaActual+1);
    	}
    	else {
    		throw new Exception("no hay preguntas");
    	}
    	}
    
    public Pregunta preguntaSiguienteDeBifurcada(Encuesta e) throws Exception{
    	     throw new Exception("la pregunta actual es bifurcada asi q no se"); 
    }
    
    public void responder(Respuesta r,Encuesta e) throws Exception{
    	this.preguntaActual(e).respuestaPermitida(r,e);
    }
    
    public void responderDeBasica(Encuesta e, Respuesta r ) throws Exception{
    	e.agregarRespuesta(r, this.preguntaActual(e));
    	this.nroPreguntaActual ++;
    	this.guardador.tienePregunta(false);
    }
    
    public void responderDeBifurcada(Encuesta e, Respuesta r) throws Exception {
    	e.agregarRespuesta(r, this.preguntaActual(e));
        this.guardador.guardar(this.preguntaActual(e).preguntaSiguiente(r)); 
    }
    
    
 
    public Pregunta preguntaAnterior(Encuesta e) throws Exception{
    	return this.ultimaRespuesta(e).preguntaQueRespondio();
    }
    
    private Respuesta ultimaRespuesta(Encuesta e) throws Exception{
    	   
    		   if(e.respuestas().size() > 0) {
    			   return e.respuestas().get(e.respuestas().size()-1);
    		   }
    		   else {
    			   throw new Exception("no hay respuestas todavia"); 
    		   }
    	   }

    }
    
