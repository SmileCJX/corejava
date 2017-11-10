package pers.caijx.corejava.chapter13.priorityqueue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * 优先级队列
 * 按照任意的顺序插入，却可以按照排序的顺序进行检索
 * 使用堆来作为数据结构
 * Created by Administrator on 2017/11/11/011.
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
        pq.add(new GregorianCalendar(1906,Calendar.DECEMBER,9));
        pq.add(new GregorianCalendar(1815,Calendar.DECEMBER,10));
        pq.add(new GregorianCalendar(1903,Calendar.DECEMBER,3));
        pq.add(new GregorianCalendar(1910,Calendar.JUNE,22));

        System.out.println("Iterating over elements...");
        for (GregorianCalendar date : pq) {
            System.out.println(date.get(Calendar.YEAR));
        }
        System.out.println("Removing elements....");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove().get(Calendar.YEAR));
        }
    }
}
