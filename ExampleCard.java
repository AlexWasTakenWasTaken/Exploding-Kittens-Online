/**
 * 
 * @author 
 * @version 
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
public class ExampleCard extends Card{
  private int num;
//------------------------------------------------------------------------------
  public ExampleCard(String name, String num){
    super(name);
    this.num = Integer.parseInt(num);
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
  public void draw(Graphics g, int x, int y){
    g.setColor(Color.blue);
    g.fillRect(x, y, Const.CARD_WIDTH, Const.CARD_HEIGHT);
    g.setColor(Color.green);
    int largeSize = 24;
    Font largeFont = new Font("Arial", Font.BOLD, largeSize);
    g.setFont(largeFont); 
    g.drawString(this.getName(), x, y);
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
