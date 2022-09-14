package gui;

import repository.Repository;
import users.Account;

import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {


    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("FlightBooker - Login Page");
        frame.setLocation(new Point(500, 300));


        JPanel panel = new JPanel(new BorderLayout());
        panel.setLayout(null);



        JLabel label = new JLabel("Username");
        label.setBounds(100, 8, 70, 20);
        panel.add(label);


        JTextField email = new JTextField();
        email.setBounds(100, 27, 193, 28);
        panel.add(email);

        JLabel pswdLabel = new JLabel("Password");
        pswdLabel.setBounds(100, 55, 70, 20);
        panel.add(pswdLabel);

        JPasswordField pswdField = new JPasswordField();
        pswdField.setBounds(100, 75, 190, 28);
        panel.add(pswdField);


        JButton but = new JButton("Login");
        but.setBounds(100, 110, 90, 25);
        but.setForeground(Color.WHITE);
        but.setBackground(Color.BLACK);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //TODO: Confirm if logged in



                String mail = email.getText();
                List<Account> accountsQueried = Repository.getByMail(mail);
                if(accountsQueried.size() <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid email!");
                } else {
                    String password = String.valueOf(pswdField.getPassword());
                    System.out.println(accountsQueried.get(0).getPassword());
                    System.out.println(password);
                    if(!accountsQueried.get(0).getPassword().equals(password)) {
                        JOptionPane.showMessageDialog(null, "Invalid password!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        //TODO: Pass <User> to FrontPage to query records
                        FrontPage page = new FrontPage(mail);
                        page.setLocationRelativeTo(frame);
                        frame.setVisible(false);
                    }

                }



            }
        });
        panel.add(but);



//        JTextPane f = new JTextPane();
//        f.setEditable(false);
//        f.setFont(new Font("Serif", Font.BOLD, 30));
//        StyledDocument doc = f.getStyledDocument();
//        doc.setParagraphAttributes(0, doc.getLength(), GUIAttributes.getCenter(), false);
//        f.setText("Welcome to FlightBooker! \nPlease log in to continue.");
//        panel.add(f, BorderLayout.NORTH);
//        frame.add(panel);
//
//        JTextField field = new JTextField();
//        field.setToolTipText("Enter e-mail");
//        field.setBackground(new Color(255, 255, 0));
//        field.setSize(new Dimension(400, 300));
//        frame.add(field);










        frame.pack();
        frame.add(panel);
        frame.setSize(new Dimension(700, 300));

        frame.setVisible(true);

    }


}
