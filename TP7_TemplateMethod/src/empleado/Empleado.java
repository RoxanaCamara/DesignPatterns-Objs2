package empleado;

public abstract class Empleado {

	public final Integer sueldoNeto() {
		return this.getSueldoBruto() - this.descuentoDeObraSocialYAportes();
	}
	
	protected Integer descuentoDeObraSocialYAportes() {
		return (this.getSueldoBruto() * 13)/ 100;
	}

	protected abstract Integer getSueldoBruto();
	
	public void setSueldoBasico(Integer sueldoBasico) {}
	
	public void setCantidadDeHijos(Integer hijos) {}
	
	public void setHorasTrabajadas(Integer horas) {}
	
}
