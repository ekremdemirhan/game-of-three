package com.example.gameofthree.model;

import com.example.gameofthree.integration.incoming.request.MoveRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.net.InetAddress;

public class Move {

    private final String player;
    private final int number;

    private int addition;

    public Move(String port, int number) {
        this.player = playerEndpoint(port);
        this.number = number;
    }

    public Move(String port, MoveRequest lastMove) {
        this.player = playerEndpoint(port);
        this.number = divideNumberByThree(lastMove.getNumber());
    }

    private int divideNumberByThree(int number) {
        if (number % 3 == 0) {
            this.addition = 0;
        } else if (number % 3 == 1) {
            this.addition = -1;
        } else {
            this.addition = 1;
        }
        return (number + addition) / 3;
    }

    @Override
    public String toString() {
        return "{" +
                "addition=" + addition +
                ", result number=" + number +
                '}';
    }

    private String playerEndpoint(String port) {
        return InetAddress.getLoopbackAddress().getHostAddress() + ":" + port;
    }

    public String getPlayer() {
        return player;
    }

    public int getNumber() {
        return number;
    }
}
