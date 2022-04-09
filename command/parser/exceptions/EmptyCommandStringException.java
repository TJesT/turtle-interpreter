package command.parser.exceptions;

public class EmptyCommandStringException extends CannotParseException {
    public EmptyCommandStringException() {
        super("Command string is empty, please, try again");
    }
}
