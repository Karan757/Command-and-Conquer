package main;

import resources.*;
import characters.*;
import buildings.*;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;

public class GameEngine extends JPanel {

    private boolean newChAdded = false;
    private boolean newBAdded = false;
    private boolean paused = false;

    private final int FPS = 60;

     private Image sold1= new ImageIcon("data/images/sold1.png").getImage();
     private Image sold2 = new ImageIcon("data/images/sold2.png").getImage();
     
    private Image minerImageb= new ImageIcon("data/images/miner.gif").getImage();
    private Image hqimage1 = new ImageIcon("data/images/hq1.png").getImage();
    private Image bimage1 = new ImageIcon("data/images/barracks2.png").getImage();
    private Image timage1 = new ImageIcon("data/images/tank2.png").getImage();

    private Image minerImager= new ImageIcon("data/images/miner.gif").getImage();
    private Image workerImager = new ImageIcon("data/images/workerred.gif").getImage();
    private Image hqimage2 = new ImageIcon("data/images/hq2.png").getImage();
    private Image bimage2 = new ImageIcon("data/images/barracks1.png").getImage();
    private Image timage2 = new ImageIcon("data/images/tank1.png").getImage();
     

    protected Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private JPanel hqMenu, barrackMenu;
    private Image background;

    private Sprite tmp = null;
    private Building tmpBuilding = null;
    private Label jCrystal = new Label();

    protected Player me = new Player(sold1, minerImageb,  hqimage1, bimage1 , timage1);
    private Point player1Position = new Point();

    protected Player enemy = new Player(sold2, minerImager, hqimage2, bimage2, timage2 );
    private Point player2Position = new Point();

    protected Player current = new Player();

    private HeadQuarter hq, hqenemy, currenthq;

    private int mx, my;
    private int vel = 1;
    private int scrollX, scrollY = 0;
    private int imageX = 2600, imageY = 1500;
    private int maxScrollX = imageX - screenSize.width, maxScrollY = imageY - screenSize.height;
    private int constantMove = 5;
    private int mapWidth = 400, mapHeight = 231;
    private int widhtOfMenue = screenSize.width - 600 - mapWidth - 50;

    private ArrayList<Resource> resources = new ArrayList<>(); //added array for reso

    

   
    

    public GameEngine() throws IOException {
        super();
        Timer newFrameTimer;
        Image rockImage;
        Barracks barracks, barrackse;

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "pressed left");
        this.getActionMap().put("pressed left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < constantMove; i++) {
                    if (scrollX < 0) {
                        scrollX += 1;
                        repaint(-scrollX + 50, -scrollY, 1, 1);
                    }
                }
            }
        });
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "pressed right");
        this.getActionMap().put("pressed right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < constantMove; i++) {
                    if (scrollX > -maxScrollX) {
                        scrollX -= 1;
                        repaint(-scrollX + 50, -scrollY, 1, 1);
                    }
                }
            }
        });

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "pressed up");
        this.getActionMap().put("pressed up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < constantMove; i++) {
                    if (scrollY < 0) {
                        scrollY += 1;
                        repaint(-scrollX + 50, -scrollY, 10, 10);
                    }
                }
            }
        });
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "pressed down");
        this.getActionMap().put("pressed down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < constantMove; i++) {
                    if (scrollY > -maxScrollY) {
                        scrollY -= 1;
                        repaint(-scrollX + 50, -scrollY, 1, 1);
                    }
                }
            }
        });
        current = me;
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("1"), "pressed 1");
        this.getActionMap().put("pressed 1", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                current = me;
                currenthq = hq;
            }
        });
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("2"), "pressed 2");
        this.getActionMap().put("pressed 2", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                current = enemy;
                currenthq = hqenemy;
            }
        });
        background = new ImageIcon("data/images/background.jpg").getImage();
        rockImage = ImageIO.read(new File("data/images/rock.png"));
 

        player1Position.setLocation(100,70);
        player2Position.setLocation(2300,70);

   

        hqMenu = new JPanel();
        hqMenu.setLayout(new GridLayout(6, 1));
        hqMenu.setBounds(screenSize.width - widhtOfMenue, 0, widhtOfMenue, screenSize.height);
        hqMenu.setBorder(new LineBorder(Color.black, 3));
        hqMenu.setBackground(Color.GRAY);
        hqMenu.setVisible(false);
        hqMenu.add(jCrystal);
        this.add(hqMenu);
        barrackMenu = new JPanel();
        barrackMenu.setLayout(new GridLayout(6, 1));
        barrackMenu.setBounds(screenSize.width - widhtOfMenue, 0, widhtOfMenue, screenSize.height);
        barrackMenu.setBorder(new LineBorder(Color.black, 3));
        barrackMenu.setBackground(Color.GRAY);
        barrackMenu.setVisible(false);
        JButton createMachineGunner = new JButton("Create MachineGunner");
        JButton createTank = new JButton("Create Tank");
        JButton createMiner = new JButton("Create Miner");
        barrackMenu.add(createMachineGunner);
        barrackMenu.add(createTank);
        barrackMenu.add(createMiner);
        createMachineGunner.addMouseListener(new NewMouseListener("createMachineGunner"));
        createTank.addMouseListener(new NewMouseListener("createTank"));
        createMiner.addMouseListener(new NewMouseListener("createMiner"));
        this.add(barrackMenu);

        

        hq = new HeadQuarter(100, player1Position.x, player1Position.y, 300, 300, true, me,
                10, hqimage1);
        barracks = new Barracks(100, player1Position.x+450, player1Position.y+20,
                300, 200, true, me,
                10, bimage1);
        hqenemy = new HeadQuarter(100, player2Position.x, player2Position.y, 300, 300, true,
                enemy, 10, hqimage2);
        barrackse = new Barracks(100, player2Position.x-450, player2Position.y+20,
                300, 200, true, enemy,
                10, bimage2);
        currenthq = hq;


        //Resorce
        Crystal c1Resource;
        Crystal c2Resource;
        Crystal c3Resource;
        Crystal c4Resource;
        Crystal c5Resource;
 

        c1Resource = new Crystal(1000, 800, 900, 90, 60, true, rockImage);
        c2Resource = new Crystal(1000, 1000, 900, 90, 60, true, rockImage);
        c3Resource = new Crystal(1000, 1650, 1000, 90, 60, true, rockImage);
        c4Resource = new Crystal(1000, 2000, 800, 90, 60, true, rockImage);
        c5Resource = new Crystal(1000, 760, 370, 90, 60, true, rockImage);
 

        resources.add(c1Resource);
        resources.add(c2Resource);
        resources.add(c3Resource);
        resources.add(c4Resource);
        resources.add(c5Resource);
 


        this.add(hq);
        this.add(hqenemy);

        this.add(barracks);
        this.add(barrackse);


        for (int i = me.getMyCharacters().size()-1; i >= 0; i--) {
            me.getMyCharacters().get(i).addMouseListener(new NewMouseListener("click" + String.valueOf(i)));
        }

        this.addMouseListener(new NewMouseListener("this"));
        for (int i = me.getMyBuildings().size()-1; i >= 0; i--) {
            if (me.getMyBuildings().get(i) instanceof Barracks) {
                me.getMyBuildings().get(i).addMouseListener(new NewMouseListener("B" + String.valueOf(i)));
            }
        }

        for (int i = enemy.getMyCharacters().size()-1; i >= 0; i--) {
            enemy.getMyCharacters().get(i).addMouseListener(new NewMouseListener("click" + String.valueOf(i)));
        }

        for (int i = enemy.getMyBuildings().size()-1; i >= 0; i--) {
            if (enemy.getMyBuildings().get(i) instanceof Barracks) {
                enemy.getMyBuildings().get(i).addMouseListener(new NewMouseListener("B enemy" + String.valueOf(i)));
            }
        }

        hq.addMouseListener(new NewMouseListener("click hq"));
        hqenemy.addMouseListener(new NewMouseListener("click hq enemy"));
        //soldierHouse.addMouseListener(new NewMouseListener("click soldierHouse"));
        newFrameTimer = new Timer(1000 / FPS, new NewFrameListener("frame"));
        newFrameTimer.start();
        //System.out.println(screenSize.width + " width");

    }

    public void putInThis(Sprite ch) {
        this.add(ch);
    }

    public void putInThis(Building b) {
        this.add(b);
    }


    @Override
    protected void paintComponent(Graphics grphcs) {
        //grphcs.dispose();

        super.paintComponent(grphcs);
        if (!paused){
            //System.out.println("Iteration");
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.drawImage(background, 0, 0, imageX, imageY, null);
            if (!hq.isAlive()){
                paused = true;
                showTheWinner(2);
                //System.out.println("Done");
            }
            else if (!hqenemy.isAlive()){
                paused = true;
                showTheWinner(1);
            }
            
            for (int i = me.getMyCharacters().size()-1; i >= 0; i--) {
                // me.getMyCharacters().get(i).addMouseListener(new NewMouseListener("click" + String.valueOf(i)));
                if (me.getMyCharacters().get(i).isAlive()) {
                    me.getMyCharacters().get(i).draw(g2);
                    //System.out.println("drawn" + i);
                } else {
                    this.remove(me.getMyCharacters().get(i));
                    //me.getMyCharacters().remove(me.getMyCharacters().get(i));
                    //size = me.getMyCharacters().size();
                }
            }
            for (int i = enemy.getMyCharacters().size()-1; i >= 0; i--) {
                //enemy.getMyCharacters().get(i).addMouseListener(new NewMouseListener("click" + String.valueOf(i)));
                if (enemy.getMyCharacters().get(i).isAlive()) {
                    enemy.getMyCharacters().get(i).draw(g2);
                } else {
                    this.remove(enemy.getMyCharacters().get(i));
                    //enemy.getMyCharacters().remove(enemy.getMyCharacters().get(i));
                    //sizeEnemy = enemy.getMyCharacters().size();
                }
            }

            //int buidlingsSize = me.getMyBuildings().size();
            for (int i = me.getMyBuildings().size()-1; i >= 0; i--) {
                if (me.getMyBuildings().get(i).isAlive()) {
                    me.getMyBuildings().get(i).draw(g2);
                }
                else {
                    this.remove(me.getMyBuildings().get(i));
                    //me.getMyBuildings().remove(me.getMyBuildings().get(i));
                }

            }
            //buidlingsSize = enemy.getMyBuildings().size();
            for (int i = enemy.getMyBuildings().size()-1; i >= 0; i--) {
                if (enemy.getMyBuildings().get(i).isAlive()) {
                    enemy.getMyBuildings().get(i).draw(g2);
                }
                else {
                    this.remove(enemy.getMyBuildings().get(i));
                    //enemy.getMyBuildings().remove(enemy.getMyBuildings().get(i));
                }
            }
            for (int i = resources.size()-1; i >= 0; i--) {
                resources.get(i).draw(g2);
            }

            
            this.setLocation(scrollX, scrollY);
           
            hqMenu.setLocation(screenSize.width - widhtOfMenue - scrollX, -scrollY);
            barrackMenu.setLocation(screenSize.width - widhtOfMenue - scrollX, -scrollY);
        }
    }

    class NewFrameListener implements ActionListener {

        private final String choice;

        public NewFrameListener(String dir) {

            this.choice = dir;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (!paused){
                if (choice.equals("frame")) {
                    repaint(-scrollX, -scrollY, 10, 10);
                }
                if (choice.equals("menue")) {
                    if (hqMenu.getWidth() != 0) {
                        hqMenu.setBounds(screenSize.width - 400, 0, 400, screenSize.height);
                    }
                }

                if (choice.equals("soldierMenu")) {
                    if (barrackMenu.getWidth() != 0) {
                        barrackMenu.setBounds(screenSize.width - 400, 0, 400, screenSize.height);
                    }
                }
      
                if (newChAdded) {
                    current.getMyCharacters().get(current.getMyCharacters().size() - 1).addMouseListener
                            (new NewMouseListener("click" + String.valueOf(current.getMyCharacters().size() - 1)));
                    newChAdded = false;
                }
                if (newBAdded) {
                    if (current.getMyBuildings().get(current.getMyBuildings().size() - 1) instanceof Barracks) {
                        current.getMyBuildings().get(current.getMyBuildings().size() - 1).addMouseListener
                                (new NewMouseListener("B" + String.valueOf(current.getMyBuildings().size() - 1)));
                        newBAdded = false;
                    }
                }
                for (int i = me.getMyCharacters().size()-1; i >= 0; i--) {
                    me.getMyCharacters().get(i).moveC(me.getMyCharacters().get(i).getGo_x(),
                            me.getMyCharacters().get(i).getGo_y());
                }
                for (int i = enemy.getMyCharacters().size()-1; i >= 0; i--) {
                    enemy.getMyCharacters().get(i).moveC(enemy.getMyCharacters().get(i).getGo_x(),
                            enemy.getMyCharacters().get(i).getGo_y());
                }
                
                int sizeEnemy = 0;
                Player enemyPlayer = new Player();
                if (current == me) {
                    sizeEnemy = enemy.getMyCharacters().size();
                    enemyPlayer = enemy;
                } else {
                    sizeEnemy = me.getMyCharacters().size();
                    enemyPlayer = me;
                }
                for (int i = current.getMyCharacters().size()-1; i >= 0; i--) {
                    for (int j = 0; j < sizeEnemy; j++) {
                        current.getMyCharacters().get(i).collides(enemyPlayer.getMyCharacters().get(j));
                    }
                    if (current.getMyCharacters().get(i) instanceof MachineGunner) {
                        for (int j = 0; j < sizeEnemy; j++) {
                            ((MachineGunner) current.getMyCharacters().get(i)).attack(enemyPlayer.getMyCharacters().get(j));
                        }
                    }
                    if (current.getMyCharacters().get(i) instanceof MachineGunner) {
                        for (int j = enemyPlayer.getMyBuildings().size()-1; j >= 0; j--) {
                            ((MachineGunner) current.getMyCharacters().get(i)).attackBuilding(enemyPlayer.getMyBuildings().get(j));
                        }
                    }
                    if (current.getMyCharacters().get(i) instanceof Miner) {
                        for (int k = resources.size()-1; k >= 0; k--) {
                            if (((Miner) current.getMyCharacters().get(i)).mining(resources.get(k))) {
                                currenthq.setCrystal(currenthq.getCrystal() + 1);
                            }
                        }
                    }
                    for (int j = current.getMyCharacters().size()-1; j >= 0; j--) {
                        if (current.getMyCharacters().get(i) != current.getMyCharacters().get(j)) {
                            current.getMyCharacters().get(i).collides(current.getMyCharacters().get(j));
                        }
                    }
                    for (int j = current.getMyBuildings().size()-1; j >= 0; j--) {
                        current.getMyCharacters().get(i).collidesBuilding(current.getMyBuildings().get(j));
                    }
                    current.getMyCharacters().get(i).collidesBuilding(currenthq);
                    current.getMyCharacters().get(i).collidesBuilding(hq);

                    repaint(-scrollX + 50, -scrollY, screenSize.width, screenSize.height);
                }

                
                jCrystal.setText(currenthq.getCrystal() + " of crystal,");
      

            }
        }
    }

    class NewMouseListener implements MouseListener {

        private final String choice;

        public NewMouseListener(String dir) {

            this.choice = dir;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (!paused){
                //System.out.println("Clicked" + choice);

                if (choice.equals("click hq")) {
                    if (current == me) {
                        tmpBuilding = currenthq;
                        tmp = null;
                    }
                }
                if (choice.equals("click hq enemy")) {
                    if (current == enemy) {
                        tmpBuilding = currenthq;
                        tmp = null;
                    }
                }
                for (int i = current.getMyBuildings().size()-1; i >= 0; i--) {
                    if (choice.equals("B" + String.valueOf(i))) {
                        if (current == me){
                            tmpBuilding = current.getMyBuildings().get(i);
                            tmp = null;
                        }
                    }
                    if (choice.equals("B enemy" + String.valueOf(i))) {
                        if (current == enemy){
                            tmpBuilding = current.getMyBuildings().get(i);
                            tmp = null;
                        }
                    }
                }

                if (choice.equals("createMachineGunner")) {
                    Barracks tmpsh = (Barracks) tmpBuilding;
                    tmpsh.createCharacter("mg");

                    putInThis(current.getMyCharacters().get(current.getMyCharacters().size() - 1));
                    newChAdded = true;
                }

                
                if (choice.equals("createTank")) {
                    Barracks tmpsh = (Barracks) tmpBuilding;
                    tmpsh.createCharacter("tank");

                    putInThis(current.getMyCharacters().get(current.getMyCharacters().size() - 1));
                    newChAdded = true;
                }
                if (choice.equals("createMiner")) {
                    Barracks tmpsh = (Barracks) tmpBuilding;
                    tmpsh.createCharacter("miner");

                    putInThis(current.getMyCharacters().get(current.getMyCharacters().size() - 1));
                    newChAdded = true;
                }

                if (choice.equals("this")) {
                    tmpBuilding = null;

                    boolean right = SwingUtilities.isRightMouseButton(e);
                    if (right) {
                        if (tmp != null) {

                            mx = e.getX() - tmp.getWidth() / 2;
                            my = e.getY() - tmp.getHeight() / 2;
                            //System.out.println(mx);
                            tmp.setVelocityX(vel);
                            tmp.setVelocityY(vel);
                            tmp.setGo_x(mx);
                            tmp.setGo_y(my);

                        }

                    } else {
                        tmp = null;
                    }
                }

                for (int i = current.getMyCharacters().size()-1; i >= 0; i--) {
                    if (choice.equals("click" + String.valueOf(i))) {
                        tmpBuilding = null;
                        tmp = current.getMyCharacters().get(i);
                        tmp.setBorder(new LineBorder(Color.BLUE));
                        tmp.setBorderPainted(true);
                        tmp.setVelocityX(0);
                        tmp.setVelocityY(0);

                    } else if (tmp != current.getMyCharacters().get(i)) {

                        current.getMyCharacters().get(i).setBorderPainted(false);
                    }

                }
                if (tmpBuilding != null) {
                    if (tmpBuilding == currenthq) {
                        hqMenu.setVisible(true);
                    }
                    if (tmpBuilding instanceof Barracks) {
                        barrackMenu.setVisible(true);
                    }
                } else {
                    hqMenu.setVisible(false);
                    barrackMenu.setVisible(false);
                }

                 

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    

    public void showTheWinner(int player){
        //pause();
        String winningText="";
        int n = JOptionPane.showConfirmDialog(
                this,
                winningText + "Player " + player + " won.",
                "You Won",
                JOptionPane.YES_OPTION);
        if (n==0){
            exit(1);
        }
        else{
            exit(1);
        }
    }

}
