package globals;

import java.util.Arrays;

public class Field {
    private static final char EMPTY_CELL_CHAR  = '.';
    private static final char FILLED_CELL_CHAR = '█';

    private final Size     size;
    private final char[][] data;

    /**
     * Create  Field instance
     *
     * @param  size Field size
     * @throws IllegalArgumentException Is field size is invalid
     * */
    public Field(Size size) throws IllegalArgumentException {
        size.isValid();
        this.size = size;
        this.data = new char[size.w][size.h];
        for (char[] row : data) {
            Arrays.fill(row, EMPTY_CELL_CHAR);
        }
    }
    /**
     * Set field's cell with validated coords specified value
     *
     * @param  coords   Cell coordinates
     * @param  isFilled Cell type - filled / empty
     * @throws IndexOutOfBoundsException If field size is invalid
     * */
    public void setCell(Coords coords, boolean isFilled) throws IndexOutOfBoundsException {
        coords.validate(size);
        data[coords.x][coords.y] = isFilled
                ? FILLED_CELL_CHAR
                : EMPTY_CELL_CHAR;
    }
    /** Return Field size */
    public Size getSize() {
        return size;
    }
    /** Return Field data */
    public char[][] getData() {
        return data;
    }
}
