package gui.panels;

import entity.flight.Airport;
import entity.flight.Plane;
import gui.designpatterns.Component;
import gui.designpatterns.Mediator;
import util.repository.Repository;

import javax.swing.*;
import java.util.List;

public class FlightMenuPanel extends JPanel implements Component {
    private JButton loadFlight = new JButton("Load flights from docs");
    private JButton saveFlight = new JButton("Save flights");
    private JLabel createFlight = new JLabel("Create flight");
    private JLabel airportFromJL = new JLabel("Airport from by city name");
    private JTextField airportFromJTF = new JTextField();
    private JButton searchAirportFromJB = new JButton("Search");
    private JLabel airportToJL = new JLabel("Airport from by city name");
    private JTextField airportToJTF = new JTextField();
    private JButton searchAirportToJB = new JButton("Search");
    private JTextArea resultAirportFromJTA = new JTextArea(10,15);
    private JScrollPane scrollResultAirportFromJSP = new JScrollPane(resultAirportFromJTA);
    private JTextArea resultAirportToJTA = new JTextArea(10,15);
    private JScrollPane scrollResultAirportToJSP = new JScrollPane(resultAirportToJTA);
    private JLabel planesByNameJL = new JLabel("Planes by name");
    private JTextField planesByNameJTF = new JTextField();
    private JButton searchPlanesJB = new JButton("Search");
    private JTextArea resultPlanesJTA = new JTextArea(10,15);
    private JScrollPane scrollResultPlanesJSP = new JScrollPane(resultPlanesJTA);
    private Mediator mediator;

    public FlightMenuPanel() {
        setAllBounds();
        addAllToPanel();
        createResultAirportFrom();
        createResultAirportTo();
        createResultPlane();
        setLayout(null);
        setVisible(true);
    }

    private void addAllToPanel(){
        add(loadFlight);
        add(saveFlight);
        add(createFlight);
        add(airportFromJL);
        add(airportFromJTF);
        add(airportToJL);
        add(airportToJTF);
        add(searchAirportFromJB);
        add(searchAirportToJB);
        add(scrollResultAirportFromJSP);
        add(scrollResultAirportToJSP);
        add(planesByNameJL);
        add(planesByNameJTF);
        add(searchPlanesJB);
        add(scrollResultPlanesJSP);
    }

    private void setAllBounds(){
        loadFlight.setBounds(400,530,120,25);
        saveFlight.setBounds(530,530,120,25);
        createFlight.setBounds(120,40,120,25);
        airportFromJL.setBounds(20,60,150,25);
        airportFromJTF.setBounds(20,90,150,25);
        searchAirportFromJB.setBounds(190,90,120,25);
        airportToJL.setBounds(20,200,150,25);
        airportToJTF.setBounds(20,230,150,25);
        searchAirportToJB.setBounds(190,230,120,25);
        planesByNameJL.setBounds(20,340,150,25);
        planesByNameJTF.setBounds(20,370,150,25);
        searchPlanesJB.setBounds(190,370,120,25);
    }

    private void createResultAirportFrom(){
        resultAirportFromJTA.setEditable(false);
        scrollResultAirportFromJSP.setBounds(330,20,450,100);
        scrollResultAirportFromJSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        searchAirportFromJB.addActionListener(e -> {
            String searchAirports = airportFromJTF.getText();
            List<Airport> airports = Repository.getByCityName(searchAirports);
            resultAirportFromJTA.setText(airports.toString());
        });
    }

    private void createResultAirportTo(){
        resultAirportToJTA.setEditable(false);
        scrollResultAirportToJSP.setBounds(330,160,450,100);
        scrollResultAirportToJSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        searchAirportToJB.addActionListener(e -> {
            String searchAirports = airportToJTF.getText();
            List<Airport> airports = Repository.getByCityName(searchAirports);
            resultAirportToJTA.setText(airports.toString());
        });
    }

    private void createResultPlane(){
        resultPlanesJTA.setEditable(false);
        scrollResultPlanesJSP.setBounds(330,300,450,100);
        scrollResultPlanesJSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        searchPlanesJB.addActionListener(e -> {
            String searchPlanes = planesByNameJTF.getText();
            List<Plane> planes = Repository.getByName(searchPlanes);
            resultPlanesJTA.setText(planes.toString());
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
