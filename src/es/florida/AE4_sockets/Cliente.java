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
	// Descripci�n m�todo: Arranca el cliente, permite introducir una contrasena y
		// se env�a al servidor para encriptarla, despu�s se pregunta con que tipo de
		// encriptaci�n se quiere encriptar la contrase�a
	// Par�metros de entrada: String[] args pasado por par�metro
	// Par�metros de salida: No
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		String host = "localhost";
		int puerto = 1234;
		System.out.println("CLIENTE >> Arranca el cliente");
		Socket cliente = new Socket(host, puerto);
		ObjectInputStream inObjetoStream = new ObjectInputStream(cliente.getInputStream());
		
		// Se crea el objeto contrase�a, se introduce por teclado una contrase�a y se setea el atributo setCOntrasenaTextoPlano para que valga la contrase�a que se introduce por teclado y se env�a al servidor
		Contrasena contra = (Contrasena) inObjetoStream.readObject();
		Scanner sc = new Scanner(System.in);
		System.out.print("CLIENTE >> Introduce una contrase�a: ");
		String contrasenaTeclado = sc.nextLine();
		contra.setContrasenaTextoPlano(contrasenaTeclado);
		ObjectOutputStream outputStream = new ObjectOutputStream(cliente.getOutputStream());
		outputStream.writeObject(contra);
		System.out.println("CLIENTE >> Se env�a la contrase�a: " + contra.getContrasenaTextoPlano()
				+ " al servidor para poder encriptarla");
		PrintWriter pw = new PrintWriter(cliente.getOutputStream());
		
		// Se pregunta el tipo de encriptaci�n con que el cual se va a encriptar la contrase�a introducida anteriormente por teclado
		System.out.print("CLIENTE >> M�todos de encriptaci�n: \n" 
				+ "	- 1. ASCII \n" 
				+ "	- 2. MD5 \n"
				+ "Introduce un m�todo de encriptaci�n: ");
		String opcionMetodo = sc.nextLine();
		switch (opcionMetodo) {
		case "1":
			System.out.println("CLIENTE >> El m�todo de encriptaci�n elegido es: ASCII");
			break;
		case "2":
			System.out.println("CLIENTE >> El m�todo de encriptaci�n elegido es: MD5");
			break;
		}
		pw.print(opcionMetodo + "\n");
		pw.flush();

		// Se recibe la contrase�a encriptada del servidor
		contra = (Contrasena) inObjetoStream.readObject();
		System.out.println(
				"CLIENTE >> Recibe la contrase�a encriptada del servidor: " + contra.getContrasenaEncriptada());

		sc.close();
		inObjetoStream.close();
		outputStream.close();
		cliente.close();

	}

}
