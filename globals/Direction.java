package globals;

import java.util.HashMap;
import java.util.Map;

public class Direction {

    private final Map<String, Coords> directionsMap =
            new HashMap<String, Coords>() {{
                put("u", new Coords(0, 1));
                put("d", new Coords(0, -1));
                put("r", new Coords(1, 0));
                put("l", new Coords(-1, 0));
            }};

    private boolean isValid(String dir) {
        return directionsMap.containsKey(dir);
    }
    public Coords toCoords(String dir) {
        String dir_lower = dir.toLowerCase();
        if (!isValid(dir_lower)) {
            return new Coords(0, 0);
        }

        return directionsMap.get(dir_lower);
    }
}
