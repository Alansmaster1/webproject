import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static Connection conn=null;
    private static final String username="root";
    private static final String passwd="712939";
    private static final String url="jdbc:mysql://localhost:3306/webdb";
    private static final String driver="com.mysql.jdbc.Driver";

    public static Connection getMySqlConn() {
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,username,passwd);
        }catch(SQLException | ClassNotFoundException e) {
            System.out.println("获取连接失败"+e.getMessage());
        }
        return conn;
    }
}
