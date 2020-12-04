package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.DBConnect;
import entity.PhieuMuonEntity;
import entity.TraSachEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PhieuMuonKhung implements Initializable {
		@FXML
    	private Button bnThemPM;

    	@FXML
    	void actionThemPM(ActionEvent event) {
    		try{
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ThemPhieuMuon.fxml"));
        		Parent root1 = (Parent) fxmlLoader.load();
        		Stage stage = new Stage();
        		stage.setScene(new Scene(root1));  
        		stage.show();
        	}catch(Exception e) {
        		System.out.println("Can't load new Window");
        	}
    	}
	    @FXML
	    private TableView<PhieuMuonEntity> tableview;

	    @FXML
	    private TableColumn<PhieuMuonEntity, String> col1;

	    @FXML
	    private TableColumn<PhieuMuonEntity, String> col2;

	    @FXML
	    private TableColumn<PhieuMuonEntity, String> col3;

	    @FXML
	    private TableColumn<PhieuMuonEntity, String> col4;

	    @FXML
	    private TableColumn<PhieuMuonEntity, String> col5;

	    @FXML
	    private TableColumn<PhieuMuonEntity, String> col6;
	    
	    ObservableList<PhieuMuonEntity> oblist = FXCollections.observableArrayList();
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			try {
				Connection con = DBConnect.getConnection();
				ResultSet rs = con.createStatement().executeQuery("SELECT * FROM qlthuvien.phieumuon");
				while(rs.next()) {
					oblist.add(new PhieuMuonEntity(rs.getString("idphieumuon"), rs.getString("madocgia"), rs.getString("ngaymuon"), rs.getString("ngaytra"), rs.getString("tongphimuon"), rs.getString("soluongsach")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			col1.setCellValueFactory(new PropertyValueFactory<>("idPM"));
			col2.setCellValueFactory(new PropertyValueFactory<>("idDG"));
			col3.setCellValueFactory(new PropertyValueFactory<>("ngaymuon"));
			col4.setCellValueFactory(new PropertyValueFactory<>("ngaytra"));
			col5.setCellValueFactory(new PropertyValueFactory<>("sotien"));
			col6.setCellValueFactory(new PropertyValueFactory<>("soluong"));
			
			tableview.setItems(oblist);
		}

}

