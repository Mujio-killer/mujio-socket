package com.mujio.single;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: Server
 * @Author: GZY
 * @Date: 2020/4/22 0022
 */

public class Server {

    public void start() {
        System.out.println("服务端启动");
        Socket accept = null;
        try {
            //创建 ServerSocket 服务，监听 8080 端口
            ServerSocket serverSocket = new ServerSocket(8080);
            //用 Socket接收传入 8080 端口的数据
            accept = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sendMsg(accept);
        System.out.println("服务端关闭");
    }

    /**
     * 打印请求数据
     *
     * @param socket
     */
    private void sendMsg(Socket socket) {
        try {
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            dos.writeUTF("This is " + socket.getInetAddress() + " Port:" + socket.getPort());

            dos.close();
            os.close();
        } catch (IOException e) {
            System.out.println("发生错误！");
        }finally {
        }
    }

}
