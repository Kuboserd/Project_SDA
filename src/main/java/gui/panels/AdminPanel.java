package gui.panels;

import gui.designpatterns.AccountStrategy;
import gui.designpatterns.Component;
import gui.designpatterns.Mediator;

import javax.swing.*;

public class AdminPanel extends JPanel implements Component {
    private JButton flights = new JButton("Flights menu");
    private JButton regAssistant = new JButton("Register Assistant");
    private Mediator mediator;
    private AccountStrategy accountStrategy;
    private RegisterPanel registerPanel = new RegisterPanel();


    public AdminPanel() {
        setAllBounds();
        addAllToPanel();
        createRegAssistantButton();
        setLayout(null);
        setVisible(true);
    }

    private void addAllToPanel(){
        add(flights);
        add(regAssistant);
        registerPanel.setVisible(false);
        add(registerPanel);
    }

    private void setAllBounds(){
        flights.setBounds(20,20,140,25);
        regAssistant.setBounds(170,20,140,25);
        registerPanel.setBounds(0,40,350,400);
    }

    private void createRegAssistantButton(){
        regAssistant.addActionListener(e -> {
           registerPanel.setAccountStrategy(accountStrategy);
           registerPanel.setMediator(mediator);
           registerPanel.setVisible(true);
           //registerPanel.setBounds(0,40,350,400);
        });
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName(){
        return "adminPanel";
    }

    public void setAccountStrategy(AccountStrategy accountStrategy) {
        this.accountStrategy = accountStrategy;
    }
}
