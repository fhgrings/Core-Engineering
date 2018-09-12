package com.github.vinifkroth.coreeng.tema9.app;

import com.github.vinifkroth.coreeng.tema9.apiconnection.SwApiFacade;

public class Main {

	public static void main(String args[]) {
		SwApiFacade facade = new SwApiFacade();
		System.out.println(facade.getCharacterById("2"));
		System.out.println(facade.getCharacterById("22"));
		System.out.println(facade.getMovieById("2"));
		System.out.println(facade.getMovieById("6"));
		
	}
}
