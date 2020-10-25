package com.mujio.single;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Description: Client
 * @Author: GZY
 * @Date: 2020/4/23 0023
 */

public class Client {

    public void start() {
        System.out.println("客户端启动");
        try {
            //创建 Socket客户端 连接到 127.0.0.1:8080
            Socket socket = new Socket("127.0.0.1", 8080);
            //获取服务端写过的内容
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            System.out.println("读取到：" + dis.readUTF());

            dis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("客户端关闭");
    }
}
