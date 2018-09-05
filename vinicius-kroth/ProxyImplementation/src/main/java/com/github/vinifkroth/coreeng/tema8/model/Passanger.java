package com.github.vinifkroth.coreeng.tema8.model;

public class Passanger {
	private String name;
	private String race;

	public Passanger(String name, String race) {
		this.name = name;
		this.race = race;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

}
