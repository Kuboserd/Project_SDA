package gui.designpatterns;

import entity.users.Account;

public interface Mediator {
    void registerComponent(Component component);
    void setAccount(Account account);
    void choicePanel();
    void offLogJpOnRegJp();
    void onVisibleLogPanel();
    void offRegJpOnLogJp();
    void onVisibleRegPanel();

}
