import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThings {
    protected double x;
    protected double vx;
    protected double ax;
    protected double y;
    protected double vy;
    protected double ay;
    protected double dt;
    protected double g;
    private ImageView spriteAnimatedThings;
    protected int attitude;
    protected long index;
    protected int positionOnSpriteSheet;


    public AnimatedThings(String pictureAdress,double x,double y,int attitude,int index){
        this.x=x;
        this.y=y;
        Image spriteSheetAnimatedThings = new Image(pictureAdress);
        this.spriteAnimatedThings = new ImageView(spriteSheetAnimatedThings);
    }

    public ImageView getSpriteAnimatedThings() {
        return spriteAnimatedThings;
    }

    public void setX(double x) {
        this.x = x;
    }

    public long getIndex() {
        return index;
    }

    public double getX() {
        return x;
    }

    public double getY(){return y; }

    public int getAttitude() {
        if(attitude==0){
            return(0);
        }
        return(160);
    }
    public Rectangle2D getHitbox(){
        return(new Rectangle2D(x+5,y+5,spriteAnimatedThings.getViewport().getWidth()-10,spriteAnimatedThings.getViewport().getHeight()-10));
    }
}
