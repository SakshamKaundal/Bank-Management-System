import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinchange extends JFrame implements ActionListener {


    JPasswordField pinTextfield,rePintextfield;

    JButton change,back;

    String pinChange;
    Pinchange (String pinchange){

        this.pinChange = pinchange;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel amount = new JLabel("Change your PIN Here");
        amount.setBounds(165,300,700,35);
        amount.setFont(new Font("Raleway",Font.BOLD,18));
        amount.setForeground(Color.white);
        image.add(amount);

        JLabel pinLable = new JLabel(" NEW PIN ");
        pinLable.setFont(new Font("Raleway",Font.BOLD,15));
        pinLable.setBounds(200,360,200,30);
        pinLable.setForeground(Color.white);
        image.add(pinLable);

        JLabel rePinLable = new JLabel(" RE Enter ");
        rePinLable.setFont(new Font("Raleway",Font.BOLD,15));
        rePinLable.setBounds(200,420,200,30);
        rePinLable.setForeground(Color.white);
        image.add(rePinLable);




        pinTextfield= new JPasswordField();
        pinTextfield.setBounds(300,360,200,30);
        pinTextfield.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(pinTextfield);

        rePintextfield= new JPasswordField();
        rePintextfield.setBounds(300,420,200,30);
        rePintextfield.setFont(new Font("Raleway",Font.BOLD,15));
        rePintextfield.addActionListener(this);
        image.add(rePintextfield);

        change = new JButton("Change");
        change.setBounds(390,480,120,30);
        change.setFont(new Font("Raleway",Font.BOLD,15));
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(390,490,120,30);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);


        getContentPane().setBackground(Color.white);
        setSize(900,900);
        setLocation(500,30);
        setUndecorated(true);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Pinchange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == change){
        try {
                String npin = pinTextfield.getText();
                String rpin = rePintextfield.getText();


                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Enterd pin does not match");
                    return;
                }else{
                Conn conn  = new Conn();
                String query1 = "update bank set pin ='"+rpin+"' where pin = '"+pinChange+"'";
                String query2 = "update login set pin ='"+rpin+"' where pin = '"+pinChange+"'";
                String query3 = "update signupthree set pin ='"+rpin+"' where pin = '"+pinChange+"'";

                conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null,"PIN Changed Successfully");

                    setVisible(false);
                    new Transactions(pinChange).setVisible(true);
                }




            }catch (Exception ex){
                System.out.println(ex);
            }

    }else {
            setVisible(false);
            new Transactions(pinChange).setVisible(true);
        }
}}
