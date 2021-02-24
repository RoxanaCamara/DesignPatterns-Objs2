package empleado;

public class EmpleadoPasante extends Empleado{

	private Integer horasTrabajadas;
			
	public EmpleadoPasante(Integer horasTrabajadas) {
		super();
		this.horasTrabajadas = horasTrabajadas;
	}

	@Override
	protected Integer getSueldoBruto() {
		return this.getHorasTrabajadas() * 40;
	}

	private Integer getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

	public void setHorasTrabajadas(Integer horas) {
		this.horasTrabajadas = horas;
	}
	

}
