//imports for network communication
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
class Game {
  final static int WAITING = 0;
  final static int GAME_RUNNING = 1;
  private ArrayList<Card> deck;
  private ArrayList<Card> discardPile;
  private ArrayList<Card> playedCards;
  private int currentPlayer;
  private int status;
  private ArrayList<Player> players;

  Game(){
    deck = new ArrayList<Card>();
    discardPile = new ArrayList<Card>();
    playedCards = new ArrayList<Card>();
    playedCards.add(new SkipCard("cardone","1"));
    int currentPlayer = 0;
    int status = WAITING;
    players = new ArrayList<Player>();
  }
  
}
