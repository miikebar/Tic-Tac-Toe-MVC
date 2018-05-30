package me.pumpking.tictactoe.controllers;

import me.pumpking.tictactoe.Game;
import org.junit.Before;
import org.mockito.Mockito;

public class GameControllerTest {

    private GameController controller;

    @Before
    public void before() {
        Game game = Mockito.mock(Game.class);
        controller = new GameController(game);
    }

}
