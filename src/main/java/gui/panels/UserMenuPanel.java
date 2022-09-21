package gui.panels;

import gui.designpatterns.Component;
import gui.designpatterns.Mediator;

import javax.swing.*;

public class UserMenuPanel extends JPanel implements Component {
    private JButton changeData = new JButton("Change data");
    private JButton viewFlights = new JButton("View Flights");
    private JButton fundWallet = new JButton("Fund wallet");
    private JButton yourTicket = new JButton("Your ticket");
    private JButton contactAssistant = new JButton("Contact with Assistant");
    private JButton backJB = new JButton("Back");
    private ChangeDataPanel changeDataPanel;
    private Mediator mediator;

    public UserMenuPanel() {
        setAllBounds();
        addActionChangeDate();
        addActionBackButton();
        addAllToPanel();
        setLayout(null);
        setVisible(true);
    }

    private void addAllToPanel() {
        add(changeData);
        add(viewFlights);
        add(fundWallet);
        add(yourTicket);
        add(contactAssistant);
        add(backJB);
    }

    private void setAllBounds() {
        changeData.setBounds(20, 20, 140, 25);
        viewFlights.setBounds(170, 20, 140, 25);
        fundWallet.setBounds(20, 50, 140, 25);
        yourTicket.setBounds(170, 50, 140, 25);
        contactAssistant.setBounds(70, 80, 200, 25);
        backJB.setBounds(260,440,70,25);
    }

    private void addActionChangeDate() {
        changeData.addActionListener(e -> {
            changeDataPanel = mediator.getChangeDataPanel();
            add(changeDataPanel);
            changeDataPanel.setAccount(mediator.getAccount());
            changeDataPanel.setBounds(0,110,350,330);
        });
    }

    /* TODO
    *   Zmienić z cofania do głównego ekranu na wylogowanie
    *   account ustawienie na null
    *   opcjonalnie wyczyszczenie JTF w menu*/
    private void addActionBackButton(){
        backJB.addActionListener(e -> {
            mediator.offPanelOnLoginPanel(this);
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
