import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    long random;

    JTextField nameTextField,fatherNameTextField,mailTextField,addTextField,cityTextField,stateTextField,pinTextField;
    JDateChooser dateChooser;

    JRadioButton male,female,married, unmarried;

    JButton next;
    SignUpOne(){

        setLayout(null);
        Random ran =new Random();
        //putting icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/personalDetails.png"));
        Image i2 = i1.getImage().getScaledInstance(85,85,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);//again make it ImageIcon coz it doest support swing
        JLabel label =new JLabel(i3);
        label.setBounds(40,20,85,85);
        //making custom layout but there is default we have to make it zero
        add(label);

        //form no hedding
        random = Math.abs(ran.nextLong() % 9000L);
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(160,40,600,40);
        add(formno);

        //personal details
        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        personalDetails.setBounds(280,110,600,40);
        add(personalDetails);

        //all lables of personal details
        //name
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(110,170,600,40);
        add(name);
        //name text field
        nameTextField = new JTextField();
        nameTextField.setBounds(290,175,350,30);
        nameTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(nameTextField);

        //fathers name
        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(110,230,600,40);
        add(fname);
        //fatername text field
        fatherNameTextField = new JTextField();
        fatherNameTextField.setBounds(290,240,350,30);
        fatherNameTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(fatherNameTextField);
        //dateofbirth
        JLabel DOB = new JLabel("DOB :");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(110,290,600,40);
        add(DOB);
        //dobTextField
        dateChooser = new JDateChooser();
        dateChooser.setBounds(290,300,200,30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);
        //gender
        JLabel sex = new JLabel("Gender :");
        sex.setFont(new Font("Raleway",Font.BOLD,20));
        sex.setBounds(110,350,600,40);
        add(sex);
        //gender Radio button
        male = new JRadioButton("Male");
        male.setBounds(290,360, 80, 30);
        male.setBackground(Color.white);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(380,360, 80, 30);
        female.setBackground(Color.white);
        add(female);
        //grouping two radio buttons
        ButtonGroup sexgroup = new ButtonGroup();
        sexgroup.add(male);
        sexgroup.add(female);

        //emailaddress
        JLabel mail = new JLabel("Email Address :");
        mail.setFont(new Font("Raleway",Font.BOLD,20));
        mail.setBounds(110,410,600,40);
        add(mail);
        //mailTextField
        mailTextField = new JTextField();
        mailTextField.setBounds(290,420,350,30);
        mailTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(mailTextField);
        //marital status
        JLabel maritalStatus = new JLabel("Marital Status :");
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,20));
        maritalStatus.setBounds(110,470,600,40);
        add(maritalStatus);
        //status radio buttons
        married = new JRadioButton("Married");
        married.setBounds(290,480, 100, 30);
        married.setBackground(Color.white);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400,480, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        //grouping two radio buttons
        ButtonGroup statusgroup = new ButtonGroup();
        statusgroup.add(married);
        statusgroup.add(unmarried);
        //address
        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(110,530,600,40);
        add(address);
        //address text field
        addTextField = new JTextField();
        addTextField.setBounds(290,540,350,30);
        addTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(addTextField);
        //city
        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(110,590,600,40);
        add(city);
        //cityTextField
        cityTextField = new JTextField();
        cityTextField.setBounds(290,600,350,30);
        cityTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(cityTextField);
        //state
        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(110,650,600,40);
        add(state);
        //stateTextField
        stateTextField = new JTextField();
        stateTextField.setBounds(290,660,350,30);
        stateTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(stateTextField);
        //pin code
        JLabel PIN = new JLabel("PIN :");
        PIN.setFont(new Font("Raleway",Font.BOLD,20));
        PIN.setBounds(110,710,600,40);
        add(PIN);
        //pinTextField
        pinTextField = new JTextField();
        pinTextField.setBounds(290,720,350,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(pinTextField);

        //next button
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(650,780,70,50);
        next.addActionListener(this);
        add(next);

        //making frame
        getContentPane().setBackground(Color.white);
        setSize(850,900);
        setLocation(500,30);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpOne();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = String.valueOf(random);
        String name  = nameTextField.getText();
        String fname = fatherNameTextField.getText();
        String DOB = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        //if male or female is selected
        if(male.isSelected()){
            gender = "Male";
        }
        else{
            gender = "Female";
        }

        String email=mailTextField.getText();

        //checking marital status
        String martial = null;
        if(married.isSelected()){
            martial = "Married";
        }else{
            martial = "UnMarried";
        }

        String adderss = addTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name Field is Requried");
            }else{
                Conn c = new Conn();
                String quary = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+DOB+"','"+gender+"','"+email+"','"+martial+"','"+adderss+"','"+city+"','"+state+"','"+pin+"')";
                Conn.s.executeUpdate(quary);

                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
