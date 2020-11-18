
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class loginController {

    @FXML
    private TextField textTaiKhoan;

    @FXML
    private PasswordField textMatKhau;

    @FXML
    private Button butDangNhap;

    @FXML
    void EventListener(ActionEvent event) throws IOException {
        if (textTaiKhoan.getText().equalsIgnoreCase("khoa123") && textMatKhau.getText().equalsIgnoreCase("12303")) {
            Parent parent = FXMLLoader.load(getClass().getResource("LMS.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Quản Lý Thư Viện");
            stage.setScene(scene);
            stage.show();
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert!");
            alert.setHeaderText(null);
            alert.setContentText("Password incorect!");
            alert.showAndWait();
        }
    }
}
