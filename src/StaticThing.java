import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    private double x;
    private double y;
    private ImageView spriteStaticThing;
    public StaticThing(double x,double y,String pictureAdress){
        this.x=x;
        this.y=y;
        Image spriteSheetStaticThing = new Image(pictureAdress);
        this.spriteStaticThing = new ImageView(spriteSheetStaticThing);
    }

    public ImageView getSpriteStaticThing() {
        return spriteStaticThing;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
