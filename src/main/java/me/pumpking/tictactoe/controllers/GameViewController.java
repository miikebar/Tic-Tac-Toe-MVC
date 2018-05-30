package me.pumpking.tictactoe.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import me.pumpking.tictactoe.Game;
import me.pumpking.tictactoe.views.GameView;

public class GameViewController extends Controller implements EventHandler<ActionEvent> {

    private GameView view;

    public GameViewController(Game game, GameView view) {
        super(game);
        this.view = view;
        this.view.setEventListener(this);
    }

    public void showGUI(Stage stage) {
        view.showGUI(stage);
    }

    public void clear() {
        view.clear();
    }

    @Override
    public void handle(ActionEvent event) {
        if (!(event.getSource() instanceof Button)) return;
        Button button = (Button) event.getSource();

        if (button.getId() != null && button.getId().equalsIgnoreCase("reset")) {
            // TODO: reset the game
        } else {
            int index = (int) button.getProperties().get("index");
            // TODO: set field
        }

        event.consume();
    }

}
