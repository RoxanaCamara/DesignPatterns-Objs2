package publicaciones.notificardor;

import java.util.ArrayList;
import java.util.List;
import publicaciones.entidades.IArticulo;
import publicaciones.notificaciones.INotificador;

public class GestorDeNotificaciones {
	
	 private List<INotificador> observadores = new ArrayList<INotificador>();
		
	public void notificar(IArticulo articulo) {
		for(INotificador obs : observadores ) {
			obs.notificacion(articulo);
		}
	}

	public List<INotificador> getObservadores() {
		return observadores;
	}

	public void addObservador(INotificador observador) {
		this.observadores.add(observador);
	}

	public void removeObservador(INotificador observador) {
		this.observadores.remove(observador);
	}
	
}
