package es.florida.EjTema1;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number1 = 0;
		int number2 = 0;

		do {
			System.out.print("Introduce un n�mero: ");
			number1 =Integer.parseInt(sc.nextLine());  
			
			System.out.print("Introduce otro n�mero: ");
			number2 =Integer.parseInt(sc.nextLine());
			
		}while(number1 != number2);
		System.out.println("El n�mero " + number1 + " es igual que el n�mero " + number2);
		
		sc.close();
	}

}
