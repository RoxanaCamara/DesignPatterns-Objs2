package creditosInterfaces;

import cliente.Propiedad;
import creditos.CreditoHipotecario;

public interface SolicitudDeCreditoHipotecario {
	
	public CreditoHipotecario solicitarCreditoHipotecario(Integer monto, Integer cuotas,Propiedad propiedad);
}
