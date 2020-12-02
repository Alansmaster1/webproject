import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheckServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userName=request.getParameter("username");
        String userPasswd=request.getParameter("passwd");

        String sql="select * from kpeople where name='"+userName+"'";

        try{
            Connection conn=null;
            conn=DBUtil.getMySqlConn();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                if(resultSet.getString("passwd").equals(userPasswd)){
                    new ShowItemServlet(userName).doPost(request,response);
                } else {
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                }
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
