package es.florida.AE4_sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
	
	// M�todo: main
	// Descripci�n m�todo: Arranca el servidor y una vez ha hecho la conexi�n lanza el hilo de la clase peticion
	// Par�metros de entrada: String[] args pasado por par�metro
	// Par�metros de salida: No
	public static void main(String[] args) throws IOException {
		System.err.println("SERVIDOR >>> Arranca el servidor, espera petici�n: ");
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(1234);
		} catch (IOException e) {
			System.err.println("SERVIDOR >>> Error");
			return;
		}
		while(true) {
			Socket conexion = socketEscucha.accept();
			System.err.println("SERVIDOR >>> Conexi�n recibida --> Lanza hilo clase Petici�n");
			Peticion peticion = new Peticion(conexion);
			Thread hilo = new Thread(peticion);
			hilo.start();
		}
	}
}
