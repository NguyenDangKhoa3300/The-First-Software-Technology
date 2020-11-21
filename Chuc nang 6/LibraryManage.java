import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class LibraryManage extends Application{
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Đăng nhập");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
