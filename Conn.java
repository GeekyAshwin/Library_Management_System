package library.management.systems;
import java.sql.*;

public class Conn {
    Connection c1;
    Statement s;
    Conn() throws Exception {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c1=DriverManager.getConnection("jdbc:mysql://localhost:3305/Lib_Man_Sys","root","");
            s=c1.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}

