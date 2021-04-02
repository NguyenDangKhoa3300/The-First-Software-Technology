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

import dao.CTPhieuDatDAO;
import dao.CTPhieuThanhLyDAO;
import entities.ChiTietPhieuDat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import entities.ChitietPhieuThanhLy;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GD_ChiTietPhieuThanhLy extends JFrame {
	private String maPTL = "";
	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaSach;
	private JTextField txtDonGia;
	private CTPhieuThanhLyDAO dsCTPhieuTL = new CTPhieuThanhLyDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ChiTietPhieuThanhLy frame = new GD_ChiTietPhieuThanhLy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GD_ChiTietPhieuThanhLy() {
		initialize();

	}

	public GD_ChiTietPhieuThanhLy(String maPTL) {
		this.maPTL = maPTL;
		initialize();
		bangdulieuCTPTL();

	}

	public String getMaPTL() {
		return maPTL;
	}

	public void bangdulieuCTPTL() {
		DefaultTableModel Df = (DefaultTableModel) table.getModel();
		
		ArrayList<ChitietPhieuThanhLy> list = dsCTPhieuTL.doctubangPhieuDat(getMaPTL());
		
			Df.setRowCount(0);

			for (ChitietPhieuThanhLy ptl : list) {
				String[] rowtable = { ptl.getMaCTPTL(), ptl.getTenSach(), ptl.getDonGia() };
				Df.addRow(rowtable);

			}
			table.setModel(Df);
		
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 10, 368, 379);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel Df = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();

				String mactptl = Df.getValueAt(selectedIndex, 0).toString();

				txtMaSach.setText(dsCTPhieuTL.getMaSach(mactptl));
				txtDonGia.setText(Df.getValueAt(selectedIndex, 2).toString());

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 CTPTL", "T\u00EAn s\u00E1ch", "\u0110\u01A1n gi\u00E1" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(275);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Nhập mã sách:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 83, 94, 17);
		contentPane.add(lblNewLabel);

		txtMaSach = new JTextField();
		txtMaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaSach.setBounds(127, 80, 126, 23);
		contentPane.add(txtMaSach);
		txtMaSach.setColumns(10);

		txtDonGia = new JTextField();
		txtDonGia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = txtDonGia.getText();

				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					txtDonGia.setEditable(true);

				} else {
					String mess = "Khong duoc nhap chu!";
					JOptionPane.showMessageDialog(null, mess);
					txtDonGia.setText("");
				}
			}
		});
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(127, 115, 126, 23);
		contentPane.add(txtDonGia);

		JLabel lblNhpnGi = new JLabel("Nhập đơn giá:");
		lblNhpnGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhpnGi.setBounds(23, 118, 94, 17);
		contentPane.add(lblNhpnGi);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maSach = txtMaSach.getText();
				String donGia = txtDonGia.getText();
				ArrayList<String> ck = dsCTPhieuTL.validationTonTaiThemPhieuThanhLy(maSach);
				if (dsCTPhieuTL.validationTrungThemPhieuThanhLy(maSach)) {
					if (ck.get(0).equalsIgnoreCase("kotrung")) {
						dsCTPhieuTL.themPhieuThanhLy(getMaPTL(), maSach, donGia);
						txtMaSach.setText("");
						txtDonGia.setText("");
						bangdulieuCTPTL();
					} else {
						JOptionPane.showMessageDialog(null, "Trung ma sach o phieu " + ck.get(1) + "!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ma sach khong hop le!");
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(10, 256, 85, 35);
		contentPane.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				String id = Df.getValueAt(selectedIndex, 0).toString();
				int dialog = JOptionPane.showConfirmDialog(null, "Are you sure?", "Warning!",
						JOptionPane.YES_NO_OPTION);
				if (dialog == JOptionPane.YES_OPTION) {
					CTPhieuThanhLyDAO ctptl = new CTPhieuThanhLyDAO();
					ctptl.xoaCTPTL(id);
					JOptionPane.showMessageDialog(null, "Deleted");
					bangdulieuCTPTL();
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(116, 256, 85, 35);
		contentPane.add(btnXoa);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				String maCTPTLs = Df.getValueAt(selectedIndex, 0).toString();
				String maSachs = txtMaSach.getText();
				String donGias = txtDonGia.getText();
				if (dsCTPhieuTL.getMaSach(maCTPTLs).equalsIgnoreCase(maSachs)) {
					dsCTPhieuTL.suaChiTietPhieuTL(maCTPTLs, maSachs, donGias);
					bangdulieuCTPTL();
					txtMaSach.setText("");
					txtDonGia.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Khong duoc sua ma sach");
					txtMaSach.setText(dsCTPhieuTL.getMaSach(maCTPTLs));
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(231, 256, 85, 35);
		contentPane.add(btnSua);

		JLabel LabelMaPTL = new JLabel("Mã phiếu:");
		LabelMaPTL.setFont(new Font("Tahoma", Font.BOLD, 18));
		LabelMaPTL.setBounds(23, 13, 161, 22);
		contentPane.add(LabelMaPTL);
		LabelMaPTL.setText("Mã Phiếu: " + maPTL);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int x = 800;
		int y = (screenSize.height - getHeight()) / 2;
		setLocation(x, y);

	}
}
