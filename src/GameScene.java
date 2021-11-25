import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import java.util.Random;
import javafx.scene.image.Image;



import java.util.ArrayList;
import java.util.Vector;



public class GameScene extends Scene {
    private Camera camera1;
    private StaticThing leftBackground;
    private StaticThing rightBackground;
    private Hero hero;
    private AnimationTimer timer;
    public int incrementHero;
    private Foe foe;
    private int numberOfLives;
    private ImageView spriteHearts;
    private int invincible;
    private double invincibiltyTime;
    private ImageView spriteGameOver;

    Random rand = new Random();



    public GameScene(Group root, double width, double height) {
        super(root, width, height);
        this.numberOfLives=3;
        this.invincible=0;
        this.invincibiltyTime=100;
        Image spriteSheetHearts = new Image("hearts_3.png");
        this.spriteHearts = new ImageView(spriteSheetHearts);
        Image spriteSheetGameOver = new Image("GameOver.png");
        this.spriteGameOver = new ImageView(spriteSheetGameOver);
        this.foe = new Foe("AngryBuffCactus2.png",800+rand.nextInt(800),250,0,0);
        this.leftBackground = new StaticThing(0,0,"desert.png");
        this.rightBackground = new StaticThing(800,0,"desert.png");
        this.hero = new Hero("heros.png",250,0,0,0);
        this.camera1 = new Camera(0,0);
        this.incrementHero=0;
        timer = new AnimationTimer() {
            @Override
            public void handle(long time) {
                camera1.update(hero);
                incrementHero++;
                hero.update();
                foe.update(camera1);
                if(invincible==0){
                    if(hero.getHitbox().intersects(foe.getHitbox())){
                        numberOfLives--;
                        System.out.println("OUÏE");
                        invincible=1;
                        System.out.println("INVINCIBLE");
                    }
                }
                if(invincible==1){
                    invincibiltyTime--;
                    if(invincibiltyTime<=0){
                        invincibiltyTime=100;
                        invincible=0;
                        System.out.println("PLUS INVINCIBLE");
                    }
                }
                if(numberOfLives==0){
                    root.getChildren().add(spriteGameOver);
                    timer.stop();
                }



                leftBackground.getSpriteStaticThing().setViewport(new Rectangle2D(camera1.getX()%800,0,800-(camera1.getX())%800,400));
                rightBackground.getSpriteStaticThing().setViewport(new Rectangle2D(0,0,camera1.getX()%800,400));
                rightBackground.getSpriteStaticThing().setX(800-camera1.getX()%800);
                //hero.getSpriteAnimatedThings().setViewport(new Rectangle2D(hero.getPositionOnSpriteSheet(),0,76,100));
                hero.getSpriteAnimatedThings().setX(hero.getX()-camera1.getX());
                hero.getSpriteAnimatedThings().setY(hero.getY()-camera1.getY());
                foe.getSpriteAnimatedThings().setX(foe.getX()-camera1.getX()); //ou on va afficher le cactus
                foe.getSpriteAnimatedThings().setY(220);
                spriteHearts.setViewport(new Rectangle2D((3-numberOfLives)*48,0,48,48));
                spriteHearts.setX(0);
                spriteHearts.setY(0);
                spriteGameOver.setViewport(new Rectangle2D(0,0,0,0));
                spriteGameOver.setX((800-300)/2);
                spriteGameOver.setY((400-300)/2);


            }
        };
        root.setOnMouseClicked((event)->{
            System.out.println("SAUTE SAUTE");
            hero.jump();
        });
        timer.start();
    }

    public void displayWhatsOnScreen(){
        double camX=camera1.getX();
        leftBackground.getSpriteStaticThing().setViewport(new Rectangle2D(camX%800,0,800-camX%800,400));
        leftBackground.getSpriteStaticThing().setX(0);
        rightBackground.getSpriteStaticThing().setViewport(new Rectangle2D(0,0,camX%800,400));
        rightBackground.getSpriteStaticThing().setX(800-camX%800);

        hero.getSpriteAnimatedThings().setViewport(new Rectangle2D(hero.getPositionOnSpriteSheet(),0,76,100));
        foe.getSpriteAnimatedThings().setViewport(new Rectangle2D(0,0,163,150));

    }


    public ImageView getLeftBackground() {
        return leftBackground.getSpriteStaticThing();
    }
    public ImageView getRightBackground(){return rightBackground.getSpriteStaticThing();}
    public ImageView getHero(){return hero.getSpriteAnimatedThings();}
    public ImageView getFoe(){return foe.getSpriteAnimatedThings();}
    public ImageView getSpriteHearts(){return spriteHearts;}


}
