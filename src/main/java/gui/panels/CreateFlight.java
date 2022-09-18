package gui.panels;

import gui.designpatterns.Component;
import gui.designpatterns.Mediator;

import javax.swing.*;

public class CreateFlight extends JPanel implements Component {
    private Mediator mediator;
    private JLabel a;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
