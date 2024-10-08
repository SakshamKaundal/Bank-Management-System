import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit,fastCash,pinChange,cashWithdrawl,miniStatement,balanceEnquiry,exit;

    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select your Amount");
        text.setBounds(190,300,700,35);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170,417,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        fastCash = new JButton("Rs 200");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        pinChange = new JButton("Rs 500");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        cashWithdrawl = new JButton("Rs 1000");
        cashWithdrawl.setBounds(360,417,150,30);
        cashWithdrawl.addActionListener(this);
        image.add(cashWithdrawl);

        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(360,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        balanceEnquiry = new JButton("Rs 5000");
        balanceEnquiry.setBounds(360,485,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);



        exit = new JButton("Exit");
        exit.setBounds(360,517,150,30);
        exit.addActionListener(this);
        image.add(exit);

        getContentPane().setBackground(Color.white);
        setSize(900,900);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {

        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(3);
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
                if(e.getSource() != null && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance your balance is rs "+balance);
                    return;
                }



                Date date = new Date();
                String quary = "insert into  bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                c.s.executeUpdate(quary);
                JOptionPane.showMessageDialog(null , "Rs "+ amount + "Debited Sucessfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
}
