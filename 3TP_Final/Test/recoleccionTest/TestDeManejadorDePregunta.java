package recoleccionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import preguntaStrategy.PreguntaBasica;
import preguntaStrategy.PreguntaBifurcada;
import preguntaStrategy.PreguntaMultipleOpcion;
import recoleccion.Encuesta;
import recoleccion.ManejadorDePregunta;
import recoleccion.ProtocoloEncuesta;
import respuesta.Respuesta;
import respuesta.RespuestaBasicaYBifurcada;
import respuesta.RespuestaDePreguntaMultiple;



class TestDeManejadorDePregunta {
    private ManejadorDePregunta manejador;
    private PreguntaBasica pregu1;
    private PreguntaBasica pregu2;
    private PreguntaMultipleOpcion pregu3;
    private PreguntaBifurcada pregu4;
    private PreguntaBasica pregu5;
    private PreguntaBasica pregu6;
    private Encuesta encuesta;
    private ProtocoloEncuesta protocolo;
    @BeforeEach
    public void setUp() {
        pregu1= new PreguntaBasica("edad");
        pregu2 = new PreguntaBasica("sexo");
        pregu3 = new PreguntaMultipleOpcion("generos favoritos");
        pregu3.agregarOpcion("accion");
        pregu3.agregarOpcion("romance");
        pregu3.agregarOpcion("comedia");
        pregu4 = new PreguntaBifurcada("tiene casa");
        pregu5 = new PreguntaBasica("cuanto salio");
        pregu6 = new PreguntaBasica("tiene Departamento");
        
        pregu4.agregarPreguntaAOpcion(pregu5, "si");
        pregu4.agregarPreguntaAOpcion(pregu6, "no");
    
        protocolo = new ProtocoloEncuesta();
        protocolo.agregarPregunta(pregu1);
        protocolo.agregarPregunta(pregu2);
        protocolo.agregarPregunta(pregu3);
        protocolo.agregarPregunta(pregu4);
    	manejador = new ManejadorDePregunta();
    	encuesta = new Encuesta(LocalDate.of(2010, 01, 12));
    	encuesta.agregarProtocolo(protocolo);
    	encuesta.setManejador(manejador);
        
    }
    
    @Test
    public void preguntaActual() throws Exception{
       assertEquals(pregu1, manejador.preguntaActual(encuesta));
    }
    
    @Test
    public void preguntaSiguiente()throws Exception {
    	assertEquals(pregu2, manejador.preguntaSiguiente(encuesta));
    }
    @Test
    public void noHayPreguntaAnterior() throws Exception{
    	assertThrows(Exception.class,() -> manejador.preguntaAnterior(encuesta));

    }
    @Test
    public void preguntaActualErronea() throws Exception{
    	assertNotEquals(pregu6,manejador.preguntaActual(encuesta));
    }
    @Test
    public void responder() throws Exception{
    	Respuesta r = new RespuestaBasicaYBifurcada();
    	r.agregarRespuesta("si");
    	manejador.responder(r, encuesta);
        assertEquals(pregu2,manejador.preguntaActual(encuesta));   
    }
    @Test
    public void respuestaAnterior() throws Exception{
    	Respuesta r = new RespuestaBasicaYBifurcada();
    	r.agregarRespuesta("si");
    	manejador.responder(r, encuesta);
        assertEquals(pregu1,manejador.preguntaAnterior(encuesta));
     }
    
    @Test
    public void responderPreguntaMultiple() throws Exception{
    	Respuesta r = new RespuestaBasicaYBifurcada();
    	Respuesta r2= new RespuestaBasicaYBifurcada();
    	Respuesta r3= new RespuestaDePreguntaMultiple();
    	r3.agregarRespuesta("comedia");
    	r3.agregarRespuesta("accion");
    	manejador.responder(r, encuesta);
    	manejador.responder(r2, encuesta);
    	assertEquals(pregu3,manejador.preguntaActual(encuesta));
    	manejador.responder(r3, encuesta);
    	assertEquals(pregu4,manejador.preguntaActual(encuesta));
    }
    @Test
    public void siguientePreguntaDeBifurcada() throws Exception{
    	Respuesta r = new RespuestaBasicaYBifurcada();
    	Respuesta r2= new RespuestaBasicaYBifurcada();
    	Respuesta r3= new RespuestaDePreguntaMultiple();
    	r3.agregarRespuesta("comedia");
    	r3.agregarRespuesta("accion");
    	manejador.responder(r, encuesta);
    	manejador.responder(r2, encuesta);
       	manejador.responder(r3, encuesta);
    	assertThrows(Exception.class,() -> manejador.preguntaSiguiente(encuesta));
     }
    
    @Test
    public void responderPreguntaBifurcada() throws Exception{
    	Respuesta r = new RespuestaBasicaYBifurcada();
    	Respuesta r2= new RespuestaBasicaYBifurcada();
    	Respuesta r3= new RespuestaDePreguntaMultiple();
        Respuesta r4= new RespuestaBasicaYBifurcada();
    	r3.agregarRespuesta("comedia");
    	r3.agregarRespuesta("accion");
    	r4.agregarRespuesta("si");
    	manejador.responder(r, encuesta);
    	manejador.responder(r2, encuesta);
       	manejador.responder(r3, encuesta);
        manejador.responder(r4, encuesta);
        assertEquals(pregu5,manejador.preguntaActual(encuesta));
        assertEquals(pregu4,manejador.preguntaAnterior(encuesta));
    }
    @Test
    public void noHayPreguntaActual() throws Exception{
    	Respuesta r = new RespuestaBasicaYBifurcada();
    	Respuesta r2= new RespuestaBasicaYBifurcada();
    	Respuesta r3= new RespuestaDePreguntaMultiple();
        Respuesta r4= new RespuestaBasicaYBifurcada();
        Respuesta r5= new RespuestaBasicaYBifurcada(); 
        r3.agregarRespuesta("comedia");
    	r3.agregarRespuesta("accion");
    	r4.agregarRespuesta("si");
    	manejador.responder(r, encuesta);
    	manejador.responder(r2, encuesta);
       	manejador.responder(r3, encuesta);
        manejador.responder(r4, encuesta);
    	manejador.responder(r5, encuesta);
    	assertThrows(Exception.class,() -> manejador.preguntaActual(encuesta));
        assertEquals(pregu5,manejador.preguntaAnterior(encuesta));
    }
    @Test
    public void responderCuandoNoHayPregunta() throws Exception{
    	Respuesta r = new RespuestaBasicaYBifurcada();
    	Respuesta r2= new RespuestaBasicaYBifurcada();
    	Respuesta r3= new RespuestaDePreguntaMultiple();
        Respuesta r4= new RespuestaBasicaYBifurcada();
        Respuesta r5= new RespuestaBasicaYBifurcada(); 
        r3.agregarRespuesta("comedia");
    	r3.agregarRespuesta("accion");
    	r4.agregarRespuesta("si");
    	manejador.responder(r, encuesta);
    	manejador.responder(r2, encuesta);
       	manejador.responder(r3, encuesta);
        manejador.responder(r4, encuesta);
    	manejador.responder(r5, encuesta);
    	assertThrows(Exception.class,() -> manejador.responder(r, encuesta));
    	assertThrows(Exception.class,() -> manejador.preguntaSiguienteDeBasica(encuesta));

    }
    
   
   
}
