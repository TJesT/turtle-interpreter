package view;

import globals.Coords;
import globals.Size;
import turtle_interpreter.Environment;

public class View {

    private final Environment environment;

    /** Clear view instance */
    public View(Environment environment) {
        this.environment = environment;
    }
    /** Clear terminal via escape sequence */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
    /** Show command game status -message */
    public void showMessage(String msg) {
        System.out.print(msg + (this.environment.isInitialized() ? "\n" : "\n$ "));
    }
    /** Draw field with Field data & Robot coords */
    public void drawField() {
        Size     fieldSize          = environment.field.getSize();
        char[][] fieldData          = environment.field.getData();
        Coords   turtleCoordsCoords = environment.turtle.getCoords();

        for (int i = 0; i < fieldSize.h; ++i) {
            for (int j = 0; j < fieldSize.w; ++j) {
                if (turtleCoordsCoords.x == j && turtleCoordsCoords.y == i) {
                    System.out.print("\uD83D\uDC22");
                } else {
                    System.out.print(fieldData[j][i]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.print("$ ");
    }
}
