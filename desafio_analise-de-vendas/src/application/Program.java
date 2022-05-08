package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Sale;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the full file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Sale> sales = new ArrayList<>();

			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");
				sales.add(new Sale(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), fields[2],
						Integer.parseInt(fields[3]), Double.parseDouble(fields[4])));

				line = br.readLine();
			}

			Double avgPrice = sales.stream().map(x -> x.averagePrice()).reduce(0.0, (x, y) -> x + y) / sales.size();
			// System.out.println(avgPrice);

			Comparator<Sale> comp = (x1, x2) -> x1.averagePrice().compareTo(x2.averagePrice());

			List<Sale> topFiveSales = sales.stream()
					.filter(x -> x.averagePrice() > avgPrice && x.getYear() == 2016)
					.sorted(comp.reversed())
					.limit(5)
					.toList();

			System.out.printf("\nCinco primeiras vendas de 2016 de maior preço médio: \n");
			topFiveSales.forEach(System.out::println);

			List<Sale> salesLogan = sales.stream()
					.filter(x -> x.getSeller().equals("Logan"))
					.toList();

			Double totalSalesLogan_1 = salesLogan.stream()
					.filter(x -> x.getMonth() == 1)
					.map(x -> x.getTotal())
					.reduce(0.0, (x, y) -> x + y);

			Double totalSalesLogan_7 = salesLogan.stream()
					.filter(x -> x.getMonth() == 7)
					.map(x -> x.getTotal())
					.reduce(0.0, (x, y) -> x + y);

			Double totalSalesMonthsLogan = totalSalesLogan_1 + totalSalesLogan_7;

			System.out.printf("\nValor total vendido pelo vendedor Logan nos meses 1 e 7: %.2f", totalSalesMonthsLogan);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		sc.close();

	}

}
