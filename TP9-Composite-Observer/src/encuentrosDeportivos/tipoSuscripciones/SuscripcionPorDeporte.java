package encuentrosDeportivos.tipoSuscripciones;

import encuentrosDeportivos.AplicacionesMobiles;
import encuentrosDeportivos.Partido;

public class SuscripcionPorDeporte implements Suscripto{

	private String nombreDeporte;
	private AplicacionesMobiles aplicacionesMobiles;
	
	public SuscripcionPorDeporte(String nombreDeporte, AplicacionesMobiles aplicacionesMobiles) {
		super();
		this.nombreDeporte = nombreDeporte;
		this.aplicacionesMobiles = aplicacionesMobiles;
	}

	public String getNombreDeporte() {
		return nombreDeporte;
	}

	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}

	public AplicacionesMobiles getAplicacionesMobiles() {
		return aplicacionesMobiles;
	}

	public void setAplicacionesMobiles(AplicacionesMobiles aplicacionesMobiles) {
		this.aplicacionesMobiles = aplicacionesMobiles;
	}

	@Override
	public String nuevaNoticia(Partido partido) {
		if( this.getNombreDeporte().equals(partido.getNombreDeporte()) ) {
			this.getAplicacionesMobiles().recibirNotificacion(partido);
			return "Notificacion";	
		}
		return "No es de tu interes";
	}

}
