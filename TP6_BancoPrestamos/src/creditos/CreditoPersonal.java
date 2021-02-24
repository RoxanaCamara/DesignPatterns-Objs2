package creditos;

import cliente.Cliente;

public class CreditoPersonal extends Credito{

	public CreditoPersonal(Integer monto, Integer cuotas, Cliente cliente) {
		super( monto,cuotas,cliente);
	}

	private boolean sueldoAnualMayorA(Integer numero) {
		return cliente.getSueldoAnual() > numero;
	}

	@Override
	protected boolean sueldoMensualMayorALMonto() {
		return cliente.getSueldoMensual() > (monto / 0.7 );
	}

	@Override
	protected boolean otrasCondicionesEspecificas() {
		return this.sueldoAnualMayorA(15000);
	}

}
