package buildings;

import characters.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import main.Player;

public class Barracks extends Building {
    public Barracks(Integer health, Integer positionX, Integer positionY, Integer width, Integer length, Boolean doesExists, Player isEnemy, Integer timeToCreate, Image image) {
        super(health, positionX, positionY, width, length, doesExists, isEnemy, timeToCreate, image);
        this.setBounds(positionX,positionY,width,length);
        this.setOpaque(false);
    }
    
   
    public void createCharacter(String type) {
        if (type.equals("mg")){
            MachineGunner machinegunner = new MachineGunner(this.getPositionX()-50,this.getPositionY()-50, this.getIsEnemy());
       
        }
         if (type.equals("worker")){
            Worker worker = new Worker(this.getPositionX()-50,this.getPositionY()-50, this.getIsEnemy());
         }
         if (type.equals("tank")){
            Tank tank = new Tank(this.getPositionX()-50,this.getPositionY()-50, this.getIsEnemy());
         }
         if (type.equals("miner")){
            Miner miner = new Miner(this.getPositionX()-50,this.getPositionY()-50, this.getIsEnemy());
       
        }
    }
    

}