package gui.panels;

import gui.designpatterns.AccountStrategy;
import gui.designpatterns.Component;
import gui.designpatterns.Mediator;

import javax.swing.*;

public class AdminPanel extends JPanel implements Component {
    private JButton flightsJB = new JButton("Flights menu");
    private JButton regAssistantJB = new JButton("Register Assistant");
    //private JButton backJB = new JButton("Back");
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

    private void addAllToPanel() {
        add(flightsJB);
        add(regAssistantJB);
        registerPanel.setVisible(false);
        add(registerPanel);
    }

    private void setAllBounds() {
        flightsJB.setBounds(20, 10, 140, 25);
        regAssistantJB.setBounds(170, 10, 140, 25);
        registerPanel.setBounds(0, 50, 350, 400);
    }

    private void createRegAssistantButton() {
        regAssistantJB.addActionListener(e -> {
            registerPanel.getBackJB().addActionListener(e1 -> mediator.offAdminPanelOnLogPanel());
            registerPanel.getInfoJL().setText("Register service assistant");
            registerPanel.setAccountStrategy(accountStrategy);
            registerPanel.setMediator(mediator);
            registerPanel.setVisible(true);
        });
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "adminPanel";
    }

    public void setAccountStrategy(AccountStrategy accountStrategy) {
        this.accountStrategy = accountStrategy;
    }
}
