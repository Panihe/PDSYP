package es.florida.AE01;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		long factorial = 1;
		for(int i = 2; i <= 15; i++) {
			factorial *= i;
		}
		System.out.println("El factorial del número 15 es: " + factorial);
	}
}
