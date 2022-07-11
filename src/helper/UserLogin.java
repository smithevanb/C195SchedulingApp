package helper;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;


public abstract class UserLogin {

    public static int loginMatch(String username, String password) throws SQLException {
        String sql = "SELECT FROM USERS(User_Name, Password) VALUES(?, ?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

}
