package servicios;

import agencia.Agencia;
import cliente.Cliente;

public class Servicio implements Factura {
	
	private Integer costoPorUnidad;
	private Integer cantidadConsumida;
	private Agencia agencia;
	private Cliente cliente;
	
	
	@Override
	public void realizarPago() {
		cliente.cobrar(this.getPrecio());
		agencia.registroDePago(this);
	}

	private Integer getPrecio() {
		return costoPorUnidad * cantidadConsumida ;
	}



}

