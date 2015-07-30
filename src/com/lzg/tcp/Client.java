package com.lzg.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		OutputStream out = null;
		PrintWriter pw = null;
		Socket socket = null;
		try {
			socket = new Socket("localhost", 8888);

			out = socket.getOutputStream();
			pw = new PrintWriter(out);
			pw.write("我是客户端，我要登录");
			pw.flush();

			socket.shutdownOutput();

			in = socket.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

			socket.shutdownInput();
		} catch (Exception e) {

		} finally {
			try {
				if (pw != null) {
					pw.close();
					pw = null;
				}
				if (out != null) {
					out.close();
					out = null;
				}

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

				if (socket != null) {
					socket.close();
					socket = null;
				}
			} catch (IOException e) {
				System.out.println("关闭流异常");
			}
		}
	}
}
