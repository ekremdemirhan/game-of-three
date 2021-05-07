package com.example.gameofthree.service;

import com.example.gameofthree.integration.incoming.request.ChallengeRequest;
import com.example.gameofthree.integration.incoming.request.MoveRequest;
import com.example.gameofthree.integration.outgoing.GameClient;
import com.example.gameofthree.model.InputType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.env.Environment;

class GameOfThreeServiceTest {

    private Environment environment;
    private GameClient gameClient;
    private GameOfThreeService gameOfThreeService;

    @BeforeEach
    void setUp() {

        environment = Mockito.mock(Environment.class);
        gameClient = Mockito.mock(GameClient.class);
        gameOfThreeService = new GameOfThreeService(environment, gameClient);
    }

    @Test
    void when_ChallengeRequestHasCome_Then_SendAChallengeToOpponent() {

        gameOfThreeService.challenge(new ChallengeRequest("opponent", InputType.AUTO, 0));

        Mockito.verify(gameClient).sendMove(Mockito.anyString(), Mockito.any());
    }

    @Test
    void when_GameContinuesAndOpponentsNumberBiggerThanThree_Then_SendTheValueDivided() {

        gameOfThreeService.move(new MoveRequest("opponent", 5));

        Mockito.verify(gameClient).sendMove(Mockito.anyString(), Mockito.any());
    }

    @Test
    void when_GameContinuesAndOpponentsNumberSmallerThanThree_Then_FinishGame() {

        final String opponentEndpoint = "opponent";

        gameOfThreeService.move(new MoveRequest(opponentEndpoint, 3));

        Mockito.verify(gameClient).sendGameEnds(opponentEndpoint);
    }
}