package gui.panels;

import entity.flight.Airport;
import gui.designpatterns.Component;
import gui.designpatterns.Mediator;
import util.repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FlightMenuPanel extends JPanel implements Component {
    private JButton loadFlight = new JButton("Load flights from docs");
    private JButton saveFlight = new JButton("Save flights");
    private JLabel createFlight = new JLabel("Create flight");
    private JLabel flightFromJL = new JLabel("Flight from - use city name");
    private JTextField flightFromJTF = new JTextField();
    private JButton searchFlightFromJB = new JButton("Search");
    private JLabel flightToJL = new JLabel("Flight from - use city name");
    private JTextField flightToJTF = new JTextField();
    private JButton searchFlightToJB = new JButton("Search");
    private JTextArea resultFlightFromJTA = new JTextArea(15,20);
    private JScrollPane scrollResultFlightFromJSP = new JScrollPane(resultFlightFromJTA);
    private JTextArea resultFlightToJTA = new JTextArea();
    private Mediator mediator;

    public FlightMenuPanel() {
        setAllBounds();
        addAllToPanel();
        addActionSearchFromButton();
        setLayout(null);
        setVisible(true);
    }

    private void addAllToPanel(){
        add(loadFlight);
        add(saveFlight);
        add(createFlight);
        add(flightFromJL);
        add(flightFromJTF);
        add(flightToJL);
        add(flightToJTF);
        add(searchFlightFromJB);
        add(searchFlightToJB);
        add(scrollResultFlightFromJSP);
        add(resultFlightToJTA);
    }

    private void setAllBounds(){
        loadFlight.setBounds(400,530,120,25);
        saveFlight.setBounds(530,530,120,25);
        createFlight.setBounds(120,40,120,25);
        flightFromJL.setBounds(20,70,150,25);
        flightFromJTF.setBounds(20,90,150,25);
        searchFlightFromJB.setBounds(190,90,120,25);
        resultFlightFromJTA.setEditable(false);
        scrollResultFlightFromJSP.setBounds(330,50,400,100);
        scrollResultFlightFromJSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  ;
    }

    public void addActionSearchFromButton(){
        searchFlightFromJB.addActionListener(e -> {
            String searchAirports = flightFromJTF.getText();
            List<Airport> airports = Repository.getByCityName(searchAirports);
            resultFlightFromJTA.setText(airports.get(0).toString());
        });
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName(){
        return "flightMenuPanel";
    }
}
