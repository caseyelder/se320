package Question1;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    ServerSocket serverSocket;
    Socket socket;

    public Server(int port){
        try{
            System.out.println("Server started");
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for client..." + serverSocket.getLocalSocketAddress() + " on port " + serverSocket.getLocalPort());
        }catch(IOException e){
            System.out.println("Failed to start server");
            e.printStackTrace();
        }
    }

    public void calc(){
        try{
            socket = serverSocket.accept();
            
            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Client connected");
            String line = "";
            while(!line.equals("exit")){
                line = dataInputStream.readUTF();
                String[] data = line.split(",");
                System.out.println("Recieved weight: " + data[0] + " and height: " + data[1] + " from client");
                double bmi = bmi(Double.parseDouble(data[0]), Double.parseDouble(data[1]));
                System.out.println("Sending BMI to Client: " + bmi);
                dataOutputStream.writeUTF("BMI: " + bmi);
            }
            serverSocket.close();
            dataInputStream.close();
            System.out.println("Connections closed"); 
        }catch(IOException e){
            System.out.println(e);
        }
    }

    private double bmi(double weight, double height){
        return weight/(height*height);
    }

    public static void main(String[] args){
        Server server = new Server(5000);
        server.calc();
    }


}
