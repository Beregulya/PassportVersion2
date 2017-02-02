import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Passport {

    public static void openPassport(String name, Integer age, String country) {
        Stage passport = new Stage();

        passport.setTitle("Your Passport");
        passport.setResizable(false);

        Label welcome = new Label("Welcome, " + name);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.minWidth(300);

        Label ageLeft = new Label("Age:");
        ageLeft.setPadding(new Insets(15,20,15,20));
        pane.add(ageLeft, 0 , 0);
        pane.setHalignment(ageLeft, HPos.CENTER);

        Label countryLeft = new Label("Country:");
        countryLeft.setPadding(new Insets(15,20,15,20));
        pane.add(countryLeft, 0 , 1);
        pane.setHalignment(countryLeft, HPos.CENTER);

        Label ageRight = new Label(age.toString());
        ageRight.setPadding(new Insets(15,20,15,20));
        pane.add(ageRight, 1 , 0);
        pane.setHalignment(ageRight, HPos.CENTER);

        Label countryRight = new Label(country);
        countryRight.setPadding(new Insets(15,20,15,20));
        pane.add(countryRight, 1 , 1);
        pane.setHalignment(countryRight, HPos.CENTER);

        pane.setGridLinesVisible(true);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(welcome, pane);
        layout.setAlignment(Pos.CENTER);
        layout.minWidth(500);

        Scene scene = new Scene(layout);
        passport.setScene(scene);
        passport.show();
    }

}
