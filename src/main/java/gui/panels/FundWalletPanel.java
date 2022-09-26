package gui.panels;

import entity.users.User;
import gui.designpatterns.Component;
import gui.designpatterns.Mediator;

import javax.swing.*;

public class FundWalletPanel extends JPanel implements Component {
    private JLabel cashJL = new JLabel("Cash user:");
    private User user;
    private Mediator mediator;

    public FundWalletPanel() {
        add(cashJL);
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
