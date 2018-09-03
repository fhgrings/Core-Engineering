package com.github.vinifkroth.coreeng.tema7.factory;

import com.github.vinifkroth.coreeng.tema7.model.Closet;
import com.github.vinifkroth.coreeng.tema7.model.Furniture;
import com.github.vinifkroth.coreeng.tema7.model.Rack;
import com.github.vinifkroth.coreeng.tema7.model.Shelf;

public class FurnitureFactory {

	public static Furniture getFurniture(String furnitureType) {
		if (furnitureType == null)
			return null;

		if (furnitureType.equalsIgnoreCase("SHELF"))
			return new Shelf();

		else if (furnitureType.equalsIgnoreCase("RACK"))
			return new Rack();

		else if (furnitureType.equalsIgnoreCase("CLOSET"))
			return new Closet();

		return null;
	}
}
