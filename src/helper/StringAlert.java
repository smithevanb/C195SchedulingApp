package helper;

import javafx.scene.control.Alert;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class StringAlert {
    public static Alert stringToAlert(String string, Alert.AlertType alertType) throws Exception {
        Alert a = null;
        try {
            a = new Alert(alertType);
            a.setContentText(string);
            a.showAndWait();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Connectivity: " + e.getMessage());
        }

        return a;
    }
}
