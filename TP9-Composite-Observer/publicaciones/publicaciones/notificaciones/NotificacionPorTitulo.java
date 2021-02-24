package publicaciones.notificaciones;

import java.util.ArrayList;
import java.util.List;

import publicaciones.entidades.IArticulo;
import publicaciones.entidades.ILaboratorio;

public class NotificacionPorTitulo extends Notificacion {
	
	private List<String> titulos = new ArrayList<String>();
	
	public NotificacionPorTitulo(ILaboratorio laboratorio, String titulo) {
		super(laboratorio);
		this.titulos.add(titulo);
	}

	@Override
	public String notificacion(IArticulo articulo) {
		if(this.existeEn(titulos, articulo.getTipoDeArticulo())) {
			return "Ey! esta publicacion tiene un titulo de tu interes";		
		}
		return "No es de interes";		
	}

}
