
/*
 * Fichero: EnviarMail.java
 * Autor: Chuidiang
 * Fecha: 5/04/07 18:14
 */
package chuidiang.ejemplos.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Ejemplo de envio de correo simple con JavaMail
 *
 * @author Chuidiang
 *
 */
public class EnviarMail
{
  /**
   * main de prueba
   * @param args Se ignoran.
   */
  public static void main(String[] args)
  {
    try
    {
      // Propiedades de la conexión
      Properties props = new Properties();
      props.setProperty("mail.smtp.host", "smtp.mail.yahoo.com");
      props.setProperty("mail.smtp.starttls.enable", "true");
      props.setProperty("mail.smtp.port", "587");
      props.setProperty("mail.smtp.user", "patitasalrescate10@yahoo.com");
      props.setProperty("mail.smtp.auth", "true");

      // Preparamos la sesion
      Session session = Session.getDefaultInstance(props);

      // Construimos el mensaje
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress("patitasalrescate10@yahoo.com"));
      message.addRecipient(
          Message.RecipientType.TO,
          new InternetAddress("ftoledofernadnez@frba.utn.edu.ar"));
      message.setSubject("Hola");
      message.setText(
          "Mensajito con Java Mail" + "de los buenos." + "poque si");

      // Lo enviamos.
      Transport t = session.getTransport("smtp");
      t.connect("patitasalrescate10@yahoo.com", "elfjlphzgtjacsfk");
      t.sendMessage(message, message.getAllRecipients());

      // Cierre.
      t.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
