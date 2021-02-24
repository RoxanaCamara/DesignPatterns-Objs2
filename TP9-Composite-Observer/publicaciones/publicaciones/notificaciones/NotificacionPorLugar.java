package publicaciones.notificaciones;

import java.util.List;

import publicaciones.entidades.IArticulo;
import publicaciones.entidades.ILaboratorio;

public class NotificacionPorLugar extends Notificacion {

	private List<String> lugar;

	public NotificacionPorLugar(ILaboratorio laboratorio,String lugar) {
		super(laboratorio);
		this.lugar.add(lugar);
	}

	@Override
	public String notificacion(IArticulo articulo) {
		if(this.existeEn(lugar, articulo.getLugarDePublicacion())) {
			return "Ey! esta publicacion es de un lugar de tu interes";		
		}
		return "No es de interes";		
	}

	
}
