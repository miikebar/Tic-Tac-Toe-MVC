package me.pumpking.tictactoe.controllers;

import me.pumpking.tictactoe.Game;
import me.pumpking.tictactoe.models.Board;
import me.pumpking.tictactoe.models.Field;

import java.util.List;
import java.util.Set;

public class BoardController extends Controller {

    private Board board;

    public BoardController(Game game, Board board) {
        super(game);
        this.board = board;
    }

    void setFieldSelectedBy(int index, Field field) {
        board.setFieldSelectedBy(index, field);
    }

    Set<Integer> getIndexesSelectedByX() {
        return board.getIndexesSelectedByX();
    }

    Set<Integer> getIndexesSelectedByO() {
        return board.getIndexesSelectedByO();
    }

    List<Integer> getAvailableIndexes() {
        return board.getAvailableIndexes();
    }

    List<Set<Integer>> getWinningCombinations() {
        return board.getWinningCombinations();
    }

    void clear() {
        board.clear();
    }

}
