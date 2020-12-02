import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("username");
        String userPasswd=request.getParameter("passwd");

        String sql="insert into kpeople value ('"+userName+"','"+userPasswd+"');";

        try{
            Connection conn=null;
            conn=DBUtil.getMySqlConn();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.execute();

            request.getRequestDispatcher("/login.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
