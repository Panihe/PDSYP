package es.florida.AE2_Multiproceso;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Calculador {
	// M�tode: probalidad
	// Descripci� m�tode: Hace el c�lculo de la podibilidad que tiene cada uno de
	// los NEOs en colisionar con la tierra
	// Par�metros de entrada: String nombreNEO, double posicionNEO i double
	// velocidadNEO pasado por par�metro
	// Par�metros de salida: Return resultado
	public double probabilidad(String nombreNEO, double posicionNEO, double velocidadNEO) {
		String nombreNEOs = nombreNEO;
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
			posicionNEO = posicionNEO + velocidadNEO * i;
			posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random()
				* Math.pow(((posicionNEO - posicionTierra) / (posicionNEO + posicionTierra)), 2);
		return resultado;
	}

	// M�tode: main
	// Descripci� m�tode: Obtiene el nombre, posicion i velocidad de cada neo, con
		// la variable resultado le paso el resultado de colisi�n i le digo si el
		// resultado es mayor a 10 muestra un mensaje de Alerta Mundial sino
		// tranquilidad, luego muestra el nombre y la posibilidad por pantalla, y por
		// �ltimo guarda el resltudo de la posibilidad en un fichero aparte con el
		// nombre del NEo como nombre del archivo
	// Par�metros de entrada: String[] args pasado por par�metro
	// Par�metros de salida: No
	public static void main(String[] args) {
		Calculador calculador = new Calculador();
		String nombreNEO = args[0];
		double posicionNEO = Double.parseDouble(args[1]);
		double velocidadNEO = Double.parseDouble(args[2]);
		double resultado = calculador.probabilidad(nombreNEO, posicionNEO, velocidadNEO);

		if (resultado > 10) {
			System.err.println("Alerta Mundial, hay peligro de colisi�n con la Tierra");
		} else {
			System.err.println("Tranquilidad, no hay peligro de colisi�n con la Tierra");
		}

		System.out.println("Nombre: " + nombreNEO);
		System.out.println("Probabilidad: " + String.format("%.2f", resultado) + "%" + "\n");

		try {
			File fitxerNEO = new File(nombreNEO + ".txt");
			FileWriter fw = new FileWriter(fitxerNEO);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Probabilidad: " + String.format("%.2f", resultado) + "%");
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
