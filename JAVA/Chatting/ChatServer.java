package Chatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Chatting.ChatHandler;

class ChatServer {
	private ServerSocket ss;
	private ArrayList<ChatHandler> list;

	public ChatServer(){
		try{
			ss = new ServerSocket(9500);
			System.out.println("서버준비완료");

			list = new ArrayList<ChatHandler>();

			while(true){
				Socket socket = ss.accept();
				ChatHandler handler = new ChatHandler(socket, list);//스레드 생성
				handler.start();//스레드 시작

				list.add(handler);
			}//while
		}catch(IOException io){
			io.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}
