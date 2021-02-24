package productos;

public class Cooperativa extends Producto {
	
	private Integer ivaDescuento;
	
	public Cooperativa(Integer precio, Integer stock, Integer ivaDescuento ) {
		super(precio, stock);
		this.ivaDescuento=ivaDescuento;
	}
	
	public Integer getIvaDescuento() {
		return ivaDescuento;
	}

	public void setIvaDescuento(Integer ivaDescuento) {
		this.ivaDescuento = ivaDescuento;
	}

	@Override
	public Integer getPrecio() {
		return precio - getIvaDescuento() ;
	}
}
