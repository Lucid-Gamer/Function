import java.lang.reflect.Type;
import java.sql.*;

public class Function {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Found!!!!");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","MH12TX8186");
        System.out.println("Connection Established!!!!");

        CallableStatement stmt = connection.prepareCall("{?=Call add_function(?,?)}");
        stmt.setInt(2,25);
        stmt.setInt(3,23);

        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.execute();

        System.out.println(stmt.getInt(1));
    }

}
