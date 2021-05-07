package com.example.gameofthree.integration.outgoing;

import com.example.gameofthree.model.Move;

public interface GameClient {

    void sendMove(String opponentEndpoint, Move move);

    void sendGameEnds(String opponentEndpoint);
}
