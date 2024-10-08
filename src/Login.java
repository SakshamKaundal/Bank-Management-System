import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton signin,clear,signUPbut; //declared globally
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        //putting image in the popup box
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/logolast.png"));
        Image i2 = i1.getImage().getScaledInstance(85,85,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);//again make it ImageIcon coz it doest support swing
        JLabel label =new JLabel(i3);
        label.setBounds(45,30,85,85);
        //making custom layout but there is default we have to make it zero
        add(label);

        //Jlabel to make text
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(223,50,400,40);
        text.setForeground(Color.pink);
        add(text);

        //cardNo area
        JLabel cardNo = new JLabel("Enter Card Number :");
        cardNo.setFont(new Font("Osward",Font.BOLD,20));
        cardNo.setBounds(120,190,400,40);
        cardNo.setForeground(Color.white);
        add(cardNo);
        //card text field
        cardTextField = new JTextField();
        cardTextField.setBounds(320,197,205,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        //pin area
        JLabel pin = new JLabel("Enter PIN :");
        pin.setFont(new Font("Osward",Font.BOLD,20));
        pin.setBounds(212,250,400,40);
        pin.setForeground(Color.white);
        add(pin);
        //pin text field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(320,257,205,30);
        add(pinTextField);

        //adding buttons
        //sign in
        signin = new JButton("Sign In");
        signin.setFont(new Font("Osward",Font.BOLD,20));
        signin.setBounds(320,310,111,30);
        signin.addActionListener(this);
        add(signin);

        //clear button
        clear = new JButton("Clear");
        clear.setFont(new Font("Osward",Font.BOLD,20));
        clear.setBounds(550,230,100,30);
        clear.addActionListener(this);
        add(clear);

        //sign up with text
        JLabel signUpText = new JLabel("Make a account");
        signUpText.setFont(new Font("SansSerif",Font.BOLD,18));
        signUpText.setBounds(150,375,400,40);
        signUpText.setForeground(Color.pink);
        add(signUpText);
        //signup button
        signUPbut = new JButton("Sign Up");
        signUPbut.setFont(new Font("Osward",Font.BOLD,20));
        signUPbut.setBounds(320,380,111,30);
        signUPbut.addActionListener(this);
        add(signUPbut);


        //initialising the login box
        setTitle("Automatic Teller Machine");
        setSize(800,500);
        setVisible(true);
        setLocation(450,200);
        getContentPane().setBackground(Color.black);
    }
    //abstract methods should be over ride here
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == clear){
                cardTextField.setText("");
                pinTextField.setText("");
            }
            else if(ae.getSource()==signin){
                Conn conn = new Conn();
                String cardnumber  = cardTextField.getText();
                String pinnumber = pinTextField.getText();
                String quary = "select * from login where cardnumber = '"+cardnumber+"'and pin = '"+pinnumber+"'";
                try{
                    ResultSet rs= conn.s.executeQuery(quary);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Incorrect Card number or PIN ");
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }
            else if(ae.getSource()==signUPbut){
                    setVisible(false);
                    new SignUpOne().setVisible(true);
            }
    }
    public static void main(String[] args) {

        new Login();
    }
}
