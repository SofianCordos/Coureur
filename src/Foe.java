import javafx.geometry.Rectangle2D;


import java.util.Random;
import java.util.Random.*;

import java.util.ArrayList;
import java.util.Vector;

public class Foe extends AnimatedThings{
    public Foe(String pictureAdress, double x, double y, int attitude, int index){
        super(pictureAdress, x, y, attitude, index);
    }
    public void update(Camera camera1){
        if(x+163<camera1.getX()){
            Random rand = new Random();
            int r=rand.nextInt(800);
            this.x= camera1.getX()+800+r;
            System.out.println(this.x);


        }
        //getSpriteAnimatedThings().setViewport(new Rectangle2D(0,0,163,150));
    }
}
