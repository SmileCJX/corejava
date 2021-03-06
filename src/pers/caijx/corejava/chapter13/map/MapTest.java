package pers.caijx.corejava.chapter13.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/11/011.
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String,Employee> staff = new HashMap<>();
        staff.put("144-25-5464",new Employee("Amy Lee"));
        staff.put("567-24-2546",new Employee("Harry Hacker"));
        staff.put("157-62-7935",new Employee("Gary Cooper"));
        staff.put("456-62-5527",new Employee("Francesca Cruz"));
        LinkedList<String> linkedList = new LinkedList<>();
        System.out.println(staff);
        staff.remove("567-24-2546");
        staff.put("456-62-5527",new Employee("Caijx"));
        System.out.println(staff.get("157-62-7935"));
        for (Map.Entry<String,Employee> entry : staff.entrySet()) {
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println("key = " + key + ", value = " + value);
        }
    }
}
