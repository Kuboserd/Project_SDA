package gui.panels;

import entity.flight.Flight;
import gui.designpatterns.Component;
import gui.designpatterns.Mediator;
import util.repository.Repository;

import javax.swing.*;
import java.util.List;

public class ViewFlightPanel extends JPanel implements Component {
    private Mediator mediator;
    private JTextArea flightsJTA = new JTextArea();
    private JScrollPane flightsJSP = new JScrollPane(flightsJTA);
    private JLabel searchFLightJL = new JLabel("Search flights by city");
    private JTextField searchFLightJTF = new JTextField();
    private JButton searchFlightJB = new JButton("Search");
    private JButton buyTicket = new JButton("Buy ticket");


    public ViewFlightPanel() {
        setAllBounds();
        addAllToPanel();
        addActionSearchButton();
        setLayout(null);
        setVisible(true);
    }

    public void addAllToPanel(){
        add(searchFLightJL);
        add(searchFLightJTF);
        add(searchFlightJB);
        add(flightsJSP);
    }

    public void setAllBounds(){
        searchFLightJL.setBounds(20,20,140,30);
        searchFLightJTF.setBounds(170,20,140,30);
        searchFlightJB.setBounds(320,20,100,30);
        flightsJSP.setBounds(10,60,450,100);
    }

    public void addActionSearchButton(){
        searchFlightJB.addActionListener(e -> {
            if(!searchFLightJTF.getText().isEmpty()){
                String cityName = searchFLightJTF.getText();
                List<Flight> flights= Repository.getPlaneByAirportCity(cityName);
                flightsJTA.selectAll();
                flightsJTA.replaceSelection("");
                flights.forEach(flight -> flightsJTA.append(flight.toString()));
            }
        });
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }


}
