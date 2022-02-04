package es.florida.Ae4_serviciosRed;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.sun.net.httpserver.HttpServer;

public class Servidor {

	public static void main(String[] args) throws Exception {
		String host = "localhost"; //127.0.0.1
		int puerto = 7777;
		InetSocketAddress direccionTCPIP = new InetSocketAddress(host,puerto);
		int backlog = 0;
		HttpServer servidor = HttpServer.create(direccionTCPIP, backlog);
		
		GestorHTTPHand gestorHTTP = new GestorHTTPHand();
		String rutaRespuesta = "/estufa";
		servidor.createContext(rutaRespuesta, gestorHTTP); 
		
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
		servidor.setExecutor(threadPoolExecutor);
		
		servidor.start();
		System.out.println("Servidor HTTP arranca en el puerto " + puerto);
	}

}
