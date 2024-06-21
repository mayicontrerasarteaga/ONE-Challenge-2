import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "USD/ARS");
        map.put(2, "ARS/USD");
        map.put(3, "USD/BRL");
        map.put(4, "BRL/USD");
        map.put(5, "USD/COP");
        map.put(6, "COP/USD");

        System.out.println(map.get(1));
    }

}
