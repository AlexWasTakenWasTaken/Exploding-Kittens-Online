//imports for network communication
import java.util.ArrayList;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class Player {
    final String LOCAL_HOST = "127.0.0.1";
    final int PORT = 5001;
    
    Socket clientSocket;
    PrintWriter output;    
    BufferedReader input;
    
    ArrayList<Card> hand = new ArrayList<Card>();
    
    public static void main (String[] args) throws Exception{ 
        Player client = new Player();
        client.start();
        client.stop();                                        //after completing the communication close the streams and the sockets
    }
    
    public void start() throws Exception{ 
      
      //create a socket with the local IP address and attempt a connection
      System.out.println("Attempting to establish a connection ...");
      clientSocket = new Socket(LOCAL_HOST, PORT);          //create and bind a socket, and request connection
      output = new PrintWriter(clientSocket.getOutputStream());
      input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      System.out.println("Connection to server established!");
      
      output.println("Hi. I am Amanda!");           //send a message to the server
      output.flush();                                       //ensure the message was sent but not kept in the buffer
      String msg = input.readLine();                        //get a response from the server
      System.out.println("Message from server: '" + msg+"'");   
      
    }
    
    public void stop() throws Exception{ 
        input.close();
        output.close();
        clientSocket.close();
    }
}

