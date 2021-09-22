package es.florida.AE01;

import java.util.Scanner;

public class Ejercicio6 {
	
	
	public static void main(String[] args) {
		intNumbers();
	}
	
	public static void intNumbers() {
		int num[] = new int[5];
		Scanner sc = new Scanner(System.in);
	
		for (int i = 0; i < num.length; i++) {
			System.out.print("Introduce un número entero: ");
			num[i] = Integer.parseInt(sc.nextLine());
		}
		
		int sum = 0;
		System.out.println("Imprimiendo orden inverso: ");
		for (int i = num.length - 1; i >= 0 ; i--) {
            System.out.println(num[i]);
            sum += num[i];
        }
		
		System.out.println("La suma de los números proporcionados es: " + sum);
		
		sc.close();
	}
}
