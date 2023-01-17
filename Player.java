/**
 * 
 * @author 
 * @version 
 */

import java.util.ArrayList;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
class Player {
  final String LOCAL_HOST = "127.0.0.1";
  final int PORT = 5001;
  
  JFrame frame;
  GraphicsPanel canvas;
  
  Socket clientSocket;
  PrintWriter output;    
  BufferedReader input;
  
  ArrayList<Card> hand = new ArrayList<Card>();
  Game game = new Game();
  String username;
  int playerNumber;
  
  public static void main (String[] args) throws Exception{ 
    Player client = new Player();
    client.start();
  }
  
  public void start() throws Exception{ 
    // setting up jframe
    frame = new JFrame("Name of the game here?");     
    frame.setSize(Const.WIDTH,Const.HEIGHT); // width, height
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // i should change this later maybe
    canvas = new GraphicsPanel();
    frame.add(canvas);
    frame.setVisible(true);
    
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    username = keyboard.readLine();
    keyboard.close();
    
    //create a socket with the local IP address and attempt a connection
    System.out.println("Attempting to establish a connection ...");
    clientSocket = new Socket(LOCAL_HOST, PORT);          //create and bind a socket, and request connection
    output = new PrintWriter(clientSocket.getOutputStream());
    input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    System.out.println("Connection to server established!");
    
    output.println(username);           //send a message to the server
    output.flush();                                       //ensure the message was sent but not kept in the buffer
    String msg = input.readLine();                        //get a response from the server
    System.out.println("Message from server: '" + msg+"'");   
    String[] splitMsg = msg.split(";");
    playerNumber = Integer.parseInt(splitMsg[0]);
    Card myCard = new ExampleCard(splitMsg[1],splitMsg[2]);
    hand.add(myCard);
    run();
  }
  public void run() throws Exception{
    boolean running = true;
    while(running){
      canvas.repaint();
    }
    stop();
  }
  public void stop() throws Exception{ 
    input.close();
    output.close();
    clientSocket.close();
  }
//------------------------------------------------------------------------------
  /**
   * A JPanel that contains all the graphics code
   */
  public class GraphicsPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) { 
      super.paintComponent(g);
      game.draw(g);
      for(Card card:hand){
        card.draw(g);
      } 
    }
  }
//------------------------------------------------------------------------------     
}

