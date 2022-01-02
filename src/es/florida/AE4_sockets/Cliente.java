package es.florida.AE4_sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	// M�todo: main
	// Descripci�n m�todo: Ejecuta la aplicaci�n de la parte del cliente
	// Par�metros de entrada: String[] args pasado por par�metro
	// Par�metros de salida: No
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		String host = "localhost";
		int puerto = 1234;
		System.out.println("CLIENTE >> Arranca cliente");
		Socket cliente = new Socket(host, puerto);
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Contrasena c = (Contrasena) inObjeto.readObject();
		Scanner sc = new Scanner(System.in);
		System.out.print("CLIENTE >> Introduce una contrase�a: ");
		String contrasenaTeclado = sc.nextLine();
		c.setContrasenaTextoPlano(contrasenaTeclado);
		ObjectOutputStream pMod = new ObjectOutputStream(cliente.getOutputStream());
		pMod.writeObject(c);
		System.out.println("CLIENTE >> Envio al servidor para encriptar la contrase�a: " + c.getContrasenaTextoPlano());
		PrintWriter pw = new PrintWriter(cliente.getOutputStream());
		System.out.print("CLIENTE >> M�todos de encriptaci�n: \n"
				+ "	- 1. ASCII \n"
				+ "	- 2. MD5 \n"
				+ "Introduce un m�todo de encriptaci�n: ");
		String opcion = sc.nextLine();
		switch (opcion) {
		case "1":
			System.out.println("CLIENTE >> El m�todo de encriptaci�n elegido es: ASCII");
			break;
		case "2":
			System.out.println("CLIENTE >> El m�todo de encriptaci�n elegido es: MD5");
			break;
		}
		pw.print(opcion + "\n");
		pw.flush();

		c = (Contrasena) inObjeto.readObject();
		System.out.println("CLIENTE >> Contrase�a encriptada recibida del servidor: " + c.getContrasenaEncriptada());

		sc.close();
		inObjeto.close();
		pMod.close();
		cliente.close();

	}

}
