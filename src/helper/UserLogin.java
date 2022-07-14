package helper;

import javafx.scene.control.Alert;
import main.Main;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;


public abstract class UserLogin {

    /**
     * Matches input username to the SQL Database, and then checks if password matches the record in the DB
     * @param username user input
     * @param password user input
     * @throws SQLException in case of errors from SQL Server
     */
    public static void loginMatch(String username, String password) throws SQLException {
        String sql = "SELECT * FROM USERS WHERE User_Name = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        try{
            while(rs.next()){
                String pword = rs.getString("Password");
                if(password.equals(pword)) {
                    System.out.println("Login Successful!");
                }
                else {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    //Do a check for current Local, then display appropriate text
                    if(Locale.getDefault().getLanguage().equals("fr")){ //French Locale is set, and French is true
                        a.setContentText(Main.rb.getString("Login-error"));
                        a.showAndWait();
                    }

                    else if(Locale.getDefault().getLanguage().equals("en")){ //English
                        a.setContentText(Main.rb.getString("Login-error"));
                        a.showAndWait();
                    }
                }
            }
            if(!rs.next()) { //if the username doesn't match, or if any field is empty
                Alert a = new Alert(Alert.AlertType.ERROR);
                //Do a check for current Local, then display appropriate text
                if(Locale.getDefault().getLanguage().equals("fr")){ //French Locale is set, and French is true
                    a.setContentText(Main.rb.getString("Login-error"));
                    a.showAndWait();
                }

                else if(Locale.getDefault().getLanguage().equals("en")){ //English
                    a.setContentText(Main.rb.getString("Login-error"));
                    a.showAndWait();
                }
            }
        }
        catch(SQLException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Login Failed");
            a.showAndWait();
            //JOptionPane.showMessageDialog(null,"Error in Connectivity: " +e.getMessage());
            System.out.println("Login Failed!");
        }
    }
}
