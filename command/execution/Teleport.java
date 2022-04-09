package command.execution;

import command.execution.exceptions.CannotExecuteException;
import command.execution.exceptions.EnvironmentNotInitializedException;
import globals.Coords;
import globals.State;
import turtle_interpreter.Environment;

public class Teleport extends Command {
    public Teleport(Environment environment) {
        super(environment);
    }
    @Override
    public State execute() throws CannotExecuteException {
        if (!environment.isInitialized()) {
            throw new EnvironmentNotInitializedException();
        }

        Coords newCoords = new Coords(
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2])
        );

        LOGGER.debug(String.format(
                "Teleporting robot to [%d, %d]",
                newCoords.x, newCoords.y
        ));

        environment.turtle.setCoords(newCoords);

        return State.SUCCESS;
    }
}
