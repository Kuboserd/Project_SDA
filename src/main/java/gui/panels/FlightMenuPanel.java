package gui.panels;

import entity.flight.Airport;
import entity.flight.Flight;
import entity.flight.Plane;
import gui.designpatterns.Component;
import gui.designpatterns.Mediator;
import util.ValidationUtil;
import util.repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FlightMenuPanel extends JPanel implements Component {
    private JButton loadFlight = new JButton("Load flights from docs");
    private JButton saveFlight = new JButton("Save flights");
    private JLabel createFlight = new JLabel("Create flight");
    private JLabel airportFromJL = new JLabel("Airport from by city name");
    private JTextField airportFromJTF = new JTextField();
    private JButton searchAirportFromJB = new JButton("Search");
    private JLabel airportToJL = new JLabel("Airport to by city name");
    private JTextField airportToJTF = new JTextField();
    private JButton searchAirportToJB = new JButton("Search");
    private JTextArea resultAirportFromJTA = new JTextArea(10, 15);
    private JScrollPane scrollResultAirportFromJSP = new JScrollPane(resultAirportFromJTA);
    private JTextArea resultAirportToJTA = new JTextArea(10, 1);
    private JScrollPane scrollResultAirportToJSP = new JScrollPane(resultAirportToJTA);
    private JLabel planesByNameJL = new JLabel("Planes by name");
    private JTextField planesByNameJTF = new JTextField();
    private JButton searchPlanesJB = new JButton("Search");
    private JTextArea resultPlanesJTA = new JTextArea(10, 1);
    private JScrollPane scrollResultPlanesJSP = new JScrollPane(resultPlanesJTA);
    private JTextField departureTimeJTF = new JTextField();
    private JTextField arrivalTimeJTF = new JTextField();
    private JLabel departureTimeJL = new JLabel("Departure time");
    private JLabel arrivalTimeJL = new JLabel("Arrival time");
    private JButton saveDepartureTimeJB = new JButton("Save");
    private JButton saveArrivalTimeJB = new JButton("Save");
    private JButton saveAirportFromJB = new JButton("Save");
    private JButton saveAirportToJB = new JButton("Save");
    private JButton savePlaneJB = new JButton("Save");
    private JTextArea flightJTA = new JTextArea(10, 1);
    private JScrollPane flightJSP = new JScrollPane(flightJTA);
    private Flight flight = new Flight();
    private Mediator mediator;

    public FlightMenuPanel() {
        setAllBounds();
        setColorButtons();
        addAllToPanel();
        createResultAirportFrom();
        createResultAirportTo();
        createResultPlane();
        addActionSaveDepTimeButton();
        addActionSaveArrTimeButton();
        addActionSaveAirportFromButton();
        addActionSaveAirportToButton();
        addActionSavePlaneButton();
        addActionSaveFlightButton();
        setLayout(null);
        setVisible(true);
    }

    private void addAllToPanel() {
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
        add(departureTimeJL);
        add(departureTimeJTF);
        add(arrivalTimeJL);
        add(arrivalTimeJTF);
        add(saveDepartureTimeJB);
        add(saveArrivalTimeJB);
        add(saveAirportFromJB);
        add(saveAirportToJB);
        add(savePlaneJB);
        flightJTA.setEditable(false);
        add(flightJSP);
    }

    private void setAllBounds() {
        loadFlight.setBounds(400, 530, 120, 25);
        saveFlight.setBounds(530, 530, 120, 25);
        createFlight.setBounds(120, 40, 120, 25);
        airportFromJL.setBounds(20, 60, 150, 25);
        airportFromJTF.setBounds(20, 90, 150, 25);
        searchAirportFromJB.setBounds(190, 90, 120, 25);
        airportToJL.setBounds(20, 200, 150, 25);
        airportToJTF.setBounds(20, 230, 150, 25);
        searchAirportToJB.setBounds(190, 230, 120, 25);
        planesByNameJL.setBounds(20, 340, 150, 25);
        planesByNameJTF.setBounds(20, 370, 150, 25);
        searchPlanesJB.setBounds(190, 370, 120, 25);
        scrollResultAirportFromJSP.setBounds(330, 20, 450, 100);
        saveAirportFromJB.setBounds(330, 130, 100, 25);
        scrollResultAirportToJSP.setBounds(330, 160, 450, 100);
        saveAirportToJB.setBounds(330, 270, 100, 25);
        scrollResultPlanesJSP.setBounds(330, 300, 450, 100);
        savePlaneJB.setBounds(330, 410, 100, 25);
        departureTimeJL.setBounds(20, 420, 120, 25);
        departureTimeJTF.setBounds(20, 450, 120, 25);
        saveDepartureTimeJB.setBounds(160, 450, 100, 25);
        arrivalTimeJL.setBounds(20, 480, 120, 25);
        arrivalTimeJTF.setBounds(20, 500, 120, 25);
        saveArrivalTimeJB.setBounds(160, 500, 100, 25);
        flightJSP.setBounds(330, 450, 450, 70);
    }

    public void setColorButtons() {
        saveDepartureTimeJB.setForeground(Color.WHITE);
        saveDepartureTimeJB.setBackground(Color.BLACK);
        saveArrivalTimeJB.setForeground(Color.WHITE);
        saveArrivalTimeJB.setBackground(Color.BLACK);
        saveAirportToJB.setForeground(Color.WHITE);
        saveAirportToJB.setBackground(Color.BLACK);
        saveAirportFromJB.setForeground(Color.WHITE);
        saveAirportFromJB.setBackground(Color.BLACK);
        savePlaneJB.setForeground(Color.WHITE);
        savePlaneJB.setBackground(Color.BLACK);
        searchPlanesJB.setForeground(Color.WHITE);
        searchPlanesJB.setBackground(Color.BLACK);
        searchAirportFromJB.setForeground(Color.WHITE);
        searchAirportFromJB.setBackground(Color.BLACK);
        searchAirportToJB.setForeground(Color.WHITE);
        searchAirportToJB.setBackground(Color.BLACK);
        loadFlight.setForeground(Color.WHITE);
        loadFlight.setBackground(Color.BLACK);
        saveFlight.setForeground(Color.WHITE);
        saveFlight.setBackground(Color.BLACK);
    }

    private void createResultAirportFrom() {
        resultAirportFromJTA.setEditable(false);
        searchAirportFromJB.addActionListener(e -> {
            resultAirportFromJTA.selectAll();
            resultAirportFromJTA.replaceSelection("");
            String searchAirports = airportFromJTF.getText();
            List<Airport> airports = Repository.getByCityName(searchAirports);
            airports.forEach(airport -> resultAirportFromJTA.append(airport.toString()));
        });
    }

    private void createResultAirportTo() {
        resultAirportToJTA.setEditable(false);
        searchAirportToJB.addActionListener(e -> {
            resultAirportToJTA.selectAll();
            resultAirportToJTA.replaceSelection("");
            String searchAirports = airportToJTF.getText();
            List<Airport> airports = Repository.getByCityName(searchAirports);
            airports.forEach(airport -> resultAirportToJTA.append(airport.toString()));
        });
    }

    private void createResultPlane() {
        resultPlanesJTA.setEditable(false);
        searchPlanesJB.addActionListener(e -> {
            resultPlanesJTA.selectAll();
            resultPlanesJTA.replaceSelection("");
            String searchPlanes = planesByNameJTF.getText();
            List<Plane> planes = Repository.getByName(searchPlanes);
            planes.forEach(plane -> resultPlanesJTA.append(plane.toString()));
        });
    }

    private void addActionSaveDepTimeButton() {
        saveDepartureTimeJB.addActionListener(e -> {
            if (ValidationUtil.isValidLocalDataTime(departureTimeJTF.getText())) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime localDateTime = LocalDateTime.parse(departureTimeJTF.getText(), formatter);
                flight.setDepartureTime(localDateTime);
                flightJTA.selectAll();
                flightJTA.replaceSelection("");
                flightJTA.append(flight.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Invalid date");
            }
        });
    }

    private void addActionSaveArrTimeButton() {
        saveArrivalTimeJB.addActionListener(e -> {
            if (ValidationUtil.isValidLocalDataTime(arrivalTimeJTF.getText())) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime localDateTime = LocalDateTime.parse(arrivalTimeJTF.getText(), formatter);
                flight.setArrivalTime(localDateTime);
                flightJTA.selectAll();
                flightJTA.replaceSelection("");
                flightJTA.append(flight.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Invalid date");
            }
        });
    }

    private void addActionSaveAirportFromButton() {
        saveAirportFromJB.addActionListener(e -> {
            String[] airportTab = resultAirportFromJTA.getSelectedText().split("\\w+: ");
            String airportName = airportTab[1].split(",")[0];
            flight.setStartAirport(Repository.getAirportByName(airportName));
            flightJTA.selectAll();
            flightJTA.replaceSelection("");
            flightJTA.append(flight.toString());
        });
    }

    private void addActionSaveAirportToButton() {
        saveAirportToJB.addActionListener(e -> {
            String[] airportTab = resultAirportToJTA.getSelectedText().split("\\w+: ");
            String airportName = airportTab[1].split(",")[0];
            flight.setEndAirport(Repository.getAirportByName(airportName));
            flightJTA.selectAll();
            flightJTA.replaceSelection("");
            flightJTA.append(flight.toString());
        });
    }

    private void addActionSavePlaneButton() {
        savePlaneJB.addActionListener(e -> {
            String[] planeTab = resultPlanesJTA.getSelectedText().split("\\w+: ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate yearOfProduction = LocalDate.parse(planeTab[3], formatter);
            flight.setPlane(Repository.getPlaneByDate(yearOfProduction));
            flightJTA.selectAll();
            flightJTA.replaceSelection("");
            flightJTA.append(flight.toString());
        });
    }

    private void addActionSaveFlightButton() {
        saveFlight.addActionListener(e -> {
            System.out.println(flight);
            if (isValidFlight()) {
                Repository.addFlight(flight);
                JOptionPane.showMessageDialog(null, "Update flight");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid flight");
            }
        });
    }

    private boolean isValidFlight() {
        return flight.getArrivalTime() != null
                && flight.getDepartureTime() != null
                && flight.getEndAirport() != null
                && flight.getStartAirport() != null
                && flight.getPlane() != null;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return "flightMenuPanel";
    }
}
