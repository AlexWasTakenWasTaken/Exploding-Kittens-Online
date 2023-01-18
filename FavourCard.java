/**
 * 
 * @author 
 * @version 
 */

public class FavourCard extends Card{
//------------------------------------------------------------------------------
  public FavourCard(String name, String imageFile){
    super(name, imageFile);
  }
//------------------------------------------------------------------------------ 
  @Override
  public void play(){
    System.out.println(this.getName());
  }
  @Override
  public String toString(){
    return super.toString()+";"+"Favour card";
  }
//------------------------------------------------------------------------------    
}