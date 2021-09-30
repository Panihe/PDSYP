package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); 

		int dni = 0;
		
		System.out.print("Introduce tu DNI (sin la letra): ");
		dni = Integer.parseInt(sc.nextLine());
			
		String lettersDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
		
		if(dni > 8) {
	
			// Calcula la letra correcta
			int rest = dni % 23;
			char letterCorrect = lettersDNI.charAt(rest);
				
			System.out.println("Tu dni es: "  + dni + letterCorrect);
			
		}else if(dni <= 8) {
			System.out.println("La parte númerica de tu dni debe tener 8 números");
		}
		
		sc.close();
	}
}
