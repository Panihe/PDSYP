package es.florida.EjTema1;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un n�mero: ");
		int number1 =Integer.parseInt(sc.nextLine());  
		System.out.print("Introduce otro n�mero: ");
		int number2 =Integer.parseInt(sc.nextLine());
		if ( number1 > number2 ) {
			System.out.println("El primer n�mero que has introducido, " + number1 + " , es mayor que el segundo, " + number2);
		}else if ( number2 > number1) {
			System.out.println("El segundo n�mero que has introducido, " + number2 + " , es mayor que el primero, " + number1);
		}else if ( number1 == number2) {
			System.out.println("Los n�meros introducidos son iguales, los n�meros son los siguientes: " + number1 + " y " + number2);
		}
		
		sc.close();
		
	}

}
