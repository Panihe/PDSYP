package es.florida.EjTema2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce un número: ");
		int numero1 = Integer.parseInt(sc.nextLine());

		System.out.print("Introduce otro número: ");
		int numero2 = Integer.parseInt(sc.nextLine());
		
		String nombreFichero = "resultado_ej7.txt";
		File fichero = new File(nombreFichero);

		String clase = "es.florida.EjTema2.Ejercicio1";

		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String className = clase;
		ArrayList<String> command = new ArrayList<>();
		command.add(javaBin);
		command.add("-cp");
		command.add(classpath);
		command.add(className);
		command.add(String.valueOf(numero1));
		command.add(String.valueOf(numero2));
		System.out.println("Comando que se pasa a ProcessBuilder: " + command + "\n");
		System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",","") + "\n");
		ProcessBuilder builder = new ProcessBuilder(command);
		builder.redirectOutput(fichero);
		try {
			builder.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

		sc.close();

	}

}
