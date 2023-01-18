/**
 * 
 * @author 
 * @version 
 */

public class ShuffleCard extends Card{
//------------------------------------------------------------------------------
  public ShuffleCard(String name, String imageFile){
    super(name, imageFile);
  }
//------------------------------------------------------------------------------ 
  @Override
  public void play(){
    System.out.println(this.getName());
  }
  @Override
  public String toString(){
    return super.toString()+";"+"Shuffle card";
  }
//------------------------------------------------------------------------------    
}