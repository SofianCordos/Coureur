import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThings{

    public Hero(String pictureAdress, double x, double y, int attitude, int index) {
        super(pictureAdress, x, y, attitude, index);
        vx=300; //valeur initiale de la vitesse pour que le démarrage du jeu ne soit pas trop lent
        g=500; //On est sur une grosse planète
        attitude=0;
    }
    public void update(){
        index++;
        dt=0.01;
        double m=1;
        double f=5;
        double k=f*f/4;
        ax=5;
        vx=vx+ax*dt;
        x=x+vx*dt;
        vy=vy+ay*dt;
        y=y+vy*dt;
        if(y>=250){
            y=250;
            vy=0;
            attitude=0;
        }
        if(y<250){
            attitude=1;
        }

        //System.out.println(y);
        getSpriteAnimatedThings().setViewport(new Rectangle2D(getPositionOnSpriteSheet(),getAttitude(),76,100));
        ay=g; // dans ce jeu l'axe des y est descendant, d'ou une gravité positive
    }
    public int getPositionOnSpriteSheet() {
        if (y == 250) {
            if ((index / 20) % 6 == 0) {
                return (20);
            }
            if ((index / 20) % 6 == 1) {
                return (20 + 75);
            }
            if ((index / 20) % 6 == 2) {
                return (174);
            }
            if ((index / 20) % 6 == 3) {
                return (255);
            }
            if ((index / 20) % 6 == 4) {
                return (335);
            }
            return (425);
        }

        if (vy >= 0) {
            return (95);
        }
        return (20);
    }
    public void jump(){
        if(y==250){
            ay=-40000;
        }
    }
}
