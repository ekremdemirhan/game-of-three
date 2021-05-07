package com.example.gameofthree.integration.outgoing;

import com.example.gameofthree.model.Move;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class GameOfThreeClient implements GameClient {

    private final RestTemplate restTemplate;

    @Autowired
    public GameOfThreeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendMove(String opponentEndpoint, Move move) {
        try {
            restTemplate.postForLocation("http://" + opponentEndpoint + "/game/move", new HttpEntity<>(move));
        } catch (RestClientException e) {
            System.out.println("Opponent is offline!");
        }
    }

    @Override
    public void sendGameEnds(String opponentEndpoint) {

        try {
            restTemplate.postForLocation("http://" + opponentEndpoint + "/game/finish",
                    new HttpEntity<>("I won! Good game."),
                    HttpEntity.class);
        } catch (RestClientException e) {
            System.out.println("Opponent is offline!");
        }
    }

}
