package es.florida.AE4_sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
	
	// Método: main
	// Descripción método: Arranca el servidor y una vez ha hecho la conexión lanza el hilo de la clase peticion
	// Parámetros de entrada: String[] args pasado por parámetro
	// Parámetros de salida: No
	public static void main(String[] args) throws IOException {
		System.err.println("SERVIDOR >>> Arranca el servidor, espera petición: ");
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(1234);
		} catch (IOException e) {
			System.err.println("SERVIDOR >>> Error");
			return;
		}
		while(true) {
			Socket conexion = socketEscucha.accept();
			System.err.println("SERVIDOR >>> Conexión recibida --> Lanza hilo clase Petición");
			Peticion peticion = new Peticion(conexion);
			Thread hilo = new Thread(peticion);
			hilo.start();
		}
	}
}
