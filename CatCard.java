/**
 * 
 * @author 
 * @version 
 */

public class CatCard extends Card{
//------------------------------------------------------------------------------
  public CatCard(String name, String imageFile){
    super(name, imageFile);
  }
//------------------------------------------------------------------------------ 
  @Override
  public void play(){
    System.out.println(this.getName());
  }
  @Override
  public String toString(){
    return super.toString()+";"+"Cat card";
  }
//------------------------------------------------------------------------------    
}