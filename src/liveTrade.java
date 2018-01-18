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
        try {
            String query = "INSERT INTO BITSTAMP VALUES (?,?,?,?,?)";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:bitstamp", "system", "Shevali123");
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, req.getParameter("timestamp"));
            st.setString(2, req.getParameter("id"));
            st.setString(3, req.getParameter("amount"));
            st.setString(4, req.getParameter("price"));
            st.setString(5, req.getParameter("type"));
            st.execute();

        }
        catch (Exception e){
            e.getStackTrace();}
    }
    public static void main(String[] args) {

    }
}
