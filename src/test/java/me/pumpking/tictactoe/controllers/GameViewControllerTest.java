package me.pumpking.tictactoe.controllers;

import javafx.stage.Stage;
import me.pumpking.tictactoe.Game;
import me.pumpking.tictactoe.models.GameState;
import me.pumpking.tictactoe.views.GameView;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameViewControllerTest {

    private GameView view;
    private GameViewController controller;

    @Before
    public void before() {
        Game game = mock(Game.class);
        view = mock(GameView.class);
        controller = new GameViewController(game, view);
    }

    @Test
    public void showGUI() {
        Stage stage = mock(Stage.class);
        controller.showGUI(stage);
        verify(view).showGUI(stage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void showGUINull() {
        controller.showGUI(null);
    }

    @Test
    public void clear() {
        controller.clear();
        verify(view).clear();
    }

    @Test
    public void showState() {
        controller.showState(GameState.X_TURN);
        verify(view).showState(GameState.X_TURN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void showStateNull() {
        controller.showState(null);
    }

}
