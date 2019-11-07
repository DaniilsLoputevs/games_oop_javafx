package ru.job4j.chess;

import javafx.scene.Group;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void move() {
        Logic logic = new Logic();


        boolean compare = new Logic().move(Cell.C1, Cell.A3);
        assertThat(compare, is(true));
    }
}
