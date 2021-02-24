package servicios;

import agencia.Agencia;
import cliente.Cliente;

public class Impuesto implements Factura{
	
	private Integer tazaServicio;
	private Agencia agencia;
	private Cliente cliente;
	
	public Impuesto(Cliente cliente, Agencia agencia, Integer tazaServicio ){
		
	}

	@Override
	public void realizarPago() {
		cliente.cobrar(tazaServicio);
		agencia.registroDePago(this);
	}

	

}
