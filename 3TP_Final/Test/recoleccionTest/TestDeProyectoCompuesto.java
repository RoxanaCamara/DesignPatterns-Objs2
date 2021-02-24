package recoleccionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import proyecto.Proyecto;
import proyecto.ProyectoCompuesto;
import proyecto.ProyectoSimple;
import recoleccion.Encuesta;

class TestDeProyectoCompuesto {
   private ProyectoCompuesto proyecto;
   private ProyectoSimple proye1;
   private ProyectoSimple proye2;
   private ProyectoCompuesto proye3;
   @Mock
   private Encuesta e1;
   @Mock
   private Encuesta e2;
   @Mock
   private Encuesta e3;
   @Mock
   private Encuesta e4;
   
   
   
   @BeforeEach
   public void setUp() {
	   MockitoAnnotations.initMocks(this);
	   proyecto = new ProyectoCompuesto("liga");
	   proye1= new ProyectoSimple("simple1");
	   proye2= new ProyectoSimple("simple2");
       proye3 = new ProyectoCompuesto("compuesto1");    
       proye3.agregarSubproyecto(proye2);

       proyecto.agregarSubproyecto(proye1);
       proyecto.agregarSubproyecto(proye3);
   }
   
   
   @Test
   public void cantidadDeEncuestas() {
	   assertEquals(new Integer(0),proyecto.cantidadDeEncuestas());
       proyecto.agregarEncuesta(e1);
       proyecto.agregarEncuesta(e2);
	   assertEquals(new Integer(2),proyecto.cantidadDeEncuestas());

   }
   @Test
   public void getEncuestas() {
       proyecto.agregarEncuesta(e1);
       proyecto.agregarEncuesta(e2);
	   List<Encuesta> encuestas = new ArrayList<Encuesta>();
	   encuestas.add(e1);
	   encuestas.add(e2);

	   assertEquals(encuestas,proyecto.getEncuestas());
   }
   
   @Test
   public void subproyectos() {
	   List<Proyecto> proyecs = new ArrayList<Proyecto>();
	   proyecs.add(proye1);
	   proyecs.add(proye3);
	   assertEquals(proyecs, proyecto.subproyectos());
	   
   }
   @Test
   public void agregoSubproyectoQueMeContiene() {
	   Proyecto p = new ProyectoCompuesto("");
	   p.agregarSubproyecto(proyecto);
	   proyecto.agregarSubproyecto(p);
	   List<Proyecto> proyecs = new ArrayList<Proyecto>();
	   proyecs.add(proye1);
	   proyecs.add(proye3);
	   assertEquals(proyecs, proyecto.subproyectos());
	   
   }

   @Test
   public void quitarSubproyecto() {
	   proyecto.quitarSubproyecto(proye2);   
	   List<Proyecto> proyecs = new ArrayList<Proyecto>();
	 
	  assertEquals(proyecs,proye3.subproyectos());
   }
   @Test
   public void encuestaFinalizadas() {
	   when(e1.estaTerminada()).thenReturn(true);
	   when(e2.estaTerminada()).thenReturn(true);
	   when(e3.estaTerminada()).thenReturn(true);
	   when(e4.estaTerminada()).thenReturn(true);
	   
	   proyecto.agregarEncuesta(e1);
	   proyecto.agregarEncuesta(e2);
	   proye1.agregarEncuesta(e3);
	   proye3.agregarEncuesta(e4);
	   List<Encuesta> encuestas = new ArrayList<Encuesta>();
	   encuestas.add(e1);
	   encuestas.add(e2);
	   encuestas.add(e3);
	   encuestas.add(e4);
	   assertEquals(encuestas,proyecto.encuestasFinalizadas());
   }
   
   @Test
   public void encuestasDisponibles() {
		when(e1.estaTerminada()).thenReturn(false);
		when(e2.estaTerminada()).thenReturn(false);
		when(e3.estaTerminada()).thenReturn(false);
		when(e4.estaTerminada()).thenReturn(false);
		when(e1.presentaDisponibilidad()).thenReturn(true);
		when(e2.presentaDisponibilidad()).thenReturn(false);
		when(e3.presentaDisponibilidad()).thenReturn(true);
		when(e4.presentaDisponibilidad()).thenReturn(true);
        
		proye1.agregarEncuesta(e1);
		proye3.agregarEncuesta(e2);
		proye2.agregarEncuesta(e3);
		proye2.agregarEncuesta(e4);
	 
		List<Encuesta> encuestas = new ArrayList<Encuesta>();
		 encuestas.add(e1);
		 encuestas.add(e3);
		 encuestas.add(e4);
		 
		 assertEquals(encuestas,proyecto.encuestasDisponibles());
		
   }
}
