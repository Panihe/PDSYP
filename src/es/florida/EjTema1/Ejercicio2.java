package es.florida.EjTema1;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce tu nombre: ");
		
		String nombre = sc.nextLine();
		System.out.println("Hola " + nombre);
		sc.close();

	}

}
