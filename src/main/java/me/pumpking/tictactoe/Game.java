package me.pumpking.tictactoe;

import javafx.application.Application;
import javafx.stage.Stage;
import me.pumpking.tictactoe.controllers.BoardController;
import me.pumpking.tictactoe.controllers.GameViewController;
import me.pumpking.tictactoe.models.Board;
import me.pumpking.tictactoe.views.GameView;

public class Game extends Application {

    private BoardController boardController;
    private GameViewController viewController;

    private static final int SIZE = 3;

    @Override
    public void init() {
        boardController = new BoardController(this, new Board(SIZE));
        viewController = new GameViewController(this, new GameView(SIZE));
    }

    @Override
    public void start(Stage primaryStage) {
        viewController.showGUI(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
