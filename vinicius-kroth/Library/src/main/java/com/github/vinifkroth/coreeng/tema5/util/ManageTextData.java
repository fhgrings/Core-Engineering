package com.github.vinifkroth.coreeng.tema5.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.github.vinifkroth.coreeng.tema5.model.*;
import com.github.vinifkroth.coreeng.tema5.service.Library;

public class ManageTextData {
	private static List<Book> books;
	private static List<Client> clients;
	private static List<Lease> leases;
	
	public static Library extractData() {
		clients = new ArrayList<>();
		books = new ArrayList<>();
		leases = new ArrayList<>();
		Integer currentIdNumber = 0;
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader("arquivobase.txt"));
			currentIdNumber = Integer.parseInt(br.readLine());
			while (br.ready()) {
				line = br.readLine();
				if (line.charAt(0) == '$') {
					parseBooks(line);
				} else if (line.charAt(0) == '&') {
					parseClients(line);
				} else {
					parseLeases(line);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Library(books, currentIdNumber, clients, leases);
	}

	public static void storeData(String data) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("arquivobase.txt"));
			bw.write(data);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void parseLeases(String leaseInfo) {
		leaseInfo = leaseInfo.substring(1);
		String []splitingAux = leaseInfo.split(";");
		String bookId = splitingAux[0];
		String clientDocument = splitingAux[1];

		Optional<Book> retrievedBook = books.stream().filter(b -> b.getId().equals(bookId)).findFirst();
		Optional<Client> retrievedClient = clients
				.stream()
				.filter(c -> c.getDocument().equals(clientDocument))
				.findFirst();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Lease lease = new Lease(retrievedBook.get(), retrievedClient.get(),
				LocalDate.parse(splitingAux[2], formatter));
		leases.add(lease);
	}
	
	private static void parseBooks(String bookInfo) {
		bookInfo = bookInfo.substring(1);
		String[] splitingAux = bookInfo.split(";");
		Book book = new Book(splitingAux[0], splitingAux[1], splitingAux[2],
				Boolean.parseBoolean(splitingAux[3]));
		books.add(book);
		
	}
	
	private static void parseClients(String clientInfo) { 
		clientInfo = clientInfo.substring(1);
		String[] splitingAux = clientInfo.split(";");
		Client client = new Client(splitingAux[0], Integer.parseInt(splitingAux[1]), splitingAux[2]);
		clients.add(client);	
	}
}
