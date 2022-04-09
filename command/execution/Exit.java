package command.execution;

import globals.State;
import turtle_interpreter.Environment;

public class Exit extends Command {
    public Exit(Environment environment) {
        super(environment);
    }

    @Override
    public State execute() {
        LOGGER.debug("Exiting...");

        return State.EXIT;
    }
}
