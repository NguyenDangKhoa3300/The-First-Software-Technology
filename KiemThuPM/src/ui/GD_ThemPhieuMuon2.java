package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class GD_ThemPhieuMuon2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField txtMaDG;
	private JTextField txtNgayLapPhieu;
	private JTextField txtThangLapPhieu;
	private JTextField textField_1;

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

	/**
	 * Create the frame.
	 */
	public GD_ThemPhieuMuon2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 388, 253);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 \u0110\u1ED9c Gi\u1EA3", "T\u00EAn \u0110\u1ED9c Gi\u1EA3", "S\u1ED1 CMND"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
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
		
		JLabel lblThiGianLp = new JLabel("Thời gian lập phiếu:");
		lblThiGianLp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThiGianLp.setBounds(562, 170, 126, 17);
		contentPane.add(lblThiGianLp);
		
		JLabel lblNgy = new JLabel("Ngày:");
		lblNgy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgy.setBounds(433, 223, 37, 17);
		contentPane.add(lblNgy);
		
		JLabel lblThng = new JLabel("Tháng:");
		lblThng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThng.setBounds(606, 223, 45, 17);
		contentPane.add(lblThng);
		
		JLabel lblNm = new JLabel("Năm:");
		lblNm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNm.setBounds(790, 223, 34, 17);
		contentPane.add(lblNm);
		
		txtNgayLapPhieu = new JTextField();
		txtNgayLapPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgayLapPhieu.setBounds(489, 220, 37, 23);
		contentPane.add(txtNgayLapPhieu);
		txtNgayLapPhieu.setColumns(10);
		
		txtThangLapPhieu = new JTextField();
		txtThangLapPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtThangLapPhieu.setColumns(10);
		txtThangLapPhieu.setBounds(693, 220, 45, 23);
		contentPane.add(txtThangLapPhieu);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(834, 220, 59, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLu = new JButton("Lưu");
		btnLu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLu.setBounds(459, 392, 74, 42);
		contentPane.add(btnLu);
		
		JLabel lblChnNhnVin = new JLabel("Chọn Nhân Viên:");
		lblChnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChnNhnVin.setBounds(693, 107, 107, 17);
		contentPane.add(lblChnNhnVin);
		
		JComboBox comboBoxNV = new JComboBox();
		comboBoxNV.setBounds(833, 107, 133, 21);
		contentPane.add(comboBoxNV);
		
		JLabel lblLpPhiuMn = new JLabel("Lập Phiếu Mượn");
		lblLpPhiuMn.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLpPhiuMn.setBounds(443, 21, 154, 23);
		contentPane.add(lblLpPhiuMn);
	}
}
