package encuentrosDeportivos;

import java.util.List;

public class Partido {

	private List<String> contrincantes;
	private String nombreDeporte;
	private String resultado;
	
	public Partido(List<String> contrincantes, String nombreDeporte, String resultado) {
		super();
		this.contrincantes = contrincantes;
		this.nombreDeporte = nombreDeporte;
		this.resultado = resultado;
	}
	
	public List<String> getContrincantes() {
		return contrincantes;
	}
	public void setContrincantes(List<String> contrincantes) {
		this.contrincantes = contrincantes;
	}
	public String getNombreDeporte() {
		return nombreDeporte;
	}
	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}
}
