package com.github.vinifkroth.coreeng.tema10.model;

public class Coffee extends HotBeverage {

	@Override
	String setUp() {
		return "Grounding all the coffe beans and put them on the filter and boiling the water.\n";
	}

	@Override
	String heat() {
		return "Pouring the boiled water slowly on the coffee filter\n";
	}

	@Override
	String serve() {
		return "Serving the hot coffee on a cup with a bicuit on the side\n";
	}

}
