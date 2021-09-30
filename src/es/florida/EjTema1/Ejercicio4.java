package es.florida.EjTema1;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un número: ");
		int number1 =Integer.parseInt(sc.nextLine());  
		System.out.print("Introduce otro número: ");
		int number2 =Integer.parseInt(sc.nextLine());
		if ( number1 > number2 ) {
			System.out.println("El primer número que has introducido, " + number1 + " , es mayor que el segundo, " + number2);
		}else if ( number2 > number1) {
			System.out.println("El segundo número que has introducido, " + number2 + " , es mayor que el primero, " + number1);
		}else if ( number1 == number2) {
			System.out.println("Los números introducidos son iguales, los números son los siguientes: " + number1 + " y " + number2);
		}
		
		sc.close();
		
	}

}
