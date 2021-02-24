package creditos;

import cliente.Cliente;
import cliente.Propiedad;

public class CreditoHipotecario extends Credito{
	
	private Propiedad propiedad;

	public CreditoHipotecario(Integer monto, Integer cuotas, Cliente cliente, Propiedad propiedad) {
		super( monto,cuotas,cliente);
		this.propiedad= propiedad;
	}
	
	@Override
	protected boolean otrasCondicionesEspecificas() {
		return this.edadMenor65PorCantidadDeCuotas() && this.valorPropiedadMenorAlMonto();
	}
	
	private boolean edadMenor65PorCantidadDeCuotas() { //False
		return (cliente.getEdad() + this.cuotasEnAnios()) < 65;
	}

	private boolean valorPropiedadMenorAlMonto() {
		return (propiedad.getValorFiscal() / 0.7) < monto;
	}

	private double cuotasEnAnios() {			
		 return Math.ceil( cuotas / 12);
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	@Override
	protected boolean sueldoMensualMayorALMonto() {
		return  cliente.getSueldoMensual() / 2  > (monto / cuotas);
	}
	
}
