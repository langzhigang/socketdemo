package com.lzg.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread extends Thread {

	private Socket socket;

	public SocketThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		OutputStream out = null;
		PrintWriter pw = null;
		try {
			in = socket.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			socket.shutdownInput();

			out = socket.getOutputStream();
			pw = new PrintWriter(out);
			pw.print("我是服务端，欢迎登录");
			pw.flush();

			socket.shutdownOutput();

			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
					br = null;
				}
				if (isr != null) {
					isr.close();
					isr = null;
				}
				if (in != null) {
					in.close();
					in = null;
				}
				if (pw != null) {
					pw.close();
					pw = null;
				}
				if (out != null) {
					out.close();
					out = null;
				}
				if( socket != null){
					socket.close();
					socket = null;
				}
			} catch (IOException e) {
				System.out.println("关闭流异常");
			}
		}
	}

}
