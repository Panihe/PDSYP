package es.florida.EjTema2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce un número: ");
		int numero1 = Integer.parseInt(sc.nextLine());
		System.out.print("Introduce otro número: ");
		int numero2 = Integer.parseInt(sc.nextLine());
		String nombreFichero1 = "resultado1.txt";
		
		System.out.print("Introduce otro número: ");
		int numero3 = Integer.parseInt(sc.nextLine());
		System.out.print("Introduce otro número: ");
		int numero4 = Integer.parseInt(sc.nextLine());
		String nombreFichero2 = "resultado2.txt";

		// Llamada 1
		String clase = "es.florida.EjTema2.Ejercicio3";

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
		command.add(nombreFichero1);
		System.out.println("Comando que se pasa a ProcessBuilder: " + command + "\n");
		System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",","") + "\n");
		ProcessBuilder builder = new ProcessBuilder(command);
		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Llamada 2
		ArrayList<String> command2 = new ArrayList<>();
		command2.add(javaBin);
		command2.add("-cp");
		command2.add(classpath);
		command2.add(className);
		command2.add(String.valueOf(numero3));
		command2.add(String.valueOf(numero4));
		command2.add(nombreFichero2);
		System.out.println("Comando que se pasa a ProcessBuilder: " + command2 + "\n");
		System.out.println("Comando a ejecutar en cmd.exe: " + command2.toString().replace(",","") + "\n");
		ProcessBuilder builder2 = new ProcessBuilder(command2);
		try {
			builder2.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		boolean ficheroLeido = false;
		while(!ficheroLeido) {
			File fichero1 = new File(nombreFichero1);
			File fichero2 = new File(nombreFichero2);
			FileReader fr1;
			FileReader fr2;
			try {
				fr1 = new FileReader(fichero1);
				BufferedReader br1 = new BufferedReader(fr1);
				String resultado1 = br1.readLine();
				br1.close();
				fr1.close();
				
				fr2 = new FileReader(fichero2);
				BufferedReader br2 = new BufferedReader(fr2);
				String resultado2 = br2.readLine();
				br2.close();
				fr2.close();
				
				System.out.println("Resultado (leído de fichero): " + resultado1);
				System.out.println("Resultado (leído de fichero): " + resultado2);
				
				ficheroLeido = true;
			}catch (FileNotFoundException e) {
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		sc.close();

	}

}
