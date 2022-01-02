package es.florida.EjTema4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args)  throws UnknownHostException, IOException, ClassNotFoundException {
//		String host = "localhost";
//		int puerto = 5000;
//		System.out.println("CLIENTE >> Arranca cliente");
//		Socket cliente = new Socket(host, puerto);
//		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
//		Cliente p = (Cliente) inObjeto.readObject();
//		System.out.println("CLIENTE >> Recibo del servidor: " + p.getNombre() + " - " + p.getEdad());
//		p.setNombre("Jose Garcia");
//		p.setEdad(30);
//		ObjectOutputStream pMod = new ObjectOutputStream(cliente.getOutputStream());
//		pMod.writeObject(p);
//		System.out.println("CLIENTE >> Envio al servidor: " + p.getNombre() + " - " + p.getEdad());
//		inObjeto.close();
//		pMod.close();
//		cliente.close();

	}

}
