package ui;
import dao.DataBase;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import dao.CTPhieuDatDAO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.CTPhieuDatDAO;
import entities.ChiTietPhieuDat;




import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GD_ChiTietPhieuDat extends JFrame {
	private String maPD = "";
	private JPanel contentPane;
	private JTextField txtTenSach;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JLabel lblmaPD;
	private CTPhieuDatDAO dsCTPhieuDat = new CTPhieuDatDAO();
	private JTable table;
	private String tenNXB;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ChiTietPhieuDat frame = new GD_ChiTietPhieuDat();
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
	public GD_ChiTietPhieuDat() {
		initialize();
		
	}
	public GD_ChiTietPhieuDat(String maPD) {
		this.maPD = maPD;
		initialize();
		bangdulieuCTPD();
		
	}
	
	public String getMaPD() {
		return maPD;				
	}
	public void bangdulieuCTPD() {
		DefaultTableModel Df = (DefaultTableModel)table.getModel();
		ChiTietPhieuDat ctpd = new ChiTietPhieuDat();
		ArrayList<ChiTietPhieuDat> list = dsCTPhieuDat.doctubangPhieuDat(getMaPD());
		if(list.size()>0) {
			Df.setRowCount(0);		
			
			for (ChiTietPhieuDat pd : list) {				
				String[] rowtable = {pd.getMaCTPD(),pd.getMaNXB(),pd.getTenSach(),pd.getSoLuong(),pd.getDonGia()};
				Df.addRow(rowtable);	
				
			}					
			table.setModel(Df);
		}
	}
	private void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(379, 10, 545, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				txtTenSach.setText(Df.getValueAt(selectedIndex,2).toString());
				txtSoLuong.setText(Df.getValueAt(selectedIndex,3).toString());
				txtDonGia.setText(Df.getValueAt(selectedIndex,4).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã CTPD","Nh\u00E0 xu\u1EA5t b\u1EA3n", "T\u00EAn s\u00E1ch", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class,String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false,false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(205);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(65);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(65);
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tenNXB =  (String) comboBox.getItemAt(comboBox.getSelectedIndex());

			}
		});
		comboBox.setBounds(132, 107, 115, 21);
		contentPane.add(comboBox);
		ArrayList<String> dsNXB = dsCTPhieuDat.JComBoBoxNXB();
		for (int i = 0; i < dsNXB.size(); i++) {
			comboBox.addItem(dsNXB.get(i));
		}
		
		
		JLabel lblNhXutBn = new JLabel("Nhà xuất bản:");
		lblNhXutBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhXutBn.setBounds(10, 110, 112, 17);
		contentPane.add(lblNhXutBn);
		
		JLabel lblNewLabel = new JLabel("Tên sách:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 150, 62, 17);
		contentPane.add(lblNewLabel);
		
		txtTenSach = new JTextField();
		txtTenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenSach.setBounds(132, 146, 221, 19);
		contentPane.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(10, 190, 62, 17);
		contentPane.add(lblSLng);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(133, 188, 96, 19);
		contentPane.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JLabel lblnGi = new JLabel("Đơn giá:");
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnGi.setBounds(10, 228, 62, 17);
		contentPane.add(lblnGi);
		
		txtDonGia = new JTextField();
		txtDonGia.setBounds(133, 226, 96, 19);
		contentPane.add(txtDonGia);
		txtDonGia.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenSach = txtTenSach.getText();
				String soLuong = txtSoLuong.getText();
				String donGia = txtDonGia.getText();
				new CTPhieuDatDAO().themPhieuDat(maPD, tenNXB, tenSach, soLuong, donGia);
				bangdulieuCTPD();
				txtTenSach.setText("");
				txtSoLuong.setText("");
				txtDonGia.setText("");
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setBounds(144, 410, 103, 31);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				String maCTPD = Df.getValueAt(selectedIndex, 0).toString();
				String tenSach = txtTenSach.getText();
				String soLuong = txtSoLuong.getText();
				String donGia = txtDonGia.getText();
				new CTPhieuDatDAO().suaPhieuDat(tenNXB, tenSach, soLuong, donGia,maCTPD);
				bangdulieuCTPD();
				txtTenSach.setText("");
				txtSoLuong.setText("");
				txtDonGia.setText("");
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSua.setBounds(423, 410, 103, 31);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				String idTenSach = Df.getValueAt(selectedIndex, 0).toString();
				int dialog = JOptionPane.showConfirmDialog(null, "Are you sure?", "Warning!",
						JOptionPane.YES_NO_OPTION);
				if (dialog == JOptionPane.YES_OPTION) {
					CTPhieuDatDAO ctpd = new CTPhieuDatDAO();
					ctpd.xoaCTPD(idTenSach);
					JOptionPane.showMessageDialog(null, "Deleted");
					bangdulieuCTPD();
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setBounds(691, 410, 103, 31);
		contentPane.add(btnXoa);
		
		lblmaPD = new JLabel("Phiếu đặt:");
		lblmaPD.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblmaPD.setBounds(10, 21, 151, 22);
		contentPane.add(lblmaPD);
		lblmaPD.setText("Phiếu đặt: " +this.maPD);
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize(); 
		int x = (screenSize.width -  getWidth()) / 2;  
		int y = (screenSize.height - getHeight()) / 2;  
		setLocation(x, y);  
		
	}
}
