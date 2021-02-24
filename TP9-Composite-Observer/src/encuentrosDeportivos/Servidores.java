package encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;

import encuentrosDeportivos.tipoSuscripciones.SuscripcionPorContrincante;
import encuentrosDeportivos.tipoSuscripciones.SuscripcionPorDeporte;
import publicaciones.notificaciones.INotificador;

public class Servidores {

	private GestorNotificacionesPartido gestorNotificaciones;
	private List<Partido> partidos = new ArrayList<Partido>();
	 
	 public void agregarPartido(Partido partido) {
		 gestorNotificaciones.notificarNuevoPartido(partido);
	 }
	 
	 public void crearSuscripcionPorContrincante(List<String> contrincante , AplicacionesMobiles aplicacionesMobiles) {
		 gestorNotificaciones.agregarSuscriptor( new SuscripcionPorContrincante(contrincante,aplicacionesMobiles ) );
	 }

	 public void crearSuscripcionPorDeporte(String nombreDeporte, AplicacionesMobiles aplicacionesMobiles) {
		 gestorNotificaciones.agregarSuscriptor( new SuscripcionPorDeporte(nombreDeporte,aplicacionesMobiles ) );
	 }

}
