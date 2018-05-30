package me.pumpking.tictactoe.models;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {

    private int size;
    private Field[] fields;
    private Set<Integer> allIndexes;
    private Set<Integer> indexesSelectedByX;
    private Set<Integer> indexesSelectedByO;
    private List<Set<Integer>> winningCombinations;

    public Board(int size) {
        Preconditions.checkArgument(size > 1, "Board size cannot be smaller than 2");

        this.size = size;
        this.fields = new Field[size * size];
        this.indexesSelectedByX = new HashSet<>();
        this.indexesSelectedByO = new HashSet<>();
        this.winningCombinations = new ArrayList<>();
        this.allIndexes = IntStream.range(0, fields.length).boxed().collect(Collectors.toSet());

        clear();
        populateWinningPositions();
    }

    public void clear() {
        indexesSelectedByX.clear();
        indexesSelectedByO.clear();

        for (int i = 0; i < size * size; i++) {
            fields[i] = Field.EMPTY;
        }
    }

    @VisibleForTesting void populateWinningPositions() {
        winningCombinations.add(IntStream.iterate(0, i -> i + size + 1).limit(size).boxed().collect(Collectors.toSet()));
        winningCombinations.add(IntStream.iterate(size - 1, i -> i + size - 1).limit(size).boxed().collect(Collectors.toSet()));

        for (int y = 0; y < size; y++) {
            int firstIndexInRow = y * size;
            winningCombinations.add(IntStream.range(firstIndexInRow, firstIndexInRow + size).boxed().collect(Collectors.toSet()));
            winningCombinations.add(IntStream.iterate(y, i -> i + size).limit(size).boxed().collect(Collectors.toSet()));
        }
    }

    @VisibleForTesting Field[] getFields() {
        return fields;
    }

    public Field getField(int index) {
        Preconditions.checkArgument(index >= 0 && index < size, "Invalid field index");
        return fields[index];
    }

    public void setFieldSelectedBy(int index, Field type) {
        Preconditions.checkArgument(index >= 0 && index < size, "Invalid field index");
        Preconditions.checkArgument(type == Field.X || type == Field.O, "Cannot mark field as selected for type EMPTY");

        fields[index] = type;
        (type == Field.X ? indexesSelectedByX : indexesSelectedByO).add(index);
    }

    public int getSize() {
        return size;
    }

    public Set<Integer> getIndexesSelectedByX() {
        return Collections.unmodifiableSet(indexesSelectedByX);
    }

    public Set<Integer> getIndexesSelectedByO() {
        return Collections.unmodifiableSet(indexesSelectedByO);
    }

    public List<Set<Integer>> getWinningCombinations() {
        return winningCombinations;
    }

    public Set<Integer> getAllIndexes() {
        return allIndexes;
    }

}
