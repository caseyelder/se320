//this server can accpent multiple clients at the same time by creating a new thread for each client connection 
package Question2;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private int index;

    //create server
    public Server(Socket socket, int index){
        try {
            this.socket = socket;
            this.index = index;
            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try
        {
            String line = "";
            while (!line.equals("Over"))
            {
                line = dataInputStream.readUTF();
                String[] params = line.split(",");
                
                System.out.println("Received weight: " + params[0] + " height " + params[1] + " from socket connection " + index);
                double bmi = bmi( Double.parseDouble(params[0]),Double.parseDouble(params[1]) );
                System.out.println("Sending " + bmi + " to socket connection " + index + "\n\n");
                dataOutputStream.writeUTF("Your BMI is: " + bmi);
            }
            System.out.println("Closing connection");
 
            socket.close();
            dataInputStream.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    private double bmi(double weight, double height)
    {
        return weight / (height * height);
    }

    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000); // Use any free port
            int index = 0;
    
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                System.out.println("Client accepted");
    
                Server server = new Server(socket, index++);
                server.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
