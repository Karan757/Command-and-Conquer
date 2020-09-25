package characters;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import main.Player;
import resources.*;


public class Miner extends Sprite {

  private Integer powerAttack;
  

    public Miner() {
    }

    public Miner(Integer positionX, Integer positionY, Player isEnemy) {
        super(positionX, positionY, isEnemy);
        this.setImage(isEnemy.getMinerImage());
    }
    
    public boolean mining(Resource e){
         Rectangle rect = new Rectangle(e.getPositionX(), e.getPositionY(), e.getWidth(), e.getHeight());
            Ellipse2D.Double circle = new Ellipse2D.Double(this.getPositionX() + getWidth()/2, this.getPositionY() + this.getHeight()/2, 25, 25);
         if(circle.intersects(rect)){
             this.setGo_x(this.getPositionX());
             this.setGo_y(this.getPositionY());
             return true;
         }else{
             return false;
         }
            
     
    }

}