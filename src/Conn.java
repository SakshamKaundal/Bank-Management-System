import java.sql.*;

public class Conn {

    Connection c;
    static Statement s;
    public Conn(){

        try{

            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","P@ppupass100");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
