package gui.panels;

import gui.designpatterns.Component;
import gui.designpatterns.Mediator;

import javax.swing.*;

public class UserMenuPanel extends JPanel implements Component {
    private JButton changeDate = new JButton("Change date");
    private JButton viewFlights = new JButton("View Flights");
    private JButton fundWallet = new JButton("Fund wallet");
    private JButton yourTicket = new JButton("Your ticket");
    private JButton contactAssistant = new JButton("Contact with Assistant");
    private ChangeDataPanel changeDataPanel;
    private Mediator mediator;

    public UserMenuPanel() {
        setAllBounds();
        addActionChangeDate();
        addAllToPanel();
        setLayout(null);
        setVisible(true);
    }

    private void addAllToPanel() {
        add(changeDate);
        add(viewFlights);
        add(fundWallet);
        add(yourTicket);
        add(contactAssistant);
    }

    private void setAllBounds() {
        changeDate.setBounds(20, 20, 140, 25);
        viewFlights.setBounds(170, 20, 140, 25);
        fundWallet.setBounds(20, 50, 140, 25);
        yourTicket.setBounds(170, 50, 140, 25);
        contactAssistant.setBounds(70, 80, 200, 25);
    }

    private void addActionChangeDate() {
        changeDate.addActionListener(e -> {
            changeDataPanel = mediator.onChangeDataPanel();
            add(changeDataPanel);
            changeDataPanel.setAccount(mediator.getAccount());
            changeDataPanel.setBounds(0,110,350,400);
        });
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "userPanel";
    }
}
