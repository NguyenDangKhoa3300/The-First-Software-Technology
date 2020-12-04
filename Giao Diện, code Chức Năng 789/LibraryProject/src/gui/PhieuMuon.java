package gui;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class PhieuMuon extends Application {
	@Override
	public void start(Stage myStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("PhieuMuonGD.fxml"));
		Scene scene = new Scene(root);
		myStage.setScene(scene);
		myStage.setTitle("Phiếu Mượn");
		myStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
