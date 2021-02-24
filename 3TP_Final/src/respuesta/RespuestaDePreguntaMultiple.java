package respuesta;

import java.util.ArrayList;
import java.util.List;

public class RespuestaDePreguntaMultiple extends Respuesta{
    private List<String> respuestas;
	public RespuestaDePreguntaMultiple() {
        this.respuestas = new ArrayList<String>();
	}
	@Override
	public void agregarRespuesta(String res) {
          this.respuestas.add(res);		
	}
	@Override
	public String respuesta() {
	
		return null;
	}
	@Override
	public List<String> respuestas() {
		
		return this.respuestas;
	}
	
	
}
