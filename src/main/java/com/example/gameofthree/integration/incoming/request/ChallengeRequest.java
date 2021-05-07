package com.example.gameofthree.integration.incoming.request;

import com.example.gameofthree.model.InputType;

import java.util.Random;

public class ChallengeRequest {

    private final String opponent;
    private final InputType inputType;
    private final int number;

    public ChallengeRequest(String opponent, InputType inputType, int number) {
        this.opponent = opponent;
        this.inputType = inputType;
        this.number = number;
    }

    public String getOpponent() {
        return opponent;
    }

    public InputType getInputType() {
        return inputType;
    }

    public int getNumber() {

        if (InputType.AUTO.equals(this.getInputType())) {
            return new Random().nextInt(100000);
        }
        return number;
    }
}
