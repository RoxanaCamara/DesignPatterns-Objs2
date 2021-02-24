package cultivos.region;

import java.util.ArrayList;
import java.util.List;

import cultivos.Porcion;

public class Parcela {

	List<Porcion> region;
	
	public Parcela() {
		super();
		this.region = new ArrayList<Porcion>();
	}

	public Integer gananciaAnual() {
		Integer total = 0;
		for(Porcion p : region ) {
			total = total + p.getGanancia(); 
		}
		return total;	
	}

	public List<Porcion> getRegion() {
		return region;
	}

	public void setRegion(Porcion region) {
		this.region.add(region);
	}

	
}
