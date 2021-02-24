package encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;
import encuentrosDeportivos.tipoSuscripciones.Suscripto;

public class GestorNotificacionesPartido {
	 private List<Suscripto> observadores = new ArrayList<Suscripto>();
	
	void notificarNuevoPartido(Partido partido) {
		for(Suscripto obs : observadores) {
			obs.nuevaNoticia(partido);
		}
	}

	public void agregarSuscriptor(Suscripto suscripcion) {
		observadores.add(suscripcion);	
	}
	
	public void eliminarSuscriptor(Suscripto suscripcion) {
		observadores.remove(suscripcion);
	}
	

}
