package publicaciones.notificaciones;

import java.util.ArrayList;
import java.util.List;

import publicaciones.entidades.IArticulo;
import publicaciones.entidades.ILaboratorio;

public class NotificacionPorClaves extends Notificacion {

	private List<String> claves = new ArrayList<String>();

	public NotificacionPorClaves(ILaboratorio laboratorio, List<String> claves) {
		super(laboratorio);
		this.claves = claves;
	}

	public NotificacionPorClaves(String claves, ILaboratorio laboratorio) {
		super(laboratorio);
		this.claves.add(claves);	}

	@Override
	public String notificacion(IArticulo articulo) {
		if (this.existeEn(claves, articulo.getClaves())  ) {
			return "Ey! Este articulo podria interesarte";
		}
		return "No es de interes";
	}

}
