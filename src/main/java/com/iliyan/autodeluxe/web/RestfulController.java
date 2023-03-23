package com.iliyan.autodeluxe.web;

import com.iliyan.autodeluxe.models.beans.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestfulController {

    private final LoggedUser loggedUser;

    @Autowired
    public RestfulController(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }

    @GetMapping(value = "/logged-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoggedUser getLoggedUser() {
        return loggedUser;
    }
}
