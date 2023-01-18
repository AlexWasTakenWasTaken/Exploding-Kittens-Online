/**
 * 
 * @author 
 * @version 
 */

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
class Player {
  private ArrayList<Card> hand;
  private String name;
  private int playerNumber;
  private BufferedImage backOfCard;
  Player(String name, int playerNumber){
    this.name = name;
    this.playerNumber = playerNumber;
    this.hand = new ArrayList<Card>();
    try {                
      backOfCard = ImageIO.read(new File("Back"+playerNumber+".png")); // load the picture from a file
    } catch (IOException ex){
      System.out.println("file not found");
    } 
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
  public void draw(Graphics g, int mouseX, int mouseY){
    int largeSize = 24;
    Font largeFont = new Font("Arial", Font.PLAIN, largeSize);
    g.setFont(largeFont); 
    if(this.playerNumber == 1){
      for(int i=0; i<this.hand.size(); i++){
        if(this.hand.get(i).isUnderMouse(12,i,mouseX,mouseY)){
          this.hand.get(i).draw(g, i,10);
          this.hand.get(i).draw(g, 13,9);
        }else{
          this.hand.get(i).draw(g, i,11);
        }
        g.setColor(Color.black);
        g.fillRect(0,14*Const.GRID_SIZE,10*Const.GRID_SIZE,2*Const.GRID_SIZE); 
        g.setColor(Color.white);
        g.drawString("Player 1: "+this.name, 0, 15*Const.GRID_SIZE);
      }
    }else if(this.playerNumber == 2){
      for(int i=0; i<this.hand.size(); i++){
        g.drawImage(this.backOfCard,18*Const.GRID_SIZE,(Const.ROWS-i)*Const.GRID_SIZE-Const.CARD_WIDTH,null);
      }
    }else if(this.playerNumber == 3){
      for(int i=0; i<this.hand.size(); i++){
        g.drawImage(this.backOfCard,(Const.COLUMNS-i)*Const.GRID_SIZE-Const.CARD_WIDTH,(-4)*Const.GRID_SIZE,null);
      }
    }else if(this.playerNumber == 4){
      for(int i=0; i<this.hand.size(); i++){
        g.drawImage(this.backOfCard,(-4)*Const.GRID_SIZE,i*Const.GRID_SIZE,null);
      }
    }
    
  }  
}
