package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    // Bishop Black
    @Test // move to free cell
    public void moveSimple() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        assertThat(logic.move(Cell.C8, Cell.A6), is(true));
    }

    @Test // move through figure(Pawn)
    public void move() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new PawnBlack(Cell.B7));
        assertThat(logic.move(Cell.C8, Cell.A6), is(false));
    }
}
