package me.pumpking.tictactoe.controllers;

import com.google.common.base.Preconditions;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import me.pumpking.tictactoe.Game;
import me.pumpking.tictactoe.models.Field;
import me.pumpking.tictactoe.models.GameState;
import me.pumpking.tictactoe.views.GameView;

public class GameViewController extends Controller implements EventHandler<ActionEvent> {

    private GameView view;

    public GameViewController(Game game, GameView view) {
        super(game);
        this.view = view;
        this.view.setEventListener(this);
    }

    public void showGUI(Stage stage) {
        Preconditions.checkArgument(stage != null, "Cannot build GUI with null Stage");
        view.showGUI(stage);
    }

    public void clear() {
        view.clear();
    }

    public void showState(GameState state) {
        Preconditions.checkArgument(state != null, "Cannot display null game state");
        view.showState(state);
    }

    public void setFieldSelectedBy(int index, Field field) {
        view.setFieldSelectedBy(index, field);
    }

    @Override
    public void handle(ActionEvent event) {
        if (!(event.getSource() instanceof Button)) return;
        Button button = (Button) event.getSource();

        if (button.getId() != null && button.getId().equalsIgnoreCase("reset")) {
            game.getGameController().reset();

        } else {
            int index = (int) button.getProperties().get("index");
            game.getGameController().handleFieldSelection(index);
        }

        event.consume();
    }

}
