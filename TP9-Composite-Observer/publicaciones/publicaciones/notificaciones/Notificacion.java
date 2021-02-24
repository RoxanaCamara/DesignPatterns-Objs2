package publicaciones.notificaciones;

import java.util.List;

import publicaciones.entidades.ILaboratorio;

public abstract class Notificacion implements INotificador{
	
	protected ILaboratorio laboratorio;

	public Notificacion(ILaboratorio laboratorio) {
		super();
		this.laboratorio = laboratorio;
	}

	public ILaboratorio getLaboratorio() {
		return laboratorio;
	}
	
	protected boolean existeEn(List<String> list1 ,List<String> list2) {
		return list1.stream().allMatch( a -> this.existeEn(list2, a));
	}
	
	protected boolean existeEn(List<String> list1, String list2) {
		return list1.stream().anyMatch(s -> s.equals(list2));
	}

}
