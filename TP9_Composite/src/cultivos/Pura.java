package cultivos;

public class Pura extends Porcion {
	
	private Integer ganacia;
	private String planta;

	public Pura(Integer ganacia, String planta) {
		super();
		this.ganacia = ganacia;
		this.setPlanta(planta);
	}

	@Override
	public Integer getGanancia() {
		return ganacia;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

}
