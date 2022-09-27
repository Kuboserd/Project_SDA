package gui.panels;

import entity.users.User;
import gui.designpatterns.Component;
import gui.designpatterns.Mediator;
import util.repository.Repository;

import javax.swing.*;

public class FundWalletPanel extends JPanel implements Component {
    private JLabel cashJL = new JLabel("Cash user:");
    private JLabel codeCardJL = new JLabel("Code card");
    private JTextField codeJTF = new JTextField();
    private JLabel validThruJL = new JLabel("Valid thru");
    private JTextField validThruJTF = new JTextField();
    private JLabel cvvJL = new JLabel("CVV");
    private JTextField cvvJTF = new JTextField();
    private JLabel howManyCashJL = new JLabel("How many cash");
    private JTextField howManyCashJTF = new JTextField();
    private JButton addCash = new JButton("Top up your funds wallet");
    private User user;
    private Mediator mediator;

    public FundWalletPanel() {
        setAllBounds();
        addAllToPanel();
        addActionButton();
        setLayout(null);
        setVisible(true);
    }

    private void addAllToPanel(){
        add(cashJL);
        add(codeCardJL);
        add(codeJTF);
        add(validThruJL);
        add(validThruJTF);
        add(cvvJL);
        add(cvvJTF);
        add(addCash);
        add(howManyCashJL);
        add(howManyCashJTF);
    }

    private void setAllBounds(){
        cashJL.setBounds(160,0,150,30);
        codeCardJL.setBounds(20,40,80,30);
        codeJTF.setBounds(20,80,250,30);
        validThruJL.setBounds(20,120,80,30);
        validThruJTF.setBounds(20,160,100,30);
        cvvJL.setBounds(20,190,80,30);
        cvvJTF.setBounds(20,230,100,30);
        howManyCashJL.setBounds(20,270,140,30);
        howManyCashJTF.setBounds(20,310,100,30);
        addCash.setBounds(40,350,150,30);
    }

    private boolean checkJTF(){
        return !codeJTF.getText().isEmpty()
                && !validThruJTF.getText().isEmpty()
                && !cvvJTF.getText().isEmpty()
                && !howManyCashJTF.getText().isEmpty();
    }

    private void addActionButton(){
        addCash.addActionListener(e -> {
            if(checkJTF()){
                user.addBalance(Double.parseDouble(howManyCashJTF.getText()));
                Repository.updateAccount(user);
                cashJL.setText("Cash user: " + user.getBalance());
                JOptionPane.showMessageDialog(null, "Success");
            } else {
                JOptionPane.showMessageDialog(null,"Error");
            }
        });
    }

    public JLabel getCashJL() {
        return cashJL;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName(){
        return "fundWallet";
    }
}
