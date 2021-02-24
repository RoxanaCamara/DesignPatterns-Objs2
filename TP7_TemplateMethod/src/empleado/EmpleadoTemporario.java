package empleado;

public class EmpleadoTemporario extends Empleado{
	
	private Integer sueldoBasico;
	private boolean hijosOCasado;
	private Integer horas;
	
	public EmpleadoTemporario(Integer sueldoBasico, boolean hijosOCasado, Integer horas) {
		super();
		this.sueldoBasico = sueldoBasico;
		this.hijosOCasado = hijosOCasado;
		this.horas = horas;
	}

	@Override
	protected Integer getSueldoBruto() {
		return this.getSueldoBasico() + ((this.hijosOCasado)?100:0) + (horas * 5);
	}

	public boolean tieneHijosOEstaCasado(boolean b) {
		return hijosOCasado= b;
	}

	private Integer getSueldoBasico() {
		return this.sueldoBasico;
	}

	public void setSueldoBasico(Integer sueldoBasico) {
		this.sueldoBasico= sueldoBasico;
	}
	
	
	public void setHorasTrabajadas(Integer horas) {
		this.horas=horas;
	}
	
}
