package com.example.gameofthree.integration.incoming;

import com.example.gameofthree.integration.incoming.request.ChallengeRequest;
import com.example.gameofthree.integration.incoming.request.MoveRequest;
import com.example.gameofthree.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/challenge")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void challengeAFriend(@RequestBody ChallengeRequest challengeRequest) {

        gameService.challenge(challengeRequest);
    }

    @PostMapping("/move")
    @ResponseStatus(HttpStatus.OK)
    public void move(@RequestBody MoveRequest move) {

        gameService.move(move);
    }

    @PostMapping("/finish")
    public HttpEntity<HttpStatus> finish(@RequestBody String string) {

        System.out.println("I lost. Well played.");
        return new HttpEntity<>(HttpStatus.OK);
    }
}
