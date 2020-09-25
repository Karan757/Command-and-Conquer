package main;

import java.util.ArrayList;

import buildings.*;
import characters.*;
import java.awt.Image;

public class Player {
    
  private ArrayList<Sprite> myCharacters;
  private ArrayList<Building> myBuildings;
  
  private Image soilderImage;
  private Image minerImage;
  private Image workerImage;
  private Image tankImage;
  private Image hqImage;
  private Image bImage;
  
  
  public Player() {
        this.myCharacters = new ArrayList<Sprite>();
        this.myBuildings = new  ArrayList<Building>();
      
    }

    public Player(Image s, Image m, Image c, Image sh, Image t) {
        this.myCharacters = new ArrayList<Sprite>();
        this.myBuildings = new  ArrayList<Building>();
        this.soilderImage =s;
        this.minerImage =m;
        this.hqImage =c;
        this.bImage =sh;
        this.tankImage=t;
    }

    public ArrayList<Sprite> getMyCharacters() {
        return myCharacters;
    }

    public void setMyCharacters(ArrayList<Sprite> myCharacters) {
        this.myCharacters = myCharacters;
    }

    public ArrayList<Building> getMyBuildings() {
        return myBuildings;
    }

    public void setMyBuildings(ArrayList<Building> myBuildings) {
        this.myBuildings = myBuildings;
    }
    public Image getSoilderImage() {
        return soilderImage;
    }
    public void setSoilderImage(Image soilderImage) {
        this.soilderImage = soilderImage;
    }
    public Image getMinerImage() {
        return minerImage;
    }
    public void setMinerImage(Image minerImage) {
        this.minerImage = minerImage;
    }
    public Image getHqImage() {
        return hqImage;
    }
    public void setHqImage(Image hqImage) {
        this.hqImage = hqImage;
    }
    public Image getbImage() {
        return bImage;
    }
    public void setbImage(Image bImage) {
        this.bImage = bImage;
    }
    public Image getWorkerImage() {
        return workerImage;
    }
    public void setWorkerImage(Image workerImage) {
        this.workerImage = workerImage;
    }
    public Image getTankImage() {
        return tankImage;
    }
    public void setTankImage(Image tankImage) {
        this.tankImage = tankImage;
    }

  
}