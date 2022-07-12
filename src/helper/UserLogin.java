package helper;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class UserLogin {

    public static void loginMatch(String username, String password) throws SQLException {
        String sql = "SELECT * FROM USERS WHERE User_Name = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, username);
        //ps.setString(2,password);

        ResultSet rs = ps.executeQuery();

        try{
            while(rs.next()){
                String uname = rs.getString("User_Name");
                String pword = rs.getString("Password");
                if(password.equals(pword)) {
                    System.out.println("Login Successful!");
                }
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error in Connectivity: " +e.getMessage());
            System.out.println("Login Failed!");
        }



    }
    /**public static void select() throws SQLException {
        String sql = "SELECT * FROM USERS";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int userId = rs.getInt("User_ID");
            String userName = rs.getString("User_Name");

            System.out.println(userId + " | ");
            System.out.println(userName + "\n");
        }
    }**/

}
