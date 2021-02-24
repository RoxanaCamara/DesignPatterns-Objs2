package tp7_AyudandoAlSoberano;

//clase concreta
public class CajaDeAhorro extends CuentaBancaria {
	private int limite;

	public CajaDeAhorro(String titular, int limite) {
		super(titular);
		this.limite = limite;
	}

	public int getLimite() {
		return this.limite;
	}

	//operaciones concretas
	@Override
	protected boolean esPosibleExtraer(int monto) {
		return this.getSaldo() >= monto && this.getLimite() >= monto;
	}

}
