package buildings;

import java.awt.Image;
import main.Player;
import resources.*;

public class HeadQuarter extends Building {

  private int crystal;

  
  public HeadQuarter(Integer health, Integer positionX, Integer positionY, Integer width, Integer length, Boolean doesExists, Player isEnemy, Integer timeToCreate, Image image){
      super(health,positionX,positionY,width,length,doesExists,isEnemy,timeToCreate, image);

      this.setBounds(positionX,positionY,width,length);
      this.setOpaque(false);
  }
    public int getCrystal() {
        return crystal;
    }
    public void setCrystal(int crystal) {
        this.crystal = crystal;
    }
 





  
}