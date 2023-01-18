/**
 * 
 * @author 
 * @version 
 */

public class AttackCard extends Card{
//------------------------------------------------------------------------------
  public AttackCard(String name, String imageFile){
    super(name, imageFile);
  }
//------------------------------------------------------------------------------ 
  @Override
  public void play(){
    System.out.println(this.getName());
  }
  @Override
  public String toString(){
    return super.toString()+";"+"Attack card";
  }
//------------------------------------------------------------------------------    
}