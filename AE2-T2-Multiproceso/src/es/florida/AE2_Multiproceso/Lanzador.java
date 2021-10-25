package es.florida.AE2_Multiproceso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Lanzador {
	// M�tode: lanzarPosibilidad
	// Descripci� m�tode: Llama a la clase Calculador para obtener los datos del
	// c�lculo e inicia el proceso por bloques mediante el waitFor().
	// Par�metros de entrada: String nombreNEO, String velodidadNEO, String
	// posicionNEO pasado por par�metro
	// Par�metros de salida: No
	public void lanzarProbabilidad(String nombreNEO, String velocidadNEO, String posicionNEO) {
		String clase = "es.florida.AE2_Multiproceso.Calculador";
		try {
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			// System.out.println(classpath);
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(nombreNEO.toString());
			command.add(velocidadNEO.toString());
			command.add(posicionNEO.toString());

			// System.out.println("Comando que se pasa a ProcessBuilder: " + command);
			// System.out.println("Comando a ejecutar en cmd.exe: " +
			// command.toString().replace(",",""));

			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start();
			// Process process = builder.start();
			process.waitFor();
			// System.out.println(process.exitValue());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// M�tode: main
	// Descripci� m�tode: Lee l�nea a l�nea el fichero NEOs.txt. Obtiene el nombre,
		// posici�n y velocidad del archivo. Obtiene cuantos nucleos tiene el procesador
		// y dependiendo el n�mero de nucleos mostrar� tantos neos como nucleos tenga el
		// procesador. Tambi�n calcula el tiempo de ejecuci�n total de la aplicaci�n y
		// el tiempo medio por cada neo que se ha analizado
	// Par�metros de entrada: String[] args pasado por par�metro
	// Par�metros de salida: No
	public static void main(String[] args) {
		ArrayList<String> neos = new ArrayList<String>();
		File f = new File("NEOs.txt");
		Lanzador lanzador = new Lanzador();
		// Tiempo inicio
		long tiempoInicio = System.nanoTime();
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				neos.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Obt� el nombre de cores que t� el procesador */
		int cores = Runtime.getRuntime().availableProcessors();
		// System.out.println(cores);

		for (int i = 0; i < cores; i++) {
			String[] lineas = neos.get(i).split(",");
			lanzador.lanzarProbabilidad(lineas[0], lineas[1], lineas[2]);
		}

		// Tiempo final
		long tiempoFinal = System.nanoTime();
		// Resta del tiempo final menos el tiempo de inicio
		double tiempoMilisegundos = (tiempoFinal - tiempoInicio) / 1e6;
		double tiempoSegundos = tiempoMilisegundos / 1000;
		if (tiempoSegundos <= 0.001) {
			System.out.println("Tiempo total: " + String.format("%.2f", tiempoSegundos) + " segundo");
		} else if (tiempoSegundos > 0.001) {
			System.out.println("Tiempo total: " + String.format("%.2f", tiempoSegundos) + " segundos");
		}

		double tiempoMedioMilisegundos = (tiempoFinal - tiempoInicio) / 1e6;
		double tiempoCores = tiempoMedioMilisegundos / cores;
		double tiempoMedioSegundos = tiempoCores / 1000;
		if (tiempoMedioSegundos <= 0.001) {
			System.out.println("Tiempo medio: " + String.format("%.2f", tiempoMedioSegundos) + " segundo");
		} else if (tiempoMedioSegundos > 0.001) {
			System.out.println("Tiempo medio: " + String.format("%.2f", tiempoMedioSegundos) + " segundos");
		}
	}

}
