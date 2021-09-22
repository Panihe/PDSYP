package es.florida.AE01;

import java.util.Scanner;

public class Ejercicio3 {
	
	
	public static void main(String[] args) {
		sumPairsNumbers();
	}
	
	public static void sumPairsNumbers() {
		Scanner sc = new Scanner(System.in);
		int sumPairs = 0;
		
		System.out.print("Introduce un número para sumar los números pares hasta el número introducido: ");
		int toNumber = Integer.parseInt(sc.nextLine());
		
		for (int i = 1; i <= toNumber; i++) {
	        if(i % 2 == 0){
	            sumPairs += i;
	        }
	    }
		
		System.out.print("La suma de los números pares hasta el número " + toNumber + " (introducido anteriormente) es: " + sumPairs);
		
		sc.close();
	}
}
