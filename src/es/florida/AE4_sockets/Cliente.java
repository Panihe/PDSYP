package es.florida.AE4_sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	// Método: main
	// Descripción método: Ejecuta la aplicación de la parte del cliente
	// Parámetros de entrada: String[] args pasado por parámetro
	// Parámetros de salida: No
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		String host = "localhost";
		int puerto = 1234;
		System.out.println("CLIENTE >> Arranca cliente");
		Socket cliente = new Socket(host, puerto);
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Contrasena c = (Contrasena) inObjeto.readObject();
		Scanner sc = new Scanner(System.in);
		System.out.print("CLIENTE >> Introduce una contraseña: ");
		String contrasenaTeclado = sc.nextLine();
		c.setContrasenaTextoPlano(contrasenaTeclado);
		ObjectOutputStream pMod = new ObjectOutputStream(cliente.getOutputStream());
		pMod.writeObject(c);
		System.out.println("CLIENTE >> Envio al servidor para encriptar la contraseña: " + c.getContrasenaTextoPlano());
		PrintWriter pw = new PrintWriter(cliente.getOutputStream());
		System.out.print("CLIENTE >> Métodos de encriptación: \n"
				+ "	- 1. ASCII \n"
				+ "	- 2. MD5 \n"
				+ "Introduce un método de encriptación: ");
		String opcion = sc.nextLine();
		switch (opcion) {
		case "1":
			System.out.println("CLIENTE >> El método de encriptación elegido es: ASCII");
			break;
		case "2":
			System.out.println("CLIENTE >> El método de encriptación elegido es: MD5");
			break;
		}
		pw.print(opcion + "\n");
		pw.flush();

		c = (Contrasena) inObjeto.readObject();
		System.out.println("CLIENTE >> Contraseña encriptada recibida del servidor: " + c.getContrasenaEncriptada());

		sc.close();
		inObjeto.close();
		pMod.close();
		cliente.close();

	}

}
