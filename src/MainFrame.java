import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Helvetica", Font.BOLD, 18);
    JTextField tffirstName, tflastName;
    JLabel lbWelcome;

    public void initialize() {
        JLabel lbfirstName = new JLabel("First Name: ");
        lbfirstName.setFont(mainFont);

        tffirstName = new JTextField();
        tffirstName.setFont(mainFont);

        JLabel lblastName = new JLabel("Last Name: ");
        lblastName.setFont(mainFont);

        tflastName = new JTextField();
        tflastName.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(lbfirstName);
        formPanel.add(tffirstName);
        formPanel.add(lblastName);
        formPanel.add(tflastName);
        ////////////////
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);
        ////////////////
        JButton btnOK = new JButton("OKAY");
        btnOK.setFont(mainFont);
        btnOK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = tffirstName.getText();
                String lastName = tflastName.getText();
                lbWelcome.setText("Hello " + firstName + " " + lastName); 
            }
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                tffirstName.setText("");
                tflastName.setText("");
                lbWelcome.setText("");
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        formPanel.setOpaque(false);
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnClear);
        ////////////////
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Welcome");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}
