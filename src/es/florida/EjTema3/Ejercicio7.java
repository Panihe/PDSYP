package es.florida.EjTema3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio7 implements Runnable {
	
	double distancia = 1;
	double velocidad;
	String nombre;
	static String nombreFicheroLlegada = "ficheroLlegada.txt";
	
	Ejercicio7(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	}
	
	public static void main(String[] args) {
		File ficheroLlegada = new File(nombreFicheroLlegada);
		ficheroLlegada.delete(); // Borrar si existe para empezar carrera nueva
		
		String[] arrayNombres = {"Turbo","Rayo","Flash","Viento","Lightspeed"};
		double[] arrayVelocidades = {0.01, 0.01, 0.01, 0.01, 0.01}; // Velocidad en metros por segundo
		int[] arrayPrioridades = {1,2,3,4,10};
		int NUM_HILOS = 5;
		Ejercicio7 objetoCaracol;
		Thread hiloCaracol;
		for (int i = 0; i < NUM_HILOS; i++) {
			objetoCaracol = new Ejercicio7(arrayNombres[i], arrayVelocidades[i]);
			hiloCaracol = new Thread(objetoCaracol);
			hiloCaracol.setPriority(arrayPrioridades[i]);
			hiloCaracol.start();
		}
		boolean ficheroExiste = false;
		FileReader fr;
		while(!ficheroExiste) {
			try {
				fr = new FileReader(ficheroLlegada);
				BufferedReader br = new BufferedReader(fr);
				String nombre = br.readLine();
				System.out.println("CARRERA FINALIZADA: ha ganado " + nombre);
				br.close();
				fr.close();
				ficheroExiste = true;
			}catch (IOException e) {
				//e.printStackTrace();
			}
		}
		
	} 
	
	@Override
	public void run() {
		File ficheroLlegada = new File(nombreFicheroLlegada);
		double avance = 0; 
		double porcentaje = 0;
		System.out.println(nombre + " inicia la carrera");
		while (avance < distancia) {
			if(ficheroLlegada.exists()) { // Algun hilo ha acabado la carrera y ha creado ya el fichero de llegada
				System.out.println(nombre + "> Alguien ha ganadado la carrera... abandono en el " + String.format("%.0f", porcentaje) + "%  :(");
				avance = distancia; // Abandonar el while haciendole creer que ha acabado la carrera
			} else {
				avance += velocidad * 1; // Asumir una iteración por segundo
				porcentaje = 100 * avance / distancia;
				System.out.println(nombre + " > " + String.format("%.0f", porcentaje) + "%");
			}
		}
		if(!ficheroLlegada.exists()) { // Commprobar que ningun hilo ha escrito aun el fichero de llegada
			FileWriter fw;
			try {
				fw = new FileWriter(ficheroLlegada);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(nombre);
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.err.println(nombre + " > ¡¡¡HE LLEGADO A LA META!!! ¡¡¡ HE GANADO LA CARRERA !!!");
		}
		
	}

	

}
