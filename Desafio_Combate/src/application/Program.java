package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Champion;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("Digite os dados do primeiro campeão: ");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Vida inicial: ");
		int initialLife = sc.nextInt();
		System.out.print("Ataque: ");
		int attack = sc.nextInt();
		System.out.print("Armadura: ");
		int armor = sc.nextInt();
		
		Champion champ1 = new Champion(name, initialLife, attack, armor);
		
		System.out.println("\nDigite os dados do segundo campeão: ");
		System.out.print("Nome: ");
		sc.nextLine();
		name = sc.nextLine();
		System.out.print("Vida inicial: ");
		initialLife = sc.nextInt();
		System.out.print("Ataque: ");
		attack = sc.nextInt();
		System.out.print("Armadura: ");
		armor = sc.nextInt();
		
		Champion champ2 = new Champion(name, initialLife, attack, armor);
		
		System.out.print("\nQuantos turnos você deseja executar?: ");
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {			
			champ1.takeDamage(champ2);
			champ2.takeDamage(champ1);
			
			System.out.printf("\nResultado do turno %d\n", i + 1);
			System.out.println(champ1.Status());
			System.out.println(champ2.Status());
			
			if(champ1.getLife() <= 0 || champ2.getLife() <= 0) {				
				break;
			}
		}
		
		System.out.println("\nFIM DO COMBATE");
				
		
		sc.close();
	}

}
