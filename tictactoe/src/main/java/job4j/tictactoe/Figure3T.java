package job4j.tictactoe;

import javafx.scene.shape.Rectangle;

/**
 * Шаблом для создания объектов: Клетка на игровом поле.
 * markX - есть ли на клетке "X".
 * markO - есть ли на клетке "O".
 */
public class Figure3T extends Rectangle {
    private boolean markX = false;
    private boolean markO = false;

    // Constructors
    public Figure3T() {
    }
    public Figure3T(boolean markX, boolean markO) {
        this.markX = markX;
        this.markO = markO;
    }

    /** Setter(двойной) для markX && markO
     * @param markX - Что установить на клетке: "X" = true || "O" = false
     */
    public void take(boolean markX) {
            this.markX = markX;
            this.markO = !markX;
    }

    // Getters
    public boolean hasMarkX() {
        return this.markX;
    }
    public boolean hasMarkO() {
        return this.markO;
    }
}
