package me.pumpking.tictactoe.controllers;

import javafx.stage.Stage;
import me.pumpking.tictactoe.Game;
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

}
