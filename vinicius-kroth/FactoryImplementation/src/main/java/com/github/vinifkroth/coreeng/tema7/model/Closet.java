package com.github.vinifkroth.coreeng.tema7.model;

public class Closet implements Furniture {

	@Override
	public String furnitureType() {
		return "Oh boy, this is a closet";
	}

	@Override
	public String useFurniture() {
		return "Oh boy, you just used the closet";
	}

}
