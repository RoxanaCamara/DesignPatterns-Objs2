package poker;

import java.util.ArrayList;
import java.util.List;

public class PokerStatus {

	private List<Naipe> naipes = new ArrayList<Naipe>();

	public PokerStatus() {}

	public List<Naipe> getNaipes() {
		return naipes;
	}

	public String verificar(Naipe naipe1, Naipe naipe2, Naipe naipe3, Naipe naipe4, Naipe naipe5) {
		naipes.add(naipe1);
		naipes.add(naipe2);
		naipes.add(naipe3);
		naipes.add(naipe4);
		naipes.add(naipe5);
		return this.tipoDeJugada();
	}
	
	private String tipoDeJugada() {
		if(this.esPoker()) { return "POKER";}
		if(this.esTrio())  { return "TRIO";}
		if(this.esColor()) {return "COLOR";} //Hay un problema con color
		return "No hay jugada";
	}

	public boolean esPoker() {
		return this.cantidadDeNaipesIguales(naipes.get(0)) >= 4 || 
				this.cantidadDeNaipesIguales(naipes.get(1)) >= 4;
	}

	public boolean esColor() {
		return sonDeMismoPalo("PICAS") || sonDeMismoPalo("DIAMANTES") || sonDeMismoPalo("CORAZONES")
				|| sonDeMismoPalo("TREBOLES");
	}

	//ACa esta el error pero no se cual es
	public boolean sonDeMismoPalo(String palo) {
		return naipes.stream().allMatch(n -> n.getPalo().equals(palo));
	}

	public boolean esTrio() {
		return this.cantidadDeNaipesIguales(naipes.get(0)) == 3 ||
			   this.cantidadDeNaipesIguales(naipes.get(1)) == 3 || 
			   this.cantidadDeNaipesIguales(naipes.get(2)) == 3;
	}

	public long cantidadDeNaipesIguales(Naipe naipe) {
		return naipes.stream().filter(n -> n.getValor() == naipe.getValor()).count();
	}
}
