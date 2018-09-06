package com.github.vinifkroth.coreeng.tema10.model;

public abstract class HotBeverage {

	public String prepare() {
		return setUp() + heat() + serve();
	}

	abstract String setUp();

	abstract String heat();

	abstract String serve();
}
