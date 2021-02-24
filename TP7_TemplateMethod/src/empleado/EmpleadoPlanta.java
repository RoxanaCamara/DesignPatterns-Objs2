package empleado;

public class EmpleadoPlanta extends Empleado{

	private Integer sueldoBasico;
	private Integer hijos;
	
	public EmpleadoPlanta(Integer sueldoBasico, Integer hijos) {
		super();
		this.sueldoBasico = sueldoBasico;
		this.hijos = hijos;
	}

	@Override
	protected Integer getSueldoBruto() {
		return this.getSueldoBasico() + (this.hijos * 150);
	}
	
	public void setSueldoBasico(Integer sueldoBasico) {
		this.sueldoBasico= sueldoBasico;
	}
	
	public void setCantidadDeHijos(Integer hijos) {
		this.hijos = hijos;		
	}
	
	private Integer getSueldoBasico() {
		return sueldoBasico;
	}
}
