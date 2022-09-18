package gui.panels;

import gui.designpatterns.Component;
import gui.designpatterns.Mediator;

import javax.swing.*;
import java.awt.*;

public class FlightMenuPanel extends JPanel implements Component {
    private JButton loadFlight = new JButton("Load flights from docs");
    private JButton saveFlight = new JButton("Save flights");
    private JButton createFlight = new JButton("Create flight");
    private Mediator mediator;

    public FlightMenuPanel() {
        setBackground(Color.BLACK);
        setAllBounds();
        add(loadFlight);
        add(saveFlight);
        add(createFlight);
        setLayout(null);
        setVisible(true);
    }

    public void setAllBounds(){
        loadFlight.setBounds(10,70,120,25);
        saveFlight.setBounds(140,70,120,25);
        createFlight.setBounds(570,70,120,25);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName(){
        return "flightMenuPanel";
    }
}
