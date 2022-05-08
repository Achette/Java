package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.print("Quantas aulas tem o curso? ");
		int N = sc.nextInt();

		List<Lesson> lessons = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			System.out.printf("Dados da %da aula:\n", i);
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			sc.nextLine();
			char type = sc.nextLine().charAt(0);
			System.out.print("Título: ");
			String title = sc.nextLine();

			if (type == 'c' || type == 'C') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int duration = sc.nextInt();

				lessons.add(new Video(title, url, duration));
			} else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questions = sc.nextInt();

				lessons.add(new Task(title, description, questions));
			}
		}

		int durationTotal = 0;

		for (Lesson lesson : lessons) {
			durationTotal += lesson.duration();
		}

		System.out.printf("\nDURAÇÃO TOTAL DO CURSO = %d segundos.", durationTotal);

		sc.close();

	}

}
