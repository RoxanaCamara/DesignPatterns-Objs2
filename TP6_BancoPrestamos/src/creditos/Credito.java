package creditos;

import cliente.Cliente;

public abstract class Credito {

	protected Cliente cliente;
	protected Integer monto;
	protected Integer cuotas;

	public Credito(Integer monto, Integer cuotas, Cliente cliente) {
		 this.monto= monto;
		 this.cuotas=cuotas; 
		 this.cliente=cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public Integer getCuotas() {
		return cuotas;
	}

	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}
	
	public final boolean estaAprobado() {
		return this.sueldoMensualMayorALMonto()
				&& this.otrasCondicionesEspecificas();
	}

	protected abstract boolean otrasCondicionesEspecificas();

	protected abstract boolean sueldoMensualMayorALMonto();
	
}
