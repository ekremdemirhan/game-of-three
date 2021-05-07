package com.example.gameofthree.integration.incoming.request;

public class MoveRequest {

    private final String player;
    private final int number;

    public MoveRequest(String opponentEndpoint, int number) {
        this.player = opponentEndpoint;
        this.number = number;
    }

    public String getPlayer() {
        return player;
    }

    public int getNumber() {
        return number;
    }
}
