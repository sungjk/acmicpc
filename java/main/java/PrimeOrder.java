import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * Created by jeremy on 2019-06-06.
 */
public class PrimeOrder {
    public static List<String> prioritizedOrders(int numOrders, List<String> orderList) {
        LinkedHashMap<String, String> idKeyOrderMap = new LinkedHashMap<>();

        // initialize linked hash map
        orderList.forEach(order -> {
            String[] idAndMetadata = splitIdAndMetadata(order);
            if (idAndMetadata.length == 2) {
                String id = idAndMetadata[0];
                String metadata = idAndMetadata[1];
                idKeyOrderMap.put(id, metadata);
            }
        });

        return idKeyOrderMap.entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    String metadata1 = o1.getValue();
                    String metadata2 = o2.getValue();
                    boolean isNonPrimeO1 = isNonPrimeOrder(metadata1);
                    boolean isNonPrimeO2 = isNonPrimeOrder(metadata2);

                    if (isNonPrimeO1 && isNonPrimeO2) return 1;
                    if (isNonPrimeO1) return 1;
                    if (isNonPrimeO2) return -1;
                    if (metadata1.equals(metadata2)) return o1.getKey().compareTo(o2.getKey());
                    return metadata1.compareTo(metadata2);
                })
                .map(order -> order.getKey() + " " + order.getValue())
                .collect(Collectors.toList());
    }

    public static String[] splitIdAndMetadata(String order) {
        if (order.isEmpty() || order.indexOf(' ') < 0) {
            return new String[] {};
        }
        String id = order.substring(0, order.indexOf(' '));
        String metadata = order.substring(order.indexOf(' ') + 1);
        return new String[] { id, metadata };
    }

    public static boolean isNonPrimeOrder(String metadata) {
        return metadata.matches(".*\\d.*");
    }

    public static class UnitTest {
        @Test
        public void test() {
            int numOrders = 6;
            List<String> orderList = Arrays.asList(
                    "zld 93 12",
                    "fp kindle book",
                    "10a echo show",
                    "17g 12 25 6",
                    "ab1 kindle book",
                    "125 echo dot second generation");
            List<String> expected = Arrays.asList(
                    "125 echo dot second generation",
                    "10a echo show",
                    "ab1 kindle book",
                    "fp kindle book",
                    "zld 93 12",
                    "17g 12 25 6");

            Assert.assertEquals(expected, prioritizedOrders(numOrders, orderList));
        }

        @Test
        public void test2() {
            int numOrders = 5;
            List<String> orderList = Arrays.asList(
                    "zld 93 12",
                    "fg 12 34",
                    "10a 56 789",
                    "17g 12 25 6",
                    "fp kindle book");
            List<String> expected = Arrays.asList(
                    "fp kindle book",
                    "zld 93 12",
                    "fg 12 34",
                    "10a 56 789",
                    "17g 12 25 6");

            Assert.assertEquals(expected, prioritizedOrders(numOrders, orderList));
        }

        @Test
        public void test3() {
            int numOrders = 4;
            List<String> orderList = Arrays.asList(
                    "mi2 jog mid pet",
                    "wz3 34 54 398",
                    "al alps cow bar",
                    "x4 45 21 7");
            List<String> expected = Arrays.asList(
                    "al alps cow bar",
                    "mi2 jog mid pet",
                    "wz3 34 54 398",
                    "x4 45 21 7");

            Assert.assertEquals(expected, prioritizedOrders(numOrders, orderList));
        }

        @Test
        public void test4() {
            int numOrders = 6;
            List<String> orderList = Arrays.asList(
                    "t2 13 121 98",
                    "r1 box ape bit",
                    "b4 xi me nu",
                    "br8 eat nim did",
                    "wl has uni gry",
                    "f3 52 54 31");
            List<String> expected = Arrays.asList(
                    "r1 box ape bit",
                    "br8 eat nim did",
                    "wl has uni gry",
                    "b4 xi me nu",
                    "t2 13 121 98",
                    "f3 52 54 31");

            Assert.assertEquals(expected, prioritizedOrders(numOrders, orderList));
        }
    }
}
