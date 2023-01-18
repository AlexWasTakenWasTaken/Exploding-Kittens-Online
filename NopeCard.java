/**
 * 
 * @author 
 * @version 
 */

public class NopeCard extends Card{
//------------------------------------------------------------------------------
  public NopeCard(String name, String imageFile){
    super(name, imageFile);
  }
//------------------------------------------------------------------------------ 
  @Override
  public void play(){
    System.out.println(this.getName());
  }
  @Override
  public String toString(){
    return super.toString()+";"+"Nope card";
  }
//------------------------------------------------------------------------------    
}