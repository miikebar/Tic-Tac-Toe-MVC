package me.pumpking.tictactoe.controllers;

import me.pumpking.tictactoe.Game;

public abstract class Controller {

    protected Game game;

    public Controller(Game game) {
        this.game = game;
    }

}
