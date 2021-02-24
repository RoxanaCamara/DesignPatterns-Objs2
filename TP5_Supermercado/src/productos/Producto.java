package productos;

public abstract class Producto {
	
	protected Integer stock;
	protected Integer precio;
	
	protected Producto(Integer precio, Integer stock) {
		this.precio= precio;
		this.stock= stock;
	}
	
	public abstract Integer getPrecio();

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void reducirStock() {
		this.setStock( stock-1  );	
	}

}
