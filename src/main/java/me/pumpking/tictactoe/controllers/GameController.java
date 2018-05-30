package me.pumpking.tictactoe.controllers;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import me.pumpking.tictactoe.Game;
import me.pumpking.tictactoe.models.Field;
import me.pumpking.tictactoe.models.GameState;

import java.util.Set;

public class GameController extends Controller {

    private GameState state;

    public GameController(Game game) {
        super(game);
    }

    public void reset() {
        setAndShowGameState(Game.INITIAL_STATE);
        game.getViewController().clear();
        game.getBoardController().clear();
    }

    public void setAndShowGameState(GameState state) {
        Preconditions.checkArgument(state != null, "Cannot set the game state to null");
        this.state = state;
        game.getViewController().showState(state);
    }

    public void setAndShowField(int index, Field type) {
        game.getBoardController().setFieldSelectedBy(index, type);
        game.getViewController().setFieldSelectedBy(index, type);
    }

    private boolean hasWon(Field field) {
        Preconditions.checkArgument(field == Field.X || field == Field.O, "Cannot check whether EMPTY field has won");

        Set<Integer> indexes = (field == Field.X ? game.getBoardController().getIndexesSelectedByX() : game.getBoardController().getIndexesSelectedByO());
        for (Set<Integer> combination : game.getBoardController().getWinningCombinations()) {
            if (indexes.containsAll(combination)) {
                return true;
            }
        }
        return false;
    }

    private boolean isGameDrawn() {

    }

    public void handleFieldSelection(int index) {
        switch (state) {
            case X_TURN:
                setAndShowField(index, Field.X);
                setAndShowGameState(GameState.PROCESSING);
                setAndShowGameState(hasWon(Field.X) ? GameState.X_WINS : GameState.O_TURN);
                break;
            case O_TURN:
                setAndShowField(index, Field.O);
                setAndShowGameState(GameState.PROCESSING);
                setAndShowGameState(hasWon(Field.O) ? GameState.O_WINS : GameState.X_TURN);
                break;
        }

        if (state != GameState.X_WINS && state != GameState.O_WINS && isGameDrawn()) {
            setAndShowGameState(GameState.DRAW);
        }

    }



    @VisibleForTesting GameState getState() {
        return state;
    }

}
