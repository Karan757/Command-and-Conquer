package resources;

import java.awt.*;
import javax.accessibility.AccessibleContext;
import javax.swing.SwingUtilities;


public class Resource {

    private Integer amount;
    private Integer positionX;
    private Integer positionY;
    private Integer width;
    private Integer height;
    private Boolean doesExists;
    private Image image;

    public Resource() {}

    public Resource(Integer amount, Integer positionX, Integer positionY, Integer width, Integer height,
                    Boolean doesExists, Image image)
    {
        this.amount = amount;
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;
        this.doesExists = doesExists;
        this.image = image;
    }

    public void draw(Graphics g) {
        g.drawImage(image, positionX, positionY, width, height, null);
        //System.out.println("drawed");
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getDoesExists() {
        return doesExists;
    }

    public void setDoesExists(Boolean doesExists) {
        this.doesExists = doesExists;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    


}