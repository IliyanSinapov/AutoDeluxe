package com.iliyan.autodeluxe.models.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tika.Tika;

import java.util.Base64;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUser {
    private Long id;
    private String username;
    private String email;
    private byte[] image;

    public boolean isLoggedIn() {
        return id != null;
    }

    public boolean isNotLoggedIn() {
        return id == null;
    }

    public String getImageType() {
        Tika tika = new Tika();
        return tika.detect(this.image);
    }

    public String getImageData() {
        return Base64.getEncoder().encodeToString(image);
    }

    public void clearUser() {
        this.id = null;
        this.username = null;
    }
}
