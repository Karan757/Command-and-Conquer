package buildings;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import main.Player;
import resources.*;



public class Building extends JPanel{
    
    private Integer health;
    private Integer positionX;
    private Integer positionY;
    private Boolean doesExists;
    private Player isEnemy;
 
    private Integer timeToCreate;
    private Integer width;
    private Integer length;
    private Image image;
    
    
    public Building (Integer health, Integer positionX, Integer positionY, Integer width, Integer length, Boolean doesExists, Player isEnemy, Integer timeToCreate, Image image) {
        this.health=health;
        this.positionX = positionX;
        this.positionY = positionY;
        this.doesExists = doesExists;
        this.isEnemy = isEnemy;
        isEnemy.getMyBuildings().add(this);
        this.timeToCreate = timeToCreate;
        this.width = width;
        this.length = length;
        this.image = image;
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

    public Boolean getDoesExists() {
        return doesExists;
    }

    public void setDoesExists(Boolean doesExists) {
        this.doesExists = doesExists;
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
    public void draw(Graphics g) {
        g.drawImage(image, positionX, positionY, width, length, null);
    }
    
    public boolean isAlive() {
    if(this.health < 1){
       return false;
    }else{
        return true;
    }
    }
      
}