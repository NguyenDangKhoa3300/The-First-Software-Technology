package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.CTPhieuThanhLyDAO;
import entities.SachHienCo;
import dao.PhieuMuonDAO;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GD_ChiTietPhieuMuon extends JFrame {

	private JPanel contentPane;
	private JTable tableSachHC;
	private JTable tableSachMuon;
	private JLabel lblTenDG;
	private String maPM;
	private String tenDG;
	private CTPhieuThanhLyDAO dsshc = new CTPhieuThanhLyDAO();
	private PhieuMuonDAO pmd = new PhieuMuonDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ChiTietPhieuMuon frame = new GD_ChiTietPhieuMuon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void bangdulieuSachHienCo() {
		DefaultTableModel Df = (DefaultTableModel)tableSachHC.getModel();
		
		ArrayList<SachHienCo> list = dsshc.doctubangSachHienCo();
		if(list.size()>0) {
			Df.setRowCount(0);					
			for (SachHienCo shc : list) {				
				String[] rowtable = {shc.getMaSach(),shc.getTenSach()};
				Df.addRow(rowtable);					
			}					
			tableSachHC.setModel(Df);
		}
		
	}
	public void bangdulieuSachDangMuon() {
		DefaultTableModel Df = (DefaultTableModel)tableSachMuon.getModel();
		
		ArrayList<SachHienCo> list = pmd.doctubangSachDangMuon(getMaPM());
		if(list.size()>0) {
			Df.setRowCount(0);					
			for (SachHienCo shc : list) {				
				String[] rowtable = {shc.getMaSach(),shc.getTenSach()};
				Df.addRow(rowtable);					
			}					
			tableSachMuon.setModel(Df);
		}
		
	}
	public String getMaPM(){
		return this.maPM;
	}
	public GD_ChiTietPhieuMuon() {
		initialize();
	}
	public GD_ChiTietPhieuMuon(String maPM,String tenDG) {
		this.maPM = maPM;
		this.tenDG = tenDG;
		initialize();
		lblTenDG.setText(this.tenDG);
		bangdulieuSachHienCo();
		bangdulieuSachDangMuon();
	}
	/**
	 * Create the frame.
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 183, 286, 371);
		contentPane.add(scrollPane);
		
		tableSachHC = new JTable();
		tableSachHC.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u00E1ch ", "T\u00EAn S\u00E1ch"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableSachHC.getColumnModel().getColumn(0).setResizable(true);
		tableSachHC.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableSachHC.getColumnModel().getColumn(1).setResizable(true);
		scrollPane.setViewportView(tableSachHC);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(506, 183, 286, 371);
		contentPane.add(scrollPane_1);
		
		tableSachMuon = new JTable();
		tableSachMuon.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableSachMuon.getColumnModel().getColumn(0).setResizable(true);
		tableSachMuon.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableSachMuon.getColumnModel().getColumn(1).setResizable(true);
		scrollPane_1.setViewportView(tableSachMuon);
		
		JLabel lblNewLabel = new JLabel("Bảng Sách Đang Có:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(71, 130, 131, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblBngSchc = new JLabel("Bảng Sách Độc Đang Giả Mượn:");
		lblBngSchc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBngSchc.setBounds(552, 130, 205, 17);
		contentPane.add(lblBngSchc);
		
		JButton btnThm = new JButton("Thêm");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel) tableSachHC.getModel();
				int selectedIndex = tableSachHC.getSelectedRow();
				String maSach = Df.getValueAt(selectedIndex, 0).toString();
				pmd.themPhieuChiTietMuon(getMaPM(), maSach);
				bangdulieuSachDangMuon();
			}
		});
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThm.setBounds(354, 285, 85, 36);
		contentPane.add(btnThm);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel) tableSachMuon.getModel();
				int selectedIndex = tableSachMuon.getSelectedRow();
				String maSach = Df.getValueAt(selectedIndex, 0).toString();
				pmd.xoaChiTietPhieuMuon(maSach);
				bangdulieuSachDangMuon();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(354, 382, 85, 36);
		contentPane.add(btnXoa);
		
		JLabel lblChiTitPhiu = new JLabel("Chi Tiết Phiếu Mượn Của Độc Giả:");
		lblChiTitPhiu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChiTitPhiu.setBounds(273, 27, 286, 20);
		contentPane.add(lblChiTitPhiu);
		
		lblTenDG = new JLabel("New label",SwingConstants.CENTER);
		lblTenDG.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenDG.setBounds(273, 70, 272, 21);
		contentPane.add(lblTenDG);
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize(); 
		int x = (screenSize.width - getWidth()) / 2;  
		int y = (screenSize.height - getHeight()) / 2;  
		setLocation(x, y);  
	}
}
