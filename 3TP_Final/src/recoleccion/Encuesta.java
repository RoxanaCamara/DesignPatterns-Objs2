package recoleccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import preguntaStrategy.Pregunta;
import respuesta.Respuesta;
import state.EnEdicion;
import state.Estado;

public class Encuesta {
   private ProtocoloEncuesta protocolo;
   private List<Respuesta> respuestas;
   private ManejadorDePregunta manejador;
   private Estado estado;
   private LocalDate fechaDeCreacion;
   
   public Encuesta(LocalDate fecha) {
	   this.respuestas = new ArrayList<Respuesta>();
	   this.manejador = new ManejadorDePregunta();
	   this.estado = new EnEdicion();
	   this.fechaDeCreacion=fecha;
   }
   public void setManejador(ManejadorDePregunta p) {
	   this.manejador=p;
   }
   public void agregarProtocolo(ProtocoloEncuesta p) {
	   this.protocolo=p;
   }
   public void setEstado(Estado e) {
	   this.estado = e;
   }
   public void estadoCambia() {
	   this.estado.cambia(this);
   }
   public ManejadorDePregunta manejador() {
	   return this.manejador;
   }
   
   public ProtocoloEncuesta protocolo() {
	   return this.protocolo;
   }
   
   public Pregunta preguntaActual() throws Exception {
	   return this.manejador.preguntaActual(this);
   }
   
   public Pregunta preguntaSiguiente() throws Exception{
	   return this.manejador.preguntaSiguiente(this);
   }
   
   public Pregunta preguntaAnterior() throws Exception{
	   return this.manejador.preguntaAnterior(this);
   }
   
   public void responder(Respuesta r) throws Exception{
	    this.estado.responder(r, this);
   }
   
   public boolean estaTerminada() {
	   
	   try {
		   this.preguntaActual();
		   return false; 
	   }
	   
	   catch(Exception e) {
		   return true;
	   } 
	   
   }
   
   public void agregarRespuesta(Respuesta r,Pregunta p) {
	   this.respuestas.add(r);
	   r.preguntaQueRespondio(p);
       
   }
   public List<Respuesta>respuestas() {
	   return this.respuestas;
   }

   public Integer cantidadDeRespuestas() {
	
	return this.respuestas.size();
   }
   public LocalDate getFechaDeCreacion() {
		
		return fechaDeCreacion;
	}

	public boolean presentaDisponibilidad() {
		
		return	this.estado.tieneDisponibilidad();
	}
	
}
