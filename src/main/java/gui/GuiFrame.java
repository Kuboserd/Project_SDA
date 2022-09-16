package gui;

import gui.mediator.Component;
import gui.mediator.Mediator;

import javax.swing.*;

public class GuiFrame extends JFrame implements Mediator {
    private JPanel login;
    private JPanel reg;

    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "loginPanel" -> login = (JPanel) component;
            case "regPanel" -> reg = (JPanel) component;
        }
    }

    @Override
    public void addToFrame() {

    }

    @Override
    public void offVisibleLogPanel() {
        remove(login);
        add(reg);
        this.revalidate();
        reg.setVisible(true);
        setSize(350,400);
    }

    @Override
    public void onVisibleLogPanel() {
        add(login);
    }

    @Override
    public void offVisibleRegPanel() {
        remove(reg);
        add(login);
        this.revalidate();
        login.setVisible(true);
        setSize(350,200);
    }

    @Override
    public void onVisibleRegPanel() {
        add(reg);
    }

    public void createGui() {
        setTitle("Flybook - Login Page");
        add(login);
        setSize(350, 200);
        setResizable(true);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
