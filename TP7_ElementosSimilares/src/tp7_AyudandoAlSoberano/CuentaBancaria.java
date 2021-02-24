package tp7_AyudandoAlSoberano;

import java.util.ArrayList;
import java.util.List;

//Clase abstracta - LA Plantilla
public abstract class CuentaBancaria {
	private String titular;
	private int saldo;
	private List<String> movimientos;

	public CuentaBancaria(String titular) {
		this.titular = titular;
		this.saldo = 0;
		this.movimientos = new ArrayList<String>();
	}

	public String getTitular() {
		return this.titular;
	}

	public int getSaldo() {
		return this.saldo;
	}

	protected void setSaldo(int monto) {
		this.saldo = monto;
	}

	// operaciones primitivas
	public void agregarMovimientos(String movimiento) {
		this.movimientos.add(movimiento);
	}

	// operaciones primitivas
	public final void extraer(int monto) {
		if (this.esPosibleExtraer(monto)) {
			this.setSaldo(this.getSaldo() - monto);
			this.agregarMovimientos("Extraccion");
		}
	}

	// operaciones primitivas
	protected abstract boolean esPosibleExtraer(int monto);

	/*
	 * Un banco tiene dos tipos de cuentas bancarias. Cajas de ahorro y Cuentas
	 * corrientes. Ambas cuentas se manejan en forma similar excepto para la
	 * extracciones de dinero.
	 * 
	 * En las caja de ahorro es posible realizar la extracci�n solamente si el saldo
	 * de la cuenta es superior o igual a la cantidad de dinero que quiero extraer y
	 * no supera el l�mite por extracci�n, si esto sucede, entonces realiza
	 * efectivamente la extracci�n (actualizando el saldo) y luego registra que se
	 * hizo una extracci�n simplemente agregando un texto a una colecci�n.
	 * 
	 * Por otra parte, las cuentas corrientes pueden realizar una extracci�n
	 * solamente cuando la cantidad de dinero a extraer no supera el saldo m�s el
	 * l�mite en rojo que posee la cuenta. Si esto ocurre entonces realiza la
	 * extracci�n y luego registra que se hizo una extracci�n simplemente agregando
	 * un texto a una colecci�n
	 * 
	 * El cual compila y retorna los resultados esperados. Su compa�ero se da cuenta
	 * que hay c�digo repetido y adem�s no utilizar template method, el cual es
	 * indispensable para que apruebe la entrega.
	 * 
	 * 
	 * Su objetivo es el siguiente: 1.
	 * 
	 * Debe realizar los cambios necesarios en el c�digo para que el m�todo extraer
	 * sea un template method. (Escriba solamente los cambios, el resto se asume que
	 * queda intacto)
	 * 
	 * 2. Analice en el c�digo resultante los elementos que indica Gamma et. al que
	 * pueden aparecer en su soluci�n, por ejemplo: Clase abstracta, clase concreta,
	 * cual es el template method, cuales son las operaciones primitivas, cuales son
	 * las operaciones concretas, cuales los hook methods. Importante: No
	 * necesariamente aparecen todos los elementos que lista Gamma, ud. debe
	 * explicar solamente aquellos que est�n en su soluci�n.
	 * 
	 * 
	 * Ejercicio 6 � Contestar y justificar las respuestas 
	 * 
	 * 1. Existe m�s de un tipo de adaptadores, mencione y explique cada uno de ellos. 
	 * 
	 * 
	 * 2. �En qu� se diferencia un tipo de adaptador del otro? 
	 * 
	 * 
	 * 3. �Se pueden utilizar ambas
	 * alternativas de implementaci�n del patr�n en java? �Justifique la respuesta?
	 * 
	 * 
	 * 4. Ver la interface Enumeration de java y la clase Vector, preste atenci�n a
	 * que dicha clase contiene un m�todo "elements()". Explique c�mo funciona el
	 * patr�n adapter y cu�les son los roles de los participantes entre la interface
	 * y clase mencionada. Mencione qu� tipo de implementaci�n del patr�n se
	 * utiliza. 
	 * 
	 * 
	 * 5. Realice el mismo an�lisis del punto 3, pero con la interface
	 * Iterator, la clase ArrayList (preste atenci�n al m�todo "iterator()").
	 * Muestre un ejemplo de funcionamiento y especifique los roles de cada
	 * participante. 
	 * 
	 * 
	 * 6. Implemente un Adaptador, que adapte un Iterator a un
	 * Enumeration. Escribir c�digo que utilice dicha implementaci�n adaptando un
	 * ArrayList.
	 */

}
