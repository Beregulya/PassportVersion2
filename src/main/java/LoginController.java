import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML private TextField nameField;
    @FXML private PasswordField passField;
    @FXML private Button logInButton;
    @FXML private Button signUpButton;

    @FXML
    public void onActionLogInButton() {
        Boolean correctPassword = false;
        String username = null;
        Integer age = null;
        String country = null;
        try {
            Connection connection = Base.connectBase();
            PreparedStatement preparedStatement = connection.prepareStatement(Base.SELECT_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                username = result.getString("username");
                String password = result.getString("password");
                age = result.getInt("age");
                country = result.getString("country");
                if (username.equals(nameField.getText()) && password.equals(passField.getText())) {
                    correctPassword = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (correctPassword) {
            Passport.openPassport(username, age, country);
            Stage old = (Stage) logInButton.getScene().getWindow();
            old.close();
        } else {
            passField.setText("");
            passField.setPromptText("INCORRECT PASSWORD");
        }
    }

    @FXML
    public void onActionSignUpButton() {
        try {
            Stage registration = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("registration_form.fxml"));
            registration.setTitle("Registration");
            registration.setResizable(false);
            registration.initModality(Modality.APPLICATION_MODAL);
            registration.setScene(new Scene(root));
            registration.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
