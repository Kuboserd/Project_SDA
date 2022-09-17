package gui;

import entity.users.Account;

import javax.swing.*;
import java.awt.*;

public class FrontPage extends JFrame {
    private Account user;

    public FrontPage(Account user) {
        this.user = user;
        this.main();
    }

    public void main() {

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel welcome = new JLabel();
        welcome.setText("Welcome to the front page!");
        welcome.setFont(new Font("Sans Serif", Font.BOLD, 20));
        welcome.setBounds(120, 10, 400, 20);
        panel.add(welcome, BorderLayout.CENTER);

        JLabel loggedInAs = new JLabel("You are now logged in as: " + user.getName(), SwingConstants.CENTER);
        loggedInAs.setBounds(30, 55, 400, 20);
        loggedInAs.setPreferredSize(new Dimension(400, 20));
        loggedInAs.setHorizontalAlignment(JLabel.CENTER);
        panel.add(loggedInAs);


        this.add(panel);
        this.setLocation(new Point(500, 300));
        this.setSize(new Dimension(500, 500));
        this.setVisible(true);
        this.setResizable(false);
    }
}
