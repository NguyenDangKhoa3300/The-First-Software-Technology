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
import dao.PhieuMuonDAO;
import dao.PhieuDatDAO;
import entities.DocGia_PM;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GD_ThemPhieuMuon2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField txtMaDG;
	private String tenNV;
	private String dateLap;
	private String dateAfter1Week;
	private PhieuMuonDAO pm = new PhieuMuonDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ThemPhieuMuon2 frame = new GD_ThemPhieuMuon2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void bangdulieuDocGiaHienCo() {
		DefaultTableModel Df = (DefaultTableModel) table.getModel();

		ArrayList<DocGia_PM> list = pm.doctubangThemPhieuMuon();
		if (list.size() > 0) {
			Df.setRowCount(0);
			for (DocGia_PM shc : list) {
				String[] rowtable = { shc.getMaDG(), shc.getTenDG(), shc.getCmnd() };
				Df.addRow(rowtable);
			}
			table.setModel(Df);
		}

	}

	/**
	 * Create the frame.
	 */
	public GD_ThemPhieuMuon2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 388, 253);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel Df = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				txtMaDG.setText(Df.getValueAt(selectedIndex, 0).toString());
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 \u0110\u1ED9c Gi\u1EA3", "T\u00EAn \u0110\u1ED9c Gi\u1EA3", "S\u1ED1 CMND" }) {
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
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);

		JLabel lblTmcGi = new JLabel("Tìm Độc Giả:");
		lblTmcGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTmcGi.setBounds(21, 26, 83, 17);
		contentPane.add(lblTmcGi);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(114, 23, 126, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnTm = new JButton("Tìm");
		btnTm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTm.setBounds(270, 22, 68, 25);
		contentPane.add(btnTm);

		JLabel lblMcGi = new JLabel("Mã Độc Giả: ");
		lblMcGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMcGi.setBounds(443, 110, 82, 17);
		contentPane.add(lblMcGi);

		txtMaDG = new JTextField();
		txtMaDG.setEditable(false);
		txtMaDG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaDG.setBounds(535, 107, 126, 23);
		contentPane.add(txtMaDG);
		txtMaDG.setColumns(10);

		JButton btnLu = new JButton("Lưu");
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String maDG = txtMaDG.getText();
				if (pm.validationTrungThemPhieuMuon(maDG)) {
					LocalDate currentDate = LocalDate.now();

					dateLap = "" + currentDate;
					LocalDate result = currentDate.plus(1, ChronoUnit.WEEKS);

					dateAfter1Week = "" + result;
					pm.themPhieuMuon(maDG, dateLap, dateAfter1Week, tenNV);
					txtMaDG.setText("");
					GD_MainPage mainframe = new GD_MainPage().getInstanceOfMainPage();
					mainframe.dulieubangPhieuMuon();
				}else {
					JOptionPane.showMessageDialog(null, "Doc gia chua tra phieu muon!");
				}
			}
		});
		btnLu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLu.setBounds(308, 395, 74, 42);
		contentPane.add(btnLu);

		JLabel lblChnNhnVin = new JLabel("Chọn Nhân Viên:");
		lblChnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChnNhnVin.setBounds(418, 153, 107, 17);
		contentPane.add(lblChnNhnVin);

		JComboBox comboBoxNV = new JComboBox();
		comboBoxNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tenNV = (String) comboBoxNV.getItemAt(comboBoxNV.getSelectedIndex());
			}
		});
		comboBoxNV.setBounds(535, 153, 133, 21);
		contentPane.add(comboBoxNV);
		ArrayList<String> dsnv = new PhieuDatDAO().JComBoBoxNV();
		for (int i = 0; i < dsnv.size(); i++) {
			comboBoxNV.addItem(dsnv.get(i));
		}
		JLabel lblLpPhiuMn = new JLabel("Lập Phiếu Mượn");
		lblLpPhiuMn.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLpPhiuMn.setBounds(443, 21, 154, 23);
		contentPane.add(lblLpPhiuMn);
		bangdulieuDocGiaHienCo();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;
		setLocation(x, y);
	}
}
