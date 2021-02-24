package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import poker.Naipe;
import poker.PokerStatus;

class PokerStatusTest {
	
	@Mock Naipe naipe1;
	@Mock Naipe naipe2;
	@Mock Naipe naipe3;
	@Mock Naipe naipe4;
	@Mock Naipe naipe5;
	
	PokerStatus goldenJack;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		goldenJack = new PokerStatus();
		
		when(naipe1.getPalo()).thenReturn("DIAMANTES");
		when(naipe2.getPalo()).thenReturn("TREVOLES");
		when(naipe3.getPalo()).thenReturn("TREVOLES");
		when(naipe4.getPalo()).thenReturn("TREVOLES");
		when(naipe5.getPalo()).thenReturn("TREVOLES");
		
		when(naipe1.getValor()).thenReturn(5);
		when(naipe2.getValor()).thenReturn(1);
		when(naipe3.getValor()).thenReturn(3);
		when(naipe4.getValor()).thenReturn(1);
		when(naipe5.getValor()).thenReturn(2);
	}
	
	@Test
	void testPokerStatusVerificar() {
		when(naipe1.getValor()).thenReturn(1);
		when(naipe3.getValor()).thenReturn(1);
		assertEquals(goldenJack.verificar(naipe1, naipe2, naipe3, naipe4, naipe5), "POKER");
	}


	@Test
	void testPokerStatusColor() {
		when(naipe1.getValor()).thenReturn(5);
		when(naipe3.getValor()).thenReturn(3);
		//when(naipe1.getPalo()).thenReturn("TREVOLES");
		assertTrue(goldenJack.sonDeMismoPalo("DIAMANTES"));
		//assertEquals(goldenJack.verificar(naipe1, naipe2, naipe3, naipe4, naipe5), "COLOR");
	}

	@Test
	void testPokerStatusColorSaleFalso() {		
		assertEquals(goldenJack.verificar(naipe1, naipe2, naipe3, naipe4, naipe5), "No hay jugada");
	}

	@Test
	void testPokerStatusTrio() {
		when(naipe3.getValor()).thenReturn(1);
		assertEquals(goldenJack.verificar(naipe1, naipe2, naipe3, naipe4, naipe5), "TRIO");
	}
	
	@Test
	void testPokerStatusNoHayJugada() {

		assertEquals(goldenJack.verificar(naipe1, naipe2, naipe3, naipe4, naipe5), "No hay jugada");
	}
	
	
	@Test
	void testPokerStatusNaipeMayorQueOTro() {

	}
	
	@Test
	void testPokerStatusNaipesDeMismoPalo() {

	}


}
