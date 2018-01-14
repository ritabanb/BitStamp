import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class liveTrade extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
        System.out.println(req.getParameter("timestamp"));
        System.out.println(req.getParameter("id"));
        try {
            String query = "INSERT INTO BITSTAMP VALUES (?,?)";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:bitstamp", "system", "Shevali123");
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, req.getParameter("timestamp"));
            st.setString(2, req.getParameter("id"));
            st.execute();

        }
        catch (Exception e){
            e.getStackTrace();}
    }
    public static void main(String[] args) {

    }
}
