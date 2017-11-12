package pers.caijx.corejava.chapter13.Sieve;

import java.util.BitSet;

/**
 * 测试编译程序性能的一种流行的基准
 * Eratosthenes筛子
 * Created by Administrator on 2017/11/12/012.
 */
public class Sieve {

    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n+1);
        int count = 0;
        int i;
        for (i = 2; i <= n; i++) {
            b.set(i);
        }
        i = 2;
        while (i * i <= n) {
            if (b.get(i)) {
                count++;
                int k = 2 * i;
                while (k <= n) {
                    b.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n) {
            if (b.get(i)) {
                count++;
            }
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds");
    }
}
