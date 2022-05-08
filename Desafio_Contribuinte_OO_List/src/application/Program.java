package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Quantos contribuintes ser�o digitados?: ");
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			System.out.printf("\nDigite os dados do %do contribuinte:\n", i + 1);
			System.out.print("Renda anual com sal�rio: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com presta��o de servi�o: ");
			double serviceIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos m�dicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();

			TaxPayer payer = new TaxPayer(salaryIncome, serviceIncome, capitalIncome, healthSpending,
					educationSpending);

			list.add(payer);

		}

		int i = 1; //Apenas para usar o la�o forEach e incrementar o n�mero do contribuinte.
		for (TaxPayer payer : list) {			
			System.out.printf("\n\nResumo do %d� contribuinte:", i++);
			System.out.printf("\nImposto Bruto Total: %.2f\n", payer.grossTax());
			System.out.printf("Abatimento: %.2f\n", payer.taxRebate());
			System.out.printf("Imposto devido: %.2f\n", payer.netTax());			
		}

		sc.close();

	}

}
