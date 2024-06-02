import javax.swing.*;
import java.awt.*;
import java.nio.channels.ScatteringByteChannel;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");


        setLayout(null);

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);


        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinnumber + "' ");
            while (rs.next()) {
                card.setText("Card Number :" + rs.getString("cardnumber"));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        card.setForeground(Color.black);
        add(card);

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
