package com.example.gameofthree.service;

import com.example.gameofthree.integration.incoming.request.MoveRequest;
import com.example.gameofthree.integration.outgoing.GameClient;
import com.example.gameofthree.integration.incoming.request.ChallengeRequest;
import com.example.gameofthree.model.Move;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class GameOfThreeService implements GameService {

    private final Environment environment;

    private final GameClient gameClient;

    @Autowired
    public GameOfThreeService(Environment environment, GameClient gameClient) {
        this.environment = environment;
        this.gameClient = gameClient;
    }

    @Override
    public void challenge(ChallengeRequest challengeRequest) {

        gameClient.sendMove(
                challengeRequest.getOpponent(),
                new Move(port(), challengeRequest.getNumber())
        );
    }

    @Override
    public void move(MoveRequest move) {

        final Move nextMove = new Move(port(), move);

        System.out.println(nextMove.toString());

        if (gameFinished(nextMove)) {
            notifyFinish(move.getPlayer());
            return;
        }

        gameClient.sendMove(move.getPlayer(), nextMove);
    }

    private void notifyFinish(String player) {

        System.out.println("I won! Good game.");
        gameClient.sendGameEnds(player);
    }

    private boolean gameFinished(Move nextMove) {
        return nextMove.getNumber() == 1;
    }

    private String port() {
        return environment.getProperty("local.server.port");
    }
}
