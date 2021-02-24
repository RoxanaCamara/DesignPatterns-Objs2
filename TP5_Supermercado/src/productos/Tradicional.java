package productos;

public class Tradicional extends Producto{

	public Tradicional(Integer precio, Integer stock) {
		super(precio, stock);
	}

	@Override
	public Integer getPrecio() {
		return precio;
	}

}
