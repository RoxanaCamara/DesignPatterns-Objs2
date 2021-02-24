package respuesta;

import java.util.List;

import preguntaStrategy.Pregunta; 

public abstract class Respuesta {
  
   private Pregunta preguntaQueRespondio;
   
   public Respuesta() {
	}
   public abstract void agregarRespuesta(String res);

   
   public abstract String respuesta() ;

   public abstract List<String> respuestas();
   
   public Pregunta preguntaQueRespondio() {
	   return this.preguntaQueRespondio;
   }
   public void preguntaQueRespondio(Pregunta p) {
	   this.preguntaQueRespondio = p;
   }
}
