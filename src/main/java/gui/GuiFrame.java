package gui;

import entity.users.Account;
import entity.users.Admin;
import entity.users.ServiceAssistant;
import entity.users.User;
import gui.designpatterns.*;
import gui.panels.*;
import gui.panels.AdminPanel;

import javax.swing.*;

public class GuiFrame extends JFrame implements Mediator {
    private Account account;
    private LoginPanel login;
    private RegisterPanel regUser;
    private AdminPanel adminPanel;
    private JPanel assistant;
    private JPanel user;
    private ChangeDataPanel changeDataPanel;
    private FlightMenuPanel flightMenuPanel;
    private AccountStrategy accountStrategy;

    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "loginPanel" -> login = (LoginPanel) component;
            case "regPanel" -> regUser = (RegisterPanel) component;
            case "userPanel" -> user = (JPanel) component;
            case "assistantPanel" -> assistant = (JPanel) component;
            case "adminPanel" -> adminPanel = (AdminPanel) component;
            case "changeDataPanel" -> changeDataPanel = (ChangeDataPanel) component;
            case "flightMenuPanel" -> flightMenuPanel = (FlightMenuPanel) component;
        }
    }

    @Override
    public void choicePanel() {
        if (account.getClass().equals(Admin.class)) {
            remove(login);
            add(adminPanel);
            revalidate();
            adminPanel.setVisible(true);
            setSize(350, 480);
        } else if (account.getClass().equals(ServiceAssistant.class)) {
            remove(login);
            add(assistant);
            revalidate();
            assistant.setVisible(true);
            setSize(480, 130);
        } else if (account.getClass().equals(User.class)) {
            remove(login);
            add(user);
            revalidate();
            user.setVisible(true);
            setSize(350, 170);
        }
        setResizable(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void onPanel(JPanel jPanel) {
        add(jPanel);
        setResizable(true);
        setLocationRelativeTo(null);
        revalidate();
        jPanel.setVisible(true);
    }

    @Override
    public void offPanel(JPanel jPanel) {
        remove(jPanel);
    }

    @Override
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void setAccountType(String typeAccount) {
        switch (typeAccount) {
            case "user" -> setAccountStrategy(new User());
            case "assistant" -> setAccountStrategy(new ServiceAssistant());
        }
    }


    @Override
    public void setSizeFrame(int x, int y) {
        setSize(x, y);
    }

    @Override
    public void setBoundsPanel(JPanel jPanel) {
        jPanel.setBounds(0,170,350,330);
    }

    @Override
    public void setBackAndInfoRegPanel(String panel) {
        switch (panel) {
            case "login" -> {
                regUser.getBackJB().addActionListener(e -> {
                    setSize(350, 200);
                    offPanel(regUser);
                    onPanel(login);
                });
                regUser.getInfoJL().setText("Register user");
            }
            case "admin" -> {
                regUser.getBackJB().addActionListener(e -> {
                    setSize(350, 200);
                    offPanel(regUser);
                    offPanel(adminPanel);
                    onPanel(login);
                });
                regUser.getInfoJL().setText("Register service assistant");
            }
        }
    }

    private void setAccountStrategy(AccountStrategy accountStrategy) {
        this.accountStrategy = accountStrategy;
    }

    @Override
    public Account getAccountStrategy() {
        return accountStrategy.setAccountRegister();
    }

    @Override
    public AdminPanel getAdminPanel() {
        return adminPanel;
    }

    @Override
    public ChangeDataPanel getChangeDataPanel() {
        return changeDataPanel;
    }

    @Override
    public FlightMenuPanel getFlightMenuPanel() {
        return flightMenuPanel;
    }

    @Override
    public RegisterPanel getRegisterPanel() {
        return regUser;
    }

    @Override
    public LoginPanel getLoginPanel() {
        return login;
    }

    @Override
    public Account getAccount() {
        return account;
    }

    public void createGui() {
        setTitle("Flybook - Login Page");
        add(login);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 200);
        setResizable(true);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
