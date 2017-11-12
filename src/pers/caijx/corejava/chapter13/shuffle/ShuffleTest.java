package pers.caijx.corejava.chapter13.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/11/12/012.
 */
public class ShuffleTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        List<Integer> newList = list.subList(0,6);
        Collections.sort(newList);
        for (int i = 0; i < newList.size(); i++){
            System.out.println(newList.get(i));
        }
    }
}
