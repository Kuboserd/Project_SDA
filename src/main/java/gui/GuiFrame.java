package gui;

import entity.users.Account;
import entity.users.Admin;
import entity.users.ServiceAssistant;
import entity.users.User;
import gui.designpatterns.*;
import gui.panels.*;

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
        if(account.getClass().equals(Admin.class)){
            remove(login);
            adminPanel.setAccountStrategy(new AssistantRegister());
            add(adminPanel);
            revalidate();
            adminPanel.setVisible(true);
            setSize(350,550);
        } else if (account.getClass().equals(ServiceAssistant.class)) {
            remove(login);
            add(assistant);
            revalidate();
            assistant.setVisible(true);
            setSize(480,400);
        } else if (account.getClass().equals(User.class)) {
            remove(login);
            add(user);
            revalidate();
            user.setVisible(true);
            setSize(350,550);
        }
    }

    @Override
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void offPanelOnLoginPanel(JPanel jPanel) {
        remove(jPanel);
        add(login);
        revalidate();
        login.setVisible(true);
        setSize(350,200);
    }

    @Override
    public void onPanel(JPanel jPanel) {
        add(jPanel);
        revalidate();
        jPanel.setVisible(true);
    }

    @Override
    public void offPanel(JPanel jPanel){
        remove(jPanel);
        revalidate();
    }

    @Override
    public void setAccountStrategy(String typeAccount){
        switch (typeAccount){
            case "user" -> regUser.setAccountStrategy(new UserRegister());
            case "assistant" -> regUser.setAccountStrategy(new AssistantRegister());
        }
    }

    @Override
    public void addPanelToFrame(JPanel jPanel) {
        add(jPanel);
    }

    @Override
    public void setSizePanel(int x, int y, JPanel jPanel) {
        setSize(x,y);
        jPanel.setBounds(0,0,800,600);
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
    public RegisterPanel getRegisterPanel(){
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
