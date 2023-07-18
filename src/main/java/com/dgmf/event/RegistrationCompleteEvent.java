package com.dgmf.event;

import com.dgmf.entity.user.User;
import lombok.*;
import org.springframework.context.ApplicationEvent;

@Getter @Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private User user;
    private String confirmationUrl;

    public RegistrationCompleteEvent(User user, String confirmationUrl) {
        super(user);
        this.user = user;
        this.confirmationUrl = confirmationUrl;
    }
}
