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
  Game game = new Game();
  ArrayList<Thread> clients = new ArrayList<Thread>();
  public static void main(String[] args) throws Exception{ 
    Server server = new Server();
    server.go();
  }
  
  public void go() throws Exception{     
    serverSocket = new ServerSocket(PORT);
    while(true) {
      System.out.println("Waiting for a connection request from a client ...");
      clientSocket = serverSocket.accept();
      clientCounter = clientCounter +1;
      System.out.println("Client "+clientCounter+" connected");
      Thread connectionThread = new Thread(new ConnectionHandler(clientSocket));
      connectionThread.start();
      clients.add(connectionThread);
    }
  }
  
//------------------------------------------------------------------------------
  class ConnectionHandler extends Thread { 
    Socket socket;
    PrintWriter output;
    BufferedReader input;
    Player player;
    public ConnectionHandler(Socket socket) { 
      this.socket = socket;
    }
    @Override
    public void run() {
      try {
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream());
        //receive a message from the client
        String name = input.readLine();
        player = new Player(name, ""+clientCounter);
        //send a response to the client
        output.println(clientCounter);
        output.flush();

        Card attackCard = new AttackCard("Attack","AttackCard.png");
        Card bombCard = new BombCard("Exploding Kitten","BombCard.png");
        Card catCard = new CatCard("Tacocat","CatCard.png");
        Card defuseCard = new DefuseCard("Defuse","DefuseCard.png");
        Card favourCard = new FavourCard("Favor","FavourCard.png");
        Card futureCard = new FutureCard("See The Future","FutureCard.png");
        Card nopeCard = new NopeCard("Nope","NopeCard.png");
        Card shuffleCard = new ShuffleCard("Shuffle","ShuffleCard.png");
        Card skipCard = new SkipCard("Skip","SkipCard.png");
        output.println(attackCard.toString()+";"+bombCard.toString()+";"+catCard.toString()+";"+defuseCard.toString()+";"+favourCard.toString()+";"+futureCard.toString()+";"+nopeCard.toString()+";"+shuffleCard.toString()+";"+skipCard.toString());
        output.flush();

        input.close();
        output.close();
      }catch (IOException e) {e.printStackTrace();}
    }
  }    
}
