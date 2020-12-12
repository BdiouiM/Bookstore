/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Transport;
public class sendemail {
AjouteradminnController ad =new AjouteradminnController();
    public static String USER_NAME = "bookstorebookstore57";  
    public static String PASSWORD = "bookstore8*"; 
      public String RECIPIENT;

   

    public static void sendFromGMail(String from, String pass, String address, String subject, String body) {
       
        from = USER_NAME;
       pass = PASSWORD;
         String[] to =  { address }; 
       try{
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
       
        
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        
        catch( Exception e){
            System.out.println(e.getMessage());
        }
      
    }}