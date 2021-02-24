package cliente;

public class Propiedad {

	private Integer valorFiscal;
	
	public Propiedad(String descripcion, String direccion, Integer valorFiscal) {
		this.setValorFiscal(valorFiscal);
	}

	public Integer getValorFiscal() {
		return valorFiscal;
	}

	public void setValorFiscal(Integer valorFiscal) {
		this.valorFiscal = valorFiscal;
	}

}
