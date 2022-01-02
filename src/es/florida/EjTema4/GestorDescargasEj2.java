package es.florida.EjTema4;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class GestorDescargasEj2 {

	public void descargarArchivo(String url_descargar, String nombreArchivo) {
		System.out.println(" Descargando " + url_descargar + " a " + nombreArchivo);
		try {
			URL Url = new URL(url_descargar);
			InputStream is = Url.openStream();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			is.transferTo(byteArrayOutputStream);
			byte[] bytes = byteArrayOutputStream.toByteArray();
			OutputStream out = new FileOutputStream(nombreArchivo);

			out.write(bytes);
			
			System.out.println(" Se ha descargado el fichero");

			//System.out.println(new String(bytesData));
			is.close();
		} catch (MalformedURLException e) {
			System.out.println("URL mal escrita!");
		} catch (IOException e) {
			System.out.println("Fallo en la lectura del fichero");
		}
	}

	public static void main(String[] args) {
		GestorDescargasEj2 gd = new GestorDescargasEj2();
		String url = "http://localhost:800/dam/programacion_servicios_y_procesos/descarga.jpg";
		String fichero = "ficheroDescargado.jpg";
		gd.descargarArchivo(url, fichero);

	}

}
