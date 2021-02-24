package cliente;

import correo.Correo;

public interface ICliente {

	public void enviarCorreo(Correo correo);
	
	public void recibirNuevos();
	
	public void eliminarBorrado(Correo correo);
	
	public int contarInbox();
	
	public void borrarCorreo(Correo correo);
}

