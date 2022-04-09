package command.parser;

import command.CommandFactory;
import command.parser.exceptions.*;
import command.execution.Command;
import org.apache.log4j.Logger;
import turtle_interpreter.Environment;

import java.util.Scanner;

public class CommandParser {
    private static final Logger LOGGER = Logger.getLogger(CommandParser.class);
    private static final String CMD_SPLIT_REGEX = "\\s+";

    private final CommandFactory commandFactory;

    /**
     * Create CommandParser instance
     *
     * @param environment Environment instance - for modifying turtle &
     *                    field in commands
     * */
    public CommandParser(Environment environment) {
        commandFactory = CommandFactory.getInstance(environment);
    }

    /**
     * Parse arguments string to command with instance from CommandsFactory
     *
     * @throws CannotParseException
     * @return Command
     * */
    public Command readCommand() throws CannotParseException {
        Scanner scanner = new Scanner(System.in);
        String[] args = scanner.nextLine().strip().split(CMD_SPLIT_REGEX);

        LOGGER.debug("Parsing command string");

        if (args[0].length() == 0) {
            throw new EmptyCommandStringException();
        }

        Integer argc = commandFactory.getArgc(args[0]);
        if (argc != args.length - 1) {
            throw new WrongNumberOfArgsException();
        }

        return commandFactory.getCommandInstance(args);
    }
}
