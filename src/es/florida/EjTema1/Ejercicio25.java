package es.florida.EjTema1;

import java.util.Scanner;

public class Ejercicio25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int min = 1;
		int max = 10;

		int number = 0;
		int[] num = new int[3];
		int numberRandom = 0;

		for (int i = 0; i < 3; i++) {
			do {
				System.out.print("Introduce un número del " + min + " al " + max + ": ");
				number = Integer.parseInt(sc.nextLine());
				if (number < 1) {
					System.out.println("Número no válido, por favor introduce un valor mayor o igual que 1");
				}

				if (number > 10) {
					System.out.println("Número no válido, por favor introduce un valor menor o igual que 10");
				}
			} while (!(number > 1 && number < 10));
			num[i] = number;
		}

		numberRandom = (int) Math.floor(Math.random() * 10) + 1;

		for (int i = 0; i < 3; i++) {
			if (num[i] == numberRandom) {
				System.out.println("El número " + num[i] + " (introducido anteriormente) coincide con el número "
						+ numberRandom + " (generado aleatoriamente)");
				System.out.println("Enhorabuena!!, has ganado un iphone 12 pro");
			} else {
				System.out.println("El número " + num[i] + " (introducido anteriormente) no coincide con el número "
						+ numberRandom + " (generado aleatoriamente)");
				System.out.println("Suerte la próxima vez!");
			}
		}

		sc.close();

	}

}