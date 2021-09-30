package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		System.out.print("Introduce tu contraseña: ");
		
		String password = sc.nextLine();
		
		if(password.length() >= 5) {
			for(int i =  password.length()-1; i < password.length(); i++) {
				i++;
				System.out.println("La contraseña: " + password + " tiene un tamaño de " + i + " caracteres");
			}
			
			boolean number = false;
			boolean capitalLetter = false;
			
			// Convierto la contraseña en array
			String[] passwordArray = password.split("");
			
			// Comparo cada letra de la contraseña
			for(int i = 0; i < password.length(); i++) {
				
				// Compruebo la contraseña contiene algún caracter en mayúscula
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
					System.out.println("La contraseña: " + password + " contiene " + i + " números");
				}
				
				if (capitalLetter) {
					for(int i = password.length()-1; i < password.length(); i++) {
						i++;
						System.out.println("La contraseña: " + password + " contiene " + i + " letras en mayúscula");
					}
				}else {
					System.out.println("La contraseña: " + password + " no contiene ninguna letra en mayúscula");
				}
			}else {
				System.out.println("La contraseña: " + password + " no contiene ningún número");
			}
		}else {
			System.out.println("La contraseña tiene menos de 5 caracteres");
		}
		
		
		sc.close();
		
	}

}
