package controller;

import helper.UserLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;


public class LoginViewController implements Initializable {


    @FXML
    private Button LoginButton;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField UsernameField;

    @FXML
    private TextField ZoneId;

    @FXML
    void onZoneIdChange(ActionEvent event) {

    }

    @FXML
    void onLoginClicked(ActionEvent event) throws SQLException {
        /**
         * Convert UsernameField and PasswordField to String, and then pass them to loginMatch method,
         * to verify the user's login attempt.
         */
        try {
            String username = UsernameField.getText();
            String password = PasswordField.getText();
            UserLogin.loginMatch(username, password);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error in Connectivity: " +e.getMessage());
            System.out.println("Login Failed!");
        }

    }

    @FXML
    void onPasswordTyped(ActionEvent event) {

    }

    @FXML
    void onUsernameType(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String zone = String.valueOf(Locale.getDefault().getCountry());
        ZoneId.setText(zone);
    }
}
