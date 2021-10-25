package es.florida.EjTema2;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		int numberStart = Integer.parseInt(args[0]);
		int numberEnd = Integer.parseInt(args[1]);
		int sum = 0;
		for(int i = numberStart; i <= numberEnd; i++) {
			sum += i;
		}
		
		System.out.println("La suma de los números, desde el número " + numberStart + " hasta el número " + numberEnd + " (ambos inclusive) es: " + sum);
	}

}
