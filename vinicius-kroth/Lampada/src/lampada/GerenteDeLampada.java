package lampada;

public class GerenteDeLampada {

	private Lampada lampada;

	public GerenteDeLampada(Lampada lampada) {
		this.lampada = lampada;
	}

	/**
	 * Método que inverte o estado atual da lâmpada
	 **/
	public String switchDaLampada() {
		if (lampada.isOn()) {
			lampada.off();
			return "Sua lâmpada foi apagada";
		} else {
			lampada.on();
			return "Sua lâmpada foi ligada";
		}

	}

	/**
	 * Método que informa estado atual da lâmpada
	 **/
	public String estadoDaLampada() {
		if (lampada.isOn()) {
			lampada.off();
			return "Sua lâmpada está ligada";
		} else {
			lampada.on();
			return "Sua lâmpada está desligada";
		}

	}

	public String informacoesDaLampada() {
		return lampada.toString();
	}
}
