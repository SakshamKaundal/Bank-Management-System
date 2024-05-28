import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;

    JCheckBox c1,c2,c3,c4,c5,c6,c7;

    JButton submit , cancle ;

    String formno;

    SignUpThree(String formno){
        this.formno= formno;
        setLayout(null);

        JLabel l1= new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(270,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,16));
        type.setBounds(100,149,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Railway",Font.BOLD,16));
        r1.setBounds(100,200,250,20);
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Railway",Font.BOLD,16));
        r2.setBounds(400,200,250,20);
        r2.setBackground(Color.white);
        add(r2);

        r3 = new JRadioButton("Recurring Account");
        r3.setFont(new Font("Railway",Font.BOLD,16));
        r3.setBounds(100,250,250,20);
        r3.setBackground(Color.white);
        add(r3);

        r4 = new JRadioButton("Current Account");
        r4.setFont(new Font("Railway",Font.BOLD,16));
        r4.setBounds(400,250,250,20);
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup groupType = new ButtonGroup();
        groupType.add(r1);
        groupType.add(r2);
        groupType.add(r3);
        groupType.add(r4);

        JLabel card= new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,320,400,40);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(300,320,400,40);
        add(number);

        JLabel pin= new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,380,400,40);
        add(pin);

        JLabel pinCode = new JLabel("XXXX");
        pinCode.setFont(new Font("Raleway",Font.BOLD,22));
        pinCode.setBounds(300,380,400,40);
        add(pinCode);

        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,430,400,40);
        add(services);

        c1 = new JCheckBox(" ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,480,200,40);
        add(c1);

        c2= new JCheckBox("Inetnet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(300,480,200,40);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,530,200,40);
        add(c3);

        c4 = new JCheckBox("Email and SMS Alert");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(300,530,200,40);
        add(c4);

        c5 = new JCheckBox("Check book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,570,200,40);
        add(c5);

        c6 = new JCheckBox("E-Stamement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(300,570,200,40);
        add(c6);

        c7 = new JCheckBox("I Hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(70,620,800,40);
        add(c7);

        submit = new JButton("Sumbit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.setBounds(550,700,120,40);
        submit.addActionListener(this);
        add(submit);

        cancle = new JButton("Cancle");
        cancle.setForeground(Color.white);
        cancle.setBackground(Color.black);
        cancle.setBounds(150,700,120,40);
        cancle.addActionListener(this);
        add(cancle);






        getContentPane().setBackground(Color.white);
        setSize(850,820);
        setLocation(500,30);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SignUpThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit) {
            String accountType = null;

            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Recurring Account";

            } else if (r4.isSelected()) {
                accountType = "Current Account";
            }
            Random random = new Random();

            String cardnumber = String.valueOf(Math.abs((random.nextLong() % 90000000L)) + 5040936000000000L);

            String pinnumber = String.valueOf(Math.abs((random.nextLong() % 9000L)) + 1000L);


            String factility = "";
            if (c1.isSelected()) {
                factility = factility + " ATM Card ";


            } else if (c2.isSelected()) {
                factility = factility + " Internet Banking ";
            } else if (c3.isSelected()) {
                factility = factility + " Mobile Banking";
            } else if (c4.isSelected()) {
                factility = factility + " Email and SMS Alert ";

            } else if (c5.isSelected()) {
                factility = factility + " Check Book ";
            } else if (c6.isSelected()) {
                factility = factility + " E-statement ";
            }

            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account type requried");

                } else {
                    Conn conn = new Conn();
                    String quarry1 = "insert into signupthree value('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + factility + "')";
                    String quarry2 = "insert into login value('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                    conn.s.executeUpdate(quarry1);
                    conn.s.executeUpdate(quarry2);
                    JOptionPane.showMessageDialog(null, "Card Number :" + cardnumber + "\n PIN no:" + pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);

                }
            } catch (Exception ex) {
                System.out.println(ex);
            }





        } else if (e.getSource()==cancle) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
