package job4j.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Логика Игрового поля.
 * table - Само игровое поле.
 */
public class Logic3T {
    private final Figure3T[][] table;

    // Constructor
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /** Основа проверки: Победная комбинация.
     * Проверяет каждую клетку затронутую входными параметрами.
     * То есть, входные параметры определяют "Какие именно" клетки будут проверяны.
     * @param predicate - получит значения клетки.
     * @param startX - начинать с клетки.
     * @param startY - начинать с ряда.
     * @param deltaX - заканчивать на клетке.
     * @param deltaY - заканчивать на ряде.
     * @return result - true/false.
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /** Проверка: Есть ли на поле победитель "X".
     * Реализует проверку, используя "Основной метод" для проверки: fillBy()
     * @return boolean (true/false)
     */
    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0) ||
                this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0) ||
                this.fillBy(Figure3T::hasMarkX, 0, 2, 1, 0) ||
                this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkX, 2, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkX, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1);
    }

    /** Проверка: Есть ли на поле победитель "O".
     * Реализует проверку, используя "Основной метод" для проверки: fillBy()
     * @return boolean (true/false)
     */
    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 2, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 2, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkO, this.table.length - 1 , 0, -1, 1);
    }

    /** Проверка: Есть ли свободные клетки.
     * @return boolean (true/false)
     */
    public boolean hasGap() {
//        return Arrays.stream(table)
//                .flatMap(figure3TS -> Arrays.stream(figure3TS)
//                        .filter(figure3T -> !figure3T.hasMarkX() && !figure3T.hasMarkO()).collect(Collector.of(
//                                (figure3TS -> )
//                        )))
//                .findFirst().isPresent();

//                ))
//                .findFirst()

//        // Рабочий вариант.
//        boolean isFree = false;
//        for (Figure3T[] arr : table) {
//            for (Figure3T cell : arr) {
//                if (!cell.hasMarkX() && !cell.hasMarkO()) {
//                    isFree = true;
//                    break;
//                }
//            }
//            if (isFree) { break; }
//        }
//        return isFree;

        return Arrays.stream(table)
                .flatMap(Arrays::stream)
                .flatMap(figure3T -> {
                    boolean check = false;
                    if (!figure3T.hasMarkO() && !figure3T.hasMarkX()) {
                    return check;
                } return  check; } );


//                .forEach(figure3T -> {if (!figure3T.hasMarkO() && !figure3T.hasMarkX()) {
//                return true;
//                }
//                } );



//        return
//        List<Figure3T> check = Arrays.stream(table)
//                .flatMap(Arrays::stream)
//                .filter(figure3T -> !figure3T.hasMarkX() && !figure3T.hasMarkO())
//                .collect(

//                         (set, holder) -> set.add(holder.value),
//                         (left, right) -> { left.addAll(right); return left; }
//                ));

//        return (check != null) ? true : false;

//                .flatMap(figure3TStream -> figure3TStream.filter())
//                .filter()
//                .flatMap(figure3T -> figure3T.)
//
//                .map()


//                int[][] arr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
//IntStream stream = Arrays.stream(arr).flatMapToInt(x -> Arrays.stream(x));

//        return true;
    }
}
