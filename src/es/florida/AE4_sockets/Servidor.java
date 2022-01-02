package es.florida.AE4_sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	// Método: main
	// Descripción método: Ejecuta la aplicación de la parte del servidor
	// Parámetros de entrada: String[] args pasado por parámetro
	// Parámetros de salida: No
	public static void main(String[] args) throws IOException {

		System.err.println("SERVIDOR >>> Arranca el servidor, espera peticion");
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(1234);
		} catch (IOException e) {
			System.err.println("SERVIDOR >>> Error");
			return;
		}
		while (true) {
			Socket conexion = socketEscucha.accept();
			System.err.println("SERVIDOR >>> Conexion recibida --> Lanza hilo clase Peticion");
			Peticion p = new Peticion(conexion);
			Thread hilo = new Thread(p);
			hilo.start();

		}


	}

}
