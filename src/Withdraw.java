import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JButton back, withdrawl;
    JTextField amountTextField;
    String pinnumber;
    Withdraw(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel amount = new JLabel("Enter The Amount You Want to withdraw");
        amount.setBounds(165,300,700,35);
        amount.setFont(new Font("Raleway",Font.BOLD,18));
        amount.setForeground(Color.white);
        image.add(amount);

        amountTextField = new JTextField();
        amountTextField.setBounds(165,360,350,30);
        amountTextField.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(amountTextField);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(390,450,120,30);
        withdrawl.setFont(new Font("Raleway",Font.BOLD,15));
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back = new JButton("Back");
        back.setBounds(390,490,120,30);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(500,20);
        setVisible(true);
    }
    public static void main(String[] args) {

        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else if(e.getSource()==withdrawl){
            String number = amountTextField.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");

            }else {
                try{
                    Conn conn = new Conn();
                    String query  = "insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                }catch (Exception ex){
                    System.out.println(ex);
                }
            }
        }

    }
}


