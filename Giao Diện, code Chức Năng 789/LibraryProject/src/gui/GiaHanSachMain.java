package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GiaHanSachMain extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage myStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("GiaHanSachController.fxml"));
		Scene scene = new Scene(root);
		myStage.setScene(scene);
		myStage.setTitle("Gia Hạn Sách");
		myStage.show();

		
	}

}
