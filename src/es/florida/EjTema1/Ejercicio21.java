package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
//		for(int i = 0; i < 5; i++) {
//			System.out.print("Por favor introduzca un nombre: ");
//			String nombrePersona = sc.nextLine();
//		}
		
		int i = 0;
		
		do {
			System.out.print("Por favor introduzca un nombre: ");
			String nombrePersona = sc.nextLine();
			i++;
			
			sc.close();
		}while (i < 5);
		
		
	}

}