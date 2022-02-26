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
    JButton btnClear, btnUpdate, btnExit, btnNext, btnPrevious; //buttons
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

        /* Label Fonts and Size */
        lbWelcome.setFont(mainFont);
        lbstudentID.setFont(mainFont);
        lbfullName.setFont(mainFont);
        lbcourse.setFont(mainFont);
        lbyearLvl.setFont(mainFont);
        lbaddress.setFont(mainFont);
        lbemail.setFont(mainFont);
        lbcontact.setFont(mainFont);

        /*lbWelcome.setBounds(1,1,200,20);
        lbstudentID.setBounds(1,40,150,20);
        lbfullName.setBounds(1,80,150,20);
        lbcourse.setBounds(1,120,150,20);
        lbyearLvl.setBounds(1,160,150,20);
        lbaddress.setBounds(1,200,150,20);
        lbemail.setBounds(1,240,150,20);
        lbcontact.setBounds(1,280,150,20);*/

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

        tfstudentID.setPreferredSize(new Dimension(450,50));
        /*tfstudentID.setBounds(155,120,150,20);
        tffullName.setBounds(155,120,150,20);
        tfaddress.setBounds(155,120,150,20);
        tfcontact.setBounds(155,120,150,20);*/

        /* Dropdown */
        String courseArr[]={"BSCS-SE","BSCS-CPP","BSCS-DS","BSCS-NET"};
        ddcourse=new JComboBox<String>(courseArr);
        //ddcourse.setBounds(155,120,150,20);

        Integer levelArr[]={1,2,3,4,5,6};
        ddyearLvl=new JComboBox<Integer>(levelArr);
        //ddyearLvl.setBounds(155,160,50,20);

        /* Buttons */
        btnPrevious=new JButton("<<");
        btnPrevious.setBounds(20,320,150,20);
        //btnPrevious.addActionListener(this);
        
        btnNext=new JButton(">>");
        btnNext.setBounds(230,320,150,20);
        //btnNext.addActionListener(this);
        
        btnUpdate=new JButton("Update");
        btnUpdate.setBounds(20,360,100,20);
        //btnUpdate.addActionListener(this);
        
        btnExit=new JButton("Exit");
        btnExit.setBounds(230,360,100,20);
        //btnExit.addActionListener(this);

        /* Panels*/
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(7,2)); //Try gridbaglayout
        formPanel.add(lbstudentID);
        formPanel.add(tfstudentID);
        formPanel.add(lbfullName);
        formPanel.add(tffullName);
        formPanel.add(lbcourse);
        formPanel.add(ddcourse);
        formPanel.add(lbyearLvl);
        formPanel.add(ddyearLvl);
        formPanel.add(lbaddress);
        formPanel.add(tfaddress);
        formPanel.add(lbemail);
        formPanel.add(tfemail);
        formPanel.add(lbcontact);
        formPanel.add(tfcontact);

        formPanel.setOpaque(false);

        JPanel buttonsPanel = new JPanel();
        formPanel.setOpaque(false);
        buttonsPanel.add(btnPrevious);
        buttonsPanel.add(btnNext);
        buttonsPanel.add(btnUpdate);
        buttonsPanel.add(btnExit);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(lbWelcome, BorderLayout.PAGE_START);
        mainPanel.add(formPanel);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setTitle("Account Management");
        setSize(400, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        AccountManagement myFrame = new AccountManagement();
        myFrame.initialize();
    }
}
