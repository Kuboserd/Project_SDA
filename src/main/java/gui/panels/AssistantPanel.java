package gui.panels;

import gui.mediator.Component;
import gui.mediator.Mediator;

import javax.swing.*;

public class AssistantPanel extends JPanel implements Component {
    private JButton changeDate = new JButton("Change date");
    private JButton viewFlights = new JButton("View Flights");
    private JButton viewMessage = new JButton("View Message");
    private Mediator mediator;

    public AssistantPanel() {
        setAllBounds();
        addAllToPanel();
        setLayout(null);
        setVisible(true);
    }

    private void addAllToPanel(){
        add(changeDate);
        add(viewFlights);
        add(viewMessage);
    }

    public void setAllBounds(){
        changeDate.setBounds(20,20,140,25);
        viewFlights.setBounds(170,20,140,25);
        viewMessage.setBounds(310,20,140,25);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName(){
        return "assistantPanel";
    }
}
