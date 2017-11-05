package pers.caijx.corejava.chapter6.compare;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/4/004.
 */
public class EmployeeSortSort {

    public static void main(String[] args) {

        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker",85000);
        staff[1] = new Employee("Carl Cracker",75000);
        staff[2] = new Employee("Tony Tester",38000);

        //使用了mergersort算法
        Arrays.sort(staff);

        for (Employee e : staff) {
            System.out.println("name = " + e.getName() + ",salary = " + e.getSalary());
        }
    }
}
