package entity.users;

import gui.designpatterns.AccountStrategy;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@ToString
@Entity
@DiscriminatorValue("service_assistant")
public class ServiceAssistant extends Account implements AccountStrategy {

    public ServiceAssistant() {
    }

    @Override
    public Account setAccountRegister() {
        return this;
    }
}
