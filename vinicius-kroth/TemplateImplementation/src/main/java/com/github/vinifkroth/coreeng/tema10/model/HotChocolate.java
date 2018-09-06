package com.github.vinifkroth.coreeng.tema10.model;

public class HotChocolate extends HotBeverage {

	@Override
	String setUp() {
		return "Mixing up all the ingredients on the recipient.\n";
	}

	@Override
	String heat() {
		return "Heating up all the ingredients while mixing them.\n";
	}

	@Override
	String serve() {
		return "Serving the hot chocolate on a nice preety cup, with a lot of marshmallows.\n";
	}

}
