package turtle_interpreter;

import globals.Coords;
import globals.Field;
import globals.Size;
import turtle.Turtle;

public class Environment {
    private boolean initialized;
    public  Field field;
    public  Turtle turtle;

    public Environment() {
        initialized = false;
    }

    public void init(Size field_size, Coords turtle_coords) {
        turtle_coords.validate(field_size);
        field          = new Field(field_size);
        turtle         = new Turtle(turtle_coords, field_size);
        initialized    = true;
    }

    public boolean isInitialized() {
        return initialized;
    }
}
