package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		System.out.print("Introduce tu contrase�a: ");
		
		String password = sc.nextLine();
		
		if(password.length() >= 5) {
			for(int i =  password.length()-1; i < password.length(); i++) {
				i++;
				System.out.println("La contrase�a: " + password + " tiene un tama�o de " + i + " caracteres");
			}
			
			boolean number = false;
			boolean capitalLetter = false;
			
			// Convierto la contrase�a en array
			String[] passwordArray = password.split("");
			
			// Comparo cada letra de la contrase�a
			for(int i = 0; i < password.length(); i++) {
				
				// Compruebo la contrase�a contiene alg�n caracter en may�scula
				if(Character.isUpperCase(passwordArray[i].toCharArray()[0])) {
					capitalLetter = true;
				}
				
				// Paso passwordArray[i] a Integer
				
				try {
					Integer.parseInt(passwordArray[i]);
					// Paso number a true
					number = true;
				}catch (NumberFormatException e) {
					
				}
			}
			
			// Compruebo si number y capitalLetter es true o false
			
			if(number) {
				for(int i = password.length()-1; i < password.length(); i++) {
					i++;
					System.out.println("La contrase�a: " + password + " contiene " + i + " n�meros");
				}
				
				if (capitalLetter) {
					for(int i = password.length()-1; i < password.length(); i++) {
						i++;
						System.out.println("La contrase�a: " + password + " contiene " + i + " letras en may�scula");
					}
				}else {
					System.out.println("La contrase�a: " + password + " no contiene ninguna letra en may�scula");
				}
			}else {
				System.out.println("La contrase�a: " + password + " no contiene ning�n n�mero");
			}
		}else {
			System.out.println("La contrase�a tiene menos de 5 caracteres");
		}
		
		
		sc.close();
		
	}

}
