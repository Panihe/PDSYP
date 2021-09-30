package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print("Introduce un número: ");
			int number =Integer.parseInt(sc.nextLine());  
			sum += number;
		}
		System.out.println("La suma de los números introducidos anteriormente es " + sum);
		sc.close();
	}
	

}
