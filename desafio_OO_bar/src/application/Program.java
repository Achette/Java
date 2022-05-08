package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Bill;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.print("Gender: ");
		Bill.gender = sc.nextLine().charAt(0);
		System.out.print("Beer quantity: ");
		Bill.beer = sc.nextInt();
		System.out.print("SoftDrink quantity: ");
		Bill.softDrink = sc.nextInt();
		System.out.print("Barbecue quantity: ");
		Bill.barbecue = sc.nextInt();

		System.out.println("\n*** RELATÓRIO ***");
		System.out.println("Consumo: " + String.format("%.2f", Bill.Feeding()));
		if (Bill.Feeding() > 30.0) {
			System.out.println("ISENTO DE COUVERT");
		} else {
			System.out.println("Couvert: " + String.format("%.2f", Bill.Cover()));
		}
		System.out.println("Ingresso: " + String.format("%.2f", Bill.Ticket()));

		System.out.println("\nValor a pagar = R$ " + String.format("%.2f", Bill.Total()));

		sc.close();

	}

}
