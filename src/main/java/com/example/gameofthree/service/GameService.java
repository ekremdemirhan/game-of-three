package com.example.gameofthree.service;

import com.example.gameofthree.integration.incoming.request.ChallengeRequest;
import com.example.gameofthree.integration.incoming.request.MoveRequest;

public interface GameService {

    void challenge(ChallengeRequest challengeRequest);

    void move(MoveRequest move);
}
