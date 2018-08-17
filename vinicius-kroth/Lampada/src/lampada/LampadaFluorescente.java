package lampada;

import java.util.concurrent.ThreadLocalRandom;

public class LampadaFluorescente extends Lampada {
	/*
	 * Variavel que informa a frequencia a lampada, inicializada quando o objeto é
	 * criado
	 */
	private final int frequencia = ThreadLocalRandom.current().nextInt(50, 500);

	// Método toy realizado para diferenciar as classes
	/**
	 * Método que retorna a frequencia da lampada
	 **/
	public String frequenciaDaLampada() {
		return "Sua lâmpada tem frequencia de: " + frequencia;
	}

	@Override
	public String toString() {
		return "LampadaFluorescente [frequencia=" + frequencia + "]";
	}

}
