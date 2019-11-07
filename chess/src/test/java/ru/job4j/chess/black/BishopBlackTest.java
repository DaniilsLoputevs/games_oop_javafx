package ru.job4j.chess.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void position() {
        assertThat( new BishopBlack(Cell.F8).position(), is(Cell.F8));
    }

    @Test
    public void way() {
        assertThat(new BishopBlack(Cell.C1).way(Cell.C1, Cell.G5),
                is(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5, Cell.H6}));
    }

    @Test
    public void isDiagonal() {
        assertThat(new BishopBlack(Cell.F8).isDiagonal(Cell.F8, Cell.E7), is(true));
    }

    @Test
    public void copy() {
        assertThat(new BishopBlack(Cell.E7).copy(Cell.F8).position(), is(Cell.F8));
    }




}
