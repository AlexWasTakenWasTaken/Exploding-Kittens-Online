/**
 * 
 * @author 
 * @version 
 */

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
class Player {

  private ArrayList<Card> hand;
  private String name;
  private int playerNumber;
  
  Player(String name, String playerNumber){
    this.name = name;
    this.playerNumber = Integer.parseInt(playerNumber);
    this.hand = new ArrayList<Card>();
  }
  public void addToHand(String card){
    String[] cardDetails = card.split(";");
    if(cardDetails[2].equals("Attack card")){
      Card myCard = new AttackCard(cardDetails[0],cardDetails[1]);
      hand.add(myCard);
    }
    if(cardDetails[2].equals("Bomb card")){
      Card myCard = new BombCard(cardDetails[0],cardDetails[1]);
      hand.add(myCard);
    }
    if(cardDetails[2].equals("Cat card")){
      Card myCard = new CatCard(cardDetails[0],cardDetails[1]);
      hand.add(myCard);
    }
    if(cardDetails[2].equals("Defuse card")){
      Card myCard = new DefuseCard(cardDetails[0],cardDetails[1]);
      hand.add(myCard);
    }
    if(cardDetails[2].equals("Favour card")){
      Card myCard = new FavourCard(cardDetails[0],cardDetails[1]);
      hand.add(myCard);
    }
    if(cardDetails[2].equals("Future card")){
      Card myCard = new FutureCard(cardDetails[0],cardDetails[1]);
      hand.add(myCard);
    }
    if(cardDetails[2].equals("Nope card")){
      Card myCard = new NopeCard(cardDetails[0],cardDetails[1]);
      hand.add(myCard);
    }
    if(cardDetails[2].equals("Shuffle card")){
      Card myCard = new ShuffleCard(cardDetails[0],cardDetails[1]);
      hand.add(myCard);
    }
    if(cardDetails[2].equals("Skip card")){
      Card myCard = new SkipCard(cardDetails[0],cardDetails[1]);
      hand.add(myCard);
    }
  }
  public void draw(Graphics g){
    for(int i=0; i<this.hand.size(); i++){
      this.hand.get(i).draw(g, 10,i);
    } 
  }  
}
