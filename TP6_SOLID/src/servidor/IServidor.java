package servidor;

import java.util.List;

import correo.Correo;

public interface IServidor extends IConexion {
	
	public void enviar(Correo correo);
	
	public List<Correo> recibirNuevos(String user, String pass);

	public float tazaDeTransferencia();
	
	public void resetear();
	
	public void realizarBackUp();

	
}
