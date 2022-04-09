package command.execution;

import command.execution.exceptions.EnvironmentNotInitializedException;
import globals.State;
import turtle_interpreter.Environment;

public class Ward extends Command {
    public Ward(Environment environment) {
        super(environment);
    }
    @Override
    public State execute() throws EnvironmentNotInitializedException {
        if (!environment.isInitialized()) {
            throw new EnvironmentNotInitializedException();
        }

        LOGGER.debug("Settings drawing mode to [false]");

        environment.turtle.setMode(false);

        return State.SUCCESS;
    }
}
