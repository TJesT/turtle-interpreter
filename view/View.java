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
        Size     field_size          = environment.field.getSize();
        char[][] field_data          = environment.field.getData();
        Coords   turtle_coords = environment.turtle.getCoords();

        for (int i = 0; i < field_size.h; ++i) {
            for (int j = 0; j < field_size.w; ++j) {
                if (turtle_coords.x == j && turtle_coords.y == i) {
                    System.out.print("\uD83D\uDC22");
                } else {
                    System.out.print(field_data[j][i]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.print("$ ");
    }
}
