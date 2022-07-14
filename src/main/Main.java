package main;

import controller.LoginViewController;
import helper.JDBC;
import helper.UserLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {
    
    public static ResourceBundle rb = ResourceBundle.getBundle("main/Language", Locale.getDefault());

    public static boolean French = false;
    public static Locale frLocale = new Locale("fr");
    public static Locale enLocale = new Locale("en");

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {


            Parent root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"), rb);
            primaryStage.setTitle("Login View");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Error in Connectivity: " +e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        Locale.setDefault(frLocale);
        JDBC.openConnection();

        launch(args);
        //UserLogin.select();
        JDBC.closeConnection();
    }
}
