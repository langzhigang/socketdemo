package com.lzg.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {

		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("**********服务器开启**********");
			
			while (true) {
				Socket socket = serverSocket.accept();
				new SocketThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// serverSocket.close();
		// System.out.println("服务器关闭");
	}
}
