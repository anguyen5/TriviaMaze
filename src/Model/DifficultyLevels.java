package Model;

import java.util.HashMap;
import java.util.Map;

public enum DifficultyLevels {
    Test (0), Easy (1), Medium(2), Hard (3);

    private final int value;
    private static final Map<Integer, DifficultyLevels> myMap = new HashMap<Integer, DifficultyLevels>();

    DifficultyLevels (final int myValue)
    {
        value = myValue;
    }

    public int getValue() {
        return value;
    }

    static {
        for (DifficultyLevels difficultyLevels: DifficultyLevels.values())
        {
            myMap.put(difficultyLevels.value, difficultyLevels);
        }
    }

    public static DifficultyLevels valueOf (final int Index)
    {
        return myMap.get(Index);
    }
}
