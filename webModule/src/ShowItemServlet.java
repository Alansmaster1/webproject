import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowItemServlet extends HttpServlet {
    private String username;
    ShowItemServlet(){
        super();
    }

    ShowItemServlet(String username){
        super();
        this.username=username;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String sql="select * from kitem";
        List<String> list=new ArrayList<>();
        if(username==null){
            username="";
        }

        try{
            Connection conn=null;
            conn=DBUtil.getMySqlConn();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add(resultSet.getString("name"));
            }
            request.setAttribute("items",list);
            request.setAttribute("username",username);
            request.getRequestDispatcher("/item.jsp").forward(request,response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
