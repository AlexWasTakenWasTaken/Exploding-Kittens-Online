/**
 * 
 * @author 
 * @version 
 */

public class FutureCard extends Card{
//------------------------------------------------------------------------------
  public FutureCard(String name, String imageFile){
    super(name, imageFile);
  }
//------------------------------------------------------------------------------ 
  @Override
  public void play(){
    System.out.println(this.getName());
  }
  @Override
  public String toString(){
    return super.toString()+";"+"Future card";
  }
//------------------------------------------------------------------------------    
}