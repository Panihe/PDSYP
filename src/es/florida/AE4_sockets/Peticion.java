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
	BufferedReader bufferedReader;
	PrintWriter printWriter;
	Socket socket;

	// Método: Peticion
	// Descripción método: Obtiene el socket para poder utilizarlo
	// Parámetros de entrada: No
	// Parámetros de salida: No
	public Peticion(Socket socket) {
		this.socket = socket;
	}

	// Método: Encriptar
	// Descripción método: Encripta la contraseña en caracteres ASCII. Cada caracter
	// de la contraseña le suma el siguiente caracter. Y sustituye los caracteres
	// que no son imprimibles por un asterisco
	// Parámetros de entrada: No
	// Parámetros de salida: No
	public String encriptar(String contrasena) {
		char contraArray[] = contrasena.toCharArray();
		for (int i = 0; i < contraArray.length; i++) {
			if (contraArray[i] >= 0 && contraArray[i] <= 31 && contraArray[i] == 127) {
				contraArray[i] = '*';
			} else {
				contraArray[i] = (char) (contraArray[i] + (char) 1);
			}
		}
		return String.valueOf(contraArray);
	}

	// Método: encriptarMD5
	// Descripción método: Encripta la contraseña en MD5
	// Parámetros de entrada: String
	// Parámetros de salida: No
	public static String encriptarMD5(String contrasena) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] messageDigestByte = messageDigest.digest(contrasena.getBytes());
			BigInteger number = new BigInteger(1, messageDigestByte);
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
	// Descripción método:
	// Parámetros de entrada: No
	// Parámetros de salida: No
	public void run() {
		try {
			// Se crea el objeto contrasena y se envía al cliente
			System.err.println("SERVIDOR >>> Creación del objeto contraseña y se envia al cliente");
			ObjectOutputStream outObjetoStream = new ObjectOutputStream(socket.getOutputStream());
			Contrasena contra = new Contrasena();
			outObjetoStream.writeObject(contra);

			// Recibe la contraseña que ha puesto el cliente
			ObjectInputStream inObjetoStream = new ObjectInputStream(socket.getInputStream());
			Contrasena contraModificada = (Contrasena) inObjetoStream.readObject();
			System.err.println("SERVIDOR >>> Contraseña recibida del cliente: " + contraModificada.getContrasenaTextoPlano());

			// Pregunta el método de encriptación
			System.err.println("SERVIDOR >>> Se elije con que método de encriptación se quiere encriptar la contraseña: ");
			InputStream inputStream = socket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			OutputStream outputStream = socket.getOutputStream();

			// Se recibe la opción con el método de encriptación que se ha elegido y se realiza la encriptación de la contraseña 
			printWriter = new PrintWriter(outputStream);
			int opcionMetodo = Integer.parseInt(bufferedReader.readLine());
			System.err.println("SERVIDOR >>> Se recibe el típo de encriptación para empezar a encriptar la contraseña");
			System.err.println("SERVIDOR >>> Se realiza la encriptacion");
			String contrasena = contraModificada.getContrasenaTextoPlano();
			String contrasenaEncriptada = "";
			if (opcionMetodo == 1) {
				contrasenaEncriptada = encriptar(contrasena);
			} else {
				contrasenaEncriptada = encriptarMD5(contrasena);
			}

			// Devuelve la contraseña encriptada
			System.err.println("SERVIDOR >>> La contraseña encriptada es: " + contrasenaEncriptada);
			printWriter.write(contrasenaEncriptada.toString() + "\n");
			
			
			// Se envía la contraseña encriptada al cliente
			contra = new Contrasena(contrasena, contrasenaEncriptada);
			System.err.println("SERVIDOR >>> Se envía al cliente la contraseña encriptada: " + contrasenaEncriptada);
			outObjetoStream.writeObject(contra);

			printWriter.flush();
			
			outObjetoStream.close();
			inObjetoStream.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("SERVIDOR >>> Error.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
