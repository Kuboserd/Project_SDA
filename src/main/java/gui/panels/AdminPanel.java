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
        createFlightButton();
        setLayout(null);
        registerPanel.setVisible(false);
        setVisible(true);
    }

    private void addAllToPanel() {
        add(flightsJB);
        add(regAssistantJB);
        add(registerPanel);
    }

    private void setAllBounds() {
        flightsJB.setBounds(20, 10, 140, 25);
        regAssistantJB.setBounds(170, 10, 140, 25);
        registerPanel.setBounds(0, 50, 350, 400);
    }

    /*TODO
    *  usunąć zmienną registerPanel - zastąpić mediatorem
    *   ustawić odpowiednio rejestracje*/
    private void createRegAssistantButton() {
        regAssistantJB.addActionListener(e -> {
            mediator.setSizePanel(350,480,this);
            mediator.offPanel(mediator.getFlightMenuPanel());
            registerPanel.setMediator(mediator);
            registerPanel.getBackJB().addActionListener(e1 -> mediator.offPanelOnLoginPanel(this));
            registerPanel.getInfoJL().setText("Register service assistant");
            registerPanel.setAccountStrategy(accountStrategy);
            registerPanel.setVisible(true);
        });
    }

    private void createFlightButton() {
        flightsJB.addActionListener(e -> {
            registerPanel.setVisible(false);
            setSize(330,40);
            mediator.setSizePanel(800,600,mediator.getFlightMenuPanel());
            mediator.addPanelToFrame(mediator.getFlightMenuPanel());
            mediator.onPanel(mediator.getFlightMenuPanel());
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
