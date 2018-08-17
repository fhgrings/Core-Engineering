package lampada;

public abstract class Lampada implements LampadaInterface {

	/*
	 * Variável que representa o estado da lâmpada, caso esteja true, a lampâda está
	 * ligada, caso este false, a lampada está desligada.
	 */
	private boolean on;

	public Lampada() {
		on = false;
	}

	@Override
	public void on() {
		on = true;

	}

	@Override
	public void off() {
		on = false;

	}

	public boolean isOn() {
		return on;

	}

}
