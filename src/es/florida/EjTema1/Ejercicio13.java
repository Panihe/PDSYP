package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 

		System.out.print("Introduce un valor en grados centigrados: ");
		double centigradesDegrees = Double.parseDouble(sc.nextLine());
		
		double farenheitDegrees = centigradesDegrees;
		farenheitDegrees = farenheitDegrees * 2 - farenheitDegrees / 5;
		farenheitDegrees += 32;
		
		System.out.println("El valor, introducido anteriormente, en grados Frarenheit es: " + String.format("%.1f", farenheitDegrees) + "F");
		
		sc.close();
	}

}
