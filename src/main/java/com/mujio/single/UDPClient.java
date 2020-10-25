package com.mujio.single;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        // 自己占用的端口， 客户端占用一个端口8888
        DatagramSocket ds = new DatagramSocket();
        // 目标服务器设置
        InetSocketAddress isa = new InetSocketAddress("97.0.0.1", 9999);
        // 连接到目标服务器
        ds.connect(isa);
        boolean bound = ds.isBound();
        int soTimeout = ds.getSoTimeout();
        boolean connected = ds.isConnected();
        ds.close();
        boolean connected1 = ds.isConnected();
        ds.disconnect();
        boolean connected2 = ds.isConnected();


    }
}