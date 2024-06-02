import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener {

    JButton exit;
    String pinnumber;
    Balance(String pinnumber){
        this.pinnumber=pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        Conn c = new Conn();

        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance= 0 ;
            while(rs.next()){
                if(rs.getString("type").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            JLabel balaence = new JLabel("The Balance in your Savings Account is : "+ balance);
            balaence.setBounds(155,300,500,35);
            balaence.setFont(new Font("Raleway",Font.BOLD,15));
            balaence.setForeground(Color.white);
            image.add(balaence);

        }catch (Exception ex){
            System.out.println(ex);
        }

        exit = new JButton("Back");
        exit.setBounds(360,517,150,30);
        exit.addActionListener(this);
        image.add(exit);





        setSize(900,900);
        setLocation(500,20);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Balance("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
}
