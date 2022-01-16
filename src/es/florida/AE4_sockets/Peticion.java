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

	// M�todo: Peticion
	// Descripci�n m�todo: Obtiene el socket para poder utilizarlo
	// Par�metros de entrada: No
	// Par�metros de salida: No
	public Peticion(Socket socket) {
		this.socket = socket;
	}

	// M�todo: Encriptar
	// Descripci�n m�todo: Encripta la contrase�a en caracteres ASCII. Cada caracter
	// de la contrase�a le suma el siguiente caracter. Y sustituye los caracteres
	// que no son imprimibles por un asterisco
	// Par�metros de entrada: No
	// Par�metros de salida: No
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

	// M�todo: encriptarMD5
	// Descripci�n m�todo: Encripta la contrase�a en MD5
	// Par�metros de entrada: String
	// Par�metros de salida: No
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

	// M�todo: run
	// Descripci�n m�todo:
	// Par�metros de entrada: No
	// Par�metros de salida: No
	public void run() {
		try {
			// Se crea el objeto contrasena y se env�a al cliente
			System.err.println("SERVIDOR >>> Creaci�n del objeto contrase�a y se envia al cliente");
			ObjectOutputStream outObjetoStream = new ObjectOutputStream(socket.getOutputStream());
			Contrasena contra = new Contrasena();
			outObjetoStream.writeObject(contra);

			// Recibe la contrase�a que ha puesto el cliente
			ObjectInputStream inObjetoStream = new ObjectInputStream(socket.getInputStream());
			Contrasena contraModificada = (Contrasena) inObjetoStream.readObject();
			System.err.println("SERVIDOR >>> Contrase�a recibida del cliente: " + contraModificada.getContrasenaTextoPlano());

			// Pregunta el m�todo de encriptaci�n
			System.err.println("SERVIDOR >>> Se elije con que m�todo de encriptaci�n se quiere encriptar la contrase�a: ");
			InputStream inputStream = socket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			OutputStream outputStream = socket.getOutputStream();

			// Se recibe la opci�n con el m�todo de encriptaci�n que se ha elegido y se realiza la encriptaci�n de la contrase�a 
			printWriter = new PrintWriter(outputStream);
			int opcionMetodo = Integer.parseInt(bufferedReader.readLine());
			System.err.println("SERVIDOR >>> Se recibe el t�po de encriptaci�n para empezar a encriptar la contrase�a");
			System.err.println("SERVIDOR >>> Se realiza la encriptacion");
			String contrasena = contraModificada.getContrasenaTextoPlano();
			String contrasenaEncriptada = "";
			if (opcionMetodo == 1) {
				contrasenaEncriptada = encriptar(contrasena);
			} else {
				contrasenaEncriptada = encriptarMD5(contrasena);
			}

			// Devuelve la contrase�a encriptada
			System.err.println("SERVIDOR >>> La contrase�a encriptada es: " + contrasenaEncriptada);
			printWriter.write(contrasenaEncriptada.toString() + "\n");
			
			
			// Se env�a la contrase�a encriptada al cliente
			contra = new Contrasena(contrasena, contrasenaEncriptada);
			System.err.println("SERVIDOR >>> Se env�a al cliente la contrase�a encriptada: " + contrasenaEncriptada);
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
