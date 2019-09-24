package pers.caijx.corejava2.chapter3.threaded;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName ThreadedEchoServer
 * @Description: 可实现多个客户端同时连接到服务器上
 * @Author Think
 * @Date 2019/9/24
 * @Version V1.0
 **/
public class ThreadedEchoServer {

    public static void main(String[] args) {

        int i = 1;
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            while (true) {
                Socket s = serverSocket.accept();
                System.out.println("内容：" + i);
                Runnable r = new ThreadedEchoHandler(s);
                Thread thread = new Thread(r);
                thread.setName("Thread" + i);
                thread.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class ThreadedEchoHandler implements Runnable {

    private Socket inComing;

    public ThreadedEchoHandler(Socket inComing) {
        this.inComing = inComing;
    }

    @Override
    public void run() {
        try {
            try {
                InputStream inputStream = inComing.getInputStream();
                OutputStream outputStream = inComing.getOutputStream();
                Scanner scanner = new Scanner(inputStream);
                PrintWriter printWriter = new PrintWriter(outputStream,true);

                // 设置关闭标志
                boolean done = false;
                while (!done && scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    printWriter.write("Echo:" + line);
                    System.out.println("Echo:" + line); // 获取客户端的内容
                    if ("BYE".equals(line.trim())) {
                        done = true;
                    }
                }
            } finally {
                inComing.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
