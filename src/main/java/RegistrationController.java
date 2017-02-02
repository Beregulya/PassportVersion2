import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationController {

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private TextField ageField;
    @FXML private TextField countryField;
    @FXML private Button submitButton;
    @FXML private Button closeButton;

    @FXML
    private void onActionSubmitButton() {
        try {
            Connection connection = Base.connectBase();
            PreparedStatement preparedStatement = connection.prepareStatement(Base.INSERT_NEW);
            preparedStatement.setInt(1, Base.getId());
            preparedStatement.setString(2, usernameField.getText());
            preparedStatement.setString(3, passwordField.getText());
            preparedStatement.setInt(4, Integer.parseInt(ageField.getText()));
            preparedStatement.setString(5, countryField.getText());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onActionCloseButton() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
