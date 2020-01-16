package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

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

    /** Проверка: Есть ли на поле победная комбинация.
     * Реализует проверку, используя "Основной метод" для проверки: fillBy().
     * @param condition - входной Тип клеток для проверки.
     * @return true/false.
     */
    public boolean isWin(Predicate<Figure3T> condition) {
        return this.fillBy(condition, 0, 0, 1, 0) ||
                this.fillBy(condition, 0, 1, 1, 0) ||
                this.fillBy(condition, 0, 2, 1, 0) ||
                this.fillBy(condition, 0, 0, 0, 1) ||
                this.fillBy(condition, 1, 0, 0, 1) ||
                this.fillBy(condition, 2, 0, 0, 1) ||
                this.fillBy(condition, 0,0, 1, 1) ||
                this.fillBy(condition, this.table.length - 1 , 0, -1, 1);
    }

    /** Проверка: Есть ли на поле победитель "X".
     * Реализует проверку, используя isWin(Predicate<Figure3T> condition)
     * @return true/false
     */
    public boolean isWinnerX() {
        return this.isWin(Figure3T::hasMarkX);
    }

    /** Проверка: Есть ли на поле победитель "O".
     * Реализует проверку, используя isWin(Predicate<Figure3T> condition)
     * @return true/false
     */
    public boolean isWinnerO() {
        return this.isWin(Figure3T::hasMarkO);
    }

    /** Проверка: Есть ли свободные клетки на поле.
     * @return true/false
     */
    public boolean hasGap() {
        return Arrays.stream(table)
                .flatMap(Arrays::stream)
                .anyMatch(figure3T -> !figure3T.hasMarkX() && !figure3T.hasMarkO());
    }
}