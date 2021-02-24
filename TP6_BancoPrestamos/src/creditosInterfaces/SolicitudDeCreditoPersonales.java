package creditosInterfaces;


import creditos.CreditoPersonal;

public interface SolicitudDeCreditoPersonales {

	public CreditoPersonal solicitarCreditoPersonal(Integer monto, Integer cuotas);
}
