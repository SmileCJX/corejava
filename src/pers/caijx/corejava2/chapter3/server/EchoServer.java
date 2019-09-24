package pers.caijx.corejava2.chapter3.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName EchoServer
 * @Description: 简单的服务器，可以向客户端发送信息
 * @Author Think
 * @Date 2019/9/24
 * @Version V1.0
 **/
public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(8189)){
            try (Socket incoming = s.accept()){
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();

                try (Scanner in = new Scanner(inputStream)){
                    PrintWriter printWriter = new PrintWriter(outputStream,true);
                    printWriter.write("Hello,enter BYE to exit");

                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        printWriter.write("Echo: " + line);
                        if ("BYE".equals(line.trim())) {
                            done = true;
                        }
                    }
                }
            }
        }
    }
}
