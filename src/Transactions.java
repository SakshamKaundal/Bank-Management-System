import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,fastCash,pinChange,cashWithdrawl,miniStatement,balanceEnquiry,exit;

    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select your Transactions");
        text.setBounds(190,300,700,35);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setForeground(Color.white);
        image.add(text);

         deposit = new JButton("DEPOSIT");
        deposit.setBounds(170,417,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

         fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

         pinChange = new JButton("PIN Change");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

         cashWithdrawl = new JButton("Cash Withdrawl");
        cashWithdrawl.setBounds(360,417,150,30);
        cashWithdrawl.addActionListener(this);
        image.add(cashWithdrawl);

         miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(360,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

         balanceEnquiry = new JButton("Balance Enquiry");
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
            System.exit(0);

        }else if (e.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(e.getSource() == cashWithdrawl){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if (e.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
    }
}
