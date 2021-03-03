package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class GD_DangNhap extends JFrame implements ActionListener{

	private JFrame frame;
	private JTextField txtTaiKhoan;
	private JPasswordField txtPassWord;
	private JButton btnDangNhap;
	private JButton btnHuy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DangNhap window = new GD_DangNhap();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GD_DangNhap() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTittle = new JLabel("\u0110\u0103ng Nh\u1EADp");
		lblTittle.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblTittle.setBounds(217, 30, 148, 44);
		panel.add(lblTittle);
		
		JLabel lblTaiKhoan = new JLabel("T\u00E0i Kho\u1EA3n");
		lblTaiKhoan.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblTaiKhoan.setBounds(53, 106, 105, 26);
		panel.add(lblTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("M\u1EADt Kh\u1EA9u");
		lblMatKhau.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblMatKhau.setBounds(53, 175, 105, 26);
		panel.add(lblMatKhau);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(193, 103, 321, 30);
		panel.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		txtPassWord = new JPasswordField();
		txtPassWord.setBounds(193, 175, 321, 30);
		panel.add(txtPassWord);
		
		btnHuy = new JButton("H\u1EE7y");
		btnHuy.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnHuy.setBounds(349, 246, 85, 35);
		panel.add(btnHuy);
		
		btnDangNhap = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnDangNhap.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnDangNhap.setBounds(128, 246, 169, 35);
		panel.add(btnDangNhap);
		
		btnDangNhap.addActionListener(this);
		btnHuy.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		char chPassWord[]= txtPassWord.getPassword();
		String strPassword = new String(chPassWord);
		if (o.equals(btnDangNhap)) {
			if(strPassword.length()==0 || txtTaiKhoan.getText().toString().length()==0) {
				JOptionPane.showMessageDialog(null, "Chưa Nhập Đủ Dữ Liệu");
			}
		}
		
		if (o.equals(btnHuy)) {
			System.exit(0);
		}
	}
}
