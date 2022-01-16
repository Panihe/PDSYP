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
	// Descripción método: Arranca el cliente, permite introducir una contrasena y
		// se envía al servidor para encriptarla, después se pregunta con que tipo de
		// encriptación se quiere encriptar la contraseña
	// Parámetros de entrada: String[] args pasado por parámetro
	// Parámetros de salida: No
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		String host = "localhost";
		int puerto = 1234;
		System.out.println("CLIENTE >> Arranca el cliente");
		Socket cliente = new Socket(host, puerto);
		ObjectInputStream inObjetoStream = new ObjectInputStream(cliente.getInputStream());
		
		// Se crea el objeto contraseña, se introduce por teclado una contraseña y se setea el atributo setCOntrasenaTextoPlano para que valga la contraseña que se introduce por teclado y se envía al servidor
		Contrasena contra = (Contrasena) inObjetoStream.readObject();
		Scanner sc = new Scanner(System.in);
		System.out.print("CLIENTE >> Introduce una contraseña: ");
		String contrasenaTeclado = sc.nextLine();
		contra.setContrasenaTextoPlano(contrasenaTeclado);
		ObjectOutputStream outputStream = new ObjectOutputStream(cliente.getOutputStream());
		outputStream.writeObject(contra);
		System.out.println("CLIENTE >> Se envía la contraseña: " + contra.getContrasenaTextoPlano()
				+ " al servidor para poder encriptarla");
		PrintWriter pw = new PrintWriter(cliente.getOutputStream());
		
		// Se pregunta el tipo de encriptación con que el cual se va a encriptar la contraseña introducida anteriormente por teclado
		System.out.print("CLIENTE >> Métodos de encriptación: \n" 
				+ "	- 1. ASCII \n" 
				+ "	- 2. MD5 \n"
				+ "Introduce un método de encriptación: ");
		String opcionMetodo = sc.nextLine();
		switch (opcionMetodo) {
		case "1":
			System.out.println("CLIENTE >> El método de encriptación elegido es: ASCII");
			break;
		case "2":
			System.out.println("CLIENTE >> El método de encriptación elegido es: MD5");
			break;
		}
		pw.print(opcionMetodo + "\n");
		pw.flush();

		// Se recibe la contraseña encriptada del servidor
		contra = (Contrasena) inObjetoStream.readObject();
		System.out.println(
				"CLIENTE >> Recibe la contraseña encriptada del servidor: " + contra.getContrasenaEncriptada());

		sc.close();
		inObjetoStream.close();
		outputStream.close();
		cliente.close();

	}

}
