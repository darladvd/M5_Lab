import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AccountManagement extends JFrame {
    final private Font mainFont = new Font("Helvetica", Font.BOLD, 18);
    JLabel lbWelcome, lbstudentID, lbfullName, lbcourse, lbyearLvl, lbaddress, lbemail, lbcontact; //textarea
    JTextField tfstudentID, tffullName, tfaddress, tfemail, tfcontact; //textbox
    JComboBox<String> ddcourse; //dropdown
    JComboBox<Integer> ddyearLvl;
    JButton btnClear; //btnUpdate, btnExit, btnNext, btnPrevious; //buttons
    //ArrayList<Student> studentList;
    int currIndex;

    public void initialize() {
        /* Labels */   
        lbWelcome=new JLabel("Account Information");
        lbstudentID=new JLabel("Student ID:");
        lbfullName=new JLabel("Name:");
        lbcourse=new JLabel("Course:");
        lbyearLvl=new JLabel("Level:");
        lbaddress=new JLabel("Address:");
        lbemail=new JLabel("Email:");
        lbcontact=new JLabel("Contact Number:");

        /* Label Fonts and Bounds */
        lbWelcome.setFont(mainFont);
        lbstudentID.setFont(mainFont);
        lbfullName.setFont(mainFont);
        lbcourse.setFont(mainFont);
        lbyearLvl.setFont(mainFont);
        lbaddress.setFont(mainFont);
        lbemail.setFont(mainFont);
        lbcontact.setFont(mainFont);

        lbWelcome.setBounds(1,1,200,20);
        lbstudentID.setBounds(1,40,150,20);
        lbfullName.setBounds(1,80,150,20);
        lbcourse.setBounds(1,120,150,20);
        lbyearLvl.setBounds(1,160,150,20);
        lbaddress.setBounds(1,200,150,20);
        lbemail.setBounds(1,240,150,20);
        lbcontact.setBounds(1,280,150,20);

        /* Text Fields */
        tfstudentID = new JTextField("");
        tffullName = new JTextField("");
        tfaddress =new JTextField("");
        tfemail =new JTextField("");
        tfcontact =new JTextField("");

        /* Textfield Fonts and Bounds */
        tfstudentID.setFont(mainFont);
        tffullName.setFont(mainFont);
        tfaddress.setFont(mainFont);
        tfemail.setFont(mainFont);
        tfcontact.setFont(mainFont);

        tfstudentID.setBounds(155,40,200,20);
        tffullName.setBounds(155,80,200,20);
        tfaddress.setBounds(155,200,200,20);
        tfemail.setBounds(155,240,200,20);
        tfcontact.setBounds(155,280,200,20);

        /* Dropdown */
        String courseArr[]={"BSCS-SE","BSCS-CPP","BSCS-DS","BSCS-NET"};
        ddcourse=new JComboBox<String>(courseArr);
        ddcourse.setBounds(155,120,150,20);

        Integer levelArr[]={1,2,3,4,5,6};
        ddyearLvl=new JComboBox<Integer>(levelArr);
        ddyearLvl.setBounds(155,160,50,20);

        /* Buttons */
        btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                tfstudentID.setText("");
                tffullName.setText("");
                tfaddress.setText("");
                tfcontact.setText("");
                tfemail.setText("");
            }
        });

        /* Layout */
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.add(lbWelcome);
        formPanel.add(lbstudentID);
        formPanel.add(lbfullName);
        formPanel.add(lbcourse);
        formPanel.add(lbyearLvl);
        formPanel.add(lbaddress);
        formPanel.add(lbemail);
        formPanel.add(lbcontact);
        
        formPanel.add(tfstudentID);
        formPanel.add(tffullName);
        formPanel.add(tfaddress);
        formPanel.add(tfemail);
        formPanel.add(tfcontact);
        formPanel.add(ddcourse);
        formPanel.add(ddyearLvl);
        formPanel.add(btnClear);
        /*formPanel.add(btnNext);
        formPanel.add(btnUpdate);
        formPanel.add(btnExit);*/

        formPanel.setOpaque(false);
        formPanel.add(lbstudentID);
        formPanel.add(tfstudentID);
        formPanel.add(lbfullName);
        formPanel.add(tffullName);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        formPanel.setOpaque(false);
        buttonsPanel.add(btnClear);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Welcome");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        AccountManagement myFrame = new AccountManagement();
        myFrame.initialize();
    }
}
