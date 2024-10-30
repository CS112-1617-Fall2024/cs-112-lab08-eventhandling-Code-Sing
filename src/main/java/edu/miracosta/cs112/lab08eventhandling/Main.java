package edu.miracosta.cs112.lab08eventhandling;

//IMPORTED PACKAGES
import javafx.application.Application;  //abstract class used for JavaFX GUI's
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;              //class for GUI window
import javafx.scene.Scene;              //class for specific view in GUI window
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;        //class for layout pane, organized top-to-bottom
import javafx.scene.control.Label;      //class for label component
import javafx.scene.control.Button;     //class for button component
import javafx.event.EventHandler;       //interface for handling events
import javafx.event.ActionEvent;        //class for type of event for action (like button or key pressed)


public class Main extends Application implements EventHandler<ActionEvent> {
    //CONSTANTS
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };

    //CLASS-LEVEL VARIABLES

    //GUI COMPONENTS

    private Button drawCardButton;
    private Label titleLabel, messageLabel;
    private ProgressBar gameProgressBar;
    private ImageView cardImageView;


    //GUI METHODS

    //Driver
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Setup
        drawCardButton = new Button("drawCardButton");
        titleLabel = new Label("titleLabel");
        //titleLabel.setAlignment(Pos.TOP_CENTER);
        messageLabel = new Label("messageLabel");
        gameProgressBar = new ProgressBar();
        cardImageView = new ImageView(LOTERIA_CARDS[1].getImage());
        cardImageView.setFitHeight(238);
        cardImageView.setFitWidth(188);

        //Add

        VBox layout = new VBox(25);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.getChildren().addAll(titleLabel,cardImageView,messageLabel,gameProgressBar);

        //Setup Scene And Show
        Scene primaryScene = new Scene(layout, 300,500);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Loteria Night");
        primaryStage.show();

    }

    @Override
    public void handle(ActionEvent actionEvent){

    }
}
