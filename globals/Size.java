package globals;

public class Size {
    public int w, h;

    public Size(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public void isValid() throws IllegalArgumentException {
        if (w <= 0 || h <= 0) {
            throw new IllegalArgumentException("Invalid field size");
        }
    }
}
