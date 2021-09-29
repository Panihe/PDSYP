package es.florida.AE01;

import java.util.Scanner;

public class Ejercicio8 {
	
	public static void main(String[] args) {
		int numberStart, numberEnd;
		
		Scanner sc = new Scanner(System.in);
	
		System.out.print("Introduce un número: ");
		numberStart = Integer.parseInt(sc.nextLine());
		
		System.out.print("Introduce otro número: ");
		numberEnd = Integer.parseInt(sc.nextLine());
		
		long tiempoInicio = System.nanoTime();
		for(int i = numberStart; i <= numberEnd; i++) {
			if(isPrime(i)) {
				System.out.println(String.valueOf(i) + " - Primo");
			}else {
				System.out.println(String.valueOf(i) + " - No primo");
			}
		}
		
		//Tiempo final
        long tiempoFinal = System.nanoTime();
        //Resta del tiempo final menos el tiempo de inicio
        double tiempoMilisegundos = (tiempoFinal-tiempoInicio)/1e6;
        double tiempoSegundos = tiempoMilisegundos/1000;
        if(tiempoSegundos <= 0.001) {
        	 System.out.println("Duración: " + String.format ("%.3f",tiempoSegundos) + " segundo");
             
        }else if (tiempoSegundos > 0.001){
        	 System.out.println("Duración: " + String.format ("%.3f",tiempoSegundos) + " segundos");
        }
       
		sc.close();
	}
	
	public static boolean isPrime(int number) {
		// El 0, 1 y 4 no son primos
		if (number == 0 || number == 1 || number == 4) {
			return false;
		}
		
		for (int x = 2; x < number / 2; x++) {
			// Si es divisible por cualquiera de estos números, no es primo
			if (number % x == 0) {
				return false;
			}
				
		}
		
		// Si no se pudo dividir por ninguno de los de arriba, sí es primo
		return true;
		
	}
}
