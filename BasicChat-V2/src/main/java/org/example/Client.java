package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        String message = "";
        while(!message.equals("exit")){
            message = new Scanner(System.in).nextLine(); //HERE GET THE MESSAGE INPUT
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println(dataInputStream.readUTF()); //HERE READ THE CLIENTS MESSAGE
        }
    }
}
