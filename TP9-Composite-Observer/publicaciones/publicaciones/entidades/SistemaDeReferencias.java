package publicaciones.entidades;

import java.util.ArrayList;
import java.util.List;

import publicaciones.notificardor.GestorDeNotificaciones;

public class SistemaDeReferencias {
	
	private GestorDeNotificaciones gestorDeNotificaciones;
	private List<IArticulo> articulos = new ArrayList<IArticulo>();
	 
	public void nuevoIArticulo(IArticulo iObservado) {
		this.getGestorDeNotificaciones().notificar(iObservado);
		this.setArticulo(iObservado);
	} 	
	
	public GestorDeNotificaciones getGestorDeNotificaciones() {
		return gestorDeNotificaciones;
	}
	public void setGestorDeNotificaciones(GestorDeNotificaciones gestorDeNotificaciones) {
		this.gestorDeNotificaciones = gestorDeNotificaciones;
	}


	public List<IArticulo> getArticulos() {
		return articulos;
	}

	public void setArticulo(IArticulo articulos) {
		this.articulos.add(articulos);
	}

}
