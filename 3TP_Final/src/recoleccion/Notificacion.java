package recoleccion;

import preguntaStrategy.Pregunta;
import respuesta.Respuesta;

public class Notificacion {
   private Pregunta p;
   private Respuesta r;
   private Encuesta e;
   
   public Notificacion(Pregunta p,Respuesta r,Encuesta e) {
	   this.e = e;
	   this.p = p;
	   this.r = r;
   }
}
