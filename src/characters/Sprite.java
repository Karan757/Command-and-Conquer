package characters;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JButton;
import main.Player;
import buildings.Building;

public class Sprite extends JButton {

    private Integer health;
    private Integer positionX;
    private Integer positionY;
    private Integer width;
    private Integer height;
    private Integer velocityX;
    private Integer velocityY;
    private Integer go_x;
    private Integer go_y;
    private Player isEnemy;
    private Integer timeToCreate;
    private Image image;
   private boolean isAttacking = false;
   

    public Sprite() {
    }

    ;

   public Sprite(Integer positionX, Integer positionY, Player isEnemy) {
        this.health = 100;
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = 40;
        this.height = 60;
        this.velocityX = 0;
        this.velocityY = 0;
        this.go_x = positionX;
        this.go_y = positionY;
        this.isEnemy = isEnemy;
        isEnemy.getMyCharacters().add(this);
        //System.out.println("added to array");
        this.timeToCreate = 5;
        
        

        this.setBounds(this.getPositionX(), this.getPositionY(), this.getCWidth(), this.getCHeight());
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
    }

    /**
     * sup
     *
     * @param a
     * @param b
     */
    public void moveC(int a, int b) {

        if (this.getPositionX() == a) {
            this.setVelocityX(0);

        } else {
            this.setVelocityX(1);
        }
        if (this.getPositionY() == b) {
            this.setVelocityY(0);

        } else {
            this.setVelocityY(1);
        }

        if (a > this.positionX) {
            this.setPositionX(this.getPositionX() + this.getVelocityX());

        }
        if (a < this.positionX) {
            this.setPositionX(this.getPositionX() - this.getVelocityX());
        }

        if (b > this.positionY) {
            this.setPositionY(this.getPositionY() + this.getVelocityY());
        }
        if (b < this.positionY) {
            this.setPositionY(this.getPositionY() - this.getVelocityY());
        }

        this.setBounds(this.getPositionX(), this.getPositionY(), this.getCWidth(), this.getCHeight());

    }

     public void collides(Sprite other) /*throws InterruptedException*/ {
        Rectangle rect = new Rectangle(positionX, positionY, width, height);
        Rectangle otherRect = new Rectangle(other.positionX, other.positionY, other.getWidth(), other.getHeight());

        if(rect.intersects(otherRect)){
         if(this.velocityX != 0){
             if(this.velocityY == 0){
            if (other.positionX > this.positionX){
                this.positionY -=5;
                other.react();
            }
            if (other.positionX <= this.positionX){
                this.positionY +=5;
            other.react();
            }
             }
         }
         if(this.velocityY != 0){
             if(this.velocityX  == 0){
            if (other.positionY > this.positionY){
                this.positionX -=5;
            other.react();
            }
            if (other.positionY <= this.positionY){
                this.positionX +=5;
            other.react();
            }
             }
         }
         
         
         
     }
    }

    public void collidesBuilding(Building other) {
        Rectangle rect = new Rectangle(positionX, positionY, width, height);
        Rectangle otherRect = new Rectangle(other.getPositionX(), other.getPositionY(), other.getWidth(), other.getHeight());
        if (rect.intersects(otherRect)) {
            if (this.velocityX != 0) {
                if (this.velocityY == 0) {
                    if (other.getPositionX() > this.positionX) {
                        this.positionX -= 5;
                    }
                    if (other.getPositionX() <= this.positionX) {
                        this.positionX += 5;
                    }
                }
            }
            if (this.velocityY != 0) {
                if (this.velocityX == 0) {
                    if (other.getPositionY() > this.positionY) {
                        this.positionY -= 5;
                    }
                    if (other.getPositionY() <= this.positionY) {
                        this.positionY += 5;
                    }
                }
            }
        }
    }

    public void react() {

    }

        public void increaseHealth(int amount) {
        setHealth(health + amount);
    }
   

    public void draw(Graphics g) {     
            g.drawImage(image, positionX, positionY, width, height, null);
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public Integer getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(Integer velocityX) {
        this.velocityX = velocityX;
    }

    public Integer getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(Integer velocityY) {
        this.velocityY = velocityY;
    }

    public Integer getGo_x() {
        return go_x;
    }

    public void setGo_x(Integer go_x) {
        this.go_x = go_x;
    }

    
    public void setWidth(Integer width) {
        this.width = width;
    }

    
    public int getCWidth() {
        return this.width;
    }

    public int getCHeight() {
        return this.height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getGo_y() {
        return go_y;
    }

    public void setGo_y(Integer go_y) {
        this.go_y = go_y;
    }

    public Player getIsEnemy() {
        return isEnemy;
    }

    public void setIsEnemy(Player isEnemy) {
        this.isEnemy = isEnemy;
    }

    public Integer getTimeToCreate() {
        return timeToCreate;
    }

    public void setTimeToCreate(Integer timeToCreate) {
        this.timeToCreate = timeToCreate;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {

        this.image = image;
       
    }

    public Integer getAttackPower() {
        return 0;
    }

    public boolean isIsAttacking() {
        return isAttacking;
    }

    public void setIsAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
    }
    
    

    public boolean isAlive() {
        if (this.health < 1) {
            return false;
        } else {
            return true;
        }
    }

}
