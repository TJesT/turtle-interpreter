package turtle_interpreter;

import command.execution.Command;
import command.parser.CommandParser;
import command.execution.exceptions.CannotExecuteException;
import command.parser.exceptions.CannotParseException;
import globals.State;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import view.View;

public class TurtleInterpreter {
    private static final Logger LOGGER = LogManager.getLogger(TurtleInterpreter.class);

    private final Environment   environment;
    private final View          view;
    private final CommandParser parser;
    private       String        message;
    private       State         state;

    /** Create Interpreter instance */
    public TurtleInterpreter() {
        this.environment = new Environment();
        this.view        = new View(environment);
        this.parser      = new CommandParser(environment);
        this.state       = State.START;
        this.message     = "";
    }

    /** Start Interpreter main cycle */
    public void start() {
        LOGGER.debug("Interpreter Started");

        View.clearScreen();
        while(this.state != State.EXIT) {
            view.showMessage(this.message);
            this.message = "";

            if (environment.isInitialized()) view.drawField();

            Command cmd = null;

            LOGGER.debug("Reading Command");
            try {
                cmd = this.parser.readCommand();
                View.clearScreen();
            } catch (CannotParseException e) {
                this.message = e.getMessage();
            }

            if (cmd == null) continue;

            LOGGER.debug("Executing Command");
            try {
                this.state = cmd.execute();
            } catch (CannotExecuteException e) {
                this.message = e.getMessage();
            }
        }

        LOGGER.debug("Interpreter Stopped");
    }
}
