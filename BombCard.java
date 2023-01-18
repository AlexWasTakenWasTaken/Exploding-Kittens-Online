/**
 * 
 * @author 
 * @version 
 */

public class BombCard extends Card{
//------------------------------------------------------------------------------
  public BombCard(String name, String imageFile){
    super(name, imageFile);
  }
//------------------------------------------------------------------------------ 
  @Override
  public void play(){
    System.out.println(this.getName());
  }
  @Override
  public String toString(){
    return super.toString()+";"+"Bomb card";
  }
//------------------------------------------------------------------------------    
}