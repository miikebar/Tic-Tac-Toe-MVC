package me.pumpking.tictactoe.controllers;

import me.pumpking.tictactoe.Game;
import me.pumpking.tictactoe.models.GameState;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;


public class GameControllerTest {

    private GameController controller;

    @Before
    public void before() {
        Game game = Mockito.mock(Game.class);
        controller = new GameController(game);
    }

    @Ignore @Test
    public void showAndDisplayState() {
        controller.setAndShowGameState(GameState.DRAW);
        assertThat(controller.getState()).isEqualTo(GameState.DRAW);
        // TODO: implement mocking ViewController::showState ?
    }

}
