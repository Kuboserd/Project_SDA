package gui.panels;

import gui.designpatterns.Component;
import gui.designpatterns.Mediator;

import javax.swing.*;

public class AdminPanel extends JPanel implements Component {
    private JButton flights = new JButton("Flights menu");
    private JButton regAssistant = new JButton("Register Assistant");
    private Mediator mediator;

    public AdminPanel() {
        setAllBounds();
        addAllToPanel();
        setLayout(null);
        setVisible(true);
    }

    private void addAllToPanel(){
        add(flights);
        add(regAssistant);
    }

    private void setAllBounds(){
        flights.setBounds(20,20,140,25);
        regAssistant.setBounds(170,20,140,25);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName(){
        return "adminPanel";
    }
}