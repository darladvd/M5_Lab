import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class AccountManagement implements ActionListener 
{
    final private Font Heading = new Font("Helvetica", Font.BOLD, 18);
    final private Font mainFont = new Font("Helvetica", Font.BOLD, 12);
    final private Font infoFont = new Font("Helvetica", Font.BOLD, 16);


    JFrame accountmanagement, accounttable;
    JLabel lbWelcome, lbinfo, lbstudentID, lbfullName, lbcourse, lbyearLvl, lbaddress, lbemail, lbcontact; //textarea
    JTextField tfstudentID, tffullName, tfaddress, tfemail, tfcontact; //textbox
    JComboBox<String> ddcourse; //dropdown
    JComboBox<Integer> ddyearLvl;
    JButton btnClear, btnUpdate, btnExit, btnNext, btnPrevious; //buttons

    ArrayList<Student> studentList;
    int currIndex;

    public AccountManagement(ArrayList<Student> studentList)
    {
        accountmanagement = new JFrame("Account Management");
        accounttable = new JFrame("Account Table");

        if(studentList.size()==0 || studentList==null) {
            JOptionPane.showMessageDialog(accountmanagement, "No data to load");
            System.exit(0);
        }
        this.studentList=studentList;
        currIndex=0;

        /* Labels */   
        lbWelcome=new JLabel("Account Information");
        lbinfo = new JLabel();
        lbstudentID=new JLabel("Student ID:");
        lbfullName=new JLabel("Name:");
        lbcourse=new JLabel("Course:");
        lbyearLvl=new JLabel("Level:");
        lbaddress=new JLabel("Address:");
        lbemail=new JLabel("Email:");
        lbcontact=new JLabel("Contact Number:");

        /* Label Fonts */
        lbWelcome.setFont(Heading);
        lbinfo.setFont(infoFont);
        lbstudentID.setFont(mainFont);
        lbfullName.setFont(mainFont);
        lbcourse.setFont(mainFont);
        lbyearLvl.setFont(mainFont);
        lbaddress.setFont(mainFont);
        lbemail.setFont(mainFont);
        lbcontact.setFont(mainFont);

        /* Text Fields */
        tfstudentID = new JTextField("");
        tffullName = new JTextField("");
        tfaddress =new JTextField("");
        tfemail =new JTextField("");
        tfcontact =new JTextField("");

        /* Textfield Fonts */
        tfstudentID.setFont(mainFont);
        tffullName.setFont(mainFont);
        tfaddress.setFont(mainFont);
        tfemail.setFont(mainFont);
        tfcontact.setFont(mainFont);

        /* Dropdown */
        String courseArr[]={"BSCS-SE","BSCS-CPP","BSCS-DS","BSCS-NET"};
        ddcourse=new JComboBox<String>(courseArr);

        Integer levelArr[]={1,2,3,4,5,6};
        ddyearLvl=new JComboBox<Integer>(levelArr);

        /* Buttons */
        btnPrevious=new JButton("<<");
        btnPrevious.setBounds(20,320,150,20);
        btnPrevious.addActionListener(this);
        
        btnNext=new JButton(">>");
        btnNext.setBounds(230,320,150,20);
        btnNext.addActionListener(this);
        
        btnUpdate=new JButton("Update");
        btnUpdate.setBounds(20,360,100,20);
        btnUpdate.addActionListener(this);
        
        btnExit=new JButton("Exit");
        btnExit.setBounds(230,360,100,20);
        btnExit.addActionListener(this);

        /* Panels */
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(7,2));
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
        buttonsPanel.setLayout(new GridLayout(2,2));
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

        /* Windows */        
        accountmanagement.add(mainPanel);
        accountmanagement.setTitle("Account Management");
        accountmanagement.setSize(400, 450);
        accountmanagement.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        accountmanagement.setVisible(true);

        accounttable.add(lbinfo);
        accounttable.setTitle("Account Information");
        accounttable.setSize(200, 250);
        accounttable.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        accounttable.setVisible(true);
    }
    
    private void getData(Student s)
    {
       tfstudentID.setText(s.getstudentID());
       tffullName.setText(s.getfullName());
       tfaddress.setText(s.getaddress());
       tfemail.setText(s.getemail());
       tfcontact.setText(s.getcontact());

       int yearLvl = s.getyearLvl();
       switch (yearLvl)
       {
        case 1:
            ddyearLvl.setSelectedIndex(0);
            break;
        case 2:
            ddyearLvl.setSelectedIndex(1);
            break;
        case 3:
            ddyearLvl.setSelectedIndex(2);
            break;
        case 4:
            ddyearLvl.setSelectedIndex(3);
            break;
        case 5:
            ddyearLvl.setSelectedIndex(4);
            break;
        case 6:
            ddyearLvl.setSelectedIndex(5);
            break;
        default:
            JOptionPane.showMessageDialog(accountmanagement, "Invalid year level");
            System.exit(0);
       }

       String course = s.getCourse();
       switch (course)
       {
        case "BSCS-SE":
            ddcourse.setSelectedIndex(0);
            break;
        case "BSCS-CPP":
            ddcourse.setSelectedIndex(1);
            break;
        case "BSCS-DS":
            ddcourse.setSelectedIndex(2);
            break;
        case "BSCS-NET":
            ddcourse.setSelectedIndex(3);
            break;
        default:
            JOptionPane.showMessageDialog(accountmanagement, "Invalid course");
            System.exit(0);
       }
    }
    
    private boolean check()
    {
        if(tfstudentID.getText().equals("")) {
            JOptionPane.showMessageDialog(accountmanagement, "Invalid student id!");
            return false;
        }
        if(tffullName.getText().equals("")) {
                JOptionPane.showMessageDialog(accountmanagement, "Invalid student name!");
                return false;
        }
        if(tfaddress.getText().equals("")) {
                JOptionPane.showMessageDialog(accountmanagement, "Invalid address!");
                return false;
        }
        if(tfemail.getText().equals("")) {
                JOptionPane.showMessageDialog(accountmanagement, "Invalid email!");
                return false;
        }
        if(tfcontact.getText().equals("")) {
                JOptionPane.showMessageDialog(accountmanagement, "Invalid contact!");
                return false;
        }
        return true;
    }
    @Override

    public void actionPerformed(ActionEvent event) 
    {
        if(event.getSource()==btnExit) {
                exitApplication();
        }
        if(event.getSource()==btnNext) {
                next();
        }
        if(event.getSource()==btnPrevious) {
                previous();
        }
        if(event.getSource()==btnUpdate) {
                update();
                String studentID = tfstudentID.getText();
                String fullName = tffullName.getText();
                int selectedCourse = ddcourse.getSelectedIndex();
                int selectedLevel = ddyearLvl.getSelectedIndex();
                String course = "";
                int yearLvl = 0;
                String address = tfaddress.getText();
                String email = tfemail.getText();
                String contactNumber = tfcontact.getText();
                
                switch (selectedCourse)
                {
                    case 0: course = "BSCS-SE"; break;
                    case 1: course = "BSCS-CPP"; break;
                    case 2: course = "BSCS-DS"; break;
                    case 3: course = "BSCS-NET"; break;
                }
                switch (selectedLevel)
                {
                 case 0: yearLvl = 1; break;
                 case 1: yearLvl = 2; break;
                 case 2: yearLvl = 3; break;
                 case 3: yearLvl = 4; break;
                 case 4: yearLvl = 5; break;
                 case 5: yearLvl = 6; break;
                }

                lbinfo.setText("<html>Student ID: " + studentID + "<br>Full Name: " + fullName + "<br>Course: " + course + "<br>Year Level: " + 
                                yearLvl + "<br>Address: " + address + "<br>Email: " + email + "<br>Contact Number: " + contactNumber);
        }
    }

    private void update() {
        if(check()==false){return;}
        Student s=studentList.get(currIndex);
        s.setstudentID(tfstudentID.getText());
        s.setfullName(tffullName.getText());
        s.setAddress(tfaddress.getText());
        s.setContact(tfcontact.getText());
        s.setEmail(tfemail.getText());
        
        JOptionPane.showMessageDialog(accountmanagement, "Record updated!");
    }    

    private void next() 
    {
        if(currIndex==studentList.size()-1) {
                JOptionPane.showMessageDialog(accountmanagement, "End of record!");
                return;
        }

        currIndex++;
        Student s=studentList.get(currIndex);
        getData(s);
    }

    private void previous() 
    {
        if(currIndex==0) {
                JOptionPane.showMessageDialog(accountmanagement, "End of record!");
                return;
        }
        currIndex--;
        Student s=studentList.get(currIndex);
        getData(s);
    }

    private void exitApplication()
    {
        int result = JOptionPane.showConfirmDialog(accountmanagement,"Sure? You want to exit?", "Exit application",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){System.exit(0);}
    }

    public static void main(String[] args){
        ArrayList<Student> studentList;
        studentList=new ArrayList<Student>();
        studentList.add(new Student("1","Darla David","BSCS-CPP",3,"Philippines","darla@mail.com","09395791221"));
        AccountManagement myAcc =new AccountManagement(studentList);
    }
}
