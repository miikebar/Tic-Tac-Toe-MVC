package me.pumpking.tictactoe.models;

import com.google.common.collect.Lists;
import me.pumpking.tictactoe.GameTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board;

    @Before
    public void before() {
        board = new Board(GameTest.SIZE);
    }

    @Test
    public void create() {
        assertThat(board.getFields()).hasSize(GameTest.SIZE * GameTest.SIZE);
        assertThat(board.getIndexesSelectedByX()).isEmpty();
        assertThat(board.getIndexesSelectedByO()).isEmpty();
        assertThat(board.getWinningCombinations()).hasSize(GameTest.SIZE * 2 + 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTooSmallBoard() {
        new Board(1);
    }

    @Test
    public void clear() {
        board.clear();
        assertThat(board.getIndexesSelectedByX()).isEmpty();
        assertThat(board.getIndexesSelectedByO()).isEmpty();
        Arrays.stream(board.getFields()).forEach(field -> assertThat(field).isEqualTo(Field.EMPTY));
    }

    @Test
    public void populateWinningCombinationsForSize3() {
        Board board = new Board(3);

        assertThat(board.getWinningCombinations()).containsExactlyInAnyOrder(
                Stream.of(0, 1, 2).collect(Collectors.toSet()),
                Stream.of(3, 4, 5).collect(Collectors.toSet()),
                Stream.of(6, 7, 8).collect(Collectors.toSet()),
                Stream.of(0, 3, 6).collect(Collectors.toSet()),
                Stream.of(1, 4, 7).collect(Collectors.toSet()),
                Stream.of(2, 5, 8).collect(Collectors.toSet()),
                Stream.of(0, 4, 8).collect(Collectors.toSet()),
                Stream.of(2, 4, 6).collect(Collectors.toSet())
        );
    }

    @Test
    public void populateWinningCombinationsForSize5() {
        Board board = new Board(5);

        assertThat(board.getWinningCombinations()).containsExactlyInAnyOrder(
                Stream.of(0, 1, 2, 3, 4).collect(Collectors.toSet()),
                Stream.of(5, 6, 7, 8, 9).collect(Collectors.toSet()),
                Stream.of(10, 11, 12, 13, 14).collect(Collectors.toSet()),
                Stream.of(15, 16, 17, 18, 19).collect(Collectors.toSet()),
                Stream.of(20, 21, 22, 23, 24).collect(Collectors.toSet()),
                Stream.of(0, 5, 10, 15, 20).collect(Collectors.toSet()),
                Stream.of(1, 6, 11, 16, 21).collect(Collectors.toSet()),
                Stream.of(2, 7, 12, 17, 22).collect(Collectors.toSet()),
                Stream.of(3, 8, 13, 18, 23).collect(Collectors.toSet()),
                Stream.of(4, 9, 14, 19, 24).collect(Collectors.toSet()),
                Stream.of(0, 6, 12, 18, 24).collect(Collectors.toSet()),
                Stream.of(4, 8, 12, 16, 20).collect(Collectors.toSet())
        );
    }

    @Ignore @Test
    public void populateWinningCombinations() {
        assertThat(board.getWinningCombinations()).hasSize(GameTest.SIZE * 2 + 2);
        Set<Integer> row = IntStream.range(0, GameTest.SIZE).boxed().collect(Collectors.toSet());
        Set<Integer> column = IntStream.iterate(0, i -> i + GameTest.SIZE).limit(GameTest.SIZE).boxed().collect(Collectors.toSet());
        Set<Integer> diagonal = IntStream.iterate(0, i -> i + GameTest.SIZE + 1).limit(GameTest.SIZE).boxed().collect(Collectors.toSet());
        assertThat(board.getWinningCombinations()).contains(row, column, diagonal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFieldWithInvalidCoordinates() {
        board.getField(-1, -1);
    }

    @Test
    public void getField() {
        board.getFields()[1] = Field.X;
        assertThat(board.getField(1, 0)).isEqualTo(Field.X);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFieldSelectedByWithInvalidCoordinates() {
        board.setFieldSelectedBy(-1, -1, Field.X);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFieldSelectedByNull() {
        board.setFieldSelectedBy(0, 0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFieldSelectedByEmpty() {
        board.setFieldSelectedBy(0, 0, Field.EMPTY);
    }

    @Test
    public void setFieldSelectedBy() {
        int selectedIndex = 1;
        board.setFieldSelectedBy(1, 0, Field.X);
        assertThat(board.getFields()[selectedIndex]).isEqualTo(Field.X);
        assertThat(board.getIndexesSelectedByX()).contains(selectedIndex);
    }

}
