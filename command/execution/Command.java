package command.execution;

import command.execution.exceptions.CannotExecuteException;
import globals.State;
import org.apache.log4j.Logger;
import turtle_interpreter.Environment;

abstract public class Command {
    protected static final Logger      LOGGER = Logger.getLogger(Command.class);

    protected              String[]    args;
    protected              Environment environment;

    public Command(Environment environment) {
        this.environment = environment;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    abstract public State execute() throws CannotExecuteException;
}
