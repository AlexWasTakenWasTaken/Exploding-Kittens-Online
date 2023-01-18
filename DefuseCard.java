/**
 * 
 * @author 
 * @version 
 */

public class DefuseCard extends Card{
//------------------------------------------------------------------------------
  public DefuseCard(String name, String imageFile){
    super(name, imageFile);
  }
//------------------------------------------------------------------------------ 
  @Override
  public void play(){
    System.out.println(this.getName());
  }
  @Override
  public String toString(){
    return super.toString()+";"+"Defuse card";
  }
//------------------------------------------------------------------------------    
}