package com.github.vinifkroth.coreeng.tema8.model;

class Rivendell implements MiddleEarthCity {

	@Override
	public String enter(Passanger passanger) {

		if (passanger.getRace().equalsIgnoreCase("elf"))
			return "Welcome back brother, dinner will be served to celebrate your homecoming with a lot of leaves and lembas.";

		return "Welcome to Rivendell dear " + passanger.getName() + " we wish you safe passage and good fortune"
				+ " please enjoy yourself with our Elvish hospitality.";
	}

}
