package gui.panels;

import gui.mediator.Component;
import gui.mediator.Mediator;

import javax.swing.*;

public class UserMenuPanel extends JPanel implements Component {
    private JButton changeDate = new JButton("Change date");
    private JButton viewFlights = new JButton("View Flights");
    private JButton fundWallet = new JButton("Fund wallet");
    private JButton yourTicket = new JButton("Your ticket");
    private JButton contactAssistant = new JButton("Contact with Assistant");
    private Mediator mediator;

    public UserMenuPanel() {
        setAllBounds();
        addAllToPanel();
        setLayout(null);
        setVisible(true);
    }

    public void addAllToPanel(){
        add(changeDate);
        add(viewFlights);
        add(fundWallet);
        add(yourTicket);
        add(contactAssistant);
    }

    public void setAllBounds(){
        changeDate.setBounds(20, 20, 140, 25);
        viewFlights.setBounds(170,20,140,25);
        fundWallet.setBounds(20,50,140,25);
        yourTicket.setBounds(170,50,140,25);
        contactAssistant.setBounds(20,80,140,25);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName(){
        return "userPanel";
    }


}
