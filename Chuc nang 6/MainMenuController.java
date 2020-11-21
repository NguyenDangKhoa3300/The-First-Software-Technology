import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private Button but1;

    @FXML
    private Button but2;

    @FXML
    private Button but3;

    @FXML
    private Button but4;

    @FXML
    private Button but5;

    @FXML
    private Button but6;

    @FXML
    private Button but7;

    @FXML
    private Button but8;

    @FXML
    private Button but9;

    @FXML
    void ListenerEventButtonMainMenu(ActionEvent event) throws IOException {
        if(event.getSource()==but8){
        Parent parent = FXMLLoader.load(getClass().getResource("thanhLySach.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Phiếu Thanh Lý Sách");
        stage.setScene(scene);
        stage.show();
        } else if(event.getSource()==but9){
        Parent parent = FXMLLoader.load(getClass().getResource("datSach.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Phiếu đặt sách");
        stage.setScene(scene);
        stage.show();
    }
    }
}
