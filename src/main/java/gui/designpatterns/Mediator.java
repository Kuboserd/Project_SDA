package gui.designpatterns;

import entity.users.Account;
import gui.panels.*;
import gui.panels.AdminPanel;

import javax.swing.*;

public interface Mediator {
    void registerComponent(Component component);
    void setAccount(Account account);
    Account getAccount();
    Account getAccountStrategy();
    void choicePanel();
    void offPanelOnLoginPanel(JPanel jPanel);
    void onPanel(JPanel jPanel);
    void offPanel(JPanel jPanel);
    void setSizeFrame(int x, int y);
    LoginPanel getLoginPanel();
    ChangeDataPanel getChangeDataPanel();
    FlightMenuPanel getFlightMenuPanel();
    RegisterPanel getRegisterPanel();
    AdminPanel getAdminPanel();
    void setBackAndInfoRegPanel(String panel);
    void setAccount(String typeAccount);
}
