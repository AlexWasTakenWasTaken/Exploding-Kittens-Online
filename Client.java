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
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
class Client {
  final String LOCAL_HOST = "127.0.0.1";
  final int PORT = 5001;
  JFrame frame;
  GraphicsPanel canvas;
  Socket clientSocket;
  PrintWriter output;    
  BufferedReader input;
  Player user;
  ArrayList<Player> opponents;
  int deckSize;
  BasicMouseListener mouseListener;
  BasicMouseMotionListener mouseMotionListener; 
  int mouseX;
  int mouseY;
  String clientNum;
  public static void main (String[] args) throws Exception{ 
    Client client = new Client();
    client.start();
  }
  public void start() throws Exception{ 
    System.out.println("Enter name");
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    String name = keyboard.readLine();
    keyboard.close();
    
    System.out.println("Attempting to establish a connection ...");
    clientSocket = new Socket(LOCAL_HOST, PORT);
    output = new PrintWriter(clientSocket.getOutputStream());
    input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    System.out.println("Connection to server established!");
    output.println(name);
    output.flush();
    clientNum = input.readLine();
    System.out.println("Client number: " + clientNum+""); 
    String msg = input.readLine();
    String[] cards = msg.split(";");
    user = new Player(name, 1);
    for(int i=0; i<cards.length; i+=3){
      user.addToHand(cards[i]+";"+cards[i+1]+";"+cards[i+2]);
    }
    opponents = new ArrayList<Player>();
    for(int playerNum =2; playerNum<5; playerNum++){
      Player opponent = new Player("opponent", playerNum);
      for(int i=0; i<cards.length; i+=3){
        opponent.addToHand(cards[i]+";"+cards[i+1]+";"+cards[i+2]);
      }
      opponents.add(opponent);
    }

    // setting up jframe
    frame = new JFrame("Knockoff Exploding Kittens");     
    frame.setSize(Const.WIDTH,Const.HEIGHT);
    canvas = new GraphicsPanel();
    frame.add(canvas);
    mouseX = 0;
    mouseY = 0;
    mouseListener = new BasicMouseListener(); 
    canvas.addMouseListener(mouseListener);
    mouseMotionListener = new BasicMouseMotionListener(); 
    canvas.addMouseMotionListener(mouseMotionListener);
    frame.setVisible(true);
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
      g.setColor(Color.gray);
      g.fillRect(0, 0, Const.WIDTH, Const.HEIGHT);
      g.setColor(Color.white);
      for(int row = 0; row<Const.HEIGHT; row += Const.GRID_SIZE){
        g.drawLine(0,row,Const.WIDTH,row);
      }
      for(int col = 0; col<Const.WIDTH; col += Const.GRID_SIZE){
        g.drawLine(col,0,col,Const.HEIGHT);
      }
      for(Player opponent: opponents){
        opponent.draw(g,mouseX,mouseY);
      }
      user.draw(g, mouseX,mouseY);
    }
  }
//------------------------------------------------------------------------------ 
  public class BasicMouseListener implements MouseListener{
    public void mouseClicked(MouseEvent e){   // moves the box at the mouse location
      mouseX = e.getX();
      mouseY = e.getY();
      System.out.println("X: "+ mouseX +" Y: "+mouseY);
    }
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
  }  
  public class BasicMouseMotionListener implements MouseMotionListener{
    public void mouseMoved(MouseEvent e){
      mouseX = e.getX();
      mouseY = e.getY();
    }
    public void mouseDragged(MouseEvent e){}         
  }
}

