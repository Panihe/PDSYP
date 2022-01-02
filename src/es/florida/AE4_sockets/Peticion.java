package es.florida.AE4_sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Peticion implements Runnable {
	BufferedReader bfr;
	PrintWriter pw;
	Socket socket;

	// Método: Peticion
	// Descripción método: Obtiene el socket para poder utilizarlo
	// Parámetros de entrada: No
	// Parámetros de salida: No
	public Peticion(Socket socket) {
		this.socket = socket;
	}

	// Método: Encriptar
	// Descripción método: Encripta la contraseña en caracteres ASCII. Cada caracter de la contraseña le suma el siguiente caracter. Y sustituye los caracteres que no son imprimibles por un asterisco 
	// Parámetros de entrada: No
	// Parámetros de salida: No
	public String encriptar(String contrasena) {
		char array[] = contrasena.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 0 && array[i] <= 31 && array[i] == 127) {
				array[i] = '*';
			} else {
				array[i] = (char) (array[i] + (char) 1);
			}
		}
		return String.valueOf(array);
	}

	// Método: encriptarMD5
	// Descripción método: Encripta la contraseña en MD5
	// Parámetros de entrada: String 
	// Parámetros de salida: No
	public static String encriptarMD5(String contrasena) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(contrasena.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Método: run
	// Descripción método: Ejecuta el servidor 
	// Parámetros de entrada: No
	// Parámetros de salida: No
	public void run() {
		try {
			// Se crea el objeto contrasena y se envía al cliente
			System.err.println("SERVIDOR >>> Creación del objeto contraseña y se envia al cliente");
			ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
			Contrasena c = new Contrasena();
			outObjeto.writeObject(c);
			
			// Recibe la contraseña que ha puesto el cliente
			ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
			Contrasena pMod = (Contrasena) inObjeto.readObject();
			System.err.println("SERVIDOR >>> Contraseña recibida del cliente: " + pMod.getContrasenaTextoPlano());

			// Pregunta el método de encriptación
			System.err.println("SERVIDOR >>> Elección del método de encriptación");
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			bfr = new BufferedReader(isr);
			OutputStream os = socket.getOutputStream();
			
			pw = new PrintWriter(os);
			int opcionMetodo = Integer.parseInt(bfr.readLine());
			System.err.println("SERVIDOR >>> Recibe la opción para encriptar la contraseña con el método elegido");
			System.err.println("SERVIDOR >>> Realiza la encriptacion");
			String contrasena = pMod.getContrasenaTextoPlano();
			String contrasenaEncriptada = "";
			if(opcionMetodo == 2) {
				contrasenaEncriptada = encriptarMD5(contrasena);
			}else {
				contrasenaEncriptada = encriptar(contrasena);
			}
			
			System.err.println("SERVIDOR >>> Devuelve contraseña encriptada: " + contrasenaEncriptada);
			pw.write(contrasenaEncriptada.toString() + "\n");

			c = new Contrasena(contrasena, contrasenaEncriptada);
			System.err.println("SERVIDOR >>> Envio a cliente: " + contrasenaEncriptada);
			outObjeto.writeObject(c);

			pw.flush();

			outObjeto.close();
			inObjeto.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("SERVIDOR >>> Error.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}