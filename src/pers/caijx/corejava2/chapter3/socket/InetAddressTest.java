package pers.caijx.corejava2.chapter3.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName InetAddressTest
 * @Description: 打印主机的因特网地址，有指定主机名，则打印出该主机的所有因特网地址
 * @Author Think
 * @Date 2019/9/23
 * @Version V1.0
 **/
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        if (args.length > 0) {
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress a : addresses) {
                System.out.println(a);
            }
        } else {
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        }
    }
}
