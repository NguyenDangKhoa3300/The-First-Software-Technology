package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.PhieuDatDAO;
import dao.PhieuThanhLyDAO;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GD_ThemPhieuThanhLy extends JFrame {
	private PhieuThanhLyDAO phieuThanhLyDAO = new PhieuThanhLyDAO();
	private JPanel contentPane;
	private String tenNV;
	private String ngayNhap;
	private String thangNhap;
	private String namNhap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ThemPhieuThanhLy frame = new GD_ThemPhieuThanhLy();
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
	public GD_ThemPhieuThanhLy() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboTenNV = new JComboBox();
		comboTenNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tenNV =  (String) comboTenNV.getItemAt(comboTenNV.getSelectedIndex());
			}
		});
		comboTenNV.setBounds(213, 106, 116, 21);
		contentPane.add(comboTenNV);
		ArrayList<String> dsNV = phieuThanhLyDAO.JComBoBoxNV();
		for(int i = 0 ; i < dsNV.size(); i++) {
			comboTenNV.addItem(dsNV.get(i));
		}
		JComboBox comboNgay = new JComboBox();
		comboNgay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ngayNhap =  comboNgay.getItemAt(comboNgay.getSelectedIndex()).toString();
			}
		});
		comboNgay.setBounds(106, 174, 50, 21);
		contentPane.add(comboNgay);
		for(int i = 1 ; i <= 31 ; i++) {
			comboNgay.addItem(i);
		}
		
		JComboBox comboThang = new JComboBox();
		comboThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thangNhap =  comboThang.getItemAt(comboThang.getSelectedIndex()).toString();
			}
		});
		comboThang.setBounds(245, 174, 50, 21);
		contentPane.add(comboThang);
		for(int i = 1 ; i <= 12 ; i++) {
			comboThang.addItem(i);
		}
		JComboBox comboNam = new JComboBox();
		comboNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				namNhap =  comboNam.getItemAt(comboNam.getSelectedIndex()).toString();
			}
		});
		comboNam.setBounds(384, 174, 76, 21);
		contentPane.add(comboNam);
		for(int i = 2019 ; i <= 2024 ; i++) {
			comboNam.addItem(i);
		}
		JButton btnLu = new JButton("Lưu");
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String timeDat = namNhap + "-" + thangNhap + "-" + ngayNhap;
				
			    new PhieuThanhLyDAO().themThanhLy(tenNV, timeDat);
				GD_MainPage mainframe = new GD_MainPage().getInstanceOfMainPage();
				mainframe.dulieubangPhieuThanhLy();
			}
		});
		btnLu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLu.setBounds(243, 269, 97, 31);
		contentPane.add(btnLu);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;
		setLocation(x, y);
	}
}
