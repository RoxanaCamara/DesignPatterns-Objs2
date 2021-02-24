package tp7_AyudandoAlSoberano;

//clase concreta
public class CuentaCorriente extends CuentaBancaria {
	private int descubierto;

	public CuentaCorriente(String titular, int descubierto) {
		super(titular);
		this.descubierto = descubierto;
	}

	public int getDescubierto() {
		return this.descubierto;
	}
	
	//operaciones concretas
	@Override
	protected boolean esPosibleExtraer(int monto) {
		return this.getSaldo() + this.getDescubierto() >= monto;
	}

}
