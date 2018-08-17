package lampada;

import java.util.concurrent.ThreadLocalRandom;

public class LampadaIncandescente extends Lampada {

	private final int tempoDeAquecimento = ThreadLocalRandom.current().nextInt(20, 200);

	// Método toy realizado para diferenciar as classes
	/**
	 * Método que retorna o tempo de aquecimento necessário para a lâmpada ligar, em
	 * milissegundos
	 **/
	public String tempoDeAquecimento() {
		return "O tempo de aquecimento é de: " + tempoDeAquecimento;
	}

	@Override
	public String toString() {
		return "LampadaIncandescente [tempoDeAquecimento=" + tempoDeAquecimento + "]";
	}
	
	


}
