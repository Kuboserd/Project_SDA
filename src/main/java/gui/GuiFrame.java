package gui;

import entity.users.Account;
import entity.users.Admin;
import entity.users.ServiceAssistant;
import entity.users.User;
import gui.designpatterns.*;
import gui.panels.AdminPanel;
import gui.panels.ChangeDataPanel;
import gui.panels.RegisterPanel;

import javax.swing.*;

public class GuiFrame extends JFrame implements Mediator {
    private Account account;
    private JPanel login;
    private RegisterPanel regUser;
    private AdminPanel adminPanel;
    private JPanel assistant;
    private JPanel user;
    private ChangeDataPanel changeDataPanel;
    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "loginPanel" -> login = (JPanel) component;
            case "regPanel" -> regUser = (RegisterPanel) component;
            case "userPanel" -> user = (JPanel) component;
            case "assistantPanel" -> assistant = (JPanel) component;
            case "adminPanel" -> adminPanel = (AdminPanel) component;
            case "changeDataPanel" -> changeDataPanel = (ChangeDataPanel) component;
        }
    }

    @Override
    public void choicePanel() {
        if(account.getClass().equals(Admin.class)){
            remove(login);
            adminPanel.setAccountStrategy(new AssistantRegister());
            add(adminPanel);
            this.revalidate();
            adminPanel.setVisible(true);
            setSize(350,550);
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
            setSize(350,550);
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
        setSize(350,430);
    }

    @Override
    public void offAdminPanelOnLogPanel() {
        remove(adminPanel);
        add(login);
        this.revalidate();
        login.setVisible(true);
        setSize(350,200);
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
    public ChangeDataPanel onChangeDataPanel() {
       return changeDataPanel;
    }

    @Override
    public Account getAccount() {
        return account;
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
