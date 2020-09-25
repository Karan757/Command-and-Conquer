package characters;

import buildings.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import main.Player;

public class Worker extends Sprite {

    
     
    
    public Worker() {
    }

    public Worker(Integer positionX, Integer positionY, Player isEnemy) {
        super(positionX, positionY, isEnemy);
        this.setImage(isEnemy.getWorkerImage());
    }
    
     public void createBuilding(String type) {
         System.out.println("creating building");
         Barracks h =new Barracks(100,this.getPositionX()+20,this.getPositionY()+20,300, 200, true, this.getIsEnemy(), //new
                10, this.getIsEnemy().getbImage());
        
     }

}