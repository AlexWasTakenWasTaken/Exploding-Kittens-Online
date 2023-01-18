/**
 * 
 * @author 
 * @version 
 */
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
abstract class Card{
  private String name;
  private String imageFile;
  private BufferedImage picture;
//------------------------------------------------------------------------------
  Card(String name, String imageFile){
    this.name = name;
    this.imageFile = imageFile;
    try {                
      picture = ImageIO.read(new File(imageFile)); // load the picture from a file
    } catch (IOException ex){System.out.println("file not found");} 
  }
//------------------------------------------------------------------------------    
  public String getName(){
    return this.name;
  }
  public void setName(String name){
    this.name = name;
  }
  public String getImageFile(){
    return this.imageFile;
  }
  public void setImageFile(String imageFile){
    this.imageFile=imageFile;
  }
//------------------------------------------------------------------------------    
  abstract void play();
//------------------------------------------------------------------------------  
  public boolean isUnderMouse(int row, int col, int mouseX, int mouseY){
    return mouseY>row*Const.GRID_SIZE && mouseY<row*Const.GRID_SIZE+Const.CARD_HEIGHT &&
           mouseX>col*Const.GRID_SIZE && mouseX<(col+1)*Const.GRID_SIZE;
  }
  @Override
  public String toString(){
    return this.name + ";" + this.imageFile;
  }   
  public void draw(Graphics g, int col, int row){
    g.drawImage(picture,col*Const.GRID_SIZE,row*Const.GRID_SIZE,null);
  }
}
