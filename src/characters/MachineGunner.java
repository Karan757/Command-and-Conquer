package characters;

import buildings.Building;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import main.Player;

public class MachineGunner extends Sprite {

    private Integer attackPower;
    
   

    public MachineGunner(Integer positionX, Integer positionY, Player isEnemy) {
        super(positionX, positionY, isEnemy);
        this.attackPower = 1;
        this.setImage(isEnemy.getSoilderImage());
    }

    public void attack(Sprite e) {
        Rectangle rect = new Rectangle(e.getPositionX(), e.getPositionY(), e.getWidth(), e.getHeight());
        Ellipse2D.Double circle = new Ellipse2D.Double(this.getPositionX() + getWidth() / 2, this.getPositionY() + this.getHeight() / 2, 50, 50);
        if (e.isAlive()) {
            if (e.getIsEnemy() != this.getIsEnemy()) {
                if (circle.intersects(rect) && e.getHealth() > 0) {
                    this.setGo_x(this.getPositionX());
                    this.setGo_y(this.getPositionY());

                    e.setHealth(e.getHealth() - this.attackPower);
                    if (e instanceof MachineGunner) {
                        this.setHealth(this.getHealth() - e.getAttackPower());
                       
                    }

                    System.out.println(e.getHealth());

                }
            }
        }
    }

    public void attackBuilding(Building e) {
        Rectangle rect = new Rectangle(e.getPositionX(), e.getPositionY(), e.getWidth(), e.getHeight());
        Ellipse2D.Double circle = new Ellipse2D.Double(this.getPositionX() + getWidth() / 2, this.getPositionY() + this.getHeight() / 2, 50, 50);
        if (e.isAlive()) {
            if (e.getIsEnemy() != this.getIsEnemy()) {
                if (circle.intersects(rect) && e.getHealth() > 0) {
                    this.setGo_x(this.getPositionX());
                    this.setGo_y(this.getPositionY());

                    e.setHealth(e.getHealth() - this.attackPower);

                    System.out.println(e.getHealth());

                }
            }
        }

    }

    @Override
    public Integer getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(Integer attackPower) {
        this.attackPower = attackPower;
    }

    

    

}
