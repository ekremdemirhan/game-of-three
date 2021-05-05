package com.example.gameofthree.integration;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/game")
public class UserController {

    @GetMapping("/help")
    public HttpEntity<String> help() {
        return new HttpEntity<>("Hello");
    }
}
