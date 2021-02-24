package cliente;

import creditos.CreditoHipotecario;
import creditos.CreditoPersonal;
import creditosInterfaces.SolicitudDeCreditoHipotecario;
import creditosInterfaces.SolicitudDeCreditoPersonales;

public class Cliente implements SolicitudDeCreditoHipotecario, SolicitudDeCreditoPersonales{
	
	private Integer sueldoMensual;
	private Integer edad;
	
	public Cliente(String nombre, String direccion, Integer edad ,Integer sueldoMensual) {
		this.sueldoMensual= sueldoMensual;
		this.setEdad(edad);
	}

	@Override
	public CreditoPersonal solicitarCreditoPersonal(Integer monto, Integer cuotas) {
		return new CreditoPersonal( monto, cuotas, this) ;
	}

	@Override
	public CreditoHipotecario solicitarCreditoHipotecario(Integer monto, Integer cuotas,Propiedad propiedad) {		
		return new CreditoHipotecario( monto, cuotas,this, propiedad);
		
	}

	public Integer getSueldoMensual() {
		return sueldoMensual;
	}

	public void setSueldoMensual(Integer sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}
	
	public Integer getSueldoAnual() {
		return sueldoMensual * 12;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
