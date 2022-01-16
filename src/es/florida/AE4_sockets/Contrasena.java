package es.florida.AE4_sockets;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contrasena implements Serializable {
	String contrasenaTextoPlano;
	String contrasenaEncriptada;
	
	// M�todo: contrasena
	// Descripci�n m�todo: Obtiene la contrase�a en texto plano y la contrase�a encriptada para poder utilizarla
	// Par�metros de entrada: String contrasenaTextoPlano y String contrasenaEncriptada pasado por par�metro
	// Par�metros de salida: No
	public Contrasena(String contrasenaTextoPlano, String contrasenaEncriptada) {
		this.contrasenaTextoPlano = contrasenaTextoPlano;
		this.contrasenaEncriptada = contrasenaEncriptada;
	}
	
	// M�todo: contrasena
	// Descripci�n m�todo: Si la contrasena est� vac�a
	// Par�metros de entrada: No
	// Par�metros de salida: No
	public Contrasena() {
		super();
	}
	

	// M�todo: getContrasenaTextoPlano
	// Descripci�n m�todo: Obtiene la contrase�a en texto plano
	// Par�metros de entrada: No
	// Par�metros de salida: Devuelve la contrase�a en texto plano
	public String getContrasenaTextoPlano() {
		return contrasenaTextoPlano;
	}

	// M�todo: setContrasenaTextoPlano
	// Descripci�n m�todo: Establece la contrase�a obtenida en getContrasenaTextoPlano
	// Par�metros de entrada: String contrasenaTextoPlano pasado por p�rametros 
	// Par�metros de salida: No
	public void setContrasenaTextoPlano(String contrasenaTextoPlano) {
		this.contrasenaTextoPlano = contrasenaTextoPlano;
	}
	
	// M�todo: getContrasenaEncriptada
	// Descripci�n m�todo: Obtiene la contrase�a encriptada
	// Par�metros de entrada: No
	// Par�metros de salida: Devuelve la contrase�a encriptada
	public String getContrasenaEncriptada() {
		return contrasenaEncriptada;
	}

	// M�todo: setContrasenaEncriptada
	// Descripci�n m�todo: Establece la contrase�a obtenido en getContrasenaEncriptada
	// Par�metros de entrada: String contrasenaEncriptada pasado por p�rametros 
	// Par�metros de salida: No
	public void setContrasenaEncriptada(String contrasenaEncriptada) {
		this.contrasenaEncriptada = contrasenaEncriptada;
	}
}
