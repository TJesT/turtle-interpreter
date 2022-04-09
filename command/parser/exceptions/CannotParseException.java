package command.parser.exceptions;

public class CannotParseException extends Exception {
    public CannotParseException(String err_message) {
        super(err_message);
    }
}
