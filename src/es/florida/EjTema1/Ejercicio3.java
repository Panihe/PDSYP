package es.florida.EjTema1;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un número: ");
		int number1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("Introduce otro número: ");
		int number2 = Integer.parseInt(sc.nextLine());
		int sum = number1 + number2;
		System.out.println("La suma de los dos números, introducidos por teclado anteriormente, es: " + sum);
		sc.close();
	}

}
