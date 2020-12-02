import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddToAccServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("username");
        String itemName=request.getParameter("item");

        String sql="insert into kbitem value ('"+userName+"','"+itemName+"');";

        try{
            Connection conn=null;
            conn=DBUtil.getMySqlConn();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.execute();

            new ShowItemServlet(userName).doPost(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
