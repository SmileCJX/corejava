package pers.caijx.corejava.chapter11.stacktrace;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/11/5/005.
 */
public class StackTraceTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter: n");
        int n = in.nextInt();
        factorial(n);
    }

    /**
     * 计算阶层
     * @param
     * @return n! = 1 * 2 * ... * n
     */
    private static int factorial(int n) {
        System.out.println("factorial(" + n + "):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f : frames) {
            System.out.println(f);
        }
        int r;
        if (n <= 1) {
            r = 1;
        } else {
            r = n * factorial(n-1);
        }
        System.out.println("return " + r);
        return r;
    }
}
