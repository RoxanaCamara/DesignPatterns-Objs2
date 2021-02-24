package poker;

public class Naipe {

	/*P1 ( 1,     "PICAS" ), C1(  1,   "CORAZONES"), D1( 1,   "DIAMANTES" ), T1( 1,   "TREVOLES" ),
	P2 (2,      "PICAS" ), C2( 2,    "CORAZONES"), D2( 2,   "DIAMANTES" ), T2( 2,   "TREVOLES" ),
	P3 (3,      "PICAS" ), C3( 3,    "CORAZONES"), D3( 3,   "DIAMANTES" ), T3( 3,   "TREVOLES" ),
	P4 ( 4,     "PICAS" ), C4(  4,   "CORAZONES"), D4( 4,   "DIAMANTES" ), T4( 4,   "TREVOLES" ),
	P5 ( 5,     "PICAS" ), C5(  5,   "CORAZONES"), D5( 5,   "DIAMANTES" ), T5(  5,  "TREVOLES" ),
	P6 ( 6,     "PICAS" ), C6(  6,   "CORAZONES"), D6(  6,  "DIAMANTES" ), T6(  6,  "TREVOLES" ),
	P7 ( 7,     "PICAS" ), C7(  7,   "CORAZONES"), D7(  7,  "DIAMANTES" ), T7(  7,  "TREVOLES" ),
	P8 ( 8,     "PICAS" ), C8(  8,   "CORAZONES"), D8(  8,  "DIAMANTES" ), T8(  8,  "TREVOLES" ),
	P9 (  9,    "PICAS" ), C9(   9,  "CORAZONES"), D9(   9, "DIAMANTES" ), T9(   9, "TREVOLES" ),
	P10( 10,     "PICAS" ),C10( 10,    "CORAZONES"),D10( 10,   "DIAMANTES" ),T10( 10,   "TREVOLES" ),
	PJ ( 11,     "PICAS" ), CJ(  11,   "CORAZONES"), DJ(  11,  "DIAMANTES" ), TJ(  11,  "TREVOLES" ),
	PQ (  12,    "PICAS" ), CQ(   12,  "CORAZONES"), DQ(   12, "DIAMANTES" ), TQ(   12, "TREVOLES" ),
	PK ( 13,     "PICAS" ), CK(  13,   "CORAZONES"), DK(  13,  "DIAMANTES" ), TK(  13,  "TREVOLES" );*/
	
	private String palo;
	private int valor;

	Naipe(int valor, String palo) {
		this.palo=palo;
		this.valor=valor;
	}

	public String getPalo() {
		return palo;
	}

	public int getValor() {
		return valor;
	}

	
	

}
