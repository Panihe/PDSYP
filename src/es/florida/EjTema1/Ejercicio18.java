package es.florida.EjTema1;
import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce una contrase�a: ");

		String password = sc.nextLine();

		System.out.print("Repite la contrase�a: ");

		String passwordRepeat = sc.nextLine();

		if (!(password == "" && passwordRepeat == "")) {
			if (password.equals(passwordRepeat)) {
				System.out.println("Las contrase�as coinciden");
				if (password.length() >= 5) {
					System.out.println("La contrase�a: " + password + " tiene un tama�o de un m�nimo de 5 caracteres");
					boolean number = false;
					boolean capitalLetter = false;

					// Convierto la contrase�a en array
					String[] passwordArray = password.split("");

					// Comparo cada letra de la contrase�a
					for (int i = 0; i < password.length(); i++) {

						// Compruebo la contrase�a contiene alg�n caracter en may�scula
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
						System.out.println("La contrase�a: " + password + " contiene, al menos, un n�mero");

						if (capitalLetter) {
							System.out.println(
									"La contrase�a: " + password + " contiene, al menos, una letra en may�scula");
						} else {
							System.out
									.println("La contrase�a: " + password + " no contiene ninguna letra en may�scula");
						}
					} else {
						System.out.println("La contrase�a: " + password + " no contiene ning�n n�mero");
					}

				} else {
					System.out.println("La contrase�a tiene menos de 5 caracteres");
				}
			} else {
				System.out.println("Cuidado!, las contrase�as introducidas no coinciden");
			}
		} else {
			System.out.println("Cuidado!, no has introducido ning�n car�cter en ning�n campo de contrase�as");
		}

		sc.close();

	}

}
