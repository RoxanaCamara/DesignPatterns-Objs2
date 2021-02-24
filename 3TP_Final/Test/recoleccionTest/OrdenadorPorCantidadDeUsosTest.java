package recoleccionTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ordenadorSTRATEGY.OrdenadorPorCantidadDeUsos;
import proyecto.Proyecto;
import proyecto.ProyectoSimple;
import recoleccion.Encuesta;
import recoleccion.SistemaCientopolis;

class OrdenadorPorCantidadDeUsosTest {

	private SistemaCientopolis sistem;
	private ProyectoSimple pro1;
	private ProyectoSimple pro;
	private OrdenadorPorCantidadDeUsos ordenador;
	private Encuesta e;
	private Encuesta e1;
	private Encuesta e2;
	
	
	

	@BeforeEach
	void setUp() throws Exception {
		
		ordenador= new OrdenadorPorCantidadDeUsos();
		pro=mock(ProyectoSimple.class);
		pro1=mock(ProyectoSimple.class);
		sistem=mock(SistemaCientopolis.class);
		e=mock(Encuesta.class);
		e1=mock(Encuesta.class);
		e2=mock(Encuesta.class);
		
		
	}

	@Test
	void testOrdenDeUsos() {
		
		List <Proyecto> proyectos= new ArrayList<Proyecto>();

		proyectos.add(pro);proyectos.add(pro1);
		when(sistem.proyectosDeTodoElSistema()).thenReturn(proyectos);
		when(pro.cantidadDeEncuestas()).thenReturn(1);
		when(pro1.cantidadDeEncuestas()).thenReturn(2);
		List <Proyecto> resultado= new ArrayList<Proyecto>();
		resultado.add(pro1);resultado.add(pro);
		
		assertEquals(ordenador.ordenDeUsos(sistem),resultado);
	}
	
	
	@Test
	void testEncuestaDeUsos() {
		
		List <Proyecto> proyectos= new ArrayList<Proyecto>();
		proyectos.add(pro1);proyectos.add(pro);
		when(sistem.proyectosDeTodoElSistema()).thenReturn(proyectos);
		when(pro.cantidadDeEncuestas()).thenReturn(1);
		when(pro1.cantidadDeEncuestas()).thenReturn(2);
		
		
		List<Encuesta> encuestaspro= new ArrayList<Encuesta>();
		encuestaspro.add(e);
		List<Encuesta> encuestaspro1=new ArrayList<Encuesta>();
		encuestaspro1.add(e2);encuestaspro1.add(e1);
		when(pro.encuestasDisponibles()).thenReturn(encuestaspro);
		when(pro1.encuestasDisponibles()).thenReturn(encuestaspro1);
		
		List <Encuesta> resultado= new ArrayList<Encuesta>();
		resultado.add(e2);resultado.add(e1);resultado.add(e);
		
		assertEquals(ordenador.encuestasDeUsos(sistem),resultado);
		
	}
	
	@Test
	void testOrdenarPorMasUsadas() {
		
		Proyecto pro2=mock(Proyecto.class);Proyecto pro3=mock(Proyecto.class); Proyecto pro4=mock(Proyecto.class);
		Proyecto pro5=mock(Proyecto.class);Proyecto pro6=mock(Proyecto.class);
	
		Encuesta e3=mock(Encuesta.class);Encuesta e4=mock(Encuesta.class);Encuesta e5=mock(Encuesta.class);
		Encuesta e6=mock(Encuesta.class);Encuesta e7=mock(Encuesta.class);Encuesta e8=mock(Encuesta.class);
		Encuesta e9=mock(Encuesta.class);Encuesta e10=mock(Encuesta.class);Encuesta e11=mock(Encuesta.class);
		Encuesta e12=mock(Encuesta.class);Encuesta e13=mock(Encuesta.class);Encuesta e14=mock(Encuesta.class);
		Encuesta e15=mock(Encuesta.class);Encuesta e16=mock(Encuesta.class);Encuesta e17=mock(Encuesta.class);
		Encuesta e18=mock(Encuesta.class);Encuesta e19=mock(Encuesta.class);Encuesta e20=mock(Encuesta.class);
		Encuesta e21=mock(Encuesta.class);Encuesta e22=mock(Encuesta.class);Encuesta e23=mock(Encuesta.class);
		Encuesta e24=mock(Encuesta.class);Encuesta e25=mock(Encuesta.class);Encuesta e26=mock(Encuesta.class);
		Encuesta e27=mock(Encuesta.class);
		List <Proyecto> proyectos= new ArrayList<Proyecto>();
		proyectos.add(pro1);proyectos.add(pro);proyectos.add(pro2);proyectos.add(pro3);proyectos.add(pro4);
		proyectos.add(pro5);proyectos.add(pro6);
		when(sistem.proyectosDeTodoElSistema()).thenReturn(proyectos);
		when(pro.cantidadDeEncuestas()).thenReturn(1);
		when(pro1.cantidadDeEncuestas()).thenReturn(2);
		when(pro2.cantidadDeEncuestas()).thenReturn(3);
		when(pro3.cantidadDeEncuestas()).thenReturn(4);
		when(pro4.cantidadDeEncuestas()).thenReturn(5);
		when(pro5.cantidadDeEncuestas()).thenReturn(6);
		when(pro6.cantidadDeEncuestas()).thenReturn(7);
		
		
		
		List<Encuesta> encuestaspro= new ArrayList<Encuesta>();
		encuestaspro.add(e);
		List<Encuesta> encuestaspro1=new ArrayList<Encuesta>();
		encuestaspro1.add(e2);encuestaspro1.add(e1);
		List <Encuesta> encuestaspro2=new ArrayList<Encuesta>();
		encuestaspro2.add(e3);encuestaspro2.add(e4);encuestaspro2.add(e5);
		List<Encuesta> encuestaspro3= new ArrayList<Encuesta>();
		encuestaspro3.add(e6);encuestaspro3.add(e7);encuestaspro3.add(e8);encuestaspro3.add(e9);
		List<Encuesta> encuestaspro4= new ArrayList<Encuesta>();
		encuestaspro4.add(e10);encuestaspro4.add(e11);encuestaspro4.add(e12);
		encuestaspro4.add(e13);encuestaspro4.add(e14);
		List<Encuesta> encuestaspro5= new ArrayList<Encuesta>();
		encuestaspro5.add(e15);encuestaspro5.add(e16);encuestaspro5.add(e17);
		encuestaspro5.add(e18);encuestaspro5.add(e19);encuestaspro5.add(e20);
		List<Encuesta>encuestaspro6=new ArrayList<Encuesta>();
		encuestaspro6.add(e21);encuestaspro6.add(e22);encuestaspro6.add(e23);
		encuestaspro6.add(e24);encuestaspro6.add(e25);encuestaspro6.add(e26);
		encuestaspro6.add(e27);
		
		when(pro.encuestasDisponibles()).thenReturn(encuestaspro);
		when(pro1.encuestasDisponibles()).thenReturn(encuestaspro1);
		when(pro2.encuestasDisponibles()).thenReturn(encuestaspro2);
		when(pro3.encuestasDisponibles()).thenReturn(encuestaspro3);
		when(pro4.encuestasDisponibles()).thenReturn(encuestaspro4);
		when(pro5.encuestasDisponibles()).thenReturn(encuestaspro5);
		when(pro6.encuestasDisponibles()).thenReturn(encuestaspro6);
		
		List <Encuesta> resultado = new ArrayList<Encuesta>();
		resultado.add(e21);resultado.add(e22);resultado.add(e23);
		resultado.add(e24);resultado.add(e25);resultado.add(e26);
		resultado.add(e27);resultado.add(e15);resultado.add(e16);
		resultado.add(e17);resultado.add(e18);resultado.add(e19);
		resultado.add(e20);resultado.add(e10);resultado.add(e11);
		resultado.add(e12);resultado.add(e13);resultado.add(e14);
		resultado.add(e6);resultado.add(e7);resultado.add(e8);
		resultado.add(e9);resultado.add(e3);resultado.add(e4);
		resultado.add(e5);
		assertEquals(ordenador.ordenar(sistem),resultado);
	}

}
