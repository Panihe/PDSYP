package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce una contraseña: ");

		String password = sc.nextLine();

		System.out.print("Repite la contraseña: ");

		String passwordRepeat = sc.nextLine();

		if (!(password == "" && passwordRepeat == "")) {
			if (password.equals(passwordRepeat)) {
				System.out.println("Las contraseñas coinciden");
				if (password.length() >= 5) {
					System.out.println("La contraseña: " + password + " tiene un tamaño de un mínimo de 5 caracteres");
					boolean number = false;
					boolean capitalLetter = false;

					// Convierto la contraseña en array
					String[] passwordArray = password.split("");

					// Comparo cada letra de la contraseña
					for (int i = 0; i < password.length(); i++) {

						// Compruebo la contraseña contiene algún caracter en mayúscula
						if (Character.isUpperCase(passwordArray[i].toCharArray()[0])) {
							capitalLetter = true;
						}

						// Paso passwordArray[i] a Integer

						try {
							Integer.parseInt(passwordArray[i]);
							// Paso number a true
							number = true;
						} catch (NumberFormatException e) {

						}
					}

					// Compruebo si number y capitalLetter es true o false
					if (number) {
						System.out.println("La contraseña: " + password + " contiene, al menos, un número");

						if (capitalLetter) {
							System.out.println(
									"La contraseña: " + password + " contiene, al menos, una letra en mayúscula");
						} else {
							System.out
									.println("La contraseña: " + password + " no contiene ninguna letra en mayúscula");
						}
					} else {
						System.out.println("La contraseña: " + password + " no contiene ningún número");
					}

				} else {
					System.out.println("La contraseña tiene menos de 5 caracteres");
				}
			} else {
				System.out.println("Cuidado!, las contraseñas introducidas no coinciden");
			}
		} else {
			System.out.println("Cuidado!, no has introducido ningún carácter en ningún campo de contraseñas");
		}

		sc.close();

	}

}
