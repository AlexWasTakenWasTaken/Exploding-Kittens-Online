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
    } catch (IOException ex){
      System.out.println("file not found");
    } 
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
  @Override
  public String toString(){
    return this.name + ";" + this.imageFile;
  }   
  public void draw(Graphics g, int row, int col){
    g.drawImage(picture,col*Const.GRID_SIZE,row*Const.GRID_SIZE,null);
  }
}
