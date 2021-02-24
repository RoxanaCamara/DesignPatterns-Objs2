package preguntaStrategy;


import java.util.ArrayList;
import java.util.List;

public abstract class Pregunta {
     private String tema;
     private List<Investigador> observadores;
     private boolean notificar;
     
	public Pregunta(String string) {
	   this.tema = string;
	   this.observadores = new ArrayList<Investigador>();
	}
	
	public String leer() {
		return this.tema;
	}
	public void setNotificar(boolean v) {
		this.notificar = v;
	}
	public boolean getNotificar() {
		return this.notificar;
	}
    public void agregarObservador(Investigador investigador) {
        this.observadores.add(investigador);
    }
	
    public void notificar(Encuesta e,Respuesta r) {
    	if(this.getNotificar()) {
    		for(Investigador i:this.observadores) {
    			i.notificacion(this, r, e);
    		}
    	}
    }
	public abstract void respuestaPermitida(Respuesta r,Encuesta e) throws Exception;

	public  Pregunta preguntaSiguiente(Respuesta r) {
		return null;
	}
	
	public  Pregunta esBifurcada(Encuesta e) throws Exception{
		return e.manejador().preguntaSiguienteDeBasica(e);
	}

}
