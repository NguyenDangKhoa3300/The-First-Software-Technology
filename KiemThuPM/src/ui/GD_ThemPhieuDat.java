package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DataBase;
import dao.PhieuDatDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GD_ThemPhieuDat extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenSach;
	private JTextField txtMaNSX;
	private JTextField txtSL;
	private JTextField txtDonGia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ThemPhieuDat frame = new GD_ThemPhieuDat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GD_ThemPhieuDat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThmPhiut = new JLabel("Thêm Phiếu Đặt");
		lblThmPhiut.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblThmPhiut.setBounds(183, 10, 240, 79);
		contentPane.add(lblThmPhiut);
		
		JLabel lblTnSch = new JLabel("Tên sách:");
		lblTnSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnSch.setBounds(132, 151, 62, 17);
		contentPane.add(lblTnSch);
		
		JLabel lblMNhSn = new JLabel("Mã nhà sản xuất:");
		lblMNhSn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMNhSn.setBounds(132, 188, 110, 17);
		contentPane.add(lblMNhSn);
		
		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(132, 234, 62, 17);
		contentPane.add(lblSLng);
		
		JLabel lblnGi = new JLabel("Đơn giá:");
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnGi.setBounds(132, 267, 54, 17);
		contentPane.add(lblnGi);
		//Event nut luu
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenSach = txtTenSach.getText();
				String maNSX = txtMaNSX.getText();
				String soLuong = txtSL.getText();
				String donGia = txtDonGia.getText();
				new PhieuDatDAO().themPhieuDat(tenSach, maNSX, soLuong, donGia);
				GD_MainPage mainframe = new GD_MainPage().getInstanceOfMainPage();	
				mainframe.dulieubangPhieuDat();
				txtTenSach.setText("");
				txtMaNSX.setText("");
				txtSL.setText("");
				txtDonGia.setText("");
				txtTenSach.requestFocus();
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLuu.setBounds(240, 368, 110, 29);
		contentPane.add(btnLuu);
		
		txtTenSach = new JTextField();
		txtTenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenSach.setBounds(252, 148, 126, 23);
		contentPane.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		txtMaNSX = new JTextField();
		txtMaNSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaNSX.setColumns(10);
		txtMaNSX.setBounds(252, 185, 126, 23);
		contentPane.add(txtMaNSX);
		
		txtSL = new JTextField();
		txtSL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSL.setColumns(10);
		txtSL.setBounds(252, 231, 126, 23);
		contentPane.add(txtSL);
		
		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(252, 264, 126, 23);
		contentPane.add(txtDonGia);
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize(); 
		int x = (screenSize.width - getWidth()) / 2;  
		int y = (screenSize.height - getHeight()) / 2;  
		setLocation(x, y);  
	}
}
