package recoleccionTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import org.mockito.*;

import preguntaStrategy.PreguntaBasica;
import preguntaStrategy.PreguntaBifurcada;
import preguntaStrategy.PreguntaMultipleOpcion;
import recoleccion.Encuesta;
import recoleccion.Investigador;
import recoleccion.ProtocoloEncuesta;
import respuesta.Respuesta;
import respuesta.RespuestaBasicaYBifurcada;
import respuesta.RespuestaDePreguntaMultiple;

import static org.mockito.Mockito.*;

import java.time.LocalDate;

public class EncuestaTest {
	 Encuesta encuesta ;
	 ProtocoloEncuesta protocolo;
	 PreguntaBasica pregu1;
	 PreguntaMultipleOpcion pregu2;
	 PreguntaBifurcada pregu3;
	 PreguntaBasica pregu7 ;
	 PreguntaBasica pregu8;
	 
	 
	 
	@Before
	public void setUp(){
	 
	   pregu1 = new PreguntaBasica("nombre y apellido");
	   pregu2 = new PreguntaMultipleOpcion("cual es el sexo");
	   pregu2.agregarOpcion("masculino");
	   pregu2.agregarOpcion("femenino");
       pregu3 = new PreguntaBifurcada("¿trabaja?");
       pregu7 = new PreguntaBasica("lugar de trabajo");
       pregu8 = new PreguntaBasica("busca trabajo");
       pregu3.agregarPreguntaAOpcion(pregu7, "si");
       pregu3.agregarPreguntaAOpcion(pregu8, "no");
       encuesta = new Encuesta(LocalDate.of(1999, 06, 11));
	   protocolo = new ProtocoloEncuesta();
	   protocolo.agregarPregunta(pregu1);
	   protocolo.agregarPregunta(pregu2);
	   protocolo.agregarPregunta(pregu3);
	   encuesta.agregarProtocolo(protocolo);
	   

	}
	
	@Test
	public void protocoloDeEncuesta() {
		assertEquals(protocolo,encuesta.protocolo());
	}
	
	@Test
	public void preguntaAcualDeEncuesta() throws Exception {
		assertEquals(pregu1,encuesta.preguntaActual());
	}
	@Test
	public void preguntaAnteriorDeEncuestaNoHay() throws Exception{
    assertThrows(Exception.class,() -> encuesta.preguntaAnterior());
	}
	
	@Test
	public void preguntaSiguienteDeEncuesta() throws Exception{
	assertEquals(pregu2,encuesta.preguntaSiguiente());	
	}
	
	@Test
	public void ceroRespuestas() {
	assertEquals(0,encuesta.respuestas().size());	
	}
	@Test
	public void estaTerminada() {
    assertFalse(encuesta.estaTerminada());		
	}
	
	@Test
	public void responderEnEdicion() throws Exception{
		Respuesta r = new RespuestaBasicaYBifurcada();
	  assertThrows(Exception.class,() -> encuesta.responder(r));
	  assertFalse(encuesta.presentaDisponibilidad());
	}
	
	@Test
	public void responderEnEstadoAbierta() throws Exception {
		Respuesta r = new RespuestaBasicaYBifurcada();
	    encuesta.estadoCambia();
	    encuesta.responder(r);
	    assertEquals(pregu2,encuesta.preguntaActual());
	    assertEquals(pregu1,encuesta.preguntaAnterior());
	    assertTrue(encuesta.presentaDisponibilidad());
	    
	}
	
	@Test
	public void responderEncuestaCompleta() throws Exception{
		encuesta.estadoCambia();
		Respuesta r1 = new RespuestaBasicaYBifurcada();
	    Respuesta r2 = new RespuestaDePreguntaMultiple();
	    r2.agregarRespuesta("masculino");
	    r2.agregarRespuesta("femenino");
	    Respuesta r3 = new RespuestaBasicaYBifurcada();
	    r3.agregarRespuesta("si");
	    Respuesta r7= new RespuestaBasicaYBifurcada();
	    
	    encuesta.responder(r1);
	    assertEquals(pregu2,encuesta.preguntaActual());
	    encuesta.responder(r2);
	    assertEquals(pregu3,encuesta.preguntaActual());
	    encuesta.responder(r3);
	    assertEquals(pregu7,encuesta.preguntaActual());
	    encuesta.responder(r7);
	    assertTrue(encuesta.estaTerminada());
	    
	    assertEquals(new Integer(4),encuesta.cantidadDeRespuestas());
	}
	
	@Test
	public void responderEnEstadoFinalizada() throws Exception{
		encuesta.estadoCambia();
		encuesta.estadoCambia();
		Respuesta r1 = new RespuestaBasicaYBifurcada();
		assertThrows(Exception.class,() -> encuesta.responder(r1));	
		encuesta.estadoCambia();
		assertFalse(encuesta.presentaDisponibilidad());
	}
	
	@Test
	public void verSiSeNotificoALosInvestigadores() throws Exception{
		Investigador invest1 = new Investigador(22,"pedro");
		Investigador invest2 = new Investigador(30,"juan");
		encuesta.estadoCambia();
		pregu1.agregarObservador(invest1);
		pregu1.agregarObservador(invest2);
		pregu1.setNotificar(true);
		
		Respuesta r= new RespuestaBasicaYBifurcada();
		encuesta.responder(r);
		assertEquals(1,invest1.notificaciones().size());
		assertEquals(1,invest2.notificaciones().size());
		
	}
	
	@Test
	public void testObtenerFechaDeCreacion() {
		
		assertEquals(encuesta.getFechaDeCreacion(),LocalDate.of(1999, 06, 11));
		
	}
}
