package com.github.vinifkroth.coreeng.tema8.app;

import com.github.vinifkroth.coreeng.tema8.model.Passanger;
import com.github.vinifkroth.coreeng.tema8.model.RivendellProxy;
import com.github.vinifkroth.coreeng.tema8.util.Races;

public class App {

	public static void main(String[] args) {
		RivendellProxy proxy = new RivendellProxy();
		
		Passanger orc = new Passanger("Orcedia", Races.orc);
		Passanger human = new Passanger("Aragorn", Races.human);
		Passanger elf = new Passanger("Legolas", Races.elf);
		Passanger hobbit = new Passanger("Frodo", Races.hobbit);
		Passanger hobbitTwo = new Passanger("Sam", Races.hobbit);
		Passanger dwarf = new Passanger("Thorin", Races.dwarf);
		Passanger wizard = new Passanger("Gandalf", Races.wizard);
		
		System.out.println(proxy.enter(orc));
		System.out.println(proxy.enter(human));
		System.out.println(proxy.enter(elf));
		System.out.println(proxy.enter(hobbit));
		System.out.println(proxy.enter(hobbitTwo));
		System.out.println(proxy.enter(dwarf));
		System.out.println(proxy.enter(wizard));
	}

}
