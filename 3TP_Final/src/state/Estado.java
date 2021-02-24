package state;

import recoleccion.Encuesta;
import respuesta.Respuesta;

public interface Estado {
    public  void cambia(Encuesta e);
    public  void responder(Respuesta r,Encuesta e) throws Exception; 
    public boolean tieneDisponibilidad();
}
