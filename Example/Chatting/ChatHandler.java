package Chatting;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

class ChatHandler extends Thread {
	private BufferedReader br;
	private PrintWriter pw;
	private Socket socket;
	private ArrayList<ChatHandler> list;

	public ChatHandler(Socket socket, ArrayList<ChatHandler> list) throws IOException {
		this.socket = socket;
		this.list = list;
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		System.out.println("생성자안");
	}

	@Override
	public void run() {
		try {
			String nickName = br.readLine();
			broadcast(nickName + "님이 입장하였습니다");

			String line = null;
			while (true) {
				line = br.readLine();
				if (line == null || line.toLowerCase().equals("exit")) {
					break;
				}

				broadcast("[" + nickName + "] " + line);

			} // while

			pw.println("exit");
			pw.flush();

			list.remove(this);
			broadcast(nickName + "님이 퇴장하였습니다");

			br.close();
			pw.close();
			socket.close();

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public void broadcast(String msg) {
		for (ChatHandler handler : list) {
			handler.pw.println(msg);
			handler.pw.flush();
		} // for
	}
}
