package tp7_LlamadasTelefonicas;

public abstract class LlamadaTelefonica {

	private int tiempo;
	private int horaDelDia;

	public LlamadaTelefonica(int tiempo, int horaDelDia) {
		this.tiempo = tiempo;
		this.horaDelDia = horaDelDia;
	}

	public int getTiempo() {
		return this.tiempo;
	}

	public int getHoraDelDia() {
		return this.horaDelDia;
	}

	//Operaciones primitivas.
	public abstract boolean esHoraPico();

	//Operaciones primitivas.
	public float costoFinal() {
		if (this.esHoraPico()) {
			return this.costoNeto() * 1.2f * this.getTiempo();
		} else {
			return this.costoNeto() * this.getTiempo();
		}
	}

	//Operaciones primitivas.
	public float costoNeto() {
		return this.getTiempo() * 1;
	}


//Ejercicio 4 - Llamadas telefónicas
//A partir de las siguientes líneas de código identifique estos conceptos, si es posible:

//Template Method.

//LlamadaTelefonica es la clase plantilla del cual sus clases hijas heredan 
// No posee un mensaje del tipo FINAL aun asi cumple con el pantron TEMPLATE METHOD



//Operaciones primitivas.
//Operaciones concretas.

//Hook Method.
//No se encontro ningun hook method un ejemplo:
	public void setNumeroTelefono() {}

}
