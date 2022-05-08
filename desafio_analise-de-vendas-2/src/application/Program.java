package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Sale;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the full file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Sale> sale = new ArrayList<>();

			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");
				Integer month = Integer.parseInt(fields[0]);
				Integer year = Integer.parseInt(fields[1]);
				String seller = fields[2];
				Integer items = Integer.parseInt(fields[3]);
				Double total = Double.parseDouble(fields[4]);

				sale.add(new Sale(month, year, seller, items, total));

				line = br.readLine();

			}

			Map<String, Double> sales = sale.stream().collect(
					Collectors.groupingBy(Sale::getSeller, Collectors.summingDouble(value -> value.getTotal())));

			System.out.printf("\nTotal de vendas por vendedor:\n");
			sales.forEach((x, y) -> System.out.println(x + " - R$: " + String.format("%.2f", y)));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
