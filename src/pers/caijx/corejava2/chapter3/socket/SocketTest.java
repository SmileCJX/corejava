package pers.caijx.corejava2.chapter3.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName SocketTest
 * @Description: 连接到当日时间服务，并打印输出
 * @Author Think
 * @Date 2019/9/23
 * @Version V1.0
 **/
public class SocketTest {

    public static void main(String[] args) throws IOException {
        // 打开一个套接字
        try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13)){
            s.setSoTimeout(10000); // 设置套接字超时
            InputStream inputStream = s.getInputStream();
            Scanner in = new Scanner(inputStream);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
