package command.parser.exceptions;

public class WrongCommandNameException extends CannotParseException {
    public WrongCommandNameException() {
        super("Wrong command name, please, try again");
    }
}
