package gui.designpatterns;

import entity.users.Account;
import gui.panels.*;

import javax.swing.*;

public interface Mediator {
    void registerComponent(Component component);
    void setAccount(Account account);
    Account getAccount();
    void choicePanel();
    void offPanelOnLoginPanel(JPanel jPanel);
    void onPanel(JPanel jPanel);
    void offPanel(JPanel jPanel);
    void addPanelToFrame(JPanel jPanel);
    void setSizePanel(int x, int y, JPanel jPanel);
    LoginPanel getLoginPanel();
    ChangeDataPanel getChangeDataPanel();
    FlightMenuPanel getFlightMenuPanel();
    RegisterPanel getRegisterPanel();
    AdminPanel getAdminPanel();
    void setAccountStrategy(String typeAccount);

}
