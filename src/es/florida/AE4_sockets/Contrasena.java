package es.florida.AE4_sockets;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contrasena implements Serializable {
	String contrasenaTextoPlano;
	String contrasenaEncriptada;
	
	// Método: contrasena
	// Descripción método: Obtiene la contraseña en texto plano y la contraseña encriptada para poder utilizarla
	// Parámetros de entrada: String contrasenaTextoPlano y String contrasenaEncriptada pasado por parámetro
	// Parámetros de salida: No
	public Contrasena(String contrasenaTextoPlano, String contrasenaEncriptada) {
		this.contrasenaTextoPlano = contrasenaTextoPlano;
		this.contrasenaEncriptada = contrasenaEncriptada;
	}
	
	// Método: contrasena
	// Descripción método: Si la contrasena está vacía
	// Parámetros de entrada: No
	// Parámetros de salida: No
	public Contrasena() {
		super();
	}
	

	// Método: getContrasenaTextoPlano
	// Descripción método: Obtiene la contraseña en texto plano
	// Parámetros de entrada: No
	// Parámetros de salida: Devuelve la contraseña en texto plano
	public String getContrasenaTextoPlano() {
		return contrasenaTextoPlano;
	}

	// Método: setContrasenaTextoPlano
	// Descripción método: Establece la contraseña obtenida en getContrasenaTextoPlano
	// Parámetros de entrada: String contrasenaTextoPlano pasado por párametros 
	// Parámetros de salida: No
	public void setContrasenaTextoPlano(String contrasenaTextoPlano) {
		this.contrasenaTextoPlano = contrasenaTextoPlano;
	}
	
	// Método: getContrasenaEncriptada
	// Descripción método: Obtiene la contraseña encriptada
	// Parámetros de entrada: No
	// Parámetros de salida: Devuelve la contraseña encriptada
	public String getContrasenaEncriptada() {
		return contrasenaEncriptada;
	}

	// Método: setContrasenaEncriptada
	// Descripción método: Establece la contraseña obtenido en getContrasenaEncriptada
	// Parámetros de entrada: String contrasenaEncriptada pasado por párametros 
	// Parámetros de salida: No
	public void setContrasenaEncriptada(String contrasenaEncriptada) {
		this.contrasenaEncriptada = contrasenaEncriptada;
	}
}
