package publicaciones.notificaciones;

import java.util.ArrayList;
import java.util.List;

import publicaciones.entidades.IArticulo;
import publicaciones.entidades.ILaboratorio;

public class NotificacionPorTipoDeArticulo extends Notificacion{

	private List<String> tipoDeArticulo = new ArrayList<String>();
	
	public NotificacionPorTipoDeArticulo(ILaboratorio laboratorio,String string) {
		super(laboratorio);
		this.tipoDeArticulo.add(string);	
	}

	@Override
	public String notificacion(IArticulo articulo) {
		if(this.existeEn(tipoDeArticulo,articulo.getTipoDeArticulo() )) {
			return "Ey! esta publicacion es del tipo de tu interes";		
		}
		return "No es de inter`es";		
	}

}
