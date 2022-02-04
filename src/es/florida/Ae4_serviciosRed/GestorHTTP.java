package es.florida.Ae4_serviciosRed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GestorHTTP implements HttpHandler {

	int temperaturaActual = 21;
	int temperaturaTermostato = 21;

	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		String requestParamValue = null;
		if ("GET".equals(httpExchange.getRequestMethod())) {
			requestParamValue = handleGetRequest(httpExchange);
			handleGETResponse(httpExchange, requestParamValue);
		} else if ("POST".equals(httpExchange.getRequestMethod())) {
			try {
				requestParamValue = handlePostRequest(httpExchange);
				handlePOSTResponse(httpExchange, requestParamValue);
			} catch (IOException | InterruptedException | MessagingException  e) {
				e.printStackTrace();
			}
		}
	}

	private String handleGetRequest(HttpExchange httpExchange) {
		return httpExchange.getRequestURI().toString().split("\\?")[1];
	}

	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponsePage = "<html lang='en'>" + "<head>" + "<meta charset='UTF-8'>"
				+ "<meta http-equiv='X-UA-Compatible' content='IE=edge'>"
				+ "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
				+ "<title>AE5 - Temperatura</title>" + "</head>"
				+ "<body style='display: flex; justify-content: center; padding: 0; background-color: #082031; font-family: Roboto; margin: 0; '>"
				+ "<div style='display: flex; flex-direction: row; justify-content: center; align-items: center'>"
				+ "<div style='display: flex; flex-direction: column; justify-content: center; align-items: center; width: 25vw; padding-top: 2.5em; padding-right: 2em; padding-bottom: 2.5em; padding-left: 2em; background-color: #324555; border-radius: 10px; box-shadow: 10px 10px 5px #2b3b48;'>"
				+ "<div style='display: flex; flex-direction: row; justify-content: center; box-shadow: -5px -5px 5px #525733; border-top-left-radius: 10px; border-top-right-radius: 10px; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px;'>"
				+ "<span style='display: flex; flex-direction: row; justify-content: center; width: 12.5vw; padding: 12.5px; background-color: #676E41; color: #FAFAFA; font-size: 16px; font-weight: 700; border-top-left-radius: 10px; border-bottom-left-radius: 10px;'>Temperatura Actual</span>"
				+ "<span style='display: flex; flex-direction: row; justify-content: center; width: 6.5vw; padding: 12.5px; background-color: #CEB551; color: #111; font-size: 16px; font-weight: normal; align-self: center; border-top-right-radius: 10px; border-bottom-right-radius: 10px;'>"
				+ temperaturaActual + "&#8451;" + "</span>" + "</div>"

				+ "<div style='display: flex; flex-direction: row; margin-top: 3vh; box-shadow: -5px -5px 5px #525733; border-top-left-radius: 10px; border-top-right-radius: 10px; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px;'>"
				+ "<span style='display: flex; flex-direction: row; justify-content: center; width: 12.5vw; padding: 12.5px; background-color: #676E41; color: #FAFAFA; font-size: 16px; font-weight: 700; border-top-left-radius: 10px; border-bottom-left-radius: 10px;'>Temperatura Termostato</span>"
				+ "<span style='display: flex; flex-direction: row; justify-content: center; width: 6.5vw; padding: 12.5px; background-color: #CEB551; color: #111; font-size: 16px; font-weight: normal; align-self: center; border-top-right-radius: 10px; border-bottom-right-radius: 10px;'>"
				+ temperaturaTermostato + "&#8451;" + "</span>" + "</div>" + "</div>" + "</div>" + "</body>" + "</html>";
		httpExchange.sendResponseHeaders(200, htmlResponsePage.length());
		outputStream.write(htmlResponsePage.getBytes());
		outputStream.flush();
		outputStream.close();
	}

	private String handlePostRequest(HttpExchange httpExchange) throws IOException, MessagingException {
		InputStream inputStream = httpExchange.getRequestBody();
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		String linea, postRequest = "", setTemperatura, temperatura =  br.readLine(), notificarAveria;
		try {
			while ((linea = br.readLine()) != null) {
				postRequest += linea + "\n";
				System.out.println(postRequest);
			}
			
			if(postRequest.contains("setTemperatura")) {
				setTemperatura = postRequest.split("=")[0];
				if (setTemperatura.equals("setTemperatura")) {
					temperatura = postRequest.split("=")[1];
				}
			}else if(postRequest.contains("notificarAveria")) {
				notificarAveria = postRequest.split(":")[0];
				if (notificarAveria.equals("notificarAveria")) {
					String emailParamRemitente = postRequest.split(";")[0].split("=")[0].split(":")[1];
					String emailValor = postRequest.split(";")[0].split("=")[1];
					String contrasenaParamRemitente = postRequest.split(";")[1].split("=")[0];
					String contrasenaValor = postRequest.split(";")[1].split("=")[1];
					
					if(emailParamRemitente.equals("email_remitente")) {
						if(contrasenaParamRemitente.equals("pass_remitente")) {
							if(!emailValor.equals(null)) {
								if(!contrasenaValor.equals(null)) {
									System.out.println("Se envía el email al técnico poniendo en copia a Lord Stark");
									String asuntoEmail = "AVERIA";
									String mensajeEmail = "Tras haber hecho una revisión a las estufas se ha encontrado una avería en una estufa";
									String servidorEmail = "smtp.gmail.com";
									String puertoTls = "587";
									String ficheroImagen = "imagen.jpg";
									String ficheroPdf = "pdf.pdf";
									String anexo[] = {ficheroImagen, ficheroPdf};			
									String emailTecnico = "mantenimientoinvernalia@gmail.com";
									String emailLordStark = "megustaelfresquito@gmail.com";
									String emails[] = {emailTecnico, emailLordStark};
									
									envioMail(mensajeEmail, asuntoEmail, emailValor, contrasenaValor, servidorEmail , puertoTls, emails, anexo);
								}else {
									System.out.println("El valor del párametro de la contraseña del remitente está vacío");
								}
							}else {
								System.out.println("El valor del párametro del email del remitente está vacío");
							}
						}else {
							System.out.println("El parámetro de la contraseña del remitente no es correcto");
						}
					}else {
						System.out.println("El parámetro del email del remitente no es correcto");
					}
					
				}
			
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temperatura;
	}

	private void handlePOSTResponse(HttpExchange httpExchange, String requestParamValue)
			throws IOException, InterruptedException {
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponsePostman = "";
		String paramValue = requestParamValue.split("=")[1];
		temperaturaTermostato = Integer.parseInt(paramValue);
		htmlResponsePostman = "Asignamos la nueva temperatura a la que alcanzara la temperatura del termostato, la nueva temperatura es: "
				+ paramValue + "ºC";
		System.out.println(htmlResponsePostman);
		httpExchange.sendResponseHeaders(200, htmlResponsePostman.length());
		outputStream.write(htmlResponsePostman.getBytes());
		outputStream.flush();
		outputStream.close();
		regularTemperatura();
		
	}

	private void regularTemperatura() throws InterruptedException {
		int termostato = temperaturaTermostato;
		System.out.println("Comienza la regulación de la temperatura actual:");
		while (temperaturaActual != termostato) {
			if (temperaturaActual > termostato) {
				temperaturaActual--;
				System.out.println("Temperatura Actual: " + temperaturaActual + "ºC");
			} else if (temperaturaActual < termostato) {
				temperaturaActual++;
				System.out.println("Temperatura Actual: " + temperaturaActual + "ºC");
			}
			Thread.sleep(5000);
		}
		System.out.println("Ha terminado la regulación de la temperatura actual, ahora la temperatura actual es: " + temperaturaActual + "ºC");
	}

	public static void envioMail(String mensaje, String asunto, String email_remitente, String email_remitente_pass,
			String host_email, String port_email, String[] email_destino, String[] anexo)
			throws UnsupportedEncodingException, MessagingException {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host_email);
		props.put("mail.smtp.user", email_remitente);
		props.put("mail.smtp.clave", email_remitente_pass);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port_email);
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email_remitente));
		message.addRecipients(Message.RecipientType.TO, email_destino[0]);
		message.addRecipients(Message.RecipientType.TO, email_destino[1]);
		message.setSubject(asunto);
		BodyPart messageBodyPart1 = new MimeBodyPart();
		messageBodyPart1.setText(mensaje);
		BodyPart messageBodyPart2 = new MimeBodyPart();
		DataSource srcAnexoImagen = new FileDataSource(anexo[0]);
		messageBodyPart2.setDataHandler(new DataHandler(srcAnexoImagen));
		messageBodyPart2.setFileName(anexo[0]);
		DataSource srcAnexoPdf = new FileDataSource(anexo[1]);
		messageBodyPart2.setDataHandler(new DataHandler(srcAnexoPdf));
		messageBodyPart2.setFileName(anexo[1]);
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart1);
		multipart.addBodyPart(messageBodyPart2);
		message.setContent(multipart);
		Transport transport = session.getTransport("smtp");
		transport.connect(host_email, email_remitente, email_remitente_pass);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

}
