package gui.panels;

import gui.designpatterns.Component;
import gui.designpatterns.Mediator;

import javax.swing.*;

public class AdminPanel extends JPanel implements Component {
    private JButton flightsJB = new JButton("Flights menu");
    private JButton regAssistantJB = new JButton("Register Assistant");
    //private JButton backJB = new JButton("Back");
    private Mediator mediator;

    public AdminPanel() {
        setAllBounds();
        addAllToPanel();
        createRegAssistantButton();
        createFlightButton();
        setLayout(null);
        setVisible(true);
    }

    private void addAllToPanel() {
        add(flightsJB);
        add(regAssistantJB);
    }

    private void setAllBounds() {
        flightsJB.setBounds(20, 10, 140, 25);
        regAssistantJB.setBounds(170, 10, 140, 25);
    }

    /*TODO
    *  usunąć zmienną registerPanel - zastąpić mediatorem
    *   ustawić odpowiednio rejestracje*/
    private void createRegAssistantButton() {
        regAssistantJB.addActionListener(e -> {
            setSize(330,40);
            mediator.setSizeFrame(350,480);
            mediator.setAccountType("assistant");
            mediator.setBackAndInfoRegPanel("admin");
            mediator.offPanel(mediator.getFlightMenuPanel());
            mediator.onPanel(mediator.getRegisterPanel());
        });
    }

    private void createFlightButton() {
        flightsJB.addActionListener(e -> {
            setSize(330,40);
            mediator.setSizeFrame(800,600);
            mediator.offPanel(mediator.getRegisterPanel());
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
}
