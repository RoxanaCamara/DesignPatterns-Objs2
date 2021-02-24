package publicaciones.notificaciones;

import java.util.ArrayList;
import java.util.List;

import publicaciones.entidades.IArticulo;
import publicaciones.entidades.ILaboratorio;

public class NotificacionPorAutores extends Notificacion{
	
	/*
	 * Segun el conjunto de autores que se componen son iguales a los pasados se emitira la notificacion
	 * */
	
	
	 private List<String> autores = new ArrayList<String>();

	public NotificacionPorAutores(ILaboratorio laboratorio, List<String> autores) {
		super(laboratorio);
		this.autores = autores;
	}

	@Override
	public String notificacion(IArticulo articulo) {
		if( this.existeEn(autores, articulo.getAutores())   ) {
			return "EY! Tu autor Favorito saco un nuevo Articulo!";
		}	
		return "No es de interes";
	}
	
}
