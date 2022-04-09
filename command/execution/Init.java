package command.execution;

import globals.*;
import turtle_interpreter.Environment;

public class Init extends Command{
    public Init(Environment environment) {
        super(environment);
    }

    @Override
    public State execute() {
        Size field_size = new Size(
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2])
        );
        Coords turtle_coords = new Coords(
                Integer.parseInt(args[3]),
                Integer.parseInt(args[4])
        );
        LOGGER.debug(String.format(
                "Initializing game with [Field size %dx%d] [Turtle coords (%d, %d)]",
                field_size.w, field_size.h, turtle_coords.x, turtle_coords.y
        ));

        environment.init(field_size, turtle_coords);

        return State.SUCCESS;
    }
}
