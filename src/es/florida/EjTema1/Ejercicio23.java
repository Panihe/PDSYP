package es.florida.EjTema1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

//		for(int i = 0; i < 5; i++) {
//			System.out.print("Por favor introduzca un nombre: ");
//			String nombrePersona = sc.nextLine();
//	}

		String nombrePersona;
		ArrayList<String> nombres = new ArrayList<String>();
		boolean parar;

		do {
			System.out.print("Introduce un nombre: ");

			nombrePersona = sc.nextLine();

			nombres.add(nombrePersona);

			if (isNumeric(nombrePersona)) {
				parar = false;
			} else {
				parar = true;

			}

		} while (parar);

		for (int i = 0; i < nombres.size()-1; i++) {
			System.out.println(nombres.get(i));
		}

		sc.close();

	}

	private static boolean isNumeric(String nombrePersona) {

		try {
			int numeroPersona = Integer.parseInt(nombrePersona);
			;
			if (numeroPersona == 0) {
				return true;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return false;
	}
}