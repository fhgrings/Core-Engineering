package com.github.vinifkroth.coreeng.tema10.app;

import com.github.vinifkroth.coreeng.tema10.model.Coffee;
import com.github.vinifkroth.coreeng.tema10.model.HotBeverage;
import com.github.vinifkroth.coreeng.tema10.model.HotChocolate;

public class App {

	public static void main(String args[]) {

		HotBeverage coffee = new Coffee();
		HotBeverage hotChocolate = new HotChocolate();
		
		
		System.out.println(coffee.prepare());
		System.out.println(hotChocolate.prepare());
	}
}
