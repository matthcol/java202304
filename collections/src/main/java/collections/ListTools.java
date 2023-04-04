package collections;

import java.util.List;

public class ListTools {

    public static int sum(List<Integer> list) {
        int res = 0;
        for (int value: list) {
            res += value;
        }
        return res;
    }
}
