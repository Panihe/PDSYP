package es.florida.EjTema2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		int numberStart = Integer.parseInt(args[0]);
		int numberEnd = Integer.parseInt(args[1]);
		String nombreFichero = args[2];
		int sum = 0;
		for(int i = numberStart; i <= numberEnd; i++) {
			sum += i;
		}
		
		System.out.println("La suma de los números, desde el número " + numberStart + " hasta el número " + numberEnd + " (ambos inclusive) es: " + sum);
		
		File  fichero = new File(nombreFichero);
		FileWriter fw;
		BufferedWriter bw;
		System.out.println("Iniciando escritura en el fichero...");
		try {
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);
			bw.write(String.valueOf(sum));
			bw.close();
			fw.close();
			System.out.println("Fichero escrito con éxito!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

}
