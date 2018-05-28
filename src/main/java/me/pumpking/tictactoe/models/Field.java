package me.pumpking.tictactoe.models;

public enum Field {
    X("X"),
    O("O"),
    EMPTY(" ");

    private String value;

    Field(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
