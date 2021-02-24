package banco;

import java.util.ArrayList;
import java.util.List;
import cliente.Cliente;
import creditos.Credito;

public class Banco {
	
	private List<Credito> creditos= new ArrayList<Credito>();
	private List<Cliente> clientes= new ArrayList<Cliente>();
	
	public void recibirSolicitud(Credito credito) {
		System.out.println ( "credito.estaAprobado()" + credito.estaAprobado());
		if(credito.estaAprobado()){
			creditos.add(credito);
			System.out.println ( "credito" + creditos.size());

		}
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public Integer totalDeCreditos() {
		Integer total = 0;
		for(Credito c : creditos  ) {
			total+= c.getMonto();
		}
		return total;
	}

	public List<Credito> getCreditos() {
		return creditos;
	}

	

}
