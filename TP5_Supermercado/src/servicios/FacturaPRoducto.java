package servicios;
import java.util.ArrayList;
import java.util.List;
import cliente.Cliente;
import productos.Producto;


public class FacturaPRoducto implements Factura {
	
	private List<Producto> productos = new ArrayList<Producto>();
	private Integer precioTotal;
	private Cliente cliente;


	public FacturaPRoducto() {
		precioTotal=0;
	}
	
	public void agregarProducto(Producto producto) {
		producto.reducirStock();
		precioTotal+= producto.getPrecio();
		this.productos.add(producto);
	}

	public Integer getPrecioTotal() {
		return precioTotal;
	}

	@Override
	public void realizarPago() {
		cliente.cobrar(this.getPrecioTotal());
	}

	
}
