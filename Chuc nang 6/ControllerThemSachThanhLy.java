import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerThemSachThanhLy {

    @FXML
    private TextField textMaSach;

    @FXML
    private TextField textNgayThanhLy;

    @FXML
    private Button buttonThem;

    @FXML
    private Button buttonQuayLai;

    @FXML
    void listenerEvent(ActionEvent event) throws IOException {
       if (event.getSource() == buttonQuayLai) {
            Parent parent = FXMLLoader.load(getClass().getResource("thanhLySach.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Phiếu Thanh Lý Sách");
            stage.setScene(scene);
            stage.show();
        }     
    }

}
