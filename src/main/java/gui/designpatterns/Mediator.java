package gui.designpatterns;

import entity.users.Account;
import gui.panels.ChangeDataPanel;

public interface Mediator {
    void registerComponent(Component component);
    void setAccount(Account account);
    Account getAccount();
    void choicePanel();
    void offLogJpOnRegJp();
    void offAdminPanelOnLogPanel();
    void offRegJpOnLogJp();
    ChangeDataPanel onChangeDataPanel();

}
