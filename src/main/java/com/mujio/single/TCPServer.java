package com.mujio.single;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;

/**
    * @Description: TCPServer TCP连接的服务端
    * @Author: GZY
    * @Date: 2020/4/23 0023
    */
public class TCPServer {
    public static void main(String[] args) {
        System.out.println("服务端启动");
        Scanner sc = new Scanner(System.in);
        InputStream is = null;
        OutputStream os = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        Socket s = null;
        try {
            // 监听指定接口的连接情况
            ServerSocket ss = new ServerSocket(9999);
            // 从队列中取出连接请求，没有请求的话会进入阻塞状态
            s = ss.accept();
            // 建立连接后才会向下执行
            System.out.println("接收到客户端连接请求！");
        while (true) {
            is = s.getInputStream();
            os = s.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);
            String str = null;

            //读取客户端传来的数据
            if ((str = dis.readUTF()) != null) {
                System.out.println("你收到一条来自：" + s.getInetAddress() + s.getPort() + "的消息");
                System.out.println(str);
                System.out.println("回复：");
            }
            // 输入回复信息
            String reply = sc.next();
            // 写入socket
            dos.writeUTF(reply);
        }
        }catch (Exception e){
            System.out.println("发生错误");
        }
    }
}