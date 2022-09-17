package gui.designpatterns;

import entity.users.Account;
import gui.panels.ChangeDataPanel;

import javax.swing.*;

public interface Mediator {
    void registerComponent(Component component);
    void setAccount(Account account);
    Account getAccount();
    void choicePanel();
    void offLogJpOnRegJp();
    void offPanelOnLoginPanel(JPanel jPanel);
    void offRegJpOnLogJp();
    ChangeDataPanel onChangeDataPanel();

}
