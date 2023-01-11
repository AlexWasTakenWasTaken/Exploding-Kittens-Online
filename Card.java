/**
 * 
 * @author 
 * @version 
 */
import java.awt.Graphics;
abstract class Card{
  private String name;
//------------------------------------------------------------------------------
  Card(String name){
    this.name = name;
  }
//------------------------------------------------------------------------------    
  public String getName(){
    return this.name;
  }
  public void setName(String name){
    this.name = name;
  }
//------------------------------------------------------------------------------    
  abstract void play();
  abstract void draw(Graphics g);
  
  @Override
  public String toString(){
    return ";"+this.name;
  }
//------------------------------------------------------------------------------     
}