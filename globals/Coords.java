package globals;

public class Coords {
    public int x, y;
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Coords other = (Coords) obj;

        return this.x == other.x && this.y == other.y;
    }

    public Coords add(Coords other) {
        return new Coords(
                this.x + other.x,
                this.y + other.y
        );
    }

    public Coords mul(int n) {
        return new Coords(
                this.x * n,
                this.y * n
        );
    }

    public void validate(Size size) throws IndexOutOfBoundsException {
        size.isValid();
        this.x = this.x < 0
                ? size.w + this.x % size.w
                : this.x % size.w;
        this.y = this.y < 0
                ? size.h + this.y % size.h
                : this.y % size.h;
    }
}
