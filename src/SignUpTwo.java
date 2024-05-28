import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignUpTwo extends JFrame implements ActionListener {

    JTextField AadharTextField,panTextField;

    JComboBox religion,Category,Income,Qualification,Occupation;

    JRadioButton yesSeniorCitizenRadio,noSeniorCitizenRadio,yesExistingAccount,noExistingAccount;
    String formno;
    JButton next;
    SignUpTwo(String formno){
        this.formno =formno;
        setLayout(null);

        //putting icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/personalDetails.png"));
        Image i2 = i1.getImage().getScaledInstance(85,85,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);//again make it ImageIcon coz it doest support swing
        JLabel label =new JLabel(i3);
        label.setBounds(40,20,85,85);
        //making custom layout but there is default we have to make it zero
        add(label);

        //form no hedding

        JLabel formname = new JLabel("Page 2: Additional Deatils");
        formname.setFont(new Font("Raleway",Font.BOLD,38));
        formname.setBounds(160,40,600,40);
        add(formname);



        //all lables of personal details
        //Religion
        JLabel Religion = new JLabel("Religion :");
        Religion.setFont(new Font("Raleway",Font.BOLD,20));
        Religion.setBounds(110,170,600,40);
        add(Religion);
        //religion combo field
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian"};
        religion = new JComboBox(valReligion);
        religion.setBounds(290,180,180,40);
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBackground(Color.white);
        add(religion);

        //Category
        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(110,230,600,40);
        add(category);
        //category combobox
        String valCategory[] = {"General","ST","SC","Others"};
        Category = new JComboBox(valCategory);
        Category.setBounds(290,240,180,30);
        Category.setFont(new Font("Arial",Font.BOLD,15));
        Category.setBackground(Color.white);
        add(Category);

        //income
        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(110, 370,600,40);
        add(income);
        //income combobox
        String valIncome[] = {"< 2000000","< 4000000","< 6000000"};
        Income  = new JComboBox(valIncome);
        Income.setBounds(290,380,180,30);
        Income.setFont(new Font("Arial",Font.BOLD,15));
        Income.setBackground(Color.white);
        add(Income);

        //qualification
        JLabel qualification = new JLabel("Qualification");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(110,450,600,40);
        add(qualification);
        //income combobox
        String valqualification[] = {"Matric","Graduate","Post Graduate","None"};
        Qualification   = new JComboBox(valqualification);
        Qualification.setBounds(290,460,180,30);
        Qualification.setFont(new Font("Arial",Font.BOLD,15));
        Qualification.setBackground(Color.white);
        add(Qualification);

        //Occupation
        JLabel occupation = new JLabel("occupation");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(110,510,600,40);
        add(occupation);
        //income combobox
        String valoccupation[] = {"Salaried","Unemployed","Student","Home Maker","Other"};
        Occupation   = new JComboBox(valoccupation);
        Occupation.setBounds(290,520,180,30);
        Occupation.setFont(new Font("Arial",Font.BOLD,15));
        Occupation.setBackground(Color.white);
        add(Occupation);

        //Pan number
        JLabel Pan = new JLabel("Pan number :");
        Pan.setFont(new Font("Raleway",Font.BOLD,20));
        Pan.setBounds(110,570,600,40);
        add(Pan);
        //creating Pan text field
        panTextField = new JTextField();
        panTextField.setBounds(290,580,350,30);
        panTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(panTextField);

        //aadhar number
        JLabel Aadhar = new JLabel("Aadhar number :");
        Aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        Aadhar.setBounds(110,620,600,40);
        add(Aadhar);
        //creating Pan text field
        AadharTextField = new JTextField();
        AadharTextField.setBounds(290,630,350,30);
        AadharTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(AadharTextField);

        //Senior citizen
        JLabel seniorCitizen = new JLabel("Senior Citizen :");
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorCitizen.setBounds(110,680,600,40);
        add(seniorCitizen);
        //senior citizen radiobox
        yesSeniorCitizenRadio = new JRadioButton("yes");
        yesSeniorCitizenRadio.setBounds(290,680,50,40);
        yesSeniorCitizenRadio.setBackground(Color.white);
        add(yesSeniorCitizenRadio);
        noSeniorCitizenRadio = new JRadioButton("no");
        noSeniorCitizenRadio.setBounds(350,680,40,40);
        noSeniorCitizenRadio.setBackground(Color.white);
        add(noSeniorCitizenRadio);

        ButtonGroup isCitizen = new ButtonGroup();
        isCitizen.add(yesSeniorCitizenRadio);
        isCitizen.add(noSeniorCitizenRadio);

        //Existing Account
        JLabel  existingAccount= new JLabel("Existing Account :");
        existingAccount.setFont(new Font("Raleway",Font.BOLD,20));
        existingAccount.setBounds(110,720,600,40);
        add(existingAccount);
        //senior citizen radiobox
        yesExistingAccount = new JRadioButton("yes");
        yesExistingAccount.setBounds(290,720,50,40);
        yesExistingAccount.setBackground(Color.white);
        add(yesExistingAccount);
        noExistingAccount = new JRadioButton("no");
        noExistingAccount.setBounds(350,720,40,40);
        noExistingAccount.setBackground(Color.white);
        add(noExistingAccount);

        ButtonGroup isExisting = new ButtonGroup();
        isExisting.add(yesExistingAccount);
        isExisting.add(noExistingAccount);



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

        new SignUpTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sreligion= (String) religion.getSelectedItem();
        String scategory= (String) Category.getSelectedItem();
        String sincome= (String) Income.getSelectedItem();
        String seducation= (String) Qualification.getSelectedItem();
        String soccupation= (String) Occupation.getSelectedItem();
        String seniorcitizen= null;
        if(yesSeniorCitizenRadio.isSelected()){
            seniorcitizen = "Yes";
        }
        else{
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if(yesExistingAccount.isSelected()){
            existingaccount="Yes";

        }
        else{
            existingaccount="No";
        }
        String span = panTextField.getText();
        String saadhar = AadharTextField.getText();

        try{
            if(panTextField.equals("")){
                JOptionPane.showMessageDialog(null,"PAN Field is Requried");
            }else{
                Conn c = new Conn();
                String quary = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(quary);

                //sign up object
                setVisible(false);
                new SignUpThree(formno).setVisible(true);

            }
        }catch(Exception ex){
            System.out.println(ex);
        }

    }
}
