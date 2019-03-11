import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jeremy on 03/11/2019.
 */
public class A1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        Map<Character, Integer> hash = new HashMap<>();
        for (char c : word.toUpperCase().toCharArray()) {
            if (hash.containsKey(c)) {
                hash.replace(c, hash.get(c) + 1);
            } else {
                hash.put(c, 1);
            }
        }

        List<Map.Entry<Character, Integer>> result = hash.entrySet().stream()
            .sorted(((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())))
            .limit(2)
            .collect(Collectors.toList());

        if (result.size() == 2 && result.get(0).getValue().equals(result.get(1).getValue())) {
            System.out.println("?");
        } else {
            System.out.println(result.get(0).getKey());
        }
    }
}
