public class Camera {
    private double x;
    private double y;
    private double a;
    private double v;
    private double dt;
    public Camera(double x,double y){
        this.x=x;
        this.y=y;
        this.dt=0.01;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void update(Hero hero){
        double m=1;
        double f=5;
        double k=f*f/4;
        a=k/m*(hero.getX()-x)-f/m*v;
        v=v+a*dt;
        x=x+v*dt;
        System.out.println(y);
    }

    @Override
    public String toString(){return x+","+y;}
}
