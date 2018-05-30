package me.pumpking.tictactoe.controllers;

import me.pumpking.tictactoe.Game;
import me.pumpking.tictactoe.models.Board;
import me.pumpking.tictactoe.models.Field;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardControllerTest {

    private Board board;
    private BoardController controller;

    @Before
    public void before() {
        Game game = mock(Game.class);
        board = mock(Board.class);
        controller = new BoardController(game, board);
    }

    @Test
    public void getField() {
        controller.getField(0);
        verify(board).getField(0);
    }

    @Test
    public void setFieldSelectedBy() {
        controller.setFieldSelectedBy(0, Field.X);
        verify(board).setFieldSelectedBy(0, Field.X);
    }

    @Test
    public void getIndexesSelectedByX() {
        controller.getIndexesSelectedByX();
        verify(board).getIndexesSelectedByX();
    }

    @Test
    public void getIndexesSelectedByO() {
        controller.getIndexesSelectedByO();
        verify(board).getIndexesSelectedByO();
    }

    @Test
    public void getWinningCombinations() {
        controller.getWinningCombinations();
        verify(board).getWinningCombinations();
    }

}
