package gui;

import repository.Repository;
import users.Account;
import users.User;

import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {


    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Flybook - Login Page");
        frame.setLocation(new Point(500, 300));


        JPanel panel = new JPanel(new BorderLayout());
        panel.setLayout(null);



        JLabel label = new JLabel("E-mail");
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

        JButton reg = new JButton("Register");
        reg.setBounds(200, 110, 90, 25);
        reg.setForeground(Color.WHITE);
        reg.setBackground(Color.BLACK);


        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new RegisterPage(frame);

            }
        });


        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mail = email.getText();
                List<Account> accountsQueried = Repository.getByMail(mail);
                if(accountsQueried.size() <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid email!");
                    return;
                }
                String password = String.valueOf(pswdField.getPassword());
                Account account = accountsQueried.get(0);

                if(!account.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(null, "Invalid password!");
                    return;
                }
                FrontPage page = new FrontPage(account);
                page.setLocationRelativeTo(frame);
                frame.setVisible(false);
            }
        });

        panel.add(reg);
        panel.add(but);
        frame.pack();
        frame.add(panel);
        frame.setSize(new Dimension(700, 300));

        frame.setVisible(true);

    }


}
