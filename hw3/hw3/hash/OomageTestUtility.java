package hw3.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Oomage o : oomages) {
            int hash = (o.hashCode() & 0x7FFFFFFF) % M;

            map.put(hash, map.getOrDefault(hash, 0) + 1);

        }
        int N = oomages.size();
        for (int i = 0; i < M; i++) {
            if (map.getOrDefault(i, 0) > N / 2.5 || map.getOrDefault(i, 0) < N / 50) {
                return false;
            }
        }
        return true;
    }
}
