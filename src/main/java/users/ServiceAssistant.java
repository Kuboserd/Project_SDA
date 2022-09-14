package users;

import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@ToString
@Entity
@DiscriminatorValue("service_assistant")
public class ServiceAssistant extends Account{

    public ServiceAssistant() {
    }

}
