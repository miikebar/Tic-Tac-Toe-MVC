package me.pumpking.tictactoe.controllers;

import com.google.common.base.Preconditions;
import me.pumpking.tictactoe.Game;
import me.pumpking.tictactoe.models.GameState;

public class GameController extends Controller {

    private GameState state;

    private static final GameState INITIAL_STATE = GameState.X_TURN;

    public GameController(Game game) {
        super(game);
    }

    public void reset() {
        game.getViewController().clear();
        game.getBoardController().clear();
    }

    public void setAndShowGameState(GameState state) {
        Preconditions.checkArgument(state != null, "Cannot set the game state to null");
        this.state = state;
        // TODO: show state in view
    }


}
