package publicaciones.entidades;

import java.util.ArrayList;
import java.util.List;

public class Articulo implements IArticulo{

	private String titulo;
	private String tipoDeArticulo;
	private String lugarDePublicacion;
	private List<String> autores = new ArrayList<String>();
	private List<String> claves = new ArrayList<String>();

	public Articulo(String titulo, List<String> autores, String lugarDePublicacion, String tipoDeArticulo,
			List<String> claves) {
		super();
		this.titulo = titulo;
		this.tipoDeArticulo = tipoDeArticulo;
		this.lugarDePublicacion = lugarDePublicacion;
		this.autores = autores;
		this.claves = claves;
	}

	public Articulo() {
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipoDeArticulo() {
		return tipoDeArticulo;
	}

	public void setTipoDeArticulo(String tipoDeArticulo) {
		this.tipoDeArticulo = tipoDeArticulo;
	}

	public String getLugarDePublicacion() {
		return lugarDePublicacion;
	}

	public void setLugarDePublicacion(String lugarDePublicacion) {
		this.lugarDePublicacion = lugarDePublicacion;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	public List<String> getClaves() {
		return claves;
	}

	public void setClaves(List<String> claves) {
		this.claves = claves;
	}
	
	

}
