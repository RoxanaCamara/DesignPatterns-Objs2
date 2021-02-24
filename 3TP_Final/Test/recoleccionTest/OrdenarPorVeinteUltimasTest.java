package recoleccionTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ordenadorSTRATEGY.OrdenarPorVeinteUltimas;
import recoleccion.Encuesta;
import recoleccion.SistemaCientopolis;

class OrdenarPorVeinteUltimasTest {

	private SistemaCientopolis sistem;
	private Encuesta e;
	private Encuesta e1;
	private Encuesta e2;
	private OrdenarPorVeinteUltimas ordenador;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		sistem=mock(SistemaCientopolis.class);
		ordenador= new OrdenarPorVeinteUltimas();
		e=mock(Encuesta.class);
		e1=mock(Encuesta.class);
		e2=mock(Encuesta.class);
		
	}

	@Test
	void testOrdenarFechas() {
		
		List <Encuesta> encuestasDisponibles= new ArrayList<Encuesta>();
		encuestasDisponibles.add(e);encuestasDisponibles.add(e1);encuestasDisponibles.add(e2);
		when(sistem.encuestasDisponiblesDelSistema()).thenReturn(encuestasDisponibles);
		when(e.getFechaDeCreacion()).thenReturn(LocalDate.of(1998, 07, 12));
		when(e1.getFechaDeCreacion()).thenReturn(LocalDate.of(2019, 05, 06));
		when(e2.getFechaDeCreacion()).thenReturn(LocalDate.of(2007, 01, 06));
		
		List <Encuesta> ordenadas= new ArrayList<Encuesta>();
		ordenadas.add(e1);ordenadas.add(e2);ordenadas.add(e);
		
		assertEquals(ordenador.ordenarFechas(sistem),ordenadas);
	}
	
	@Test
	void testOrdenarUltimasVeinte() {
		
		Encuesta e3 = mock(Encuesta.class); Encuesta e4= mock(Encuesta.class);Encuesta e5= mock(Encuesta.class);
		Encuesta e6= mock(Encuesta.class);Encuesta e7= mock(Encuesta.class);Encuesta e8= mock(Encuesta.class);
		Encuesta e9= mock(Encuesta.class);Encuesta e10= mock(Encuesta.class);Encuesta e11= mock(Encuesta.class);
		Encuesta e12= mock(Encuesta.class);Encuesta e13= mock(Encuesta.class);Encuesta e14= mock(Encuesta.class);
		Encuesta e15= mock(Encuesta.class); Encuesta e16= mock(Encuesta.class); Encuesta e17= mock(Encuesta.class);
		Encuesta e18= mock(Encuesta.class);Encuesta e19= mock(Encuesta.class);Encuesta e20= mock(Encuesta.class);
		
		when(e.getFechaDeCreacion()).thenReturn(LocalDate.of(2050, 07, 12));
		when(e1.getFechaDeCreacion()).thenReturn(LocalDate.of(2049, 07, 12));
		when(e2.getFechaDeCreacion()).thenReturn(LocalDate.of(2048, 07, 12));
		when(e3.getFechaDeCreacion()).thenReturn(LocalDate.of(2047, 07, 12));
		when(e4.getFechaDeCreacion()).thenReturn(LocalDate.of(2046, 07, 12));
		when(e5.getFechaDeCreacion()).thenReturn(LocalDate.of(2045, 07, 12));
		when(e6.getFechaDeCreacion()).thenReturn(LocalDate.of(2044, 07, 12));
		when(e7.getFechaDeCreacion()).thenReturn(LocalDate.of(2043, 07, 12));
		when(e8.getFechaDeCreacion()).thenReturn(LocalDate.of(2042, 07, 12));
		when(e9.getFechaDeCreacion()).thenReturn(LocalDate.of(2041, 07, 12));
		when(e10.getFechaDeCreacion()).thenReturn(LocalDate.of(2040, 07, 12));
		when(e11.getFechaDeCreacion()).thenReturn(LocalDate.of(2039, 07, 12));
		when(e12.getFechaDeCreacion()).thenReturn(LocalDate.of(2038, 07, 12));
		when(e13.getFechaDeCreacion()).thenReturn(LocalDate.of(2037, 07, 12));
		when(e14.getFechaDeCreacion()).thenReturn(LocalDate.of(2036, 07, 12));
		when(e15.getFechaDeCreacion()).thenReturn(LocalDate.of(2035, 07, 12));
		when(e16.getFechaDeCreacion()).thenReturn(LocalDate.of(2034, 07, 12));
		when(e17.getFechaDeCreacion()).thenReturn(LocalDate.of(2033, 07, 12));
		when(e18.getFechaDeCreacion()).thenReturn(LocalDate.of(2032, 07, 12));
		when(e19.getFechaDeCreacion()).thenReturn(LocalDate.of(2031, 07, 12));
		when(e20.getFechaDeCreacion()).thenReturn(LocalDate.of(1980, 07, 12));
		
		List <Encuesta> listaRecorrida= new ArrayList<Encuesta>();
		listaRecorrida.add(e);listaRecorrida.add(e1);listaRecorrida.add(e2);
		listaRecorrida.add(e3);listaRecorrida.add(e4);listaRecorrida.add(e5);
		listaRecorrida.add(e6);listaRecorrida.add(e7);listaRecorrida.add(e8);
		listaRecorrida.add(e9);listaRecorrida.add(e10);listaRecorrida.add(e11);
		listaRecorrida.add(e12);listaRecorrida.add(e13);listaRecorrida.add(e14);
		listaRecorrida.add(e15);listaRecorrida.add(e16);listaRecorrida.add(e17);
		listaRecorrida.add(e18);listaRecorrida.add(e19);listaRecorrida.add(e20);
		when(sistem.encuestasDisponiblesDelSistema()).thenReturn(listaRecorrida);
		
		
		List<Encuesta> resultado= new ArrayList<Encuesta>();
		resultado.add(e);resultado.add(e1);resultado.add(e2);
		resultado.add(e3);resultado.add(e4);resultado.add(e5);
		resultado.add(e6);resultado.add(e7);resultado.add(e8);
		resultado.add(e9);resultado.add(e10);resultado.add(e11);
		resultado.add(e12);resultado.add(e13); resultado.add(e14);
		resultado.add(e15);resultado.add(e16);resultado.add(e17);
		resultado.add(e18);resultado.add(e19);
		
		assertEquals(ordenador.ordenar(sistem),resultado);
	}
	
	

}
