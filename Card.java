/**
 * 
 * @author 
 * @version 
 */
import java.awt.Graphics;
abstract class Card{
  private String name;
  private int x;
  private int y;
//------------------------------------------------------------------------------
  Card(String name){
    this.name = name;
    this.x = 300;
    this.y = 400;
  }
//------------------------------------------------------------------------------    
  public String getName(){
    return this.name;
  }
  public void setName(String name){
    this.name = name;
  }
  public int getX(){
    return this.x;
  }
  public void setX(int x){
    this.x = x;
  }
  public int getY(){
    return this.y;
  }
  public void setY(int y){
    this.y = y;
  }
//------------------------------------------------------------------------------    
  abstract void play();
  abstract void draw(Graphics g);
  
  @Override
  public String toString(){
    return this.name;
  }
//------------------------------------------------------------------------------     
}
