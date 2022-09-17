package gui;

import entity.users.Account;
import entity.users.Admin;
import entity.users.ServiceAssistant;
import entity.users.User;
import gui.designpatterns.AccountStrategy;
import gui.designpatterns.Component;
import gui.designpatterns.Mediator;
import gui.designpatterns.UserRegister;
import gui.panels.RegisterPanel;

import javax.swing.*;

public class GuiFrame extends JFrame implements Mediator {
    private Account account;
    private JPanel login;
    private RegisterPanel regUser;
    private JPanel admin;
    private JPanel assistant;
    private JPanel user;
    private AccountStrategy accountStrategy;
    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "loginPanel" -> login = (JPanel) component;
            case "regPanel" -> regUser = (RegisterPanel) component;
            case "userPanel" -> user = (JPanel) component;
            case "assistantPanel" -> assistant = (JPanel) component;
            case "adminPanel" -> admin = (JPanel) component;
        }
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
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void offLogJpOnRegJp() {
        remove(login);
        regUser.setAccountStrategy(new UserRegister());
        add(regUser);
        this.revalidate();
        regUser.setVisible(true);
        setSize(350,400);
    }

    @Override
    public void onVisibleLogPanel() {
        add(login);
    }

    @Override
    public void offRegJpOnLogJp() {
        remove(regUser);
        add(login);
        this.revalidate();
        login.setVisible(true);
        setSize(350,200);
    }

    @Override
    public void onVisibleRegPanel() {
        add(regUser);
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
