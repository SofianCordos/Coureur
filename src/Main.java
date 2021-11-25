import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application{

    public void start(Stage primaryStage){
        primaryStage.setTitle("COUREUR");
        Group root = new Group();
        GameScene gameScene = new GameScene(root, 800, 400);

        //Image spriteSheetHero = new Image("C:\\Users\\Celestin\\IdeaProjects\\Coureur\\heros.png");
        //ImageView spriteHero = new ImageView(spriteSheetHero);

        //Image spriteSheetDesert = new Image("C:\\Users\\Celestin\\IdeaProjects\\Coureur\\desert.png");
        //ImageView spriteDesert = new ImageView(spriteSheetDesert);

        //spriteHero.setViewport(new Rectangle2D(20,0,65,100));
        //spriteHero.setX(200);
        //spriteHero.setY(250);
        root.getChildren().add(gameScene.getLeftBackground());
        root.getChildren().add(gameScene.getRightBackground());
        root.getChildren().add(gameScene.getHero());
        root.getChildren().add(gameScene.getFoe());
        root.getChildren().add(gameScene.getSpriteHearts());

        gameScene.displayWhatsOnScreen();
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}