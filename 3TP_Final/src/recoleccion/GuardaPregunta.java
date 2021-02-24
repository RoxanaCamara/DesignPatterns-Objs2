package recoleccion;

import preguntaStrategy.Pregunta;

public class GuardaPregunta {
   private Pregunta p;
   private boolean tienePregunta;
   
   public GuardaPregunta() {
	    this.tienePregunta = false;
   }
   
   public void guardar(Pregunta p) {
	   this.p = p;
	   this.tienePregunta=true;
   }
   
   public boolean tienePregunta() {
	   return this.tienePregunta;
   }
   public void tienePregunta(boolean f) {
	   this.tienePregunta = f;
   }
   public Pregunta damePregunta() {
	    return this.p;
   }
}
