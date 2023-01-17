//imports for network communication
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
class Game {
  final static int WAITING = 0;
  final static int GAME_RUNNING = 1;
  ArrayList<Card> deck;
  ArrayList<Card> discardPile;
  ArrayList<Card> playedCards;
  int currentPlayer;
  int status;
  ArrayList<Player> players;

  Game(){
    deck = new ArrayList<Card>();
    discardPile = new ArrayList<Card>();
    playedCards = new ArrayList<Card>();
    playedCards.add(new ExampleCard("cardone","1"));
    int currentPlayer = 0;
    int status = WAITING;
    players = new ArrayList<Player>();
  }
  
  public void draw(Graphics g){
    g.setColor(Color.gray);
    g.fillRect(0, 0, Const.WIDTH, Const.HEIGHT);
    for(Card card: playedCards){
      g.setColor(Color.black);
      g.fillRect(400, 300, Const.CARD_WIDTH, Const.CARD_HEIGHT);
      g.setColor(Color.red);
      int largeSize = 24;
      Font largeFont = new Font("Arial", Font.BOLD, largeSize);
      g.setFont(largeFont); 
      g.drawString(card.getName(), 400, 300);
    }
  }
}