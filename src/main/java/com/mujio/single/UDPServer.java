package com.mujio.single;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.lang.annotation.ElementType;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPServer {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        // 监听 指定端口
        DatagramSocket ds = new DatagramSocket(9999);
        // 创建 缓冲区，用来接收“客户端”传来的数据
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

        while (true){
            // 接收数据，传入存储的位置dp，dp将具体数据存到 bytes数组中
            ds.receive(dp);
            System.out.println("接收到的数据：");
            // 数据包是一次收发一个，所以没有流的概念。由dp.getOffset(), dp.getLength()指定起始位置和长度，并将其按UTF-8编码转换为String，以方便打印出来
            String str = new String(dp.getData(), dp.getOffset(), dp.getLength(), StandardCharsets.UTF_8);
            System.out.println(str);

            System.out.println("回复：");
            String rply = sc.next();
//            String rply = "跪安吧";
            // 设置回复UDP数据包内容
            dp.setData(rply.getBytes());
            ds.send(dp);

       }
    }
}