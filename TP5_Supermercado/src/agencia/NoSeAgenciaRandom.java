package agencia;

import servicios.Factura;

public class NoSeAgenciaRandom implements Agencia {

	@Override
	public void registroDePago(Factura factura) {
		System.out.print("HAZ PAGADO EL HDP");
	}

}
