package net.creqavn;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {

    private static final Logger LOGGER = Logger.getAnonymousLogger();
    private static final String SERVIDOR_SMTP = "smtp.gmail.com";
    private static final int PORTA_SERVIDOR_SMTP = 587;
    private EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    public void send(String mail) {

        //create a variable in serenity.properties
        final String USER_AUTH = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("smtp.mailuser");
        final String PWD_AUTH = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("smtp.password");
        final String from = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("smtp.from");

        final String env = EnvironmentSpecificConfiguration
                .from(environmentVariables).getProperty("report.customfields.environment");
        final String version = EnvironmentSpecificConfiguration
                .from(environmentVariables).getProperty("report.customfields.ApplicationVersion");
        final String subTitle = EnvironmentSpecificConfiguration
                .from(environmentVariables).getProperty("smtp.subtitle");

        String subject = subTitle+" ["+env+"-"+version+"]";

        final Session session = Session.getInstance(this.getEmailProperties(), new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER_AUTH, PWD_AUTH);
            }

        });

        try {
            final Message message = new MimeMessage(session);

            try {
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail+"@creqavn.net"));
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }

            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setContent(getConent(), "text/html");
            message.setSentDate(new Date());
            Transport.send(message);
        } catch (final MessagingException ex) {
            LOGGER.log(Level.WARNING, "Error sending message: " + ex.getMessage(), ex);
        }
    }

    private String getConent() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new FileReader("./target/site/serenity/serenity-summary.html"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder content = new StringBuilder();
        String line;

        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            content.append(line);
        }
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    public Properties getEmailProperties() {
        final Properties config = new Properties();
        config.put("mail.smtp.auth", "true");
        config.put("mail.smtp.starttls.enable", "true");
        config.put("mail.smtp.host", SERVIDOR_SMTP);
        config.put("mail.smtp.port", PORTA_SERVIDOR_SMTP);
        config.put("mail.smtp.ssl.protocols", "TLSv1.2");
        return config;
    }
    public static void main(final String[] args) {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        String mails = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("smtp.to");
        List.of(mails.split(",")).forEach(
                mail->{
                    new Mailer().send(mail)
                    ;
                }
        );

    }
}