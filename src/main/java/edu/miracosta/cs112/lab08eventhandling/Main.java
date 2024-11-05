package edu.miracosta.cs112.lab08eventhandling;

//IMPORTED PACKAGES
import javafx.application.Application;  //abstract class used for JavaFX GUI's
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;              //class for GUI window
import javafx.scene.Scene;              //class for specific view in GUI window
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;        //class for layout pane, organized top-to-bottom
import javafx.scene.control.Label;      //class for label component
import javafx.scene.control.Button;     //class for button component
import javafx.event.EventHandler;       //interface for handling events
import javafx.event.ActionEvent;        //class for type of event for action (like button or key pressed)
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main extends Application {
    //CONSTANTS
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };

    //CLASS-LEVEL VARIABLES

    private int counter = 0;
    private LoteriaCard[] randomCards;

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
        LoteriaCard startupCard = new LoteriaCard();
        cardImageView = new ImageView(startupCard.getImage());
        cardImageView.setFitHeight(238);
        cardImageView.setPreserveRatio(true);

        //Shuffle Card
        randomCards = new LoteriaCard[LOTERIA_CARDS.length];
        randomCards = LOTERIA_CARDS.clone();
        List<LoteriaCard> list = Arrays.asList(randomCards);
        Collections.shuffle(list);
        list.toArray(randomCards);



        drawCardButton = new Button("Draw Random Card");
        drawCardButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent){
                    if(counter < randomCards.length){
                        cardImageView.setImage(randomCards[counter].getImage());
                        messageLabel.setText(randomCards[counter].getCardName());
                        gameProgressBar.setProgress((double) (counter +1) / LOTERIA_CARDS.length);

                    } else if (counter == randomCards.length) {
                        drawCardButton.setDisable(true);
                        cardImageView.setImage(startupCard.getImage());
                        gameProgressBar.setStyle("-fx-accent: red;");
                        messageLabel.setText("GAME OVER. No more cards! Exit and run program again to reset ^_^");
                    }
                    counter++;


                }
            }


        ); //Event handling

        titleLabel = new Label("Welcome to EChALE STEM Loteria!");
        titleLabel.setFont( new Font(20));

        messageLabel = new Label("Click the button to draw a random card." +
                " The progress bar shows how many more cards you can draw.");
        messageLabel.setWrapText(true);
        messageLabel.setTextAlignment(TextAlignment.CENTER);

        gameProgressBar = new ProgressBar();

        //Add

        VBox layout = new VBox(25);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.getChildren().addAll(titleLabel,cardImageView,messageLabel,drawCardButton,gameProgressBar);

        //Setup Scene And Show
        Scene primaryScene = new Scene(layout, 350,500);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("EChALE STEM LOTERIA");
        primaryStage.show();

    }

}
