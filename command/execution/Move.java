package command.execution;

import command.execution.exceptions.CannotExecuteException;
import command.execution.exceptions.EnvironmentNotInitializedException;
import command.execution.exceptions.InvalidDirectionException;
import globals.Coords;
import globals.Direction;
import globals.State;
import turtle_interpreter.Environment;

public class Move extends Command {
    public Move(Environment environment) {
        super(environment);
    }

    @Override
    public State execute() throws CannotExecuteException {
        if (!environment.isInitialized()) {
            throw new EnvironmentNotInitializedException();
        }

        int step = Integer.parseInt(args[2]);
        Direction direction = new Direction();
        Coords diff_coords = direction.toCoords(args[1]).mul(step);

        if (diff_coords.x == 0 && diff_coords.y == 0) {
            throw new InvalidDirectionException();
        }

        LOGGER.debug(String.format(
                "Moving robot to [%d, %d] with step [%d], drawing - [%b]",
                diff_coords.x, diff_coords.y, step, environment.turtle.isDrawing()
        ));

        Coords robot_coords = environment.turtle.getCoords();
        environment.turtle.setCoords(robot_coords.add(diff_coords));

        if (environment.turtle.isDrawing()) {
            int min_i, max_i;
            min_i = Math.min(0, diff_coords.x);
            max_i = Math.max(0, diff_coords.x);
            for (int i = min_i; i <= max_i; ++i) {
                environment.field.setCell(robot_coords.add(new Coords(i, 0)), true);
            }
            min_i = Math.min(0, diff_coords.y);
            max_i = Math.max(0, diff_coords.y);
            for (int i = min_i; i <= max_i; ++i) {
                environment.field.setCell(robot_coords.add(new Coords(0, i)), true);
            }
        }

        return State.SUCCESS;
    }
}