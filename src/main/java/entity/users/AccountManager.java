package entity.users;

import util.repository.Repository;

public class AccountManager {
    private Account account;

    public void changeName(String name){

        account.setName(name);
        updateAccount();
    }
    public void changeSurname(String surname){

        account.setSurname(surname);
        updateAccount();
    }
    public void changePhoneNumber(String phone){

        account.setPhone(phone);
        updateAccount();
    }
    public void changeEmail(String email){

        account.setEmail(email);
        updateAccount();
    }
    public void changePassword(String password){

        account.setPassword(password);
        updateAccount();
    }
    public AccountManager(Account account) {
        this.account = account;
    }
    private void updateAccount(){
        Repository.updateAccount(this.account);
    }
}
