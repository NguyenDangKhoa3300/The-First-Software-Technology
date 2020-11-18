import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class DatSachController {

    @FXML
    private TableView<?> table;

    @FXML
    private Button butThemSach;

    @FXML
    private Button butPrint;

    @FXML
    private Button butBack;

    @FXML
    private Label lab1;

    @FXML
    void listenerEventButton(ActionEvent event) throws IOException {
        if(event.getSource()==butBack){
            Parent parent = FXMLLoader.load(getClass().getResource("LMS.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Library Management System");
            stage.setScene(scene);
            stage.show();
        }else if(event.getSource() == butThemSach){
            Parent parent = FXMLLoader.load(getClass().getResource("themSachDat.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Library Management System");
            stage.setScene(scene);
            stage.show();
        }
    }

}
