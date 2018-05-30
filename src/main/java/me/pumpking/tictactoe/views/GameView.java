package me.pumpking.tictactoe.views;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import me.pumpking.tictactoe.models.GameState;

public class GameView {

    private int size;
    private Label status;
    private GridPane fields;
    private EventHandler<ActionEvent> listener;

    private static final String BUTTON_NORMAL_STYLE = "-fx-font: 24 monospaced; -fx-font-weight: bold; -fx-focus-color: transparent; -fx-faint-focus-color: transparent;";
    private static final String BUTTON_DISABLED_STYLE = BUTTON_NORMAL_STYLE + "-fx-opacity: 1.0;";

    public GameView(int size) {
        this.size = size;
    }

    public void setEventListener(EventHandler<ActionEvent> listener) {
        this.listener = listener;
    }

    public void showGUI(Stage stage) {
        stage.setTitle("Tic Tac Toe");
        stage.setResizable(false);

        BorderPane controls = new BorderPane();
        controls.setStyle("-fx-padding: 10;");

        status = new Label("TODO: SET THIS");
        status.setStyle("-fx-font: 16 arial;");

        Button reset = new Button("Reset");
        reset.setOnAction(listener);
        reset.setId("reset");
        reset.setOnAction(this.listener);

        controls.setLeft(status);
        controls.setRight(reset);

        fields = new GridPane();

        for (int i = 0; i < size; i++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setHgrow(Priority.ALWAYS);
            cc.setFillWidth(true);
            fields.getColumnConstraints().add(cc);
        }

        for (int i = 0; i < size; i++) {
            RowConstraints rc = new RowConstraints();
            rc.setVgrow(Priority.ALWAYS);
            rc.setFillHeight(true);
            fields.getRowConstraints().add(rc);
        }

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Button field = new Button(" ");
                field.setOnAction(listener);
                field.setStyle(BUTTON_NORMAL_STYLE);
                field.getProperties().put("index", y * size + x);
                field.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                fields.add(field, x, y);
            }
        }

        BorderPane root = new BorderPane();
        root.setTop(controls);
        root.setCenter(fields);

        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }

    public void clear() {
        ObservableList<Node> buttons = fields.getChildren();

        for (int i = 0; i < buttons.size(); i++) {
            Button button = (Button) buttons.get(i);
            button.setText(" ");
            button.setDisable(false);
            button.setStyle(BUTTON_NORMAL_STYLE);
        }
    }

    public void showState(GameState state) {
        status.setText(state.getValue());
    }

}
