package respuesta;

import java.util.List;

public class RespuestaBasicaYBifurcada extends Respuesta{
   private String respuesta;
	public RespuestaBasicaYBifurcada() {
	    
   }

   @Override
   public void agregarRespuesta(String res) {
         this.respuesta=res;	
   }

   @Override
   public String respuesta() {
	
	return this.respuesta;
   }

   @Override
   public List<String> respuestas() {
	return null;
   }
}
