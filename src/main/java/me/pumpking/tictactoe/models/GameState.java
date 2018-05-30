package me.pumpking.tictactoe.models;

public enum GameState {
    X_TURN("Player X's turn"),
    O_TURN("Player O's turn"),
    X_WINS("Player X wins the game!"),
    O_WINS("Player O wins the game!"),
    DRAW("It's a draw!");

    private String value;

    GameState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
