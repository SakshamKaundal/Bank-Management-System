import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
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
        JTextField cardTextField = new JTextField();
        cardTextField.setBounds(320,197,205,30);
        add(cardTextField);

        //pin area
        JLabel pin = new JLabel("Enter PIN :");
        pin.setFont(new Font("Osward",Font.BOLD,20));
        pin.setBounds(212,250,400,40);
        pin.setForeground(Color.white);
        add(pin);
        //pin text field
        JPasswordField pinTextField = new JPasswordField();
        pinTextField.setBounds(320,257,205,30);
        add(pinTextField);

        //adding buttons
        //sign in
        JButton signin = new JButton("Sign In");
        signin.setFont(new Font("Osward",Font.BOLD,20));
        signin.setBounds(320,310,111,30);
        add(signin);

        //clear button
        JButton clear = new JButton("Clear");
        clear.setFont(new Font("Osward",Font.BOLD,20));
        clear.setBounds(550,230,100,30);
        add(clear);

        //sign up with text
        JLabel signUpText = new JLabel("Make a account");
        signUpText.setFont(new Font("SansSerif",Font.BOLD,18));
        signUpText.setBounds(150,375,400,40);
        signUpText.setForeground(Color.pink);
        add(signUpText);
        //signup button
        JButton signUPbut = new JButton("Sign Up");
        signUPbut.setFont(new Font("Osward",Font.BOLD,20));
        signUPbut.setBounds(320,380,111,30);
        add(signUPbut);


        //initialising the login box
        setTitle("Automatic Teller Machine");
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        getContentPane().setBackground(Color.black);
    }
    public static void main(String[] args) {
         new Login();
    }
}
