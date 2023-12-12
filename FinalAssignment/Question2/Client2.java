//client sends weight and height to server. server computes BMI and sends it back to client

package Question2;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class Client2 {
    
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    public Client2(String address, int port){
        try{
            socket = new Socket(address, port);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected to server");
        }catch(IOException e){
            System.out.println("Failed to connect to server");
            return;
        }
    }

    public void calc(){
        Scanner scan = new Scanner(System.in);
        String line = "";

        while(!line.equals("exit")){
            try{
                System.out.println("Enter Weight in kilograms and Height in meters in the format: weight,height:");
            	dataOutputStream.writeUTF(scan.next());
            	System.out.println(dataInputStream.readUTF()+ "\n");
            }catch(IOException e){
                System.out.println("Failed to send data to server");
                return;
            }
        }
        closeStreams();
    }

    public void closeStreams() {
        try {
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.err.println("Failed to close streams: " + e.getMessage());
        }
    }
    

    public static void main(String[] args){
        //create new client(address, port)
        Client client = new Client("127.0.0.1", 5000);
        client.calc();
    }
}