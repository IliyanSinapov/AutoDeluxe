package com.iliyan.autodeluxe.models.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUser {
    private String id;
    private String username;

    public boolean isLoggedIn() {
        return id != null;
    }

    public boolean isNotLoggedIn() {
        return id == null;
    }
}
