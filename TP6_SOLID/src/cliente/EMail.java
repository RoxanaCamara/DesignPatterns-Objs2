package cliente;

import java.util.ArrayList;
import correo.Correo;

public class EMail implements ICliente {
	
	public Cliente cliente;
	 ArrayList<Correo> inbox;
	 private ArrayList<Correo> borrados;
	
	public EMail(Cliente cliente,String nombreUsuario, String pass){
		this.cliente= cliente;
		this.inbox = new ArrayList<Correo>();
		this.borrados = new ArrayList<Correo>();
	}
	
	
	public void borrarCorreo(Correo correo){
		this.inbox.remove(correo);
		this.borrados.remove(correo);
	}
	
	public int contarBorrados(){
		return this.borrados.size();
	}
	
	public int contarInbox(){
		return this.inbox.size();
	}
	
	public void eliminarBorrado(Correo correo){
		this.borrados.remove(correo);
	}
	
	public void recibirNuevos(){
	
	}
	
	@Override
	public void enviarCorreo(Correo correo) {

	}

	

}
