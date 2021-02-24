package cultivos;

import java.util.ArrayList;
import java.util.List;

public class Mixta  extends Porcion {
	
	List<Porcion> porciones;
	
	public Mixta(List<Porcion> porciones) {
		super();
		this.porciones = porciones;
	}

	public Mixta() {
		this.porciones = new ArrayList<Porcion>();
	}

	@Override
	public Integer getGanancia() {
		Integer total = 0;
		for(Porcion p : porciones ) {
			total += (p.getGanancia() / porciones.size()); 
		}
		return total;
	}

	public void setPorcion(Porcion porcion) {
		this.porciones.add(porcion);
	}

	public List<Porcion> getPorciones() {
		return porciones;
	}	
	
}
