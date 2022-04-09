package command.parser.exceptions;

public class WrongNumberOfArgsException extends CannotParseException {
    public WrongNumberOfArgsException() {
        super("Wrong arguments number, please, try again");
    }
}
