package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        /*
        * THERE FIRSTLY WE NEED TO RUN THE SERVER
        * */
        String clientMessage= "";

        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server Started!");

        Socket socket = serverSocket.accept();
        System.out.println("Client Connected!");

        while(!clientMessage.equals("exit")){
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            clientMessage = dataInputStream.readUTF();
            System.out.println(clientMessage); //HERE READ THE CLIENTS MESSAGE

            String message = new Scanner(System.in).nextLine(); //HERE GET THE MESSAGE INPUT
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
        }
    }
}