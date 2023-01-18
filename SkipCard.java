/**
 * 
 * @author 
 * @version 
 */

public class SkipCard extends Card{
//------------------------------------------------------------------------------
  public SkipCard(String name, String imageFile){
    super(name, imageFile);
  }
//------------------------------------------------------------------------------ 
  @Override
  public void play(){
    System.out.println(this.getName());
  }
  @Override
  public String toString(){
    return super.toString()+";"+"Skip card";
  }
//------------------------------------------------------------------------------    
}