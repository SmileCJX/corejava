package pers.caijx.corejava.chapter6.clone;

/**
 * Created by Administrator on 2017/11/4/004.
 */
public class cloneTest {

    public static void main(String[] args) {
        Employee orignal = new Employee("John Q. Public",5000);
        orignal.setHireDay(2000,1,1);
        try {
            Employee copy = orignal.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002,12,31);
            System.out.println("original = " + orignal);
            System.out.println("copy = " + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
