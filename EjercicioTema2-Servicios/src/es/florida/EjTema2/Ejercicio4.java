package es.florida.EjTema2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce un número: ");
		int numero1 = Integer.parseInt(sc.nextLine());

		System.out.print("Introduce otro número: ");
		int numero2 = Integer.parseInt(sc.nextLine());
		
		String nombreFichero = "resultado.txt";

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
		command.add(nombreFichero);
		System.out.println("Comando que se pasa a ProcessBuilder: " + command + "\n");
		System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",","") + "\n");
		ProcessBuilder builder = new ProcessBuilder(command);
		
		/* Forma 1 */
//		try {
//			builder.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		boolean ficheroLeido = false;
//		while(!ficheroLeido) {
//			File fichero = new File(nombreFichero);
//			FileReader fr;
//			try {
//				fr = new FileReader(fichero);
//				BufferedReader br = new BufferedReader(fr);
//				String resultado = br.readLine();
//				System.out.println("Resultado (leído de fichero): " + resultado);
//				ficheroLeido = true;
//				br.close();
//				fr.close();
//			}catch (FileNotFoundException e) {
//				
//			}catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
		/* Forma 2 */
		try {
			Process p = builder.start();
			p.waitFor();
			
		} catch (IOException | InterruptedException e ) {
			e.printStackTrace();
		}
		
		boolean ficheroLeido = false;
		//while(!ficheroLeido) {
			File fichero = new File(nombreFichero);
			FileReader fr;
			try {
				fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);
				String resultado = br.readLine();
				System.out.println("Resultado (leído de fichero): " + resultado);
				ficheroLeido = true;
				br.close();
				fr.close();
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		//}
		

		sc.close();

	}

}
