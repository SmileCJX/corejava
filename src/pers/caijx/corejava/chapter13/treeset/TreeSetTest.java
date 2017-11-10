package pers.caijx.corejava.chapter13.treeset;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/11/11/011.
 */
public class TreeSetTest {

    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",4546));
        parts.add(new Item("Modem",4445));
        parts.add(new Item("KFC",425));
        System.out.println(parts);

        SortedSet<Item> sortByDescription = new TreeSet<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                String descrA = o1.getDescription();
                String descrB = o2.getDescription();
                return descrA.compareTo(descrB);
            }
        });

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
