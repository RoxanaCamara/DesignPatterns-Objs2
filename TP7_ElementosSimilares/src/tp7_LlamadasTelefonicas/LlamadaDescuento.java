package tp7_LlamadasTelefonicas;

public class LlamadaDescuento extends LlamadaTelefonica {

	public LlamadaDescuento(int tiempo, int horaDelDia) {
		super(tiempo, horaDelDia);
	}
	//Operaciones concretas.
	@Override
	public boolean esHoraPico() {
		return false;
	}
	//Operaciones concretas.
	@Override
	public float costoNeto() {
		return this.getTiempo() * 0.95f;
	}

}
