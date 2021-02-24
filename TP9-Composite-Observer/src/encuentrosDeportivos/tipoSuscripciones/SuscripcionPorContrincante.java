package encuentrosDeportivos.tipoSuscripciones;

import java.util.List;
import encuentrosDeportivos.AplicacionesMobiles;
import encuentrosDeportivos.Partido;

public class SuscripcionPorContrincante implements Suscripto{

	private List<String> contrincantes;
	private AplicacionesMobiles aplicacionesMobiles;
	
	public SuscripcionPorContrincante(List<String> contrincantes, AplicacionesMobiles aplicacionesMobiles) {
		super();
		this.setContrincantes(contrincantes);
		this.setAplicacionesMobiles(aplicacionesMobiles);
	}

	@Override
	public String nuevaNoticia(Partido partido) {
		if( esUnContricanteDeInteres(partido.getContrincantes()) ) {
			this.getAplicacionesMobiles().recibirNotificacion(partido);
			return "Notificacion";	
		}
	
		return "No es de tu interes";
	}


	private boolean esUnContricanteDeInteres(List<String> contrincantes2) {
		return contrincantes2.stream().anyMatch(n -> this.perteneceAContricantes(n) );
	}

	private boolean perteneceAContricantes(String n) {
		return this.getContrincantes().stream().anyMatch( nd -> nd.equals(n));
	}


	public AplicacionesMobiles getAplicacionesMobiles() {
		return aplicacionesMobiles;
	}


	public void setAplicacionesMobiles(AplicacionesMobiles aplicacionesMobiles) {
		this.aplicacionesMobiles = aplicacionesMobiles;
	}


	public List<String> getContrincantes() {
		return contrincantes;
	}


	public void setContrincantes(List<String> contrincantes) {
		this.contrincantes = contrincantes;
	}	
}
