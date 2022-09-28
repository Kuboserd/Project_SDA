package gui.designpatterns;

import entity.users.Account;
import gui.panels.*;
import gui.panels.AdminPanel;

import javax.swing.*;

public interface Mediator {
    void registerComponent(Component component);
    void setAccount(Account account);
    void choicePanel();
    void onPanel(JPanel jPanel);
    void offPanel(JPanel jPanel);
    void setSizeFrame(int x, int y);
    void setBackAndInfoRegPanel(String panel);
    void setAccountType(String typeAccount);
    void setBoundsPanel(JPanel jPanel);
    Account getAccount();
    Account getAccountStrategy();
    LoginPanel getLoginPanel();
    ChangeDataPanel getChangeDataPanel();
    FlightMenuPanel getFlightMenuPanel();
    RegisterPanel getRegisterPanel();
    FundWalletPanel getFundWalletPanel();
    ViewFlightPanel getViewFlightPanel();
    AdminPanel getAdminPanel();
}
