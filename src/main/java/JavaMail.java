import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class JavaMail {
  private static String mailPatitas = "facutoledof@gmail.com";
  private static String contraseniaMailPatitas = "dano67890";
  private static Session session;
  private Properties props = new Properties();


  public JavaMail(){
    // Nombre del host de correo, es smtp.gmail.com
    props.setProperty("mail.smtp.host", "smtp.gmail.com");

    // TLS si está disponible
    props.setProperty("mail.smtp.starttls.enable", "true");

    // Puerto de gmail para envio de correos
    props.setProperty("mail.smtp.port","587");

    // Nombre del usuario
    props.setProperty("mail.smtp.user", "facutoledof@gmail.com");

    // Si requiere o no usuario y password para conectarse.
    props.setProperty("mail.smtp.auth", "true");

    session = Session.getDefaultInstance(props);
  }

  public static void enviarNotificacionADuenio(String mail) throws MessagingException {
    MimeMessage mensaje = crearMensaje(mail);

    Transport t = session.getTransport("smtp");

    t.connect(mailPatitas,contraseniaMailPatitas);

    t.sendMessage(mensaje,mensaje.getAllRecipients());

    t.close();
  }

  public static MimeMessage crearMensaje(String mail) throws MessagingException {
    MimeMessage message = new MimeMessage(session);

    // Quien envia el correo
    message.setFrom(new InternetAddress(mailPatitas));

    // A quien va dirigido
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));

    message.setSubject("Mascota encontrada");
    message.setText("Buenas tardes! Hemos encontrado a su mascota perdia! Asi que relajese que esta sana y salva :P" +
        "Atte Patitas Al Rescate");

    return message;
  }
}