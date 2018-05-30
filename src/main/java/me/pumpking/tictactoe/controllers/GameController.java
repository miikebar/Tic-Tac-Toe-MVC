package me.pumpking.tictactoe.controllers;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import me.pumpking.tictactoe.Game;
import me.pumpking.tictactoe.models.GameState;

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

    @VisibleForTesting GameState getState() {
        return state;
    }
}
