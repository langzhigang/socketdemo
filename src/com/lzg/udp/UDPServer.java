package com.lzg.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(8888);
		System.out.println("*************UDP服务启动*************");
		
		//服务端接收数据
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		socket.receive(packet);
		System.out.println("客户端发送的消息为："+new String(packet.getData()));
		
		//服务端发送数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] sendData = "我是服务端：欢迎登录".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
		socket.send(sendPacket);
		
		socket.close();
	}
}
