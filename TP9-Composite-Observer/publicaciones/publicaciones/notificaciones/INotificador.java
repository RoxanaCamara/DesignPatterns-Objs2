 package publicaciones.notificaciones;

import publicaciones.entidades.IArticulo;

public interface INotificador {
	
	public String notificacion(IArticulo articulo);

}