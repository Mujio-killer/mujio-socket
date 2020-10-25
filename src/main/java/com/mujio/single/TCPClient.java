package com.mujio.single;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


/**
* @Description: TCPClient TCP连接的客户端
* @Author: GZY
* @Date: 2020/4/23 0023
*/
public class TCPClient {
    public static void main(String[] args){
        System.out.println("客户端启动");
        Scanner sc = new Scanner(System.in);
        InputStream is = null;
        OutputStream os = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        Socket s = null;
        try {
            // 连接到指定的 socket
            s = new Socket("127.0.0.1",9999);

            while (true) {
                is = s.getInputStream();
                os = s.getOutputStream();
                dis = new DataInputStream(is);
                dos = new DataOutputStream(os);

                //客户端先写
                String str = sc.next();
                dos.writeUTF(str);
                //再读
                if ((str = dis.readUTF()) != null) {
                    System.out.println("收到一条来自服务端的信息：");
                    System.out.println(str);
                    System.out.println("回复：");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}