import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ControllerDangKyThe {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField dobTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField jobTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField cmndTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label textAddress;

    @FXML
    private Label testJob;

    @FXML
    private ToggleGroup sexButt;

    @FXML
    private Button butDangKy;

    @FXML
    private Button butQuayLai;

    @FXML
    void handleRegisteredButtonAction(ActionEvent event) throws IOException {
        if(event.getSource() == butQuayLai){
            Parent parent = FXMLLoader.load(getClass().getResource("LSM.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Library Management System");
            stage.setScene(scene);
            stage.show();
        }
    }

}
