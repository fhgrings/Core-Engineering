package com.github.vinifkroth.coreeng.tema4.util;

import java.util.Scanner;

import com.github.vinifkroth.coreeng.tema4.model.Contato;

public class CriadorDeContato {

	public static Contato criar() {
		Scanner in = new Scanner(System.in);
		String nome, numero, email;

		System.out.println("Digite o nome do contato:");
		nome = in.nextLine();
		while (nome.equals(null) || nome.length() < 2) {
			System.out.println("Erro encontrado, por favor, redigite o nome do contato:");
			nome = in.nextLine();
		}

		System.out.println("Digite o número do contato:");
		numero = in.nextLine();
		while (numero.equals(null) || numero.length() < 1) {
			System.out.println("Erro encontrado, por favor, redigite o número do contato:");
			numero = in.nextLine();
		}

		System.out.println("Digite o e-mail do contato:");
		email = in.nextLine();
		while (email.equals(null) || email.length() < 1) {
			System.out.println("Erro encontrado, por favor, redigite o email do contato:");
			numero = in.nextLine();
		}
		
		Contato contato = new Contato(nome, numero, email);
		return contato;
	}
}
