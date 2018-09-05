package com.github.vinifkroth.coreeng.tema8.model;

public class RivendellProxy implements MiddleEarthCity {

	private static MiddleEarthCity city;

	public RivendellProxy() {
		RivendellProxy.city = new Rivendell();
	}

	@Override
	public String enter(Passanger passanger) {
		if (passanger.getRace().equalsIgnoreCase("DWARF"))
			return "Stay back Dwarf, by the word of our lord Elrond you're not welcome here in our holy ground!";
		if (passanger.getRace().equalsIgnoreCase("ORC"))
			return "GUARDS, ATTACK!!! THERE'S A FILTHY ORC BY THE GATE!";
		return city.enter(passanger);
	}

}
