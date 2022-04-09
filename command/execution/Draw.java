package command.execution;

import command.execution.exceptions.EnvironmentNotInitializedException;
import globals.State;
import turtle_interpreter.Environment;

public class Draw extends Command {
    public Draw(Environment environment) {
        super(environment);
    }
    @Override
    public State execute() throws EnvironmentNotInitializedException {
        if (!environment.isInitialized()) {
            throw new EnvironmentNotInitializedException();
        }

        LOGGER.debug("Settings drawing mode to [true]");

        environment.turtle.setMode(true);

        return State.SUCCESS;
    }
}