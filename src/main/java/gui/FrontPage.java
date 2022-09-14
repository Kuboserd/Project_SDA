package gui;

import javax.swing.*;
import java.awt.*;

public class FrontPage extends JFrame {
    private String user;         /*TODO: Convert into <User> object */

    public FrontPage(String user) {
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

        JLabel loggedInAs = new JLabel("You are now logged in as: " + user);
        loggedInAs.setBounds(150, 55, 400, 20);
        panel.add(loggedInAs, BorderLayout.CENTER);

        this.add(panel);
        this.setLocation(new Point(500, 300));
        this.setSize(new Dimension(500, 500));
        this.setVisible(true);
        this.setResizable(true);
    }
}
