package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }


    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }

        int size = 10, count = 0;
        Cell[] steps = new Cell[size];
        int deltaX = source.x;
        int deltaY = source.y;

        for (int index = 0; index < size; index++) {
            if (source.x < dest.x) {
                deltaX++;
            } else deltaX--;
            if (source.y < dest.y) {
                deltaY++;
            } else deltaY--;

            for (Cell cell : Cell.values()) {
                if (deltaX == cell.x && deltaY == cell.y) {
                    steps[index] = cell;
                    count++;
                    break;
                }
            }
        }
        return Arrays.copyOf(steps, count);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        //TODO check diagonal
        int deltaX = source.x;
        int deltaY = source.y;
        boolean result = false;

        for (int index = 0; index <= 10; index++) {
            if (source.x < dest.x) {
                deltaX++;
            } else deltaX--;
            if (source.y < dest.y) {
                deltaY++;
            } else deltaY--;

            if (deltaX == dest.x && deltaY == dest.y) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
