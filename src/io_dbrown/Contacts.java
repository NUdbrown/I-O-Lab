package io_dbrown;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Contacts {

	String userChoice;
	String line = "";
	boolean shouldGo = true;

	ArrayList<Contact> conList = new ArrayList<Contact>();
	Scanner scan = new Scanner(System.in);

	public void Selection() {

		System.out.println("Welcome to your Contacts!");
		System.out.println("What would you like to do?");
		System.out.println("1. See all contacts");
		System.out.println("2. See a certain contact");
		System.out.println("3. Enter a new contact");
		System.out.println("4. Exit");

		userChoice = scan.nextLine();

		if (userChoice.equals("1")) {
			PrintLeName();

		} else if (userChoice.equals("2")) {
			Pick();
		} else if (userChoice.equals("3")) {
			createContact();

		} else if (userChoice.equals("4")) {
			System.out.println("Good Bye");
			shouldGo = false;
			writeContacts();
		}
	}

	public void writeContacts() {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"C:\\Contacts.csv"));
			for (int i = 0; i < conList.size(); i++) {
				writer.write(conList.get(i).toString() + '\n');

			}

			writer.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void createContact() {
		System.out.println("Enter a name");
		String conName = scan.nextLine();
		System.out.println("Enter an email");
		String conEmail = scan.nextLine();
		System.out.println("Enter a phone number");
		String conPhone = scan.nextLine();

		conList.add(new Contact(new String[] { conName, conEmail, conPhone }));

	}

	public boolean shouldGo() {
		return shouldGo;
	}

	public void LoadingFile() {
		FileReader input = null;
		try {
			input = new FileReader("C:\\Contacts.csv");
			BufferedReader reader = new BufferedReader(input);

			while (reader.ready()) {
				line = reader.readLine();
				conList.add(new Contact(line.split(",")));

			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void PrintLeName() {
		for (int i = 0; i < conList.size(); i++) {
			System.out.println(i + " " + conList.get(i).name);

		}

	}

	public void Pick() {
		System.out.println("Which contact would you like to see?");
		System.out.println("Select a number.");
		int conChoice = scan.nextInt();
		System.out.println("Name: " + conList.get(conChoice).name);
		System.out.println("Email: " + conList.get(conChoice).email);
		System.out.println("Phone: " + conList.get(conChoice).phone);
	}
}
