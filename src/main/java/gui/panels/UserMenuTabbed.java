package gui.panels;

import gui.designpatterns.Component;
import gui.designpatterns.Mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserMenuTabbed extends JPanel implements Component {
    private Mediator mediator;
    private JLabel welcomeJL = new JLabel();
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem changeData = new JMenuItem("Change data");
    private JMenuItem viewFlights = new JMenuItem("View Flights");
    private JMenuItem fundWallet = new JMenuItem("Fund wallet");
    private JMenuItem yourTicket = new JMenuItem("Your ticket");
    private JMenuItem contactAssistant = new JMenuItem("Contact with Assistant");
    private JMenuItem backToMenu = new JMenuItem("Back");
    private JMenu menu = new JMenu("Menu");
    private JButton closeJB = new JButton("x");

    public UserMenuTabbed() {
        setColorButton();
        addMenuItemToMenu();
        addActionMenuItem();
        createJMenu();
        setAllBounds();
        addAllToPanel();
        setLayout(null);
       // setSize(300,300);
        setVisible(true);
    }

    public void addAllToPanel(){
        add(menuBar);
        welcomeJL.setFont(new Font("Serif", Font.PLAIN, 20));
        add(welcomeJL);
        tabbedPane.setSize(600,460);
        add(tabbedPane);

    }

    private void setAllBounds(){
        menuBar.setBounds(0,0,80,40);
        welcomeJL.setBounds(180,0,160,40);
        tabbedPane.setBounds(0,40,100,100);
    }

    private void createJMenu(){
        menu.setSize(80,40);
        menu.setHorizontalTextPosition(SwingConstants.CENTER);
        //menuBar.setLayout(new BorderLayout());
        menuBar.setLayout(null);
        menuBar.add(menu);

    }

    private void addMenuItemToMenu(){
        menu.add(changeData);
        menu.add(viewFlights);
        menu.add(fundWallet);
        menu.add(yourTicket);
        menu.add(contactAssistant);
        menu.add(backToMenu);
    }

    private void addActionMenuItem(){
        changeData.addActionListener(e -> addActionToTabbedPane("Change data"));
        fundWallet.addActionListener(e -> addActionToTabbedPane("Found wallet"));
        viewFlights.addActionListener(e -> addActionToTabbedPane("View flights"));
        backToMenu.addActionListener(e -> {
            mediator.offPanel(this);
            mediator.setSizeFrame(350,200);
            mediator.onPanel(mediator.getLoginPanel());
        });
    }

    private void addActionToTabbedPane(String text){
        switch (text){
            case "Change data" -> tabbedPane.addTab(text, mediator.getChangeDataPanel());
            case "Found wallet" -> tabbedPane.addTab(text, mediator.getFundWalletPanel());
            case "View flights" -> tabbedPane.addTab(text, mediator.getViewFlightPanel());
        }
    }

    public void setColorButton(){
        UIManager.put("TabbedPane.selected", Color.GRAY);
        SwingUtilities.updateComponentTreeUI(tabbedPane);
        tabbedPane.setForeground(Color.WHITE);
        tabbedPane.setBackground(Color.BLACK);
    }

    public JLabel getWelcomeJL() {
        return welcomeJL;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName(){
        return "userMenuTab";
    }
}
