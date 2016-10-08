import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Demo extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        final FirmataSingleton firmataSingleton = FirmataSingleton.getInstance();

        final Button btn = new Button();
        btn.setText("Launcher");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                firmataSingleton.startDevice();
                firmataSingleton.setPin();
                firmataSingleton.loopAndCheck();
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Launcher");
        stage.setScene(scene);
        stage.show();
    }

}
