package turtle;

import globals.Coords;
import globals.Size;

public class Turtle {
    private       boolean drawing;
    private final Size    field_size;
    private       Coords  coords;

    public Turtle(Coords turtle_coords, Size field_size) {
        this.coords     = turtle_coords;
        this.drawing    = false;
        this.field_size = field_size;
    }

    public void setCoords(Coords coords) throws IndexOutOfBoundsException {
        coords.validate(this.field_size);
        this.coords = coords;
    }
    public void    setMode(boolean drawing) {
        this.drawing = drawing;
    }
    public Coords  getCoords() {
        return coords;
    }
    public boolean isDrawing() {
        return drawing;
    }
}
