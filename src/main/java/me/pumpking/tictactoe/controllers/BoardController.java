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

    public Field getField(int index) {
        return board.getField(index);
    }

    public void setFieldSelectedBy(int index, Field field) {
        board.setFieldSelectedBy(index, field);
    }

    public Set<Integer> getIndexesSelectedByX() {
        return board.getIndexesSelectedByX();
    }

    public Set<Integer> getIndexesSelectedByO() {
        return board.getIndexesSelectedByO();
    }

    public Set<Integer> getAllIndexes() {
        return board.getAllIndexes();
    }

    public List<Set<Integer>> getWinningCombinations() {
        return board.getWinningCombinations();
    }

    public void clear() {
        board.clear();
    }

}
