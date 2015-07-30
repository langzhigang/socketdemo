package com.lzg.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		//客户端发送数据
		byte[] data = "用户名：admin,密码:123".getBytes();
		DatagramPacket packet = new DatagramPacket(data, 0, data.length,InetAddress.getByName("localhost"),8888);
		DatagramSocket socket = new DatagramSocket(9999);
		socket.send(packet);
		
		
		//客户端接收数据
		byte[] receiveData = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		socket.receive(receivePacket);
		System.out.println("服务端发送的消息为："+new String(receivePacket.getData()));
		
		socket.close();
	}
}
