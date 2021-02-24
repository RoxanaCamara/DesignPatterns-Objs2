package publicaciones.entidades;

import java.util.List;

public interface IArticulo {

	public String getTitulo();
	
	public String getTipoDeArticulo();
	
	public String getLugarDePublicacion();
	
	public List<String> getAutores();

	public List<String> getClaves();
	
}
