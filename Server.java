//imports for network communication
import java.util.ArrayList;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Server {
  final int PORT = 5001;       
  
  ServerSocket serverSocket;
  Socket clientSocket;
  PrintWriter output;
  BufferedReader input;
  int clientCounter = 0;
  Card card1 = new ExampleCard("cardone","1");
  Card card2 = new ExampleCard("cardtwo","2");
  Card card3 = new ExampleCard("cardthree","3");
  ArrayList<Card> deck;
  Game game = new Game();
  public static void main(String[] args) throws Exception{ 
    Server server = new Server();
    server.go();
  }
  
  public void go() throws Exception{ 
    deck = new ArrayList<Card>();
    deck.add(card1);
    deck.add(card2);
    deck.add(card3);
    //create a socket with the local IP address and wait for connection request       
    System.out.println("Waiting for a connection request from a client ...");
    serverSocket = new ServerSocket(PORT);                //create and bind a socket
    while(true) {
      clientSocket = serverSocket.accept();             //wait for connection request
      clientCounter = clientCounter +1;
      System.out.println("Client "+clientCounter+" connected");
      Thread connectionThread = new Thread(new ConnectionHandler(clientSocket));
      connectionThread.start();                         //start a new thread to handle the connection
    }
  }
  
//------------------------------------------------------------------------------
  class ConnectionHandler extends Thread { 
    Socket socket;
    PrintWriter output;
    BufferedReader input;
    
    public ConnectionHandler(Socket socket) { 
      this.socket = socket;
    }
    @Override
    public void run() {
      try {
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream());
        //receive a message from the client
        String msg = input.readLine();
        System.out.println("Message from the client: " + msg);
        //send a response to the client
        output.println(clientCounter+";"+deck.get(clientCounter-1).toString());
        output.flush();         
        //after completing the communication close the streams but do not close the socket!
        input.close();
        output.close();
      }catch (IOException e) {e.printStackTrace();}
    }
  }    
}
