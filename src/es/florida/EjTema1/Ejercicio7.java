package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int i = 1;
		int sum = 0;
		while (i < 5) {
			System.out.print("Introduce un n�mero: ");
			int number =Integer.parseInt(sc.nextLine());  
			sum += number;
			i++;
		}
		System.out.println("La suma de los n�meros introducidos anteriormente es " + sum);
		sc.close();
	}

}
