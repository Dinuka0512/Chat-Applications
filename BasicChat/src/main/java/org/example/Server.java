package org.example;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server Started!");

        Socket socket = serverSocket.accept();
        System.out.println("Client Connected!");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        System.out.println(dataInputStream.readUTF()); //HERE READ THE CLIENTS MESSAGE
    }
}