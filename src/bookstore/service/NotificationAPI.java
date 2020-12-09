/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.service;

import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author gar4a
 */
public class NotificationAPI {

    Connection cnx;

    public NotificationAPI() {

    }


    public static void notif(String mes, String message) {
        Notifications notificationBuilder = Notifications.create()
                .title(mes)
                .text(message).darkStyle()
                //.graphic(new ImageView(img))
                .hideAfter(Duration.seconds(5))
              //  .position(Pos.CENTER)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("clicked");
                    }
                });
        //notificationBuilder.darkStyle();
        notificationBuilder.showError();

    }

    public static void notifInfo(String mes, String message) {
        Notifications notificationBuilder = Notifications.create()
                .title(mes)
                .text(message).darkStyle()
                //.graphic(new ImageView(img))
                .hideAfter(Duration.seconds(5))
              //  .position(Pos.CENTER)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("clicked");
                    }
                });
        //notificationBuilder.darkStyle();
        notificationBuilder.showInformation();

    }

    public static void notifConfirm(String mes, String message) {
        Notifications notificationBuilder = Notifications.create()
                .title(mes)
                .text(message).darkStyle()
                //.graphic(new ImageView(img))
                .hideAfter(Duration.seconds(5))
              //  .position(Pos.CENTER)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("clicked");
                    }
                });
        //notificationBuilder.darkStyle();
        notificationBuilder.showConfirm();

    }

}
