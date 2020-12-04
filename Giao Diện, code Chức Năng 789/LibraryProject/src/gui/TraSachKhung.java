package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.DBConnect;
import entity.TraSachEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TraSachKhung implements Initializable {

    @FXML
    private TableView<TraSachEntity> tbvtrasach;

    @FXML
    private TableColumn<TraSachEntity, String> col_maphieumuon;

    @FXML
    private TableColumn<TraSachEntity, String> col_masach;

    @FXML
    private TableColumn<TraSachEntity, String> col_tensach;

    @FXML
    private TableColumn<TraSachEntity, String> col_solangiahan;

    @FXML
    private TableColumn<TraSachEntity, String> col_tienphat;

    @FXML
    private TableColumn<TraSachEntity, String> col_sotientralai;

    @FXML
    private TableColumn<TraSachEntity, String> col_tinhtrangsach;
    
    ObservableList<TraSachEntity> oblist = FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			Connection con = DBConnect.getInstance().getConnection();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM qlthuvien.trasach");
			while(rs.next()) {
				oblist.add(new TraSachEntity(rs.getString("idphieumuon"), rs.getString("idsach"), rs.getString("tensach"), rs.getString("solangiahan"), rs.getString("tienphat"), rs.getString("sotientralai"), rs.getString("tinhtrangsach")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		col_maphieumuon.setCellValueFactory(new PropertyValueFactory<>("idPM"));
		col_masach.setCellValueFactory(new PropertyValueFactory<>("idSach"));
		col_tensach.setCellValueFactory(new PropertyValueFactory<>("tenSach"));
		col_solangiahan.setCellValueFactory(new PropertyValueFactory<>("solangiahan"));
		col_tienphat.setCellValueFactory(new PropertyValueFactory<>("tienphat"));
		col_sotientralai.setCellValueFactory(new PropertyValueFactory<>("sotientralai"));
		col_tinhtrangsach.setCellValueFactory(new PropertyValueFactory<>("tinhtrangsach;"));
		
		tbvtrasach.setItems(oblist);
	}


}
