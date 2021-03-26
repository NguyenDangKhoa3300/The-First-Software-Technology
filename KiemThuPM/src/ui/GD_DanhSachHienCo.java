package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.SachHienCo;
import entities.ChitietPhieuThanhLy;
import dao.CTPhieuThanhLyDAO;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

public class GD_DanhSachHienCo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private CTPhieuThanhLyDAO dsshc = new CTPhieuThanhLyDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DanhSachHienCo frame = new GD_DanhSachHienCo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void bangdulieuSachHienCo() {
		DefaultTableModel Df = (DefaultTableModel)table.getModel();
		
		ArrayList<SachHienCo> list = dsshc.doctubangSachHienCo();
		if(list.size()>0) {
			Df.setRowCount(0);					
			for (SachHienCo shc : list) {				
				String[] rowtable = {shc.getMaSach(),shc.getTenSach(),shc.getTheLoai(),shc.getNamXB(),shc.getTenNXB(),shc.getTinhTrangSach()};
				Df.addRow(rowtable);					
			}					
			table.setModel(Df);
		}
		
	}

	/**
	 * Create the frame.
	 */
	public GD_DanhSachHienCo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 683, 239);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "Th\u1EC3 lo\u1EA1i", "N\u0103m XB", "T\u00EAn NXB", "T\u00ECnh tr\u1EA1ng s\u00E1ch"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(205);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(110);
		scrollPane.setViewportView(table);
		
		JLabel lblDanhSchSch = new JLabel("Danh sách sách hiện có");
		lblDanhSchSch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDanhSchSch.setBounds(242, 21, 253, 25);
		contentPane.add(lblDanhSchSch);
		bangdulieuSachHienCo();
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize(); 
		int x = 100; 
		int y = (screenSize.height - getHeight()) / 2;  
		setLocation(x, y);  
		
		
	}
}
