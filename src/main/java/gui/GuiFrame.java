package gui;

import entity.users.Account;
import entity.users.Admin;
import entity.users.ServiceAssistant;
import entity.users.User;
import gui.mediator.Component;
import gui.mediator.Mediator;

import javax.swing.*;

public class GuiFrame extends JFrame implements Mediator {
    private Account account;
    private JPanel login;
    private JPanel reg;
    private JPanel admin;
    private JPanel assistant;
    private JPanel user;

    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "loginPanel" -> login = (JPanel) component;
            case "regPanel" -> reg = (JPanel) component;
            case "userPanel" -> user = (JPanel) component;
            case "assistantPanel" -> assistant = (JPanel) component;
            case "adminPanel" -> admin = (JPanel) component;
        }
    }

    @Override
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void choicePanel() {
        if(account.getClass().equals(Admin.class)){
            remove(login);
            add(admin);
            this.revalidate();
            admin.setVisible(true);
            setSize(350,400);
        } else if (account.getClass().equals(ServiceAssistant.class)) {
            remove(login);
            add(assistant);
            this.revalidate();
            assistant.setVisible(true);
            setSize(480,400);
        } else if (account.getClass().equals(User.class)) {
            remove(login);
            add(user);
            this.revalidate();
            user.setVisible(true);
            setSize(350,400);
        }
    }

    @Override
    public void offLogJpOnRegJp() {
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
    public void offRegJpOnLogJp() {
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
