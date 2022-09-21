package gui.designpatterns;

import entity.users.Account;
import entity.users.ServiceAssistant;

public class AssistantRegister implements AccountStrategy {
    private Account account = new ServiceAssistant();
    @Override
    public Account setAccountRegister() {
        return account;
    }
}
