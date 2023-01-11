/**
 * 
 * @author 
 * @version 
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
public class ExampleCard extends Card{
  private int num;
//------------------------------------------------------------------------------
  public ExampleCard(String name, int num){
    super(name);
    this.num = num;
  }
//------------------------------------------------------------------------------    
  public int getNum(){
    return this.num;
  }
  public void setNum(int num){
    this.num=num;
  }
//------------------------------------------------------------------------------ 
  @Override
  public void draw(Graphics g){
    g.setColor(Color.blue);
    g.fillRect(0, 0, 800, 250);
    g.setColor(Color.green);
    int largeSize = 24;
    Font largeFont = new Font("Arial", Font.PLAIN, largeSize);
    g.setFont(largeFont); 
    g.drawString(this.getName(), 0, 0);
  }
  @Override
  public void play(){
    System.out.println(this.num);
  }
  @Override
  public String toString(){
    return super.toString()+";"+this.num;
  }
//------------------------------------------------------------------------------    
}