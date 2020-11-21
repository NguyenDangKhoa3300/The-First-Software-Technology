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

public class ThemSachDatController {

    @FXML
    private TextField textfieldThem;

    @FXML
    private TextField textfieldTheLoai;

    @FXML
    private TextField textfieldNamXB;

    @FXML
    private TextField textfieldNXB;

    @FXML
    private TextField textfieldSoLuong;

    @FXML
    private TextField textfieldDonGia;

    @FXML
    private Button butQuayLai;

    @FXML
    private Button butLuu;

    @FXML
    void listenerEventButton(ActionEvent event) throws IOException {
            if (event.getSource() == butQuayLai) {
            Parent parent = FXMLLoader.load(getClass().getResource("datSach.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Phiếu đặt sách");
            stage.setScene(scene);
            stage.show();
        }     
    }

}
